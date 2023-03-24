package com.mybatis.shopping.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.AuthorVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AuthorServiceTests {
	/*AuthoreService 의존성 주입*/
    @Autowired
    private AuthorService authorService;
    
    
    @Test
    public void authorEnroll() throws Exception {
    
    	AuthorVo authorVo = new AuthorVo();
        
        authorVo.setNationId("01");
        authorVo.setAuthName("테스트");
        authorVo.setAuthorIntro("테스트 소개");
        
        authorService.authorEnrol(authorVo);
        
    }
       
}
