package com.mybatis.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.MemberMapper;
import com.mybatis.shopping.model.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Override
	public void memberJoin(MemberVo memberVo) throws Exception {
		memberMapper.memberJoin(memberVo);
	}

	@Override
	public int idCheck(String memberId) throws Exception {
		return memberMapper.idCheck(memberId);
	}

	@Override
	public MemberVo memberLogin(MemberVo memberVo) throws Exception {
		return memberMapper.memberLogin(memberVo);
	}

<<<<<<< HEAD
	/*주문자정보 */
	@Override
	public MemberVo getMemberInfo(String memberId) {
		
		return memberMapper.getMemberInfo(memberId);
	}
	
=======
//	/*주문자정보 */
//	@Override
//	public MemberVo getMemberInfo(String memberId) {
//		
//		return memberMapper.getMemberInfo(memberId);
//	}
//	
>>>>>>> 7bffc37... 뷰페이지에 장바구니에 담은dto 리스트로 콘솔창에 나오는지 체크
	
}
