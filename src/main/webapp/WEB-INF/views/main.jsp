<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>

</head>
<body>

<%@include file="./include/user/header.jsp"%>

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
		
			<div class="content_area">
			<div class="inner">
				<h1>content area</h1>
				</div>
			</div>
	
<%@include file="./include/user/footer.jsp"%>
		
		
</body>
</html>