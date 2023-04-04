package com.mybatis.shopping.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminMapperTests {

	@Autowired
	private AdminMapper adminMapper; 
	
	/* 상품 등록 테스트 */
//	@Test
//	public void bookEnrollTest() throws Exception {
//		
//		BookVo bookVo = new BookVo();
//		
//		bookVo.setBookName("mapper테스트");
//		bookVo.setAuthorId(12);
//		bookVo.setPubleYear("2023-03-31");
//		bookVo.setPublisher("출판사");
//		bookVo.setCateCode("0231");
//		bookVo.setBookPrice(20000);
//		bookVo.setBookStock(30);
//		bookVo.setBookDiscount(0.23);
//		bookVo.setBookIntro("책 소개");
//		bookVo.setBookContents("책 목차");
//		
//		adminMapper.bookEnroll(bookVo);
//	}
	
	/* 카테고리 테스트 */
//	@Test
//	public void cateListTest() throws Exception {
//	  System.out.println("cateList().........." + adminMapper.cateList());
//	}
	
	/* 상품리스트 및 상품 총 개수 테스트 */
	@Test
	public void goodsGetListTest() {
		
		Criteria cri = new Criteria();
		
		//검색조건
		cri.setKeyword("테스트");
		
		
		//검색 리스트
		List list = adminMapper.goodsGetList(cri);
		for(int i = 0; i< list.size(); i++) {
			System.out.println("result........." +  i + " : "  + list.get(i));
		}
		
		int result = adminMapper.goodsGetTotal(cri);
		System.out.println("result........" + result);
		
	}
	
}
