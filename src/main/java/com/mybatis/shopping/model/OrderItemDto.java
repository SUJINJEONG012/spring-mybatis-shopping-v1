package com.mybatis.shopping.model;

/* 하나의 주문상품 정보 담기 */
public class OrderItemDto {

	/* 주문번호 */
	private String orderId;	
	/* 상품번호 */
	private int bookId;
	/* 상품 수량 */
	private int bookCount;
	/* orderItem 기본키 */
	private int orderItemId;
	/* 상품 가격 */
	private int bookPrice;
	/* 상품 할인율 */
	private double bookDiscount;
	/* 상품 한개 시 적립될 포인트 */
	private int savePoint;
	
	/*할인적용된 가격 */
	private int salePrice;
	/* 총 가격 */
	private int totalPrice;
	/* 총 획득 포인트 */
	private int totalSavePoint;
	
	
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
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
	public int getSavePoint() {
		return savePoint;
	}
	public void setSavePoint(int savePoint) {
		this.savePoint = savePoint;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTotalSavePoint() {
		return totalSavePoint;
	}
	public void setTotalSavePoint(int totalSavePoint) {
		this.totalSavePoint = totalSavePoint;
	}
	@Override
	public String toString() {
		return "OrderItemDto [orderId=" + orderId + ", bookId=" + bookId + ", bookCount=" + bookCount + ", orderItemId="
				+ orderItemId + ", bookPrice=" + bookPrice + ", bookDiscount=" + bookDiscount + ", savePoint="
				+ savePoint + ", salePrice=" + salePrice + ", totalPrice=" + totalPrice + ", totalSavePoint="
				+ totalSavePoint + "]";
	}
	
	public void initSaleTotal() {
		this.salePrice = (int) (this.bookPrice * (1-this.bookDiscount));
		this.totalPrice = this.salePrice*this.bookCount;
		this.savePoint = (int)(Math.floor(this.salePrice*0.05));
		this.totalSavePoint =this.savePoint * this.bookCount;
	}
	
	
}
