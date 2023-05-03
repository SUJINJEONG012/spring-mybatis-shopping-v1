package com.mybatis.shopping.task;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
	
	@Test
	public void taskTests() {

		//DB에 저장된 파일 리스트
		List<AttachImageVo> fileList = adminMapper.checkFileList();
		
		System.out.println("디비에 저장된 파일 리스트 : fileList : " + fileList);
		
		fileList.forEach(list -> System.out.println(list));
		
		List<Path> checkFilePath = new ArrayList<Path>();
		
		fileList.forEach(bookVo ->{
			//Path path = Paths.get("/Users/jeongsujin/upload", bookVo.getUploadPath(), bookVo.getUuid() + "_" + bookVo.getFileName());
			Path path = Paths.get("C:\\upload", bookVo.getUploadPath(), bookVo.getUuid() + "_" + bookVo.getFileName());
			
			checkFilePath.add(path);
		});
		
		System.out.println("checkFilePath : ");
		
		checkFilePath.forEach(list -> System.out.println(list));
		System.out.println("==========================");	
		
	}
}
