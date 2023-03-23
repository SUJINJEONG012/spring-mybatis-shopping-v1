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
	
	
}
