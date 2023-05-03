package com.mybatis.shopping.model;

import lombok.Data;

@Data
public class AttachImageVo {

	//경로
	private String uploadPath;
	//uuid
	private String uuid;
	//파일이름
	private String fileName;	
	//상품 id
	private int bookId;
	
	
}
