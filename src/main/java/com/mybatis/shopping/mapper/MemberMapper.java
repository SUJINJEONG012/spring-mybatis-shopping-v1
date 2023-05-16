package com.mybatis.shopping.mapper;

import com.mybatis.shopping.model.MemberVo;

public interface MemberMapper {
    
	//회원가입 
	public void memberJoin(MemberVo memberVo);
	
	//아이디 중복 검사
	public int idCheck(String memberId);
	
	//로그인
	public MemberVo memberLogin(MemberVo memberVo);
	
	/* 주문자 주소 정보 */
<<<<<<< HEAD
	public MemberVo getMemberInfo(String memberId);
=======
	//public MemberVo getMemberInfo(String memberId);
>>>>>>> 7bffc37... 뷰페이지에 장바구니에 담은dto 리스트로 콘솔창에 나오는지 체크

}
