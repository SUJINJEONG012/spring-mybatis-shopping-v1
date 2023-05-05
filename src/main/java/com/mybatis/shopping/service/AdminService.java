package com.mybatis.shopping.service;

import java.util.List;

import com.mybatis.shopping.model.AttachImageVo;
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
	
	/* 상품 조회 */
	public BookVo goodsGetDetail(int bookId);
	
	/* 상품 수정 */
	public int goodsModify(BookVo bookVo);
	
	/* 상품 삭제 */
	public int goodsDelete(int bookId);
	
	/* 지정 상품 이미지 정보 얻기 */
	public List<AttachImageVo> getAttachInfo(int bookId);

}
