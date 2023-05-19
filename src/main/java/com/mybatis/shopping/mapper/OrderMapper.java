package com.mybatis.shopping.mapper;

import java.util.List;

import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CartDto;
import com.mybatis.shopping.model.MemberVo;
import com.mybatis.shopping.model.OrderDto;
import com.mybatis.shopping.model.OrderItemDto;
import com.mybatis.shopping.model.OrderPageItemDto;

public interface OrderMapper {

	/* 주문 상품 정보 */	
	public OrderPageItemDto getGoodsInfo(int bookId);
	/* 주문 상품 정보 (주문처리) */
	public OrderItemDto getOrderInfo(int bookId);
	
	/* 주문 테이블 등록 */
	public int enrollOrder(OrderDto ord);
	/* 주문 아이템 테이블 등록 */
	public int enrollOrderItem(OrderItemDto orid);
	/* 주문 금액 차감 */
	public int deductMoney(MemberVo memberVo);
	/* 주문 재고 차감 */
	public int deductStock(BookVo bookVo);
	/* 카트 제거 (주문) */
	public int deleteOrderCart(CartDto cartDto); 
	
	/* 주문 취소 */
	public int orderCancel(String orderId);
	
	/* 주문 상품 정보 (주문 취소)*/
	public List<OrderItemDto> getOrderItemInfo(String orderId);
	
	/* 주문 정보 (주문취소) */
	public OrderDto getOrder(String orderId);
}
