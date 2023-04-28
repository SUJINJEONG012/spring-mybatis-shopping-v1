package com.mybatis.shopping.service;

import java.util.List;

import com.mybatis.shopping.model.AttachImageVo;

public interface AttachService {

	/* 이미지 데이터 반환 */
	public List<AttachImageVo> getAttachList(int bookId);
	
}
