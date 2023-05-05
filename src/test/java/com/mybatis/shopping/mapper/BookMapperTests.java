package com.mybatis.shopping.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookMapperTests {

	@Autowired
	private BookMapper bookMapper;
	
	@Test
	public void getGoodsListTest() {
		Criteria cri = new Criteria();
		//테스트 키워드
		System.out.println("cri : " + cri);
		
		
		List<BookVo> list = bookMapper.getGoodsList(cri);
		System.out.println("list : " + list);
		
		System.out.println("========");
		
		int goodsTotal = bookMapper.goodsGetTotal(cri);
		System.out.println("total : " + goodsTotal);
	}
	
}
