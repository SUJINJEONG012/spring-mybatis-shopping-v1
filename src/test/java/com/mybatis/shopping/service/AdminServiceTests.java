package com.mybatis.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.AttachImageVo;
import com.mybatis.shopping.model.BookVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminServiceTests {

	@Autowired
	private AdminService service;
	
	/* 상품등록 & 상품 이미지 등록 테스트 */
	@Test
	public void bookEnrollTests() {
		BookVo bookVo = new BookVo();
		//상품정보 
		bookVo.setBookName("상품이미지 테스");
		bookVo.setAuthorId(8);
		bookVo.setPubleYear("2023-04-27");
		bookVo.setPublisher("출판사");
		bookVo.setCateCode("202001");
		bookVo.setBookPrice(20000);
		bookVo.setBookStock(300);
		bookVo.setBookDiscount(0.23);
		bookVo.setBookIntro("책 소개 ");
		bookVo.setBookContents("책 목차 ");
		
		//이미지 정보
		List<AttachImageVo> imageList = new ArrayList<AttachImageVo>();
		
		AttachImageVo image1 = new AttachImageVo();
		AttachImageVo image2 = new AttachImageVo();
		
		image1.setFileName("test Image 1");
		image1.setUploadPath("test image 1");
		image1.setUuid("test1111");
		
		image2.setFileName("test Image 2");
		image2.setUploadPath("test image 2");
		image2.setUuid("test2222");

		imageList.add(image1);
		imageList.add(image2);
		
		bookVo.setImageList(imageList);
		service.bookEnroll(bookVo);
		
		System.out.println("등록된 Vo: "  + bookVo);
	
	}
	
	
}
