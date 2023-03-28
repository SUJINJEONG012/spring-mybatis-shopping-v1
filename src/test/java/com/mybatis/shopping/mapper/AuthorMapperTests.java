package com.mybatis.shopping.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.AuthorVo;
import com.mybatis.shopping.model.Criteria;

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
	@Test
	public void authorGetTotal() throws Exception {
		Criteria cri = new Criteria();
		cri.setKeyword("제인오스틴");
		int total = authorMapper.authorGetTotal(cri);
		System.out.println("total.............." + total);
	}
	
	
	
}
