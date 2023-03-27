package com.mybatis.shopping.service;

import java.util.List;

import com.mybatis.shopping.model.AuthorVo;
import com.mybatis.shopping.model.Criteria;

public interface AuthorService {
	/* 작가등록 */
	public void authorEnrol(AuthorVo authorVo) throws Exception;
	
	/* 작가 목록 */
	public List<AuthorVo> authorGetList(Criteria cri) throws Exception;

}
