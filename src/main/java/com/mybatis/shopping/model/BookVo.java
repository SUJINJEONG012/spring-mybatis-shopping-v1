package com.mybatis.shopping.model;

import java.util.Date;

public class BookVo {

	private int bookId; // 상품아이디 
	private String bookName; //상품이름
	private int authorId; //작가 아이디
	private int authName; //작가이름 
	private String publeYerar; //출판일
	private String publisher; //출판사
	private String cateCode; //카테고리코드
	private String cateName; //카테고리 이름
	private int bookPrice; // 상품 가격 
	private int bookStock; //상품재고
	private double bookDiscount; //상품 할인율
	private String bookIntro; //상품소개 
	
	private String bookContents; // 상품 목차
	private Date regDate; // 등록날짜
	private Date updateDate; //수정날짜
	
	
}
