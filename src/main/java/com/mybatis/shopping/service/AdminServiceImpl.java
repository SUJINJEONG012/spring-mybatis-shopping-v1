package com.mybatis.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.AdminMapper;
import com.mybatis.shopping.model.BookVo;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public void bookEnroll(BookVo bookVo) {
		
		log.info("(service) bookEnroll............");
		adminMapper.bookEnroll(bookVo);
	}
	
}
