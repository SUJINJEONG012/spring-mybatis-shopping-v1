package com.mybatis.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.BookMapper;
import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.Criteria;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;
	
	/* 상품 검색 */
	@Override
	public List<BookVo> getGoodsList(Criteria cri) {
		log.info("getGoodsList()............");
		return bookMapper.getGoodsList(cri);
	}

	/* 상품 총 개수 */
	@Override
	public int goodsGetTotal(Criteria cri) {
		log.info("goodsGetTotal()..........");
		return bookMapper.goodsGetTotal(cri);
	}

}
