package com.mybatis.shopping.model;

import java.util.Date;
import java.util.List;

/* Orders 배송지정보, 사용포인트정보, 여러개 의 주문 상품정보 담기 */
public class OrderDto {
	/* 주문 번호 */
	private String orderId;
	/* 배송 받는 이 */
	private String addresse;
	/* 주문회원 아이디 */
	private String memberId;
	/* 우편번호 */
	private String memberAddr1;
	/* 회원 주소 */
	private String memberAddr2;
	/* 회원 상세 주소 */
	private String memberAddr3;
	/* 주문 상태 */
	private String orderState;
	/* 주문 상품 */
	private List<OrderItemDto> orders;
	/* 배송비 */
	private int deliveryCost;
	/* 사용 포인트 */
	private int usePoint;
	/* 주문날짜 */
	private Date orderDate;
	
	
	//DB테이블에 존재하지 않는 데이터 
	/* 판매가(모든 상품 비용) */
	private int orderSalePrice;
	/* 적립포인트 */
	private int orderSavePoint;
	/* 최종 판매 비용 */
	private int orderFinalSalePrice;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberAddr1() {
		return memberAddr1;
	}
	public void setMemberAddr1(String memberAddr1) {
		this.memberAddr1 = memberAddr1;
	}
	public String getMemberAddr2() {
		return memberAddr2;
	}
	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}
	public String getMemberAddr3() {
		return memberAddr3;
	}
	public void setMemberAddr3(String memberAddr3) {
		this.memberAddr3 = memberAddr3;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public List<OrderItemDto> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderItemDto> orders) {
		this.orders = orders;
	}
	public int getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	public int getUsePoint() {
		return usePoint;
	}
	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderSalePrice() {
		return orderSalePrice;
	}
	public void setOrderSalePrice(int orderSalePrice) {
		this.orderSalePrice = orderSalePrice;
	}
	public int getOrderSavePoint() {
		return orderSavePoint;
	}
	public void setOrderSavePoint(int orderSavePoint) {
		this.orderSavePoint = orderSavePoint;
	}
	public int getOrderFinalSalePrice() {
		return orderFinalSalePrice;
	}
	public void setOrderFinalSalePrice(int orderFinalSalePrice) {
		this.orderFinalSalePrice = orderFinalSalePrice;
	}
	
	
	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", addresse=" + addresse + ", memberId=" + memberId + ", memberAddr1="
				+ memberAddr1 + ", memberAddr2=" + memberAddr2 + ", memberAddr3=" + memberAddr3 + ", orderState="
				+ orderState + ", orders=" + orders + ", deliveryCost=" + deliveryCost + ", usePoint=" + usePoint
				+ ", orderDate=" + orderDate + ", orderSalePrice=" + orderSalePrice + ", orderSavePoint="
				+ orderSavePoint + ", orderFinalSalePrice=" + orderFinalSalePrice + "]";
	}
	
	
}
