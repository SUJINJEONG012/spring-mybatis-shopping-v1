package com.mybatis.shopping.mapper;

import java.util.List;

import com.mybatis.shopping.model.Criteria;
import com.mybatis.shopping.model.ReplyDto;
import com.mybatis.shopping.model.UpdateReplyDto;

public interface ReplyMapper {

	/* 댓글 등록 */
	public int enrollReply(ReplyDto dto);
	
	/* 댓글존재여부 */
	public Integer checkReply(ReplyDto replyDto);
	
	/* 댓글 페이징 */
	public List<ReplyDto> getReplyList(Criteria cri);
	
	/* 댓글 총 개수 (페이징) */
	public int getReplyTotal(int bookId);
	
	/* 댓글 수정 */
	public int updateReply(ReplyDto dto);
	
	
	/* 댓글 한 개 정보 (수정페이지 ) 
	 * 댓글데이터가 담을 수 있는 REplyDto 클래스를 반환타입으로 지정
	 * replyId값을 가지고 테이블의 찾고자 하는 행을 찾기때문에 파라미터로 int 타입의 replyId변수를 작성 
	 * */
	
	public ReplyDto getUpdateReply(int replyId);
	
	/* 댓글 삭제 */
	public int deleteReply(int replyId);
	
	
	/* 평점 평균 구하기 */
	public Double getRatingAverage(int bookId);
	
	
	/* 평점 평균 반영하기 
	 * 
	 * 상품번호, 상품평점평균값을 전달받을수 있도록 파라미터에 dto 생성
	 * */
	public int updateRating(UpdateReplyDto updateReplyDto);
}
