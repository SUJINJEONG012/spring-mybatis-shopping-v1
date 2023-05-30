
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mybatis.shopping.model.AttachImageVo;
import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.PageDto;
import com.mybatis.shopping.model.ReplyDto;
import com.mybatis.shopping.service.AttachService;
import com.mybatis.shopping.service.BookService;
import com.mybatis.shopping.service.ReplyService;

@Controller
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);	
	
	@Autowired
	private AttachService attachService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ReplyService replyService;
	
	
	/* 메인페이지 이동 */
	@RequestMapping(value = "/", method = RequestMethod.GET)

	public String main(Model model) {
		
		logger.info("메인페이지 진입 ");
		model.addAttribute("cate1",bookService.getCateCode1());
		model.addAttribute("cate2",bookService.getCateCode2());
		model.addAttribute("ls", bookService.likeSelect());
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
		
		List<BookVo> bookList = bookService.getGoodsList(cri);
		
		logger.info("pre list : " + bookList);
		
		if(!bookList.isEmpty()) {
			model.addAttribute("bookList" , bookList);
			logger.info("pre bookList : " + bookList);
		}else {
			model.addAttribute("listcheck" , "empty");
			return "search";
		}
		
		model.addAttribute("pageMaker",  new PageDto(cri, bookService.goodsGetTotal(cri)));
		
		String [] typeArr = cri.getType().split("");
		for(String s: typeArr) {
			if(s.equals("T") || s.equals("A")) {
				 model.addAttribute("filter_info", bookService.getCateInfoList(cri));
			}
		}
		return "search";	
	}
	
	/* 상품 상세 */
	@GetMapping("/goodsDetail/{bookId}")
	public String goodsDetailGet(@PathVariable("bookId") int booId, Model model) {
		logger.info("goodsDetailGet()............");
		model.addAttribute("goodsInfo", bookService.getGoodsInfo(booId));
		return "/goodsDetail";
	}
	
	
	/* 리뷰 쓰기 */
	@GetMapping("/replyEnroll/{memberId}")
	public String replyEnrollWindowGet(@PathVariable("memberId") String memberId, int bookId, Model model) {
		BookVo book = bookService.getBookIdName(bookId);
		model.addAttribute("bookInfo", book);
		model.addAttribute("memberId", memberId);
		return "/replyEnroll";
	}
	
	
	/* 리뷰 수정 팝업창 */
	@GetMapping("/replyUpdate")
	public String replyUpdateWindowGet(ReplyDto dto, Model model){
		BookVo book = bookService.getBookIdName(dto.getBookId());
		model.addAttribute("bookInfo",book);
		model.addAttribute("replyInfo",replyService.getUpdateReply(dto.getReplyId()));
		model.addAttribute("memberId", dto.getMemberId());
		return "/replyUpdate";
	}
	
}
