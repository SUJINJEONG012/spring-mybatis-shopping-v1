package com.mybatis.shopping.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorVo {
 
	private int authorId;
	private String authName;
	private String nationId;
	private String nationName;
	private String authorIntro;
	private Date regDate;
	private Date updateDate;
}
