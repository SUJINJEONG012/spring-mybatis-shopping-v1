package com.mybatis.shopping.mapper;

import java.util.List;

import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CateVo;
import com.mybatis.shopping.model.Criteria;

public interface AdminMapper {

	/* 상품 등록 */
	public void bookEnroll(BookVo bookVo);
	
	/* 카테고리 리스트 */
	public List<CateVo> cateList();
	
	
	/* 상품리스트 */
	public List<BookVo> goodsGetList(Criteria cri);
	
	/* 상품 총 개수 */
	public int goodsGetTotal(Criteria cri);
	
	/* 상품 조회 페이지 */
	public BookVo goodsGetDetail(int bookId);
}
