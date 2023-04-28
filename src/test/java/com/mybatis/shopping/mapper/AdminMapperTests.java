package com.mybatis.shopping.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.AttachImageVo;
import com.mybatis.shopping.model.BookVo;

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
//		bookVo.setBookName("수정이 안되서 다시 테스트로 등록 ");
//		bookVo.setAuthorId(62);
//		bookVo.setPubleYear("2023-04-17");
//		bookVo.setPublisher("출판사2");
//		bookVo.setCateCode("103003");
//		bookVo.setBookPrice(20000);
//		bookVo.setBookStock(30);
//		bookVo.setBookDiscount(0.23);
//		bookVo.setBookIntro("책 소개222");
//		bookVo.setBookContents("책 목222차");
//		
//		adminMapper.bookEnroll(bookVo);
//	}
	
	/* 카테고리 테스트 */
//	@Test
//	public void cateListTest() throws Exception {
//	  System.out.println("cateList().........." + adminMapper.cateList());
//	}
	
	/* 상품리스트 및 상품 총 개수 테스트 */
//	@Test
//	public void goodsGetListTest() {
//		
//		Criteria cri = new Criteria();
//		
//		//검색조건
//		cri.setKeyword("테스트");
//		
//		
//		//검색 리스트
//		List list = adminMapper.goodsGetList(cri);
//		for(int i = 0; i< list.size(); i++) {
//			System.out.println("result........." +  i + " : "  + list.get(i));
//		}
//		
//		int result = adminMapper.goodsGetTotal(cri);
//		System.out.println("result........" + result);
//		
//	}
	
	
	/* 상품 조회 페이지 */
//	@Test
//	public void goodsGetDetailTest() {
//		int bookId = 10;
//		BookVo result = adminMapper.goodsGetDetail(bookId);
//		System.out.println("상품조회 데이터 : " + result);
//	}
	
	
	/* 상품 정보 수정 페이지 */
//	@Test
//	public void goodsModifyTest() {
//		BookVo bookVo = new BookVo();
//		bookVo.setBookId(4087);
//		bookVo.setBookName("회사에서 수정");
//		bookVo.setAuthorId(4);
//		bookVo.setPubleYear("2023-04-17");
//		bookVo.setPublisher("출판사1");
//		bookVo.setCateCode("102002");
//		bookVo.setBookPrice(424000);
//		bookVo.setBookStock(300);
//		bookVo.setBookIntro("책소개11");
//		bookVo.setBookContents("책 목차222");
//		bookVo.setBookDiscount(0.9);
//
//		adminMapper.goodsModify(bookVo);
//		
//	}
	
	/*상품 정보 삭제 */
//	@Test
//	public void goodsDeleteTest() {
//		int bookId= 169;
//		int result = adminMapper.goodsDelete(bookId);
//		if(result ==1 ) {
//			System.out.println("삭제성공");
//		}
//	}
	
	
	/* 이미지 등록 테스트 */
	@Test
	public void imageEnrollTest() {
		AttachImageVo attachImageVo = new AttachImageVo();
		attachImageVo.setBookId(13);
		attachImageVo.setFileName("test");
		attachImageVo.setUploadPath("test");
		attachImageVo.setUuid("test2");
		
		adminMapper.imageEnroll(attachImageVo);
	}
	
}
