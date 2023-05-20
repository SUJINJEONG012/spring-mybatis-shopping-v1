package com.mybatis.shopping.mapper;

import com.mybatis.shopping.model.ReplyDto;

public interface ReplyMapper {

	/* 댓글 등록 */
	public int enrollReply(ReplyDto replyDto);
}
