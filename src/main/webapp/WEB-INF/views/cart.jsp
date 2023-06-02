<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>

<script src="/resources/js/cart.js"></script>

<link rel="stylesheet" href="/resources/css/cart.css">
		
</head>
<body>


<%@include file="./include/user/header.jsp"%>
	
			
			<div class="content_wrap">
			
			<div class="inner">
				<div class="content_subject">
					<span>장바구니</span>
				</div>
				
				
			
				
				<div class="content_totalCount_section">
				
				<div class="all_check_input_div">
				  <input type="checkbox" class="all_check_input input_size_20" checked="checked">
				  <span class="all_check_span">전체선택</span>
				</div>
				
				
				
				
 <table class="table_02">
	<colgroup>
		<col style="width: 15%">
		<col style="width: 15%">
		<col style="width: 15%">
		<col style="width: 15%">
        <col style="width: 10%">
        <col style="width: 10%">
	</colgroup>
	
	<thead>
		<tr>
			<th>이미지<th>
			<th>상품명</th>
			<th>가격</th>
			<th>수량</th>
			<th>합계</th>
			<th>삭제</th>
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
						
				</table>		
				
				<!-- 가격총합 -->
				<div class="content_total_section">
				 <div class="total_wrap">
				 	총 상품 가격<span class="totalPrice_span">70000</span> 원
				    배송비<span class="delivery_price">3000</span>원
				    총 주문 상품수<span class="totalKind_span"></span>종 <span class="totalCount_span"></span>권
				  총 결제 예상 금액<span class="finalTotalPrice_span">70000</span> 원
				총 적립 예상 마일리지<span class="totalPoint_span">70000</span> 원
					
				
				 </div>
				</div>
				
			</div>
			
				<!-- 구매 버튼 영역 -->
			<div class="content_btn_section button_wrap">
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