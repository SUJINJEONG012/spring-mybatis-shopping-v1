package com.mybatis.shopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mybatis.shopping.model.AuthorVo;
import com.mybatis.shopping.service.AuthorService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AuthorService authorService;
	
	/* 관리자 메인페이지로 이동 */
	@GetMapping("/main")
	public void adminMainGet() throws Exception {
		logger.info("관리자 페이지로 이동");
	}

	/* 상품 관리 페이지 */
	@GetMapping("/goodsManage")
	public void goodsMangeGet() throws Exception {
		logger.info("상품등록 페이지 접속");
	}

	/* 상품 등록 페이지 */
	@GetMapping("/goodsEnroll")
	public void goodsEnrollGet() throws Exception {
		logger.info("상품등록 페이지 접속");
	}

	/* 작가 등록 페이지 */
	@GetMapping("/authorEnroll")
	public void authorEnrollGet() throws Exception {
		logger.info("작가등록 페이지접속");
	}

	/* 작가 관리 페이지 */
	@GetMapping("/authorManage")
	public void authorMangeGet() throws Exception {
		
		logger.info("작가관리페이지 접속");
	}
	
	
	/* 작가 등록 관리 페이지 */
	@PostMapping("/authorEnroll")
	public String authorEnroll(AuthorVo authorVo, RedirectAttributes rttr) throws Exception {
		logger.info("@@@@@@@@@@@@@@@ authorEnroll : " + authorVo);
		authorService.authorEnrol(authorVo); //작가 등록 쿼리 수행
		rttr.addFlashAttribute("enroll_result" + authorVo.getAuthName());
 		return "redirect:/admin/authorManage";
	}
	
	

}
