<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>

<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/main.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="/resources/js/cart.js"></script>
</head>
<body>


	<div class="wrapper">
		<div class="wrap">
	
			<div class="top_gnb_area">
				<div class="inner">
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
							<span>회원 : ${member.memberName }</span> 
							<span>충전금액 : <fmt:formatNumber
									value="${member.money }" pattern="#,###.##" />원
							</span> <span>포인트: <fmt:formatNumber value="${member.point }"
									pattern="#,###" />원
							</span>
						</div>
					</c:if>



				</div>

			</div>



</body>
</html>