package com.mybatis.shopping.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.AuthorMapper;
import com.mybatis.shopping.model.AuthorVo;
import com.mybatis.shopping.model.Criteria;

@Service
public class AuthorServiceImpl implements AuthorService {

	private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);
	
	@Autowired
	AuthorMapper authorMapper;
	
	@Override
	public void authorEnrol(AuthorVo authorVo) throws Exception {
		authorMapper.authorEnroll(authorVo);	
	}

	@Override
	public List<AuthorVo> authorGetList(Criteria cri) throws Exception {
		log.info("(service)authorGetList()............." + cri);
		return authorMapper.authorGetList(cri);
	}

	@Override
	public int authorGetTotal(Criteria cri) throws Exception {
		log.info("authorGetTotal.........." + cri);
		return authorMapper.authorGetTotal(cri);
	}

	@Override
	public AuthorVo authorGetDetail(int authorId) throws Exception {
		log.info("authorGetDetail......." + authorId);
		
		return authorMapper.authorGetDetail(authorId);
	}
	
	
	
	
	
	
}
