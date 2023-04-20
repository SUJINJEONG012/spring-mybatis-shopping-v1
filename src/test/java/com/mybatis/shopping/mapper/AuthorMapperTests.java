package com.mybatis.shopping.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.controller.AdminController;
import com.mybatis.shopping.model.AuthorVo;
import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.service.AuthorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AuthorMapperTests {
	
	@Autowired
	private AuthorMapper authorMapper;
	
	/* 작가등록 테스트 */
//	@Test
//	public void authorEnroll() throws Exception{
//		AuthorVo authorVo = new AuthorVo();
//		
//		authorVo.setNationId("01");
//		authorVo.setAuthName("테스트");
//		authorVo.setAuthorIntro("테스트 소개");
//		
//		authorMapper.authorEnroll(authorVo);
//	}
	
	
	/* 작가 목록 테스트 */
//	@Test
//    public void authorGetListTest() throws Exception{       
//        Criteria cri = new Criteria(3,10);    // 3페이지 & 10개 행 표시
//        cri.setKeyword("제인오스틴");
//        List<AuthorVo> list = authorMapper.authorGetList(cri);
//        
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println("list" + i + ".........." + list.get(i));
//        }        
//    }
	
	
	/* 작가 총 수 */
//	@Test
//	public void authorGetTotal() throws Exception {
//		Criteria cri = new Criteria();
//		cri.setKeyword("제인오스틴");
//		int total = authorMapper.authorGetTotal(cri);
//		System.out.println("total.............." + total);
//	}
	
	/* 작가 상세 페이지 */
//	@Test
//	public void authorGetDetailTest() throws Exception {
//		int authorId = 20;
//	
//		AuthorVo authorVo = authorMapper.authorGetDetail(authorId);
//		System.out.println("authorVo 작가상세 페이지 mapper메서드 확인용......" + authorVo);
//	
//	}
	
	/* 작가 정보 수정 */
//	@Test
//	public void authorModifyTest() {
//		AuthorVo authorVo  = new AuthorVo();
//		authorVo.setAuthorId(1);
//		System.out.println("수정전 : " + authorMapper.authorGetDetail(authorVo.getAuthorId()));
//	authorVo.setAuthName("수정");
//	authorVo.setAuthorId(01);
//	authorVo.setAuthorIntro("소개수정 테스트");
//	
//	authorMapper.authorModify(authorVo);
//	System.out.println("수정 후 : " + authorMapper.authorGetDetail(authorVo.getAuthorId()));
//	}
	
	/* 작가 삭제 */
	@Test
	public void authorDeleteTest() {
		int authorId = 210;
		int result = authorMapper.authorDelete(authorId);
		if(result == 1 ) {
			System.out.println("삭제성공");
		}
	}
	
}
