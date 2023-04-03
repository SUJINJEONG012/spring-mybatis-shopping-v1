package com.mybatis.shopping.service;

import java.util.List;

import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CateVo;

public interface AdminService {
	/* 상품등록 */
	public void bookEnroll (BookVo bookVo);
	
	/*카테고리 리스트 */
	public List<CateVo> cateList();

}
