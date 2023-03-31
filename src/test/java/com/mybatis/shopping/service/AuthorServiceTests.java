package com.mybatis.shopping.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.AuthorVo;
import com.mybatis.shopping.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AuthorServiceTests {
	
	/*AuthoreService 의존성 주입*/
    
	@Autowired
    private AuthorService authorService;
    
    /* 작가 등록 테스트 */
//    @Test
//    public void authorEnroll() throws Exception {
//    
//    	AuthorVo authorVo = new AuthorVo();
//        
//        authorVo.setNationId("01");
//        authorVo.setAuthName("테스트");
//        authorVo.setAuthorIntro("테스트 소개");
//        
//        authorService.authorEnrol(authorVo);   
//    }
    
    /* 작가 목록 구현 */
//    @Test
//    public void authorGetListTest() {
//    	Criteria cri = new Criteria(3,10);
//    	List<E> list = authorService.authorGetList(cri);
//    	for(int i = 0; i < list.size(); i++) {
//    		System.out.println("list" + i + "....." + list.get(i));
//    	}
//    }
    
    /* 작가 상세 페이지 */
//    @Test
//    public void authorGetDetailTest() throws Exception {
//    	int authorId = 20;
//    	System.out.println("authorId @@@@@@@@" + authorService.authorGetDetail(authorId));
//    }
	
	/* 작가 정보 수정  */
	@Test
	public void authorModifyTest() throws Exception{
	 AuthorVo authorVo = new AuthorVo();
	 
	 authorVo.setAuthorId(1);
	 System.out.println("(service) 수정 전 ..........." + authorService.authorGetDetail(authorVo.getAuthorId()));
	 
	 authorVo.setAuthName("(service) 수정 합니다. 서비스단 ");
	 authorVo.setAuthorId(01);
	 authorVo.setAuthorIntro("(service )");
	 
	 authorService.authorModify(authorVo);
	 System.out.println("(service)................. 최종  : "  + authorService.authorGetDetail(authorVo.getAuthorId()));
	}
	
	

    
       
}
