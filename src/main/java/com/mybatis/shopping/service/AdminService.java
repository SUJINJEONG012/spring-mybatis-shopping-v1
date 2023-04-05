package com.mybatis.shopping.service;

import java.util.List;

import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CateVo;
import com.mybatis.shopping.model.Criteria;

public interface AdminService {
	/* 상품등록 */
	public void bookEnroll (BookVo bookVo);
	
	/*카테고리 리스트 */
	public List<CateVo> cateList();
	
	/* 상품 리스트 */
	public List<BookVo> goodsGetList(Criteria cri);
	
	/* 상품 총 개수 */
	public int goodsGetTotal(Criteria cri);

}
