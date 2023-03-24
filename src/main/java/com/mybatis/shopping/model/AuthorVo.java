
package com.mybatis.shopping.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorVo {
 
	private int authorId; //작가아이디 
	private String authName; //작가이름 
	private String nationId; //국가 아이디
	private String nationName; //작가 국가
	private String authorIntro; //작가소개
	private Date regDate; //등록 날짜 
	private Date updateDate; // 수정 날짜
}
