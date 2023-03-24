package com.mybatis.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.AuthorMapper;
import com.mybatis.shopping.model.AuthorVo;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorMapper authorMapper;
	
	@Override
	public void authorEnrol(AuthorVo authorVo) throws Exception {
		authorMapper.authorEnroll(authorVo);	
	}
	
	
}
