package com.mybatis.shopping.model;

public class PageDto {

	/* 페이지 시작 번호*/
	private int pageStart;
	
	/* 페이지 끝 번호 */
	private int pageEnd;
	
	/* 이전, 다음 버튼 존재 유무 */
	private boolean next,prev;
	/* 행 전체 개수 */
	private int total;
	/* 현재 페이지 번호 (pageNum) , 행표시수(amount), 검색 키워드 (keyword), 검색종류(tyoe),*/
	private Criteria cri;
		
	/* 생성자 (클래스 호출시 변수 값 초기화) */
	public PageDto(int total, Criteria cri) {

		this.total = total;
		this.cri = cri;
		
		this.pageStart = this.pageEnd -9;
		this.pageEnd = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		
		int realEnd = (int)(Math.ceil(total*1.0/cri.getAmount()));
		
		//이전버튼
		this.prev = this.pageStart > 1;
		//다음버튼
		this.next = this.pageEnd < realEnd;
	}

	
	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
	
	
	
}
