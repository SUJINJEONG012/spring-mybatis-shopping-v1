<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>
 


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">
<link rel="stylesheet" href="/resources/css/main.css">

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
							<li><a href="/member/${member.memberId }"><i class="fa fa-user-circle" aria-hidden="true">마이페이지</i></a></li>
							<li><a href="/cart/${member.memberId}"><i class="fa fa-shopping-cart" aria-hidden="true"> </i>장바구니</a></li>
						</c:if>
						<li><a href=""><i class="fa fa-headphones" aria-hidden="true"></i>고객센터</a></li>
					</ul>
				</div>
			</div>

			<div class="top_area">

				<div class="logo_area">
					<h1>
						<a href="/" lang="en">Book Shop</a>
					</h1>
				</div>
				<div class="search_area">

					<form id="searchForm" action="/search" method="get">
						<div class="search_input">
                    
							<select name="type">
								<option value="T">책 제목</option>
								<option value="A">작가</option>
							</select> 
							<input type="text" name="keyword" value="<c:out value="${pageMaker.cri.keyword}"/>">
								
								<!-- <i class="fa fa-star" aria-hidden="true">평점</i>
								<i class="fa fa-bell" aria-hidden="true">공지사항 </i>	 -->			
							<button class="btn search_btn"><i class="fa fa-search" aria-hidden="true">검색</i></button>
						</div>
					</form>
				</div>


				<div class="login_area">

					<!-- 로그인한 상태 -->
					<c:if test="${member != null}">
						<div class="login_success_area">	
							<ul>
							<li>회원 : <span lang="en">${member.memberName }</span></li>
							<li>충전금액 : <span lang="en"><fmt:formatNumber value="${member.money }" pattern="#,###.##" />원</span></li>
							<li> 포인트 : <span lang="en"><fmt:formatNumber value="${member.point }" pattern="#,###" />원</span></li>
							</ul>			
						</div>
					</c:if>

				</div>

			</div>
			
			
			<div class="navi_bar_area">	
					<div class="dropdown">
						<button class="dropbtn">
							국내 <i class="fa fa-caret-down"></i>
						</button>
						<div class="dropdown-content">
							<c:forEach items="${cate1}" var="cate">
								<a href="/search?type=C&cateCode=${cate.cateCode}">${cate.cateName }</a>
							</c:forEach>
						</div>
					</div>

					<div class="dropdown">
						<button class="dropbtn">
							국외 <i class="fa fa-caret-down"></i>
						</button>
						<div class="dropdown-content">
							<c:forEach items="${cate2}" var="cate">
								<a href="/search?type=C&cateCode=${cate.cateCode}">${cate.cateName}</a>
							</c:forEach>
						</div>
					</div>
				</div>
			
			
</body>
</html>