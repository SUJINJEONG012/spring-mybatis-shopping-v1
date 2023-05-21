<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>
<link rel="stylesheet" href="/resources/css/cart.css">
<script src="/resources/js/cart.js"></script>

</head>
<body>


<%@include file="./include/user/header.jsp"%>


			<div class="content_area">
				<div class="content_subject">
					<span>장바구니</span>
				</div>
				<div class="content_middle_section"></div>
				<div class="content_totalCount_section">
				
				<div class="all_check_input_div">
				  <input type="checkbox" class="all_check_input input_size_20" checked="checked">
				  <span class="all_check_span">전체선택</span>
				</div>
					<table>
						<caption></caption>
						<thead>
							<tr>
								<th class="td_width_1"></th>
								<th class="td_width_2"></th>
								<th class="td_width_3">상품명</th>
								<th class="td_width_4">가격</th>
								<th class="td_width_4">수량</th>
								<th class="td_width_4">합계</th>
								<th class="td_width_4">삭제</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${cartInfo}" var="ci">
								
								<tr>
									<td class="td_width_1 cart_info_td">
									 <!-- 체크박스 추가  -->
									 <input type="checkbox" class="individual_cart_checkbox input_size_20" checked="checked" >
									 <input type="hidden" class="individual_bookPrice_input" value="${ci.bookPrice}">
									 <input type="hidden" class="individual_salePrice_input" value="${ci.salePrice}">
									 <input type="hidden" class="individual_bookCount_input" value="${ci.bookCount}">
									 <input type="hidden" class="individual_totalPrice_input" value="${ci.salePrice * ci.bookCount}">
									 <input type="hidden" class="individual_point_input" value="${ci.point}">
									 <input type="hidden" class="individual_totalPoint_input" value="${ci.totalPoint}">
									 <input type="hidden" class="individual_bookId_input" value="${ci.bookId}">
									 
									</td>
									<td class="td_width_2">
									<div class="image_wrap" 
									data-bookid="${ci.imageList[0].bookId}" 
									data-path="${ci.imageList[0].uploadPath}" 
									data-uuid="${ci.imageList[0].uuid}"
									data-filename="${ci.imageList[0].fileName}"><img></div>
									</td>
									<td class="td_width_3">${ci.bookName}</td>
									<td class="td_width_4 price_td">
									<del>정가 :<fmt:formatNumber value="${ci.bookPrice}" pattern="#,### 원" /></del><br> 
										판매가 : <span class="red_color"><fmt:formatNumber value="${ci.salePrice}" pattern="#,### 원" /></span><br>
                                                                  
										마일리지 : <span class="green_color"><fmt:formatNumber value="${ci.point}" pattern="#,###" /></span>
									</td>
									
									<td class="td_width_4 table_text_align_center">
									 <div class="table_text_align_center quantity_div">
									    <input type="text" value="${ci.bookCount}" class="quantity_input">
									    <button class="quantity_btn plus_btn">+</button>
									    <button class="quantity_btn minus_btn">-</button>
									 </div>
									   
									   <a class="quantity_modify_btn" data-cartid="${ci.cartId}"> 변경</a>
									
									</td>
									
									<td class="td_width_4 table_text_align_center">
									<fmt:formatNumber value="${ci.salePrice * ci.bookCount}" pattern="#,### 원" />		
									</td>
											
									<td class="td_width_4 table_text_align_center">
										<button class="delete_btn" data-cartid="${ci.cartId}">삭제</button>
									</td>
								</tr>
							</c:forEach>
							
						     
						</tbody>
						
						<tr class="list_table"></tr>
						     
					</table>
				</div>
				
				<!-- 가격총합 -->
				<div class="content_total_section">
				 <div class="total_wrap">
				  
				  
				<table>
						<tr>
							<td>
								<table>
									<tr>
										<td>총 상품 가격</td>
										<td>
											<span class="totalPrice_span">70000</span> 원
										</td>
									</tr>
									<tr>
										<td>배송비</td>
										<td>
											<span class="delivery_price">3000</span>원
										</td>
									</tr>									
									<tr>
										<td>총 주문 상품수</td>
										<td><span class="totalKind_span"></span>종 <span class="totalCount_span"></span>권</td>
									</tr>
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td></td>
										<td></td>
									</tr>
								</table>							
							</td>
						</tr>
					</table>
					<div class="boundary_div">구분선</div>
					<table>
						<tr>
							<td>
								<table>
									<tbody>
										<tr>
											<td>
												<strong>총 결제 예상 금액</strong>
											</td>
											<td>
												<span class="finalTotalPrice_span">70000</span> 원
											</td>
										</tr>
									</tbody>
								</table>
							</td>
							<td>
								<table>
									<tbody>
										<tr>
											<td>
												<strong>총 적립 예상 마일리지</strong>
											
											</td>
											<td>
												<span class="totalPoint_span">70000</span> 원
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</table>
				  
				 </div>
				</div>
				
				
				<!-- 구매 버튼 영역 -->
			<div class="content_btn_section">
				<a class="order_btn">주문하기</a>
			</div>
				 

			</div>
			
			<!-- 수량 조절 form -->
			<form action="/cart/update" method="post" class="quantity_update_form">
			 	<input type="hidden" name="cartId" class="update_cartId">
			  	<input type="hidden" name="bookCount" class="update_bookCount">
			  	<input type="hidden" name="memberId" value="${member.memberId}">
			  
			</form>
			
			
			
			<!-- 삭제 form -->
			<form action="/cart/delete" method="post" class="quantity_delete_form">
			 	<input type="hidden" name="cartId" class="delete_cartId">
			  	<input type="hidden" name="memberId" value="${member.memberId}">	  
			</form>
			
			<!-- 주문 form -->
			<form action="/order/${member.memberId}" method="get" class="order_form">
			
			</form>
			
<script src="/resources/js/cart.js"></script>
		
<%@include file="./include/user/footer.jsp"%>

</body>
</html>