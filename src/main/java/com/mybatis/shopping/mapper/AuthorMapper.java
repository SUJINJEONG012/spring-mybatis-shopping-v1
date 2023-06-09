package com.mybatis.shopping.mapper;

import java.util.List;

import com.mybatis.shopping.model.AuthorVo;
import com.mybatis.shopping.model.Criteria;

/*
 *  작가 데이터 목록 쿼리 실행하는 메서드 
 * */
public interface AuthorMapper {

	/* 작가 등록 */
	public void authorEnroll(AuthorVo authorVo);
	
	/* 작가 목록 */
	public List<AuthorVo> authorGetList(Criteria cri);
	
	/* 작가 총 수 */
	public int authorGetTotal(Criteria cri);
	
	/* 작가 상세 */
	public AuthorVo authorGetDetail(int authorId);
	
	/* 작가 수정 */
	public int authorModify(AuthorVo authorVo);
	
	/* 작가 삭제 */
	public int authorDelete(int authorId);
	
}
