package com.mybatis.shopping.mapper;

import java.util.List;

import com.mybatis.shopping.model.CartDto;

public interface CartMapper {

	/* 카트 추가 */
	public int addCart(CartDto cart) throws Exception ;
	/* 카트 삭제 */
	public int deleteCart(int cartId);
	/* 카트 수량 수정 */
	public int modifyCount(CartDto cart);
	/* 카트 목록 */
	public List<CartDto> getCart(String memberId);
	/* 카트 확인 */
	public CartDto checkCart(CartDto cart);
	/* 카트 제거(주문) */
	public int deleteOrderCart(CartDto cartDto);
}
