package com.mybatis.shopping.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.AuthorVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AuthorMapperTests {

	@Autowired
	private AuthorMapper authorMapper;
	
	/* 작가등록 테스트 */
	@Test
	public void authorEnroll() throws Exception{
		AuthorVo authorVo = new AuthorVo();
		
		authorVo.setNationId("01");
		authorVo.setAuthName("테스트");
		authorVo.setAuthorIntro("테스트 소개");
		
		authorMapper.authorEnroll(authorVo);
	}
}
