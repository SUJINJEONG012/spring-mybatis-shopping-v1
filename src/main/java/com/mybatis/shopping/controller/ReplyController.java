package com.mybatis.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.ReplyDto;
import com.mybatis.shopping.model.ReplyPageDto;
import com.mybatis.shopping.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	/* 댓글 등록 */
	@PostMapping("/enroll")
	public void enrollReplyPost(ReplyDto dto) {
		replyService.enrollReply(dto);
	}
	/* 댓글체크 
	 * 존재 : 1, 존재안함 : 0
	 */
	@PostMapping("/check")
	public String replyCheckPost(ReplyDto replyDto) {
		return replyService.checkReply(replyDto);
	}
	
	/* 댓글 페이징 */
	@GetMapping(value="/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ReplyPageDto replyListGet(Criteria cri) {
		return replyService.replyList(cri);
	}
	
	/* 댓글 수정 */
	@PostMapping("/update")
	public void replyModifyPost(ReplyDto replyDto) {
		replyService.updateReply(replyDto);
	}
	
	/* 댓글 삭제 */
	@PostMapping("/delete")
	public void replyDeletePost(ReplyDto replyDto) {
		replyService.deleteReply(replyDto);
	}
	
}
