package com.mybatis.shopping.service;

import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.ReplyDto;
import com.mybatis.shopping.model.ReplyPageDto;

public interface ReplyService {
	
	/* 댓글 등록 */
	public int enrollReply(ReplyDto dto);
	/* 댓글 존재 체크 */
	public String checkReply(ReplyDto replyDto);
	/* 댓글 페이징 */
	public ReplyPageDto replyList(Criteria cri);
	/* 댓글 수정 */
	public int updateReply(ReplyDto replyDto);
	/* 댓글 한 개 수정 (수정페이지) */
	public ReplyDto getUpdateReply(int replyId);
	
}
