package com.mybatis.shopping.service;

import java.util.List;

import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CateFilterDto;
import com.mybatis.shopping.model.CateVo;
import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.SelectDto;

public interface BookService {

	/* 상품 검색 */
	public List<BookVo> getGoodsList(Criteria cri);
	
	/* 상품 총 개수 */
	public int goodsGetTotal(Criteria cri);

	/* 국내 카테고리 리스트 */
	public List<CateVo> getCateCode1();
	
	/* 국외 카테고리 리스트 */
	public List<CateVo> getCateCode2();
	
	/* 검색 결과 카테고리 필터 정보 반환 해주는 메서드 */
	public List<CateFilterDto> getCateInfoList(Criteria cri);
	
	/* 상품 정보 */
	public BookVo getGoodsInfo(int bookId);
	
	/* 상품 id 이름 */
	public BookVo getBookIdName(int bookId);
	/* 평점순 상품 정보 */
	
	public List<SelectDto> likeSelect();
}
