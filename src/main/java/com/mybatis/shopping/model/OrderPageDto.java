package com.mybatis.shopping.model;

import java.util.List;

public class OrderPageDto {

	public List<OrderPageItemDto> orders;

	public List<OrderPageItemDto> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderPageItemDto> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderPageDto [orders=" + orders + "]";
	}
	
	
}
