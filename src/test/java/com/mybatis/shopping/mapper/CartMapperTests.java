package com.mybatis.shopping.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.CartDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CartMapperTests {

	@Autowired
	private CartMapper cartMapper;
	
	/* 카트 추가 */
//	@Test
//	public void addCartTest() {
//		String memberId = "admin";
//		int bookId = 40;
//		int count = 2;
//		
//		CartDto cart = new CartDto();
//		cart.setMemberId(memberId);
//		cart.setBookId(bookId);
//		cart.setBookCount(count);
//		
//		int result= 0;
//		result = cartMapper.addCart(cart);
//		System.out.println("결과 : " + result);	
//	}
	
	/* 카트 삭제 */
//	@Test
//	public void deleteCartTest() {
//		int cartId = 1;
//		cartMapper.deleteCart(cartId);
//		System.out.println( "삭제 결과 :ㄴ " + cartMapper.deleteCart(cartId));
//	}
	
	/* 카트 수량 수정 */
//	@Test
//	public void modifyCountTest() {
//		int cartId= 3;
//		int count = 10;
//		
//		CartDto cart = new CartDto();
//		cart.setCartId(cartId);
//		cart.setBookCount(count);
//		
//		cartMapper.modifyCount(cart);
//	
//		System.out.println(" 수량 변경 결과 : " + cartMapper.modifyCount(cart));
//	}
	
	/* 카트 목록 */	
	@Test
	public void getCartTest() {
		String memberId = "admin";
		
		List<CartDto> list = cartMapper.getCart(memberId);
		for(CartDto cart: list) {
			System.out.println("cart List : " + cart );
			cart.initSaleTotal();
			System.out.print("init cart : " + cart);
		}
	}
	
	/* 카트 확인 */
	@Test
	public void checkCartTest() {
		
		String memberId = "admin";
		int bookId = 40;
		
		CartDto cart = new CartDto();
		cart.setMemberId(memberId);
		cart.setBookId(bookId);
		
		CartDto resultCart = cartMapper.checkCart(cart);
		System.out.println("결과 : "  +  resultCart);
	
	}
	
	
}
