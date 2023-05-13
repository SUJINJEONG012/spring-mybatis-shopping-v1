package com.mybatis.shopping.mapper;

import com.mybatis.shopping.model.OrderPageItemDto;

public interface OrderMapper {

	/* 주문 상품 정보 */	
	public OrderPageItemDto getGoodsInfo(int bookId);
	
}
