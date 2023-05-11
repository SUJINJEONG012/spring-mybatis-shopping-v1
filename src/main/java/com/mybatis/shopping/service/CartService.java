package com.mybatis.shopping.service;

import java.util.List;

import com.mybatis.shopping.model.CartDto;

public interface CartService {

	/* 단순히 등록만 하는게 아니라 등록하고자 하는 데이터가 존재여무 확인 
	 * 성공여부에 따라 int값을 반환 하도록 
	 * */
	
	/* 장바구니 추가 */
	public int addCart(CartDto cart);
	
	/* 장바구니 정보 리스트 */
	public List<CartDto> getCartList(String memberId);
	
	/* 카트 수량 수정 */
	public int modifyCount(CartDto cart);

}


