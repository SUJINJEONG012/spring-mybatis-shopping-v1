<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>
<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/css/cart.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>

	<div class="wrapper">
		<div class="wrap">

			<div class="top_gnb_area">
				<ul class="list">
					<c:if test="${member == null }">
						<li><a href="/member/login">로그인</a></li>
						<li><a href="/member/join">회원가입</a></li>
					</c:if>

					<c:if test="${member != null}">
						<c:if test="${member.adminCk == 1}">
							<li><a href="/admin/main">관리자 페이지</a></li>
						</c:if>
						<li><a href="" id="gnb_logout_button">로그아웃</a></li>
						<li><a href="">마이룸</a></li>
						<li><a href="/cart/${member.memberId}">장바구니</a></li>
					</c:if>

					<li><a href="">고객센터</a></li>
				</ul>
			</div>

			<div class="top_area">
				<div class="logo_area">
					<h1>
						<a href="/">logo area</a>
					</h1>
				</div>
				<div class="search_area">
					<h1>search area</h1>
					<form id="searchForm" action="/search" method="get">
						<div class="search_input">

							<select name="type">
								<option value="T">책 제목</option>
								<option value="A">작가</option>
							</select> <input type="text" name="keyword"
								value="<c:out value="${pageMaker.cri.keyword}"/>">
							<button class="btn search_btn">검색</button>
						</div>
					</form>
				</div>

				<div class="login_area">

					<!-- 로그인한 상태 -->
					<c:if test="${member != null}">
						<div class="login_success_area">
							<span>회원 : ${member.memberName }</span> <span>충전금액 : <fmt:formatNumber
									value="${member.money }" pattern="#,###.##" />원
							</span> <span>포인트: <fmt:formatNumber value="${member.point }"
									pattern="#,###" />원
							</span>
						</div>
					</c:if>



				</div>

			</div>



			<div class="content_area">
				<div class="content_subject">
					<span>장바구니</span>
				</div>
				<div class="content_middle_section"></div>
				<div class="content_totalCount_section">

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
									 
									</td>
									<td class="td_width_2"></td>
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
									<a href="" class="quantity_modify_btn">변경</a>
									</td>
									
									<td class="td_width_4 table_text_align_center">
									<fmt:formatNumber value="${ci.salePrice * ci.bookCount}" pattern="#,### 원" />		
									</td>
											
									<td class="td_width_4 table_text_align_center delete_btn">
										<button>삭제</button>
									</td>
								</tr>
							</c:forEach>
							
						     
						</tbody>
						
						<tr class="list_table">
						     
						     </tr>
						     
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
				<a>주문하기</a>
			</div>
				 

			</div>
		</div>

		<!-- Footer 영역 -->
		<div class="footer_nav">
			<div class="footer_nav_container">
				<ul>
					<li>회사소개</li>
					<span class="line">|</span>
					<li>이용약관</li>
					<span class="line">|</span>
					<li>고객센터</li>
					<span class="line">|</span>
					<li>광고문의</li>
					<span class="line">|</span>
					<li>채용정보</li>
					<span class="line">|</span>
				</ul>
			</div>
		</div>
		<!-- class="footer_nav" -->

		<div class="footer">
			<div class="footer_container">

				<div class="footer_left">
					<img src="resources/img/Logo.png">
				</div>
				<div class="footer_right">
					(주) VamBook 대표이사 : OOO <br> 사업자등록번호 : ooo-oo-ooooo <br>
					대표전화 : oooo-oooo(발신자 부담전화) <br> <br> COPYRIGHT(C) <strong>dd.tistory.com</strong>
					ALL RIGHTS RESERVED.
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- class="footer" -->


	</div>


	<script>
		$(document).ready(function(){
	
			/* 종합 정보 섹션 정보 삽입 */	
			setTotalInfo();	
			
		});

		//체크 여부에 따라 종합 정보 변화 
		$(".individual_cart_checkbox").on("change", function(){
			setTotalInfo($(".cart_info_td"));
		});
		// 총 주문 정보 세팅 (배송비, 총 가격, 마일리지, 수량 수, 종류)
		function setTotalInfo(){
			let totalPrice = 0;
			let totalCount = 0;
			
			let totalKind = 0;
			let deliveryPrice = 0 ;
			let finalTotalPrice = 0;
			
			$(".cart_info_td").each(index, element){
				if($(element).find(".individual_cart_checkbox").is(":checked") === true){
					// 총 가격
					totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
					// 총 갯수
					totalCount += parseInt($(element).find(".individual_bookCount_input").val());
					// 총 종류
					totalKind += 1;
					// 총 마일리지
					totalPoint += parseInt($(element).find(".individual_totalPoint_input").val());		
				}
			}
			
		}
		
		
	</script>
</body>
</html>