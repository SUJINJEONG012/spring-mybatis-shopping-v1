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
		<!-- slide_div_wrap end -->
		
		
		
		<div class="inner">
			
			<div class="ls_wrap">
			  <div class="ls_div_subject">
			   평점순 상품
			  </div>
			  <div class="ls_div">
			  <c:forEach items="${ls}" var="ls">
			   <a href="/goodsDetail/${ls.bookId}">
			    <div class="ls_div_content_wrap">
			      <div class="ls_div_content">
			       
			        <div class="image_wrap" 
			        data-bookid="${ls.imageList[0].bookId}" 
			        data-path="${ls.imageList[0].uploadPath}"
			        data-uuid="${ls.imageList[0].uuid}"
			        data-filename="${ls.imageList[0].fileName}">
			        <img>
			       </div>
			       
			       <div class="ls_category">${ls.cateName}</div>
			       <div class="ls_rating" ${ls.ratingAvg}></div>
			       <div class="ls.bookName">${ls.bookName}</div>
			      </div>
			    </div>
			   </a>
			  </c:forEach>
			  </div>
			</div>
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
		 $(".ls_div").slick({
				slidesToShow: 4,
				slidesToScroll: 4,
				prevArrow : "<button type='button' class='ls_div_content_prev'>이전</button>",		// 이전 화살표 모양 설정
				nextArrow : "<button type='button' class='ls_div_content_next'>다음</button>",		// 다음 화살표 모양 설정
			});
		 
		 /* 이미지 삽입 */
			$(".image_wrap").each(function(i, obj){
				
				const bobj = $(obj);
				
				if(bobj.data("bookid")){
					const uploadPath = bobj.data("path");
					const uuid = bobj.data("uuid");
					const fileName = bobj.data("filename");
					
					const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
					
					$(this).find("img").attr('src', '/display?fileName=' + fileCallPath);
				} else {
					$(this).find("img").attr('src', '/resources/img/goodsNoImage.png');
				}
				
			});
		 
		 
	});
	
	</script>

</body>
</html>