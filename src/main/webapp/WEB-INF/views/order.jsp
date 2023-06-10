<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>
<!-- <link rel="stylesheet" href="/resources/css/order.css"> -->

<!-- 다음주소 -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>


	<%@include file="./include/user/header.jsp"%>



	<div class="content_wrap">
		<div class="inner">


			<div class="content_subject">
				<span>주문자 정보</span>
			</div>

			<div class="order_wrap">


				<div class="order_info">

					<!-- 배송지 정보 -->
					<div class="addressInfo_div">


						<div class="addressInfo_button_div">
							<button class="address_btn address_btn_1"
								onclick="showAdress('1')">사용자 정보 주소록</button>
							<button class="address_btn address_btn_2"
								onclick="showAdress('2')">직접 입력</button>
						</div>


						<div class="addressInfo_input_div_wrap">
							
							<div class="addressInfo_input addressInfo_input_1"
								style="display: block">
								<table class="tbl-type01">
									<colgroup>
										<col width="20%">
										<col width="20%">
										<col width="20%">
										<col width="40%">
									</colgroup>
									<thead>
										<tr>
											<th>주문자</th>
											<th>이름</th>
											<th>메일</th>
											<th>배송지</th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td lang="en">${memberInfo.memberId}</td>
											<td lang="en">${memberInfo.memberName}</td>
											<td lang="en">${memberInfo.memberMail}</td>
											<td lang="en">${memberInfo.memberAddr1}
												${memberInfo.memberAddr2}<br>${memberInfo.memberAddr3}
												<input class="selectAddress" value="T" type="hidden">

												<input class="addressee_input"
												value="${memberInfo.memberName}" type="hidden"> <input
												class="address1_input" type="hidden"
												value="${memberInfo.memberAddr1}"> <input
												class="address2_input" type="hidden"
												value="${memberInfo.memberAddr2}"> <input
												class="address3_input" type="hidden"
												value="${memberInfo.memberAddr3}">
											</td>
										</tr>


									</tbody>
								</table>
							</div>
							<!-- 사용자정보 주소록 -->
							
							<div class="addressInfo_input addressInfo_input_2">
								<table class="tbl-type02">
									<colgroup>
										<col width="25%">
										<col width="*">
									</colgroup>
									
									<tbody>
										<tr>
											<th>이름</th>
											<td><input class="input addressee_input" placeholder="이름을 입력해주세요."></td>
										</tr>
										<tr>
											<th>주소</th>
											<td>
											<input class="selectAddress input" value="F" type="hidden">
											<div class="address_postcode">
											<input class="address1_input input" readonly="readonly" placeholder="우편번호를 선택해주세요."> 
											<a class="address_search_btn btn_black"
												onclick="execution_daum_address()">우편번호</a><br> 
											</div>
											
											<input class="address2_input input" readonly="readonly" placeholder=""><br>
											<input class="address3_input input" readonly="readonly" placeholder="나머지주소를 입력해주세요."></td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- 직접입력 -->
							
							
						</div>

					</div>


					<!-- 상품 정보 -->
					<div class="orderGoods_div order_goods">
						<!-- 상품 종류 -->
						<div class="goods_kind_div"></div>

						<div class="content_subject">
							<span>주문상품 <span class="goods_kind_div_kind" lang="en"></span>종
								<span class="goods_kind_div_count" lang="en"></span>개
							</span>
						</div>

						<!-- 상품 테이블 -->
						<table class="tbl-type01">
							<colgroup>
								<col width="15%">
								<col width="45%">
								<col width="40%">
							</colgroup>
							<thead>
								<tr>
									<th>이미지</th>
									<th>상품 정보</th>
									<th>판매가</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${orderList}" var="ol">
									<tr>
										<td>
											<div class="image_wrap"
												data-bookid="${ol.imageList[0].bookId}"
												data-path="${ol.imageList[0].uploadPath}"
												data-uuid="${ol.imageList[0].uuid}"
												data-filename="${ol.imageList[0].fileName}">
												<img>
											</div>
										</td>
										<td>${ol.bookName}</td>
										<td class="goods_table_price_td" lang="en"><fmt:formatNumber
												value="${ol.salePrice}" pattern="#,### 원" /> | 수량
											${ol.bookCount}개 <br>
										<fmt:formatNumber value="${ol.totalPrice}" pattern="#,### 원" />
											<br>[<fmt:formatNumber value="${ol.totalPoint}"
												pattern="#,### 원" />P] <input type="hidden"
											class="individual_bookPrice_input" value="${ol.bookPrice}">
											<input type="hidden" class="individual_salePrice_input"
											value="${ol.salePrice}"> <input type="hidden"
											class="individual_bookCount_input" value="${ol.bookCount}">
											<input type="hidden" class="individual_totalPrice_input"
											value="${ol.salePrice * ol.bookCount}"> <input
											type="hidden" class="individual_point_input"
											value="${ol.point}"> <input type="hidden"
											class="individual_totalPoint_input" value="${ol.totalPoint}">
											<input type="hidden" class="individual_bookId_input"
											value="${ol.bookId}"></td>
									</tr>
								</c:forEach>

							</tbody>

						</table>

					</div>

					<!-- 포인트 정보 -->
					<div class="point_wrap">
					
					<div class="content_subject">
							<span>포인트 사용</span>
						</div>
				
						<table class="point_table">
							<colgroup>
								<col width="40%">
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<th>포인트 사용</th>
									<td lang="en">${memberInfo.point} | 
									
									<input class="order_point_input"
										value="0">원 <a
										class="order_point_input_btn order_point_input_btn_N"
										data-state="N">모두사용</a> <a
										class="order_point_input_btn order_point_input_btn_Y"
										data-state="Y" style="display: none;">사용취소</a>

									</td>
									
									
								</tr>
							</tbody>
						</table>
					</div>

				</div>


				<!-- 주문 종합 정보 -->
				<div class="total_info_wrap">
				<h2>최종결제 금액</h2>
					<!-- 가격 종합 정보 -->
					<div class="total_info_price">
						<ul>
							<li>
							<span class="price_span_label">상품 금액</span> 
							<div>
							<span class="totalPrice_span" lang="en"></span>원
							</div>
							
							</li>
							
							<li>
							<span class="price_span_label">배송비</span> 
							<span class="delivery_price_span" lang="en">원</span>
							</li>
							
							<li>	
							<span class="price_span_label">할인금액</span> 
							<span class="usePoint_span" lang="en">원</span>
							</li>
							
							<li class="price_total_li">
							<strong class="price_span_label total_price_label">최종 결제 금액</strong> 
							<strong class="strong_red"> 
							<span class="total_price_red finalTotalPrice_span" lang="en">원</span>
							</strong>
							</li>
							
							<li class="point_li">
							<span class="price_span_label">적립예정 포인트</span> 
							<span class="totalPoint_span" lang="en"></span>
							</li>
							
						</ul>
					</div>
					<!-- 버튼 영역 -->
					<div class="total_info_btn_div">
						<a class="order_btn">결제하기</a>
					</div>
				</div>

			</div>

			<!-- 주문 요청 form -->
			<form class="order_form" action="/order" method="post">
				<!-- 주문자 회원번호 -->
				<input name="memberId" value="${memberInfo.memberId}" type="hidden">
				<!-- 주소록 & 받는이-->
				<input name="addressee" type="hidden"> <input
					name="memberAddr1" type="hidden"> <input name="memberAddr2"
					type="hidden"> <input name="memberAddr3" type="hidden">
				<!-- 사용 포인트 -->
				<input name="usePoint" type="hidden">
				<!-- 상품 정보 -->
			</form>
		</div>
	</div>



	<%@include file="./include/user/footer.jsp"%>


	<script>
		$(document)
				.ready(
						function() {

							/* 주문 조합정보란 최신화 */
							setTotalInfo();

							/* 이미지 삽입 */
							$(".image_wrap")
									.each(
											function(i, obj) {

												const bobj = $(obj);

												if (bobj.data("bookid")) {
													const uploadPath = bobj
															.data("path");
													const uuid = bobj
															.data("uuid");
													const fileName = bobj
															.data("filename");

													const fileCallPath = encodeURIComponent(uploadPath
															+ "/s_"
															+ uuid
															+ "_" + fileName);

													$(this)
															.find("img")
															.attr(
																	'src',
																	'/display?fileName='
																			+ fileCallPath);
												} else {
													$(this)
															.find("img")
															.attr('src',
																	'/resources/img/goodsNoImage.png');
												}

											});

						});

		/* 주소입력란 버튼 동작(숨김, 등장) */
		function showAdress(className) {
			/* 컨텐츠 동작 */
			/* 모두 숨기기 */
			$(".addressInfo_input").css('display', 'none');
			/* 컨텐츠 보이기 */
			$(".addressInfo_input_" + className).css('display', 'block');

			/* 버튼 색상 변경 */
			/* 모든 색상 동일 */
			$(".address_btn").css('backgroundColor', '#555');
			/* 지정 색상 변경 */
			$(".address_btn_" + className).css('backgroundColor', '#3c3838');
			/* selectAddress T/F */
			/* 모든 selectAddress F만들기 */
			$(".addressInfo_input").each(function(i, obj) {
				$(obj).find(".selectAddress").val("F");
			});
			/* 선택한 selectAdress T만들기 */
			$(".addressInfo_input_" + className).find(".selectAddress")
					.val("T");

		}

		/* 다음 주소 연동 */
		function execution_daum_address() {
			console.log("동작");
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var addr = ''; // 주소 변수
							var extraAddr = ''; // 참고항목 변수

							//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
							if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
								addr = data.roadAddress;
							} else { // 사용자가 지번 주소를 선택했을 경우(J)
								addr = data.jibunAddress;
							}

							// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
							if (data.userSelectedType === 'R') {
								// 법정동명이 있을 경우 추가한다. (법정리는 제외)
								// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								if (extraAddr !== '') {
									extraAddr = ' (' + extraAddr + ')';
								}
								// 추가해야할 코드
								// 주소변수 문자열과 참고항목 문자열 합치기
								addr += extraAddr;

							} else {
								addr += ' ';
							}

							// 제거해야할 코드
							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							$(".address1_input").val(data.zonecode);
							$(".address2_input").val(addr);
							// 커서를 상세주소 필드로 이동한다.
							$(".address3_input").attr("readonly", false);
							$(".address3_input").focus();

						}
					}).open();

		}

		/* 포인트 입력 */
		//0 이상 & 최대 포인트 수 이하
		$(".order_point_input").on("propertychange change keyup paste input",
				function() {

					const maxPoint = parseInt('${memberInfo.point}');

					let inputValue = parseInt($(this).val());

					if (inputValue < 0) {
						$(this).val(0);
					} else if (inputValue > maxPoint) {
						$(this).val(maxPoint);
					}

					/* 주문 조합정보란 최신화 */
					setTotalInfo();

				});

		/* 포인트 모두사용 취소 버튼 
		 * Y: 모두사용 상태 / N : 모두 취소 상태
		 */
		$(".order_point_input_btn").on("click", function() {

			const maxPoint = parseInt('${memberInfo.point}');

			let state = $(this).data("state");

			if (state == 'N') {
				console.log("n동작");
				/* 모두사용 */
				//값 변경
				$(".order_point_input").val(maxPoint);
				//글 변경
				$(".order_point_input_btn_Y").css("display", "inline-block");
				$(".order_point_input_btn_N").css("display", "none");
			} else if (state == 'Y') {
				console.log("y동작");
				/* 취소 */
				//값 변경
				$(".order_point_input").val(0);
				//글 변경
				$(".order_point_input_btn_Y").css("display", "none");
				$(".order_point_input_btn_N").css("display", "inline-block");
			}

			/* 주문 조합정보란 최신화 */
			setTotalInfo();

		});

		/* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
		function setTotalInfo() {

			let totalPrice = 0; // 총 가격
			let totalCount = 0; // 총 갯수
			let totalKind = 0; // 총 종류
			let totalPoint = 0; // 총 마일리지
			let deliveryPrice = 0; // 배송비
			let usePoint = 0; // 사용 포인트(할인가격)
			let finalTotalPrice = 0; // 최종 가격(총 가격 + 배송비)	

			$(".goods_table_price_td").each(
					function(index, element) {
						// 총 가격
						totalPrice += parseInt($(element).find(
								".individual_totalPrice_input").val());
						// 총 갯수
						totalCount += parseInt($(element).find(
								".individual_bookCount_input").val());
						// 총 종류
						totalKind += 1;
						// 총 마일리지
						totalPoint += parseInt($(element).find(
								".individual_totalPoint_input").val());
					});

			/* 배송비 결정 */
			if (totalPrice >= 30000) {
				deliveryPrice = 0;
			} else if (totalPrice == 0) {
				deliveryPrice = 0;
			} else {
				deliveryPrice = 3000;
			}

			finalTotalPrice = totalPrice + deliveryPrice;

			/* 사용 포인트 */
			usePoint = $(".order_point_input").val();

			finalTotalPrice = totalPrice - usePoint;

			/* 값 삽입 */
			// 총 가격
			$(".totalPrice_span").text(totalPrice.toLocaleString());
			// 총 갯수
			$(".goods_kind_div_count").text(totalCount);
			// 총 종류
			$(".goods_kind_div_kind").text(totalKind);
			// 총 마일리지
			$(".totalPoint_span").text(totalPoint.toLocaleString());
			// 배송비
			$(".delivery_price_span").text(deliveryPrice.toLocaleString());
			// 최종 가격(총 가격 + 배송비)
			$(".finalTotalPrice_span").text(finalTotalPrice.toLocaleString());
			// 할인가(사용 포인트)
			$(".usePoint_span").text(usePoint.toLocaleString());

		}

		/* 주문 요청 */
		$(".order_btn")
				.on(
						"click",
						function() {

							/* 주소 정보 & 받는이*/
							$(".addressInfo_input")
									.each(
											function(i, obj) {
												if ($(obj).find(
														".selectAddress").val() === 'T') {
													$("input[name='addressee']")
															.val(
																	$(obj)
																			.find(
																					".addressee_input")
																			.val());
													$(
															"input[name='memberAddr1']")
															.val(
																	$(obj)
																			.find(
																					".address1_input")
																			.val());
													$(
															"input[name='memberAddr2']")
															.val(
																	$(obj)
																			.find(
																					".address2_input")
																			.val());
													$(
															"input[name='memberAddr3']")
															.val(
																	$(obj)
																			.find(
																					".address3_input")
																			.val());
												}
											});

							/* 사용 포인트 */
							$("input[name='usePoint']").val(
									$(".order_point_input").val());

							/* 상품정보 */
							let form_contents = '';

							$(".goods_table_price_td")
									.each(
											function(index, element) {
												let bookId = $(element)
														.find(
																".individual_bookId_input")
														.val();
												let bookCount = $(element)
														.find(
																".individual_bookCount_input")
														.val();
												let bookId_input = "<input name='orders[" + index + "].bookId' type='hidden' value='" + bookId + "'>";
												form_contents += bookId_input;
												let bookCount_input = "<input name='orders[" + index + "].bookCount' type='hidden' value='" + bookCount + "'>";
												form_contents += bookCount_input;
											});

							$(".order_form").append(form_contents);

							/* 서버 전송 */
							$(".order_form").submit();

						});
	</script>

</body>
</html>