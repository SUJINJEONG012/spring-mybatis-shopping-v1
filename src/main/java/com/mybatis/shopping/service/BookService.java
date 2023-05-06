package com.mybatis.shopping.service;

import java.util.List;

import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.Criteria;

public interface BookService {

	/* 상품 검색 */
	public List<BookVo> getGoodsList(Criteria cri);
	
	/* 상품 총 개수 */
	public int goodsGetTotal(Criteria cri);
	

	
}
