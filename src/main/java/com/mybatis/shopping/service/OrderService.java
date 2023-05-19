package com.mybatis.shopping.service;

import java.util.List;

import com.mybatis.shopping.model.OrderCancelDto;
import com.mybatis.shopping.model.OrderDto;
import com.mybatis.shopping.model.OrderPageItemDto;

public interface OrderService {

	/* 주문 정보 */
	public List<OrderPageItemDto> getGoodsInfo(List<OrderPageItemDto> orders);
	
	/* 주문 */
	public void order(OrderDto ord);
	
	/* 주문 취소 */
	public void orderCancel(OrderCancelDto dto);
	
}
