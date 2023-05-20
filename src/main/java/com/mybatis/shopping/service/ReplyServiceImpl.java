package com.mybatis.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.ReplyMapper;
import com.mybatis.shopping.model.ReplyDto;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public int enrollReply(ReplyDto dto) {
		int result = replyMapper.enrollReply(dto);
		return result;
	}
	
	
}
