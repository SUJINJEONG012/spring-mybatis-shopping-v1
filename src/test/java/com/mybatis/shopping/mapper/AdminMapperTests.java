package com.mybatis.shopping.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.BookVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminMapperTests {

	@Autowired
	private AdminMapper adminMapper; 
	
	/* 상품 등록 테스트 */
	@Test
	public void bookEnrollTest() throws Exception {
		
		BookVo bookVo = new BookVo();
		
		bookVo.setBookName("mapper테스트");
		bookVo.setAuthorId(12);
		bookVo.setPubleYear("2023-03-31");
		bookVo.setPublisher("출판사");
		bookVo.setCateCode("0231");
		bookVo.setBookPrice(20000);
		bookVo.setBookStock(30);
		bookVo.setBookDiscount(0.23);
		bookVo.setBookIntro("책 소개");
		bookVo.setBookContents("책 목차");
		
		adminMapper.bookEnroll(bookVo);
	}
}
