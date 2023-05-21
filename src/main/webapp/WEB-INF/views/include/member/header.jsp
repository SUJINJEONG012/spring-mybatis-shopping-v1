<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/css/layout.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>


</head>
<body>


	<div class="wrapper">
		<div class="headeer">
	
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
						<li><a href="/member/logout" id="gnb_logout_button">로그아웃</a></li>
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