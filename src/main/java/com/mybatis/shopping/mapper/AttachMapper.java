package com.mybatis.shopping.mapper;

import java.util.List;

import com.mybatis.shopping.model.AttachImageVo;

public interface AttachMapper {

	/* 이미지 데이터 반환 */
	public List<AttachImageVo> getAttachList(int bookId);
	
}
