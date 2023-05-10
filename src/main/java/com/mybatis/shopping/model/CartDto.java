package com.mybatis.shopping.model;


/* 장바구니와 관련된 변수들 선언 */
public class CartDto {
	
	private int  cartId;
	private String memberId;
	private int bookId;
	private int bookCount;
	
	//book테이블 변수를 장바구니 페이지에 뿌려주기 위해 사용
	private String bookName;
	private int bookPrice;
	private double bookDiscount;
	
	
	private int salePrice;
	private int totalPrice;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public double getBookDiscount() {
		return bookDiscount;
	}
	public void setBookDiscount(double bookDiscount) {
		this.bookDiscount = bookDiscount;
	}
	
	
	public int getSalePrice() {
		return salePrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
	
	/* salePrice, totalPrice 변수 값을 초기화 해주는 메서드를 생성
	 * 이 두 변수의 값을 변경을 원할 경우 오직 이메서드를 통해서만 가능하
	*/
	public void initSaleTotal() {
		this.salePrice = (int) (this.bookPrice * (1 - this.bookDiscount));
		this.totalPrice = this.salePrice * this.bookCount;
	}
	
	@Override
	public String toString() {
		return "CartDto [cartId=" + cartId + ", memberId=" + memberId + ", bookId=" + bookId + ", bookCount="
				+ bookCount + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", bookDiscount=" + bookDiscount
				+ ", salePrice=" + salePrice + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	
}
