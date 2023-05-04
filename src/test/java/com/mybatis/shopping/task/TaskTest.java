package com.mybatis.shopping.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.mapper.AdminMapper;
import com.mybatis.shopping.model.AttachImageVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TaskTest {

	
	@Autowired
	private AdminMapper adminMapper;
	
	
	private String getFolderYesterDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String str = sdf.format(cal.getTime());
		return str.replace("-", File.separator);
	}
	
	@Test
	public void taskTests() {

		//DB에 저장된 파일 리스트
		List<AttachImageVo> fileList = adminMapper.checkFileList();
		
		System.out.println("디비에 저장된 파일 리스트 : fileList : " + fileList);
		
		fileList.forEach(list -> System.out.println(list));
		
		// 비교 기준 파일 리스트 path객체
		List<Path> checkFilePath = new ArrayList<Path>();
		
		//원본이미지
		fileList.forEach(bookVo ->{
			//Path path = Paths.get("/Users/jeongsujin/upload", bookVo.getUploadPath(), bookVo.getUuid() + "_" + bookVo.getFileName());
			Path path = Paths.get("C:\\upload", bookVo.getUploadPath(), bookVo.getUuid() + "_" + bookVo.getFileName());
			checkFilePath.add(path);
		});
		
		System.out.println("checkFilePath : ");
		checkFilePath.forEach(list -> System.out.println(list));
		System.out.println("==========================");	
		
		//썸네일 이미지
		fileList.forEach(bookVo -> {
			Path path = Paths.get("C:\\upload", bookVo.getUploadPath(), "s_" + bookVo.getUuid() + "_" + bookVo.getFileName());
			checkFilePath.add(path);
		});
		
		System.out.println("checkFilePath  썸네일: ");
		checkFilePath.forEach(list -> System.out.println(list));
		System.out.println("==========================");	
		
		
		
		
		//체크 할 대상의 이미지파일이 저장된 디렉토리를 File객체로 생성 후 targetDir 변수에 대입
		File targetDir = Paths.get("C:\\upload", getFolderYesterDay()).toFile();
		//listFiles()메서드를 호출하여 반환받은 File배열 객체 주소를 targetFile변수에 대입
		File[] targetFile = targetDir.listFiles();
		
		System.out.println("targetFile : " );
		for(File file : targetFile) {
			System.out.println(file);
		}
		System.out.println("============================"); 
		
		/*배열 객체를 > 리스트 객체로 변경하기 위해 사용 
		ArrayList 리스트 변수명 = new ArrayList<>(Arrays.asList(배엷변수명));
		*/
		List<File> removeFileList = new ArrayList<File>(Arrays.asList(targetFile));
		
		System.out.println("removeFileList 필터 전 : ");
		removeFileList.forEach(file ->{
			System.out.println(file);
		});
		System.out.println("==================================");
		
		
		
		/* removeFileList 에는 디렉토리에 저장되어있는 파일이 모두 담겨져 있다. 
		 * targetFile, checkFilePath와 비교를 통해 동일한 데이터를 가지고 있는 
		 * File객체를 제거함으로 DB에 정보가 저장되지않은 이미지 File만 남길것. 
		 * 
		 * 이중 for문을 통해 removeFileList에 checkFilePath(DB이미지 리스트)에 존재하지 않는 이미지 file객체만 남기고
		 * File 객체요소가 제거 되도록 자성. targetFile과 checkFilePath의 각 요소들과의 비교를 위해 targetFile의 요소인
		 * File객체를 toPath() 메서드를 호출하여 Path객체로 변환 후 비교
		 * */
		
		//제거 되어야 할 이미지 
		for(File file : targetFile) {
			checkFilePath.forEach(checkFile ->{
				if(file.toPath().equals(checkFilePath))
					removeFileList.remove(file);
			});
		}
		System.out.println("removeFileList 필터 후 : ");
		removeFileList.forEach(file ->{
			System.out.println(file);
		});
		System.out.println("=====================================");
	
		/*파일 삭제 */
		for(File file : removeFileList) {
			System.out.println("삭제 : " + file);
			file.delete();
		}
		
	}
}
