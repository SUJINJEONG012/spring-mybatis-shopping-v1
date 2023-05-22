package com.mybatis.shopping.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.ReplyDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	public void replyEnrollTest() {
		
		String id = "admin";
		//int bookId =  50;
		int bookId = 4094;
		double rating = 3.5;
		String content = "댓글 테스트 ";
		
		ReplyDto dto = new ReplyDto();
		dto.setBookId(bookId);
		dto.setMemberId(id);
		dto.setRating(rating);
		dto.setContent(content);
	
		replyMapper.enrollReply(dto);
		
	}
}
