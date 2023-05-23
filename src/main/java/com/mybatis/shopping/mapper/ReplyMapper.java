package com.mybatis.shopping.mapper;

import java.util.List;

import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.ReplyDto;

public interface ReplyMapper {

	/* 댓글 등록 */
	public int enrollReply(ReplyDto replyDto);
	
	/* 댓글존재여부 */
	public Integer checkReply(ReplyDto replyDto);
	
	/* 댓글 페이징 */
	public List<ReplyDto> getReplyList(Criteria cri);
	
	/* 댓글 총 개수 (페이징) */
	public int getReplyTotal(int bookId);
	
}
