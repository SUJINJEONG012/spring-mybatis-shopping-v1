package com.mybatis.shopping.model;

import java.util.List;

public class ReplyPageDto {
	
	List<ReplyDto> list;
	
	PageDto pageInfo;

	public List<ReplyDto> getList() {
		return list;
	}

	public void setList(List<ReplyDto> list) {
		this.list = list;
	}

	public PageDto getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageDto pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	
	
}
