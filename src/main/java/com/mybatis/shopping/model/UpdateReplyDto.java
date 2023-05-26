package com.mybatis.shopping.model;

import lombok.Data;

/*
 * 평균값 반영 쿼리를 실행할 mapper메서드에 
 * 두개의 데이터를 한번에 전달할 dto 클래스 생성  
 * */

@Data
public class UpdateReplyDto {
	private int bookId;
	private double ratingAvg;
}
