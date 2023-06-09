package com.mybatis.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.ReplyMapper;
import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.PageDto;
import com.mybatis.shopping.model.ReplyDto;
import com.mybatis.shopping.model.ReplyPageDto;
import com.mybatis.shopping.model.UpdateReplyDto;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;
	
	/* 댓글등록 */
	@Override
	public int enrollReply(ReplyDto dto) {
		int result = replyMapper.enrollReply(dto);
		//평균값 메서드 호출
		setRating(dto.getBookId());
		return result;
	}

	/* 댓글 존제 체크 */
	@Override
	public String checkReply(ReplyDto replyDto) {
		Integer result = replyMapper.checkReply(replyDto);
		// 결과값이 null 리뷰가 없으면 0 , 리뷰가 있으면 1
		if(result == null) {
			return "0";
		}else {
			return "1";		
		}
		
	}

	/* 댓글 페이징 */
	@Override
	public ReplyPageDto replyList(Criteria cri) {
		ReplyPageDto replyDto = new ReplyPageDto();
		
		replyDto.setList(replyMapper.getReplyList(cri));
		replyDto.setPageInfo(new PageDto(cri, replyMapper.getReplyTotal(cri.getBookId())));
		
		return replyDto;
	}

	/* 댓글 수정 */
	@Override
	public int updateReply(ReplyDto replyDto) {
		int result = replyMapper.updateReply(replyDto);
		setRating(replyDto.getBookId());
		return result;
	}

	/* 댓글 한 개 정보(수정페이지) */
	@Override
	public ReplyDto getUpdateReply(int replyId) {
		
		return replyMapper.getUpdateReply(replyId);
	}

	/* 댓글 삭제 */
	@Override
	public int deleteReply(ReplyDto replyDto) {
		int result = replyMapper.deleteReply(replyDto.getReplyId());
		setRating(replyDto.getBookId());
		return result;
	}
	
	
	/* 평점 평균값 구하기 */
	public void setRating(int bookId) {
		Double ratingAvg = replyMapper.getRatingAverage(bookId);
		if(ratingAvg == null) {
			ratingAvg = 0.0;
		}
		
		UpdateReplyDto urd = new UpdateReplyDto();
		urd.setBookId(bookId);
		urd.setRatingAvg(ratingAvg);
		
		replyMapper.updateRating(urd);
	}
	
}
