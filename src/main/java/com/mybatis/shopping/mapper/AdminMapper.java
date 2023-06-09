package com.mybatis.shopping.mapper;

import java.util.List;

import com.mybatis.shopping.model.AttachImageVo;
import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CateVo;
import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.OrderDto;

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
	
	/* 상품 수정 */
	public int goodsModify(BookVo bookVo);
	
	/* 상품 삭제 */
	public int goodsDelete(int bookId);
	
	/* 이미지 등록 */
	public void imageEnroll(AttachImageVo attachImageVo);
	
	/* 지정상품 이미지 전체 삭제 */
	public void deleteImageAll(int bookId);
	
	/* 어제자 날짜 이미지 리스트 */
	public List<AttachImageVo> checkFileList();
	
   /* 지정 상품 이미지 정보 얻기 */
	public List<AttachImageVo> getAttachInfo(int bookId);
	
	/* 주문 상품 리스트 */
	public List<OrderDto> getOrderList(Criteria cri);
	
	/* 주문 총 개수 */
	public int getOrderTotal(Criteria cri);
	
}
