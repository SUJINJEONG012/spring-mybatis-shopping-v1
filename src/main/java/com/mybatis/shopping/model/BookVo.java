package com.mybatis.shopping.model;

import java.util.Date;
import java.util.List;

public class BookVo {

	private int bookId; // 상품아이디 
	private String bookName; //상품이름
	
	private int authorId; //작가 아이디
	private String authName; //작가이름 
	
	private String publeYear; //출판일
	private String publisher; //출판사
	
	private String cateCode; //카테고리코드
	private String cateName; //카테고리 이름
	
	private int bookPrice; // 상품 가격 
	private int bookStock; //상품재고
	
	private double bookDiscount; //상품 할인율
	private String bookIntro; //상품소개 
	
	private String bookContents; // 상품 목차
	
	private Date regDate; // 등록날짜
	private Date updateDate; //수정날짜
	
	// 이미지 정보
	private List<AttachImageVo> imageList;


	
	public List<AttachImageVo> getImageList() {
		return imageList;
	}
	public void setImageList(List<AttachImageVo> imageList) {
		this.imageList = imageList;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public String getPubleYear() {
		return publeYear;
	}
	public void setPubleYear(String publeYear) {
		this.publeYear = publeYear;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getBookStock() {
		return bookStock;
	}
	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}
	public double getBookDiscount() {
		return bookDiscount;
	}
	public void setBookDiscount(double bookDiscount) {
		this.bookDiscount = bookDiscount;
	}
	public String getBookIntro() {
		return bookIntro;
	}
	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}
	public String getBookContents() {
		return bookContents;
	}
	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", bookName=" + bookName + ", authorId=" + authorId + ", authName="
				+ authName + ", publeYear=" + publeYear + ", publisher=" + publisher + ", cateCode=" + cateCode
				+ ", cateName=" + cateName + ", bookPrice=" + bookPrice + ", bookStock=" + bookStock + ", bookDiscount="
				+ bookDiscount + ", bookIntro=" + bookIntro + ", bookContents=" + bookContents + ", regDate=" + regDate
				+ ", updateDate=" + updateDate + ", imageList=" + imageList + "]";
	}
	
	
	
	
	
}
