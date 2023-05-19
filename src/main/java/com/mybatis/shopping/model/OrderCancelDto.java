package com.mybatis.shopping.model;

import lombok.Data;

@Data
public class OrderCancelDto {
	
	private String memberId;
	private String orderId;
	
	private String keyword;
	private int amount;
	private int pageNum;
}
