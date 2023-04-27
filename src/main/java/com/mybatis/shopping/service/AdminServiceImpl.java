package com.mybatis.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.shopping.mapper.AdminMapper;
import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CateVo;
import com.mybatis.shopping.model.Criteria;

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
	@Override
	public int goodsModify(BookVo bookVo) {
		log.info("goodsModify()..........." + bookVo);
		
		return adminMapper.goodsModify(bookVo);
	}
	
	/* 상품 삭제 페이지 */
	@Override
	public int goodsDelete(int bookId) {
		log.info("goodsDelete.............");
		return adminMapper.goodsDelete(bookId);
	}
	
	
	
	
}
