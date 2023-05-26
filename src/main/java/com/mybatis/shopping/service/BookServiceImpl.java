package com.mybatis.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.AdminMapper;
import com.mybatis.shopping.mapper.AttachMapper;
import com.mybatis.shopping.mapper.BookMapper;
import com.mybatis.shopping.model.AttachImageVo;
import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CateFilterDto;
import com.mybatis.shopping.model.CateVo;
import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.SelectDto;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private AttachMapper attachMapper;
	
	@Autowired
	private AdminMapper adminMapper;
	
	/* 상품 검색 */
	@Override
	public List<BookVo> getGoodsList(Criteria cri) {
		
		log.info("getGoodsList()............");
		
		String type= cri.getType();
		String [] typeArr = type.split("");
		String [] authorArr = bookMapper.getAuthorIdList(cri.getKeyword());
		
		
		if(type.equals("A") || type.equals("AC") || type.equals("AT") || type.equals("ACT")) {
			if(authorArr.length == 0) {
				return new ArrayList();
			}
		}
		
		for(String t : typeArr) {
			if(t.equals("A")) {
				cri.setAuthorArr(authorArr);
			}
		}
		
		List<BookVo> list = bookMapper.getGoodsList(cri);
		list.forEach(book->{
			int bookId = book.getBookId();
			List<AttachImageVo> imageList = attachMapper.getAttachList(bookId);
			book.setImageList(imageList);
		});
		
		return list;
	}

	/* 상품 총 개수 */
	@Override
	public int goodsGetTotal(Criteria cri) {
		log.info("goodsGetTotal()..........");
		return bookMapper.goodsGetTotal(cri);
	}

	/* 국내 카테고리 리스트 */
	@Override
	public List<CateVo> getCateCode1() {
		log.info("getCateCode1()....");
		return bookMapper.getCateCode1();
	}

	/* 국외 카테고리 리스트 */
	@Override
	public List<CateVo> getCateCode2() {
		log.info("getCateCode2()....");
		return bookMapper.getCateCode2();
	}

	/* 검색 결과 카테고리 필터 정보 반환 해주는 메서드 */
	@Override
	public List<CateFilterDto> getCateInfoList(Criteria cri) {
		//먼저 반환할 데이터가 담길 상자 역할을 할 List<CateFilterDto타입의 filterInfoList객체를 선언 및 초기화
		List<CateFilterDto> filterInfoList = new ArrayList<CateFilterDto>();
		
		
		String[] typeArr = cri.getType().split("");
		String[] authorArr;
		
		for(String type: typeArr) {
			if(type.equals("A")) {
				authorArr = bookMapper.getAuthorIdList(cri.getKeyword());
				if(authorArr.length == 0) {
					return filterInfoList;
				}
				cri.setAuthorArr(authorArr);
			}
		}
		
		//필터 정보의 대상이 될 '카테고리코드'를 반환해주는 getAuthorIdList를 호출 하고 반환값을  String 배열 타입의 cateList 변수에 저장
		String[] cateList = bookMapper.getCateList(cri);
		String tempCateCode = cri.getCateCode();

		for(String cateCode : cateList) {
			cri.setCateCode(cateCode);
			CateFilterDto filterInfo = bookMapper.getCateInfo(cri);
			filterInfoList.add(filterInfo);
		}
		
		cri.setCateCode(tempCateCode);
		
		return filterInfoList ;
	}

	/* 상품 정보 */
	@Override
	public BookVo getGoodsInfo(int bookId) {
		BookVo goodsInfo = bookMapper.getGoodsInfo(bookId);
		goodsInfo.setImageList(adminMapper.getAttachInfo(bookId));
		return goodsInfo;
	}

	/* 상품 id 이름 */
	@Override
	public BookVo getBookIdName(int bookId) {
		return bookMapper.getBookIdName(bookId);
	}

	/* 평점순 상품 정보 */
	@Override
	public List<SelectDto> likeSelect() {
		List<SelectDto> list = bookMapper.likeSelect();
		list.forEach(dto ->{
			int bookId = dto.getBookId();
			List<AttachImageVo> imageList = attachMapper.getAttachList(bookId);
			dto.setImageList(imageList);
		});
		return list;
	}

}
