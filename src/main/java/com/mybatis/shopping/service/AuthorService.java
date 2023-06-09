package com.mybatis.shopping.service;

import java.util.List;

import com.mybatis.shopping.model.AuthorVo;
import com.mybatis.shopping.model.Criteria;

public interface AuthorService {
	
	/* 작가등록 */
	public void authorEnrol(AuthorVo authorVo) throws Exception;
	
	/* 작가 목록 */
	public List<AuthorVo> authorGetList(Criteria cri) throws Exception;
	
	/* 작가 총 수 */
	public int authorGetTotal(Criteria cri) throws Exception;
	
	/* 작가 상세 페이지 */
	public AuthorVo authorGetDetail(int authorId) throws Exception;
	
	/* 작가 정보 수정 */
	public int authorModify(AuthorVo authorVo) throws Exception;
	
	/* 작가 삭제 */
	public int authorDelete(int authorId);

}
