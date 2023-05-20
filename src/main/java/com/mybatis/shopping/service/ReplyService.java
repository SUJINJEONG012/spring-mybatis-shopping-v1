package com.mybatis.shopping.service;

import com.mybatis.shopping.model.ReplyDto;

public interface ReplyService {
	
	/* 댓글 등록 */
	public int enrollReply(ReplyDto dto);
}
