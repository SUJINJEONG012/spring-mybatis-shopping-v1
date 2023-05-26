<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>
<link rel="stylesheet" href="/resources/css/main.css">

</head>

<body>
<%@include file="./include/user/header.jsp"%>

<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>


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
	
		<div class="slide_div_wrap">
			<div class="slide_div">
				<div>
					<a href=""> <img src="../resources/img/main_visual01.jpg"
						alt="">
					</a>
				</div>

				<div>
					<a href=""> <img src="../resources/img/main_visual02.png"
						alt="">
					</a>
				</div>

				<div>
					<a href=""> <img src="../resources/img/main_visual03.png"
						alt="">
					</a>
				</div>

			</div>
		</div>
		<div class="inner">
			<h1>content area</h1>
		</div>
	</div>

	<%@include file="./include/user/footer.jsp"%>
	
	<script>
	$(document).ready(function(){
		 $(".slide_div").slick(
				 {
				dots:true,
				autoply:true,
				autoplaySpeed: 5000
			}	 
		 );
		 
		 
	});
	
	</script>

</body>
</html>