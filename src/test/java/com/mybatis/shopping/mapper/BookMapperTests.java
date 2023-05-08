package com.mybatis.shopping.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CateVo;
import com.mybatis.shopping.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookMapperTests {

	@Autowired
	private BookMapper bookMapper;
	
//	@Test
//	public void getGoodsListTest() {
//		Criteria cri = new Criteria();
//		//테스트 키워드
//		System.out.println("cri : " + cri);
//		
//		
//		List<BookVo> list = bookMapper.getGoodsList(cri);
//		System.out.println("list : " + list);
//		
//		System.out.println("========");
//		
//		int goodsTotal = bookMapper.goodsGetTotal(cri);
//		System.out.println("total : " + goodsTotal);
//	}
	
	/* 작가 Id 리스트 요청 */
//	@Test
//	public void getAuthorId() {
//		String keyword = "ll";
//		String[] list = bookMapper.getAuthorIdList(keyword);
//		System.out.println("결과 :  " + list.toString());
//		
//		for(String id: list) {
//			System.out.println("개별 결과 : " + id);
//		}
//	}
	
	/*  검색 동적쿼리 적용 - 작가 */
	@Test
	public void getGoodsListTest1() {
		//
		Criteria cri = new Criteria();
		String type="A";
		String keyword = "유흥준";
		String cateCode ="";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(bookMapper.getAuthorIdList(keyword));
		cri.setCateCode(cateCode);
		
		List<BookVo> list = bookMapper.getGoodsList(cri);
		
		System.out.println("cri : " + cri);
		System.out.println("list : " + list);
	}
	
	@Test
	public void getGoodsListTest2() {
		Criteria cri = new Criteria();
		String type ="T";
		String keyword="테스트";
		String cateCode ="";
		
		cri.setType(type);
		cri.setKeyword(keyword);
		cri.setAuthorArr(bookMapper.getAuthorIdList(keyword));
		cri.setCateCode(cateCode);
		
		List<BookVo> list = bookMapper.getGoodsList(cri);
		
		System.out.println("cri : " + cri);
		System.out.println("list : " + list);
	}
	
	@Test
	public void getCateCode1() {
		List<CateVo> getCateCode1 = bookMapper.getCateCode1();
		System.out.println("getCateCode1 @@@@@@: " + getCateCode1);
	}

}
