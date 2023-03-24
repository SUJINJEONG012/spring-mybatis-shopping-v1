package com.mybatis.shopping.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void memberJoin() throws Exception{
		MemberVo memberVo = new MemberVo();
		
		memberVo.setMemberId("test11");
		memberVo.setMemberPw("test11");
		memberVo.setMemberName("test11");
		memberVo.setMemberMail("test11");
		memberVo.setMemberAddr1("test11");
		memberVo.setMemberAddr2("test11");
		memberVo.setMemberAddr3("test11");
	
		
		
		memberMapper.memberJoin(memberVo);
	}
	
//	@Test
//	public void memberIdChk() throws Exception{
//		String id= "admin";
//		String id2= "test123";
//		memberMapper.idCheck(id); 
//		memberMapper.idCheck(id2);
//				
//	}
	
	//로그인 처리 
//	@Test
//	public void memberLogin() throws Exception {
//		MemberVo memberVo = new MemberVo();
//		
//		memberVo.setMemberId("angela");
//		memberVo.setMemberPw("1234");
//		
//		memberMapper.memberLogin(memberVo);
//		System.out.println("결과값 : " + memberMapper.memberLogin(memberVo));
//		
//	}

}
