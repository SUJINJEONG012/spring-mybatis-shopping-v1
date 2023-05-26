package com.mybatis.shopping.model;

import java.util.List;

import lombok.Data;

@Data
public class SelectDto {
	private int bookId;
	private String bookName;
	private int bookPrice;
	private double bookDiscount; //상품 할인율
	private String cateName;
	private double ratingAvg;
	
	private List<AttachImageVo> imageList;
}
