package com.mybatis.shopping.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mybatis.shopping.model.AttachImageVo;
import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.PageDto;
import com.mybatis.shopping.service.AttachService;
import com.mybatis.shopping.service.BookService;

@Controller
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);	
	
	@Autowired
	private AttachService attachService;
	
	@Autowired
	private BookService bookService;
	
	/* 메인페이지 이동 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		logger.info("메인페이지 진입 ");
		return "main";
	}
	
	/* 이미지 출력 */
	@GetMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName) {
	//ResponseEntity객체를 통해 body에 []데이터를 보내야 하기 때문에 ResponseEntity<byte[]>를 반환 타입으로 작성
	
	logger.info("getImage()..........." + fileName);
	
	//File file = new File("C:\\upload\\" + fileName);
	File file = new File("/Users/jeongsujin/upload/" + fileName);
	
	ResponseEntity<byte[]> result = null;
	
	try {
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", Files.probeContentType(file.toPath()));
		result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);		
	}catch(IOException e) {
		e.printStackTrace();
	}

	return result;
	
	}
	
	/* 이미지 반환 */
	@GetMapping(value="/getAttachList", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachImageVo>> getAttachList(int bookId){
		logger.info("getAttachList.......... "  + bookId);
		return new ResponseEntity<List<AttachImageVo>>(attachService.getAttachList(bookId), HttpStatus.OK);
	}
	
	
	/* 상품검색 */
	@GetMapping("/search")
	public String searchGoodsGet(Criteria cri, Model model) {
		logger.info("@@ cri : " + cri);
		
		List<BookVo> list = bookService.getGoodsList(cri);
		logger.info("pre list : " + list);
		
		if(!list.isEmpty()) {
			model.addAttribute("list" , list);
			logger.info("pre list : " + list);
		}else {
			model.addAttribute("listcheck" , "empty");
			return "search";
		}
		
		model.addAttribute("pageMaker",  new PageDto(cri, bookService.goodsGetTotal(cri)));
		return "search";
	}
}
