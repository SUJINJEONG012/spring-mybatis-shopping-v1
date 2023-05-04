package com.mybatis.shopping.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		
		//썸네일 이미지
		fileList.forEach(bookVo -> {
			Path path = Paths.get("C:\\upload", bookVo.getUploadPath(), "s_" + bookVo.getUuid() + "_" + bookVo.getFileName());
			checkFilePath.add(path);
		});
		
		
		System.out.println("checkFilePath : ");
		checkFilePath.forEach(list -> System.out.println(list));
		System.out.println("==========================");	
		
	}
}
