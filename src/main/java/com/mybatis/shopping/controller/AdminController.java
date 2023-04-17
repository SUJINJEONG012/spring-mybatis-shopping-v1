package com.mybatis.shopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatis.shopping.model.AuthorVo;
import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.PageDto;
import com.mybatis.shopping.service.AdminService;
import com.mybatis.shopping.service.AuthorService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private AdminService adminService;
	
	/* 관리자 메인페이지로 이동 */
	@GetMapping("/main")
	public void adminMainGet() throws Exception {
		logger.info("관리자 페이지로 이동");
	}

	/* 상품 관리 페이지 */
	@GetMapping("/goodsManage")
	public void goodsManageGet(Criteria cri, Model model) throws Exception {
		logger.info("상품관리 페이지 접속");
		
		/* 상품 리스트 */
		List list = adminService.goodsGetList(cri);
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
		}else {
			model.addAttribute("listCheck", "empty");
			return;
		}
		/* 페이지 인터페이스 데이터 */
		model.addAttribute("pageMaker", new PageDto(cri, adminService.goodsGetTotal(cri)));
	}

	/* 상품 등록 페이지 */
	@GetMapping("/goodsEnroll")
	public void goodsEnrollGet(Model model) throws Exception {
		logger.info("상품등록 페이지 접속");
		
		ObjectMapper objm = new ObjectMapper();
		
		List list = adminService.cateList();
		String cateList = objm.writeValueAsString(list);
		model.addAttribute("cateList", cateList);
		
		logger.info(" 변경 전 .......... " +list);
		logger.info(" 변경 후 ............." + cateList);
	}
	
	
	/* 상품 조회 페이지 */
	@GetMapping({"/goodsDetail","/goodsModify"})
	public void goodsGetInfoGet(int bookId, Criteria cri, Model model) throws JsonProcessingException {
		logger.info("goodsGetInfo()..............." + bookId);
		
		ObjectMapper adminMapper = new ObjectMapper();
		
		/* 카테고리 리스트 데이터 */
		model.addAttribute("cateList", adminMapper.writeValueAsString(adminService.cateList()));	

		/* 목록 페이지 */
		model.addAttribute("cri", cri);
		
		/* 조회 페이지 정보 */
		model.addAttribute("goodsInfo", adminService.goodsGetDetail(bookId));		
		
	}
	
	/* 상품 수정 페이지 */
	@PostMapping("/goodsModify")
	public String goodsModifyPost(BookVo bookVo, RedirectAttributes rttr) {
		logger.info("goodsModifyPost......." + bookVo);
		
		int result = adminService.goodsModify(bookVo);
		
		rttr.addFlashAttribute("modify_result", result);
		
		return "redirect:/admin/goodsManage";		
	}
	
	/* 상품 정보 삭제 */
	@PostMapping("/goodsDelete")
	public String goodsDeletePost(int bookId, RedirectAttributes rttr) {
		logger.info("goodsDeletePost................");
		int result = adminService.goodsDelete(bookId);
		rttr.addFlashAttribute("delete_result",result);
		return "redirect:/admin/goodsManage";
	}
	
	
	/* 작가 등록 페이지 */
	@GetMapping("/authorEnroll")
	public void authorEnrollGet() throws Exception {
		logger.info("작가등록 페이지접속");
	}

	/* 작가 관리 페이지 */
	@GetMapping("/authorManage")
	public void authorMangeGet(Criteria cri, Model model) throws Exception {
		
		logger.info("작가관리페이지 접속");
		/* 작가목록 데이터 */
		List<?> list = authorService.authorGetList(cri);
		model.addAttribute("list", list);
		
		if(!list.isEmpty()) {
			model.addAttribute("list", list); // 작가 존재경우 
		}else {
			model.addAttribute("listCheck", "empty"); // 작가 존재하지 않을 경우
		}
	
		
		/* 페이지 이동 인터페이스 데이터 */
		int total = authorService.authorGetTotal(cri);
		PageDto pageMaker = new PageDto(cri, total);
		logger.info("pageStart 얼마인지 : 0보다 작은지 " + pageMaker.getPageStart());
		model.addAttribute("pageMaker", pageMaker);
	
	}
	
	
	/* 작가 등록 관리 페이지 */
	@PostMapping("/authorEnroll")
	public String authorEnroll(AuthorVo authorVo, RedirectAttributes rttr) throws Exception {
		logger.info("@@@@@@@@@@@@@@@ authorEnroll : " + authorVo);
		authorService.authorEnrol(authorVo); //작가 등록 쿼리 수행
		rttr.addFlashAttribute("enroll_result", authorVo.getAuthName());
		logger.info("@@ 이름들고오는지 확인 => "+ authorVo.getAuthName());
 		return "redirect:/admin/authorManage";
	}
	
	
	/* 작가 상세 페이지  맵핑주소 작가상세와 작가수정 */
	@GetMapping({"/authorDetail" , "/authorModify"})
	
	public void authorGetInfoGet(int authorId, Criteria cri, Model model) throws Exception {
		logger.info("authorDetail......" + authorId);
		
		/* 작가관리 페이지 정보*/
		model.addAttribute("cri", cri);
		
		/* 선택 작가 정보 */
		model.addAttribute("authorInfo", authorService.authorGetDetail(authorId));
	}
	
	
	
	/* 작가 정보 수정 */
	@PostMapping("/authorModify")
	public String authorModifyPost(AuthorVo authorVo , RedirectAttributes rttr) throws Exception {
		logger.info("authorModifyPost......." + authorVo);
		
		int result = authorService.authorModify(authorVo);
		rttr.addFlashAttribute("modify_result", result);
		return "redirect:/admin/authorManage";
	}
	
	
	
	/* 상품 등록 */
	@PostMapping("/goodsEnroll")
	public String goodsEnrollPost(BookVo bookVo, RedirectAttributes rttr) {
		logger.info("goodEnrollPost........." +  bookVo);
		adminService.bookEnroll(bookVo);
		rttr.addFlashAttribute("enroll_result", bookVo.getBookName());
		return "redirect:/admin/goodsManage";
	}
	
	/* 작가 검색 팝업창 */
	@GetMapping("/authorPop")
	// 작가 리스트를 가져오기 위해서 파라미터에 cri, model 추가 
	public void authorPopGet(Criteria cri, Model model) throws Exception {
		logger.info("authorPopGet........");
		
		cri.setAmount(5); //초기 5개만 보여지도록 설정
		// 게시물출력코드
		List list = authorService.authorGetList(cri);
		if(!list.isEmpty()) {
			model.addAttribute("list", list);// 작가존재 
		}else {
			model.addAttribute("listCheck", "empty"); //작가존재하지않을 경우
		}
		
		//페이지 이동 인터페이스 데이터 
		model.addAttribute("pageMaker", new PageDto(cri, authorService.authorGetTotal(cri)));
		
	}

}
