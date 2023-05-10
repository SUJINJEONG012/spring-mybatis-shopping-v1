package com.mybatis.shopping.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.CartDto;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class CartServiceTests {

	@Autowired
	private CartService cartService;
	
	// 등록실패 :0, 등록성공;
	@Test
	public void addCartTest() {
		
		//given
		String memberId = "admin";
		int bookId= 2;
		int count = 5;
		
		CartDto dto = new CartDto();
		dto.setMemberId(memberId);
		dto.setBookId(bookId);
		dto.setBookCount(count);
		
		//when
		int result = cartService.addCart(dto);
		
		//then
		System.out.println("** result : " + result);
		
	}
	
	
}
