package com.mybatis.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.shopping.mapper.AdminMapper;
import com.mybatis.shopping.model.AttachImageVo;
import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CateVo;
import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.OrderDto;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;

	/* 상품 등록 */
	@Transactional
	@Override
	public void bookEnroll(BookVo bookVo) {
		
		log.info("(service) bookEnroll............");
		adminMapper.bookEnroll(bookVo);
		
		//이미지 존재여부 확인 
		if(bookVo.getImageList() == null || bookVo.getImageList().size() <= 0) {
			return;
		}
		
		//람다식 활용한 for 문
		bookVo.getImageList().forEach(attach ->{
			attach.setBookId(bookVo.getBookId());
			adminMapper.imageEnroll(attach);
			
		});
		
		
	}

	/* 카테고리 리스트 */
	@Override
	public List<CateVo> cateList() {
		
		log.info("(service) cateList.................");
		
		return adminMapper.cateList();
	}
	
	

	/* 상품 리스트 */
	@Override
	public List<BookVo> goodsGetList(Criteria cri) {
		log.info("googsGetList().................");
		return adminMapper.goodsGetList(cri);
	}

	/* 상품 총 개수 */
	@Override
	public int goodsGetTotal(Criteria cri) {
		log.info("googsGetTotal().................");
		return adminMapper.goodsGetTotal(cri);
	}

	/* 상품 상세 페이지 */
	@Override
	public BookVo goodsGetDetail(int bookId) {
		log.info("goodsGetDetail()................" + bookId);
		return adminMapper.goodsGetDetail(bookId);
	}

	
	/* 상품 수정 페이지 */
	@Transactional
	@Override 
	public int goodsModify(BookVo bookVo) {
		log.info("goodsModify()..........." + bookVo);
	
		/* 상품 정보 데이터를 db에 반영하는 쿼리문을 수행하는 메서드만을 호출하고 그 결과 값을 반환 
		return adminMapper.goodsModify(bookVo);*/
		
		int result = adminMapper.goodsModify(bookVo);
		if(result == 1 && bookVo.getImageList() != null && bookVo.getImageList().size() > 0) {
			adminMapper.deleteImageAll(bookVo.getBookId());
			bookVo.getImageList().forEach(attach ->{
				attach.setBookId(bookVo.getBookId());
				adminMapper.imageEnroll(attach);
			});
		}
		return result;
		
		
	}
	
	/* 상품 삭제 페이지 */
	@Override
	public int goodsDelete(int bookId) {
		log.info("goodsDelete.............");
		//DB데이터 삭제
		adminMapper.deleteImageAll(bookId);
		return adminMapper.goodsDelete(bookId);
	}
	
	
	/* 지정 상품 이미지 정보 얻기 */
	@Override
	@Transactional
	public List<AttachImageVo> getAttachInfo(int bookId) {
		log.info("getAttachInfo..............");
			
		return adminMapper.getAttachInfo(bookId);
	}

	/* 주문 상품 리스트 */
	@Override
	public List<OrderDto> getOrderList(Criteria cri) {
		
		return adminMapper.getOrderList(cri);
	}

	/* 주문 총 개수 */
	@Override
	public int getOrderTotal(Criteria cri) {
		
		return adminMapper.getOrderTotal(cri);
	}
	
	
	
	
}
