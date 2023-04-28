package com.mybatis.shopping.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AttachMapperTests {

	@Autowired
	private AttachMapper attachMapper;
	
	/* 이미지정보 반환 */
	@Test
	public void getAttchListTests() {
		int bookId = 35;
		System.out.println("이미지 정보 : " + attachMapper.getAttachList(bookId));
	}
}
