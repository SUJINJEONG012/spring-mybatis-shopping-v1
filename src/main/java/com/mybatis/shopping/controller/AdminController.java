package com.mybatis.shopping.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatis.shopping.model.AttachImageVo;
import com.mybatis.shopping.model.AuthorVo;
import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.PageDto;
import com.mybatis.shopping.service.AdminService;
import com.mybatis.shopping.service.AuthorService;

import net.coobird.thumbnailator.Thumbnails;

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
		if (!list.isEmpty()) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("listCheck", "empty");
			return;
		}
		/* 페이지 인터페이스 데이터 */
		model.addAttribute("pageMaker", new PageDto(cri, adminService.goodsGetTotal(cri)));
	}

	/* 첨부파일 업로드 */
	@PostMapping(value="/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachImageVo>> uploadAjaxActionPost(MultipartFile[] uploadFile) {

		logger.info("uploadAjaxActionPost ...........");

		/* MIME TYPE  이미지 파일 체크*/
		for(MultipartFile  multipartFile : uploadFile) {
			File checkfile = new File(multipartFile.getOriginalFilename());
			String type = null;
			
			try {
				type = Files.probeContentType(checkfile.toPath());
				logger.info("MIME TYPE : " + type);
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			if(!type.startsWith("image")) {
				
				List<AttachImageVo> list = null;
				return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
			}
		}

			//String uploadFolder = "C:\\upload";
			String uploadFolder = "/Users/jeongsujin/upload";

			/* 날짜 생성 */
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Date date = new Date();

			String str = sdf.format(date);

			String datePath = str.replace("-", File.separator);
			logger.info(datePath);

			/* 폴더 생성 */
			File uploadPath = new File(uploadFolder, datePath);

			// uploadPath.mkdirs();
			if (uploadPath.exists() == false) {
				uploadPath.mkdirs();
			}
			
			
		
			/* 이미지 정보 담는 객체 */
			List<AttachImageVo> list = new ArrayList();
			
			/* 이미지 파일 체크 */
		    for (MultipartFile multipartFile : uploadFile) {
		    
		    //이미지 정보 객체 
		    AttachImageVo attachImageVo = new AttachImageVo();
		    
			/* 파일 이름 가져오는 메서드 */
			String uploadFileName = multipartFile.getOriginalFilename();
			attachImageVo.setFileName(uploadFileName);
			attachImageVo.setUploadPath(datePath);
			
			/* UUID 파일 이름 고유한 이름 */
			String uuid = UUID.randomUUID().toString();
			attachImageVo.setUuid(uuid);
			
			uploadFileName = uuid + "_" + uploadFileName;

			/* 파일위치, 파일 이름을 합친 File 객체 */
			File saveFile = new File(uploadPath, uploadFileName);
			
			/* 파일 저장 */
			try {
				multipartFile.transferTo(saveFile);
				/* 썸네일 생성 ImageIO */
				
//				File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);
//				
//				BufferedImage bo_image = ImageIO.read(saveFile);
//				/* 비율 */
//				double ratio = 3;
//				int width = (int) (bo_image.getWidth()/ ratio);
//				int height = (int) (bo_image.getHeight() / ratio);
//				
//				BufferedImage bt_image = new BufferedImage(width,height, BufferedImage.TYPE_3BYTE_BGR);
//				
//				Graphics2D graphic = bt_image.createGraphics();
//				graphic.drawImage(bo_image, 0, 0, width, height, null);
//				ImageIO.write(bt_image, "jpg", thumbnailFile);
				
				/* 방법 2 */
				File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);
				BufferedImage bo_image = ImageIO.read(saveFile);
				//비율 
				double ratio = 3;
				//넓이 높이
				int width = (int) (bo_image.getWidth() / ratio);
				int height = (int) (bo_image.getHeight() / ratio);
				
				Thumbnails.of(saveFile)
				.size(width,height)
				.toFile(thumbnailFile);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(attachImageVo); 
			

		  logger.info("파일 이름 : " + multipartFile.getOriginalFilename());
		  logger.info("파일 타입 ;" + multipartFile.getContentType());
		  logger.info("파일 크기 : " + multipartFile.getSize());
		}
		    
		    ResponseEntity<List<AttachImageVo>> result = new ResponseEntity<List<AttachImageVo>>(list, HttpStatus.OK);
		    return result;

	}
	
	/* 이미지 파일 삭제 */
	@PostMapping("/deleteFile")
	// 반환타입 : ResponseEntity, 파라미터는 파일이름
	public ResponseEntity<String> deleteFile(String fileName) {
		
		logger.info("deleteFile................... "+ fileName);
		
		File file = null;
		
		
		try {
			
			//file = new File("C:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
		    file = new File("/Users/jeongsujin/upload/" + URLDecoder.decode(fileName, "UTF-8"));
			
			file.delete();
			/* 원본 파일 삭제 */
			String originFileName = file.getAbsolutePath().replace("s_", "");
			logger.info("originFileName : " + originFileName);
			file =  new File(originFileName);
			file.delete();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);
		}
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
			

	/* 상품 등록 페이지 */
	@GetMapping("/goodsEnroll")
	public void goodsEnrollGet(Model model) throws Exception {
		logger.info("상품등록 페이지 접속");

		ObjectMapper objm = new ObjectMapper();

		List list = adminService.cateList();
		String cateList = objm.writeValueAsString(list);
		model.addAttribute("cateList", cateList);

		logger.info(" 상품등록 페이지 변경 전 .......... " + list);
		logger.info(" 상품등록 페이지 변경 후 ............." + cateList);
	}
	
	
	

	/* 상품 등록 */
	@PostMapping("/goodsEnroll")
	public String goodsEnrollPost(BookVo bookVo, RedirectAttributes rttr) {
		logger.info("goodEnrollPost......... dddd" + bookVo);
		
		adminService.bookEnroll(bookVo);
		rttr.addFlashAttribute("enroll_result", bookVo.getBookName());
		
		return "redirect:/admin/goodsManage";
	}

	/* 상품 조회 페이지 */
	@GetMapping({ "/goodsDetail", "/goodsModify" })
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
		rttr.addFlashAttribute("delete_result", result);
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

		if (!list.isEmpty()) {
			model.addAttribute("list", list); // 작가 존재경우
		} else {
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
		authorService.authorEnrol(authorVo); // 작가 등록 쿼리 수행
		rttr.addFlashAttribute("enroll_result", authorVo.getAuthName());
		logger.info("@@ 이름들고오는지 확인 => " + authorVo.getAuthName());
		return "redirect:/admin/authorManage";
	}

	/* 작가 상세 페이지 맵핑주소 작가상세와 작가수정 */
	@GetMapping({ "/authorDetail", "/authorModify" })

	public void authorGetInfoGet(int authorId, Criteria cri, Model model) throws Exception {
		logger.info("authorDetail......" + authorId);

		/* 작가관리 페이지 정보 */
		model.addAttribute("cri", cri);

		/* 선택 작가 정보 */
		model.addAttribute("authorInfo", authorService.authorGetDetail(authorId));
	}

	/* 작가 정보 수정 */
	@PostMapping("/authorModify")
	public String authorModifyPost(AuthorVo authorVo, RedirectAttributes rttr) throws Exception {
		logger.info("authorModifyPost......." + authorVo);

		int result = authorService.authorModify(authorVo);
		rttr.addFlashAttribute("modify_result", result);
		return "redirect:/admin/authorManage";
	}

	/* 작가 검색 팝업창 */
	@GetMapping("/authorPop")
	// 작가 리스트를 가져오기 위해서 파라미터에 cri, model 추가
	public void authorPopGet(Criteria cri, Model model) throws Exception {
		logger.info("authorPopGet........");

		cri.setAmount(5); // 초기 5개만 보여지도록 설정
		// 게시물출력코드
		List list = authorService.authorGetList(cri);
		if (!list.isEmpty()) {
			model.addAttribute("list", list);// 작가존재
		} else {
			model.addAttribute("listCheck", "empty"); // 작가존재하지않을 경우
		}

		// 페이지 이동 인터페이스 데이터
		model.addAttribute("pageMaker", new PageDto(cri, authorService.authorGetTotal(cri)));

	}

	/* 작가 정보 삭제 */
	@PostMapping("/authorDelete")
	public String authorDeletePost(int authorId, RedirectAttributes rttr) {
		logger.info("authorDeletePost......");
		int result = 0;
		try {
			result = authorService.authorDelete(authorId);
		} catch (Exception e) {
			e.printStackTrace();
			result = 2;
			rttr.addFlashAttribute("delete_result", result);
			return "redirect:/admin/authorManage";
		}

		rttr.addFlashAttribute("delete_result", result);
		return "redirect:/admin/authorManage";

	}

}
