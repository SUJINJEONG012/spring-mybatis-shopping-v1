package com.mybatis.shopping.mapper;

import java.util.List;

import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CateVo;

public interface AdminMapper {

	/* 상품 등록 */
	public void bookEnroll(BookVo bookVo);
	
	/* 카테고리 리스트 */
	public List<CateVo> cateList();
}
