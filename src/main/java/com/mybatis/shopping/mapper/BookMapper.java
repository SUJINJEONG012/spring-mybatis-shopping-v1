package com.mybatis.shopping.mapper;

import java.util.List;

import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.Criteria;

public interface BookMapper {

	/* 상품 검색 */
	public List<BookVo> getGoodsList(Criteria cri);
	
	/* 상품 총 개수 */
	public int goodsGetTotal(Criteria cri);
	
	/* 작가 ID 리스트 요청 */
	public String[] getAuthorIdList(String keyword);
	
}
