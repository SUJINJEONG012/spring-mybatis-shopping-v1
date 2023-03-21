package com.mybatis.shopping.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.shopping.model.MemberVo;
import com.mybatis.shopping.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	//로그인페이지로 이동
	//@GetMapping("/login")
	@GetMapping("/login")
	public String login() {
		logger.info("로그인 페이지");
		return "member/login";
	}
	
	//회원가입페이지로 이동
		//@GetMapping("/join")
		@GetMapping("/join")
		public String join() {
			logger.info("회원가입 페이지");
			return "member/join";
		}
	
	//회원가입
	@PostMapping("/join")
	public String joinPost(MemberVo memberVo) throws Exception {
		logger.info("joinPost 진입");
		
		//회원가입
		memberService.memberJoin(memberVo);
		logger.info("join service 성공 ");
		return "redirect:/";
	}
	
	//아이디 중복검사
	@PostMapping("/memberIdChk")
	@ResponseBody
	public String memberIdChkPost(String memberId) throws Exception {
		logger.info("memberIdChk() 진입");
		int result = memberService.idCheck(memberId);
		logger.info("결과값= " + result);
		
		if(result != 0) {
			return "fail"; //중복아이디 존재 
		}else {
			return "success";// 중복아아디 X
		}
	}
	
	
	//이메일 인증
	@GetMapping("/mailCheck")
	@ResponseBody //데이터만 넘기기 때문에 
	public String mailCheckGET(String email) throws Exception {
		
		/*view로 부터 넘어온 데이터 확인*/
		logger.info("이메일 데이터 전송확인");
		logger.info("인증번호" + email);
		
		/* 인증번호 난수 생성 */
		 Random random = new Random();
		 //random.nextInt() 함수를 통해 난수를 생성. checkNum변수를 선언하고 난수 생성결과값을 할당
		 int checkNum = random.nextInt(888888) + 1111;
		 logger.info("인증번호2 : " + checkNum);
		 
		 /* 이메일 보내기 */
		 String setFrom = "peekaboo2189@gmail.com"; // 보내는 사람
		 String toMail = email; // 받는메일
		 String title="회원가입 인증 이메일입니다.";
		 String content = "홈페이지를 방문해주셔서 감사합니다." +
		 "<br>"+
		"인증번호는 " + checkNum + " 입니다." + "<br>" + 
		 "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		 
		 try {
			 MimeMessage message = mailSender.createMimeMessage();
			 MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			 helper.setFrom(setFrom);
			 helper.setTo(toMail);
			 helper.setSubject(title);
			 helper.setText(content, true);
			 mailSender.send(message);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 String num = Integer.toString(checkNum);
		 return num;
		
	}
	
}

