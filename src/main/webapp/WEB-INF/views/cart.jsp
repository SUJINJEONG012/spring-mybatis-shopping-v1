<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

			

				<table class="table_02 tbl-type01">
					<colgroup>
						<col width="10%">
						<col width="35%">
						<col width="25%">
						<col width="25%">
						<col width="10%">
						<col width="25%">
					</colgroup>

					<thead>
						<tr>
							<th>

								<div class="all_check_input_div">
									<input type="checkbox" class="all_check_input input_size_20"
										checked="checked"> <span class="all_check_span">전체선택</span>
								</div>
							</th>
							
							<th>상품명</th>	
							<th>수량</th>
							<th>가격</th>
							<th>포인트 적립</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cartInfo}" var="ci">

							<tr>
								<td class="cart_info_td">
									<!-- 체크박스 추가  --> 
									<input type="checkbox"
									class="individual_cart_checkbox input_size_20"
									checked="checked"> <input type="hidden"
									class="individual_bookPrice_input" value="${ci.bookPrice}">
									<input type="hidden" class="individual_salePrice_input"
									value="${ci.salePrice}"> <input type="hidden"
									class="individual_bookCount_input" value="${ci.bookCount}">
									<input type="hidden" class="individual_totalPrice_input"
									value="${ci.salePrice * ci.bookCount}"> <input
									type="hidden" class="individual_point_input"
									value="${ci.point}"> <input type="hidden"
									class="individual_totalPoint_input" value="${ci.totalPoint}">
									<input type="hidden" class="individual_bookId_input"
									value="${ci.bookId}">

								</td>
								
								<td class="info_td name">
									<div class="image_wrap" data-bookid="${ci.imageList[0].bookId}"
										data-path="${ci.imageList[0].uploadPath}"
										data-uuid="${ci.imageList[0].uuid}"
										data-filename="${ci.imageList[0].fileName}">
										<img>
									</div>
									<div class="name">${ci.bookName}</div>
								</td>
		
								

								<td class="">
									<div class="quantity_div">
										
										<div class="quantity_box">
										<button class="quantity_btn plus_btn">+</button>
										<input type="text" value="${ci.bookCount}"
											class="quantity_input">
										<button class="quantity_btn minus_btn">-</button>
										<a class="quantity_modify_btn" data-cartid="${ci.cartId}">변경</a>
										</div>
										
										
									</div> 
									
									

								</td>
								
								<td class="price_td" >
								<p class="ls_price" lang="en"><fmt:formatNumber value="${ci.bookPrice}" pattern="#,### 원" /> </p>
								 <span class="red_color" lang="en"><fmt:formatNumber value="${ci.salePrice}" pattern="#,### 원" /></span>
								
								</td>
								
								<td>
								<span class="green_color" lang="en"><fmt:formatNumber value="${ci.point}" pattern="#,###" /></span>
								</td>
								

								
								<td class="button_wrap">
									<button class="delete_btn" data-cartid="${ci.cartId}">삭제</button>
								</td>
							</tr>
						</c:forEach>


					</tbody>

				</table>

				<!-- 가격총합 -->
				<div class="content_total_section">
					<div class="total_wrap">
						
						<strong>총 상품 가격 = </strong><span class="totalPrice_span" lang="en"> </span>원 + 
						
						<span> 배송비 = </span><span class="delivery_price" lang="en"></span>원 +
						
						<span> 적립 예상 마일리지 = </span> <span class="totalPoint_span" lang="en"></span> 원
						
						<strong>총 주문 금액 = </strong><span class="finalTotalPrice_span" lang="en"></span> 원 
						<span>[주문 상품수</span> 
						<span class="totalKind_span" lang="en"></span>종 
						<span class="totalCount_span" lang="en"></span>권]


					</div>
				</div>

			<!-- 구매 버튼 영역 -->
			<div class="content_btn_section button_wrap">
				<a class="order_btn">주문하기</a>
			</div>



		</div>

		<!-- 수량 조절 form -->
		<form action="/cart/update" method="post" class="quantity_update_form">
			<input type="hidden" name="cartId" class="update_cartId"> <input
				type="hidden" name="bookCount" class="update_bookCount"> <input
				type="hidden" name="memberId" value="${member.memberId}">

		</form>



		<!-- 삭제 form -->
		<form action="/cart/delete" method="post" class="quantity_delete_form">
			<input type="hidden" name="cartId" class="delete_cartId"> <input
				type="hidden" name="memberId" value="${member.memberId}">
		</form>

		<!-- 주문 form -->
		<form action="/order/${member.memberId}" method="get"
			class="order_form"></form>


		<script src="/resources/js/cart.js"></script>



		<%@include file="./include/user/footer.jsp"%>
</body>
</html>