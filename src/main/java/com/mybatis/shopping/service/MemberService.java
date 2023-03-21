package com.mybatis.shopping.service;

import com.mybatis.shopping.model.MemberVo;

public interface MemberService {

	// 회원가입
	public void memberJoin(MemberVo memberVo) throws Exception;

	//아이디 체크
	public int idCheck(String memberId) throws Exception;
	
	//로그인
	public MemberVo memberLoign(MemberVo memberVo) throws Exception;
}
