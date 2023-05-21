package com.mybatis.shopping.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mybatis.shopping.model.MemberVo;
import com.mybatis.shopping.service.MemberService;
//import com.mybatis.shopping.service.OrderService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	
	@Autowired
	private MemberService memberService;
	
	
	
//	@Autowired
//	private JavaMailSender mailSender;
	
	@Autowired(required=false)
	private BCryptPasswordEncoder pwEncoder;
	
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
		//logger.info("joinPost 진입");

		String rawPw =""; //인코딩 전 비밀번호
		String encodePw =""; // 인코딩 후 비밀번호
		
		rawPw = memberVo.getMemberPw(); //비밀번호 데이터 얻음
		encodePw = pwEncoder.encode(rawPw); // 비밀번호 인코딩
		memberVo.setMemberPw(encodePw);  // 인코딩된 비밀번호 member객체에 다시 저장
		
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
//		 String setFrom = "peekaboo2189@gmail.com"; // 보내는 사람
//		 String toMail = email; // 받는메일
//		 String title="회원가입 인증 이메일입니다.";
//		 String content = "홈페이지를 방문해주셔서 감사합니다." +
//		 "<br>"+
//		"인증번호는 " + checkNum + " 입니다." + "<br>" + 
//		 "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
//		 
//		 try {
//			 MimeMessage message = mailSender.createMimeMessage();
//			 MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//			 helper.setFrom(setFrom);
//			 helper.setTo(toMail);
//			 helper.setSubject(title);
//			 helper.setText(content, true);
//			 mailSender.send(message);
//		 }catch(Exception e) {
//			 e.printStackTrace();
//		 }
		 
		 String num = Integer.toString(checkNum);
		 
		 return num;
		
	}
	
	/* 로그인 */
	@PostMapping("/login")
	public String loginPost(HttpServletRequest request, MemberVo memberVo, RedirectAttributes rttr) throws Exception{
		
		System.out.println("login 메서드 진입");
		System.out.println("전달된 데이터 : " + memberVo);
		
		HttpSession session = request.getSession();
		String rawPw = "";
		String encodePw = "";
					
	    MemberVo lvo = memberService.memberLogin(memberVo);
	    System.out.println("lvo =  " + lvo);
	    
	    if(lvo != null) { //일치하는 아이디 존재시
	    	//logger.info( "lvo:  " + lvo+ "encodePw::" + encodePw);
	    	rawPw = memberVo.getMemberPw(); // 사용자가 입력한 비번
	    	encodePw = lvo.getMemberPw(); //데이터베이스에 저장된 비번
	    	
	    	logger.info("@@@");
	    	logger.info("encodePw ==> "+ encodePw);
            
	    	if(true == pwEncoder.matches(rawPw, encodePw)) { // 비밀번호 일치여부 판단            	
                lvo.setMemberPw("");                    // 인코딩된 비밀번호 정보 지움
                session.setAttribute("member", lvo);     // session에 사용자의 정보 저장
                return "redirect:/";        // 메인페이지 이동    
            }else {
	    		rttr.addFlashAttribute("result", 0);
	    		logger.info("실패했다");
	    		return "redirect:/member/login"; // 로그인 페이지로 이동
	    	}
	    	
	    }else { //일치하는 아이디가 존재하지 않을 경우(로그인 실패)
	    	rttr.addFlashAttribute("result", 0);     
	    	return "redirect:/member/login";
	    }

	    
//		if(lvo == null) {  //일치하지 않는 아이디, 비밀번호 입력경우
//			int result =0;
//			rttr.addFlashAttribute("result", result);
//			return "redirect:/member/login";
//		}
//		session.setAttribute("member", lvo); // 일치하는 아이디, 비밀번호경우(로그인성공)
//		return "redirect:/";
	    
	}
	
	
	/* 로그아웃 */
	@GetMapping("/logout")
	public String logoutMainGet(HttpServletRequest request) throws Exception {
		logger.info("logoutMainGet 메서드 진입");
		HttpSession session = request.getSession();
		session.invalidate(); //세션 전체를 무효화하는 메서드
		return "redirect:/";
	}
	
	/* 비동기식 로그아웃 */
	@PostMapping("/logout")
	@ResponseBody
	public void logoutPost(HttpServletRequest request) throws Exception {
		logger.info("비동시식 로그아웃 메서드 진입");
		HttpSession session = request.getSession();
		session.invalidate();
	}

	
	/* 마이페이지 이동 */
	@GetMapping("/{memberId}")
	public String myPageGet(@PathVariable("memberId") String memberId, Model model) {
		model.addAttribute("mypageInfo", memberService.getMemberInfo(memberId));;
		return "/member/mypage";
	}
	
}

