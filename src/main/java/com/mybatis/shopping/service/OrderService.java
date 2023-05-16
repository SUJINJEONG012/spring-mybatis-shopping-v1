package com.mybatis.shopping.service;

import java.util.List;

import com.mybatis.shopping.model.OrderPageItemDto;

public interface OrderService {

	/* 주문 정보 */
	public List<OrderPageItemDto> getGoodsInfo(List<OrderPageItemDto> orders);
	
}
