package com.mybatis.shopping.service;

import com.mybatis.shopping.model.MemberVo;

public interface MemberService {

	// 회원가입
	public void memberJoin(MemberVo memberVo) throws Exception;

	//아이디 체크
	public int idCheck(String memberId) throws Exception;
	
	//로그인
	public MemberVo memberLogin(MemberVo memberVo) throws Exception;

	/* 주문자 정보 */
<<<<<<< HEAD
	public MemberVo getMemberInfo(String memberName);
=======
	//public MemberVo getMemberInfo(String memberId);
>>>>>>> 7bffc37... 뷰페이지에 장바구니에 담은dto 리스트로 콘솔창에 나오는지 체크
}
