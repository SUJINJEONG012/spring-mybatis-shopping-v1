package com.mybatis.shopping.mapper;

import java.util.List;

import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CateFilterDto;
import com.mybatis.shopping.model.CateVo;
import com.mybatis.shopping.model.Criteria;

public interface BookMapper {

	/* 상품 검색 */
	public List<BookVo> getGoodsList(Criteria cri);
	
	/* 상품 총 개수 */
	public int goodsGetTotal(Criteria cri);
	
	/* 작가 ID 리스트 요청 */
	public String[] getAuthorIdList(String keyword);
	
	/* 국내 카테고리 리스트 */
	public List<CateVo> getCateCode1();
	/* 국외 카테고리 리스트 */
	public List<CateVo> getCateCode2();
	
	/* 검색 대상 카테고리 리스트 
	 * 
	 * 코드번호를 String배열에 담아서 반환, 파라미터를 Criteria조건문에 사용하기 때문에 넣어줌
	 * */
	public String[] getCateList(Criteria cri);
	
	/* 카테고리 정보 (+검색대장 개수)*/
	public CateFilterDto getCateInfo(Criteria cri);
	
	/* 상품 정보 */
	public BookVo getGoodsInfo(int bookId);
	
	/* 상품 id 이름 */
	public BookVo getBookIdName(int bookId);
	
}
