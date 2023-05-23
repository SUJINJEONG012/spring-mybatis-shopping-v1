<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>
<link rel="stylesheet" href="/resources/css/main.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
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
				<div class="line">
			</div>			
			<div class="content_top">
				<div class="ct_left_area">
					<div class="image_wrap" 
					data-bookid="${goodsInfo.imageList[0].bookId}" 
					data-path="${goodsInfo.imageList[0].uploadPath}" 
					data-uuid="${goodsInfo.imageList[0].uuid}" 
					data-filename="${goodsInfo.imageList[0].fileName}">
						<img>
					</div>				
				</div>
				
				<div class="ct_right_area">
					<div class="title">
						<h1>
							${goodsInfo.bookName}
						</h1>
					</div>
					<div class="line">
					</div>
					<div class="author">
						 <span>
						 	${goodsInfo.authName} 지음
						 </span>
						 <span>|</span>
						 <span>
						 	${goodsInfo.publisher}
						 </span>
						 <span>|</span>
						 <span class="publeyear">
						 	${goodsInfo.publeYear}
						 </span>
					</div>
					<div class="line">
					</div>	
					<div class="price">
						<div class="sale_price">정가 : <fmt:formatNumber value="${goodsInfo.bookPrice}" pattern="#,### 원" /></div>
						<div class="discount_price" lang="en">
							판매가 : <span class="discount_price_number"><fmt:formatNumber value="${goodsInfo.bookPrice - (goodsInfo.bookPrice*goodsInfo.bookDiscount)}" pattern="#,### 원" /></span> 
							[<fmt:formatNumber value="${goodsInfo.bookDiscount*100}" pattern="###" />% 
							<fmt:formatNumber value="${goodsInfo.bookPrice*goodsInfo.bookDiscount}" pattern="#,### 원" /> 할인]</div>							
					</div>
					<div>
					적립포인트 : <span class="point_span"></span>원
					</div>			
					<div class="line">
					</div>	
					<div class="button">						
						<div class="button_quantity">
							주문수량
							<input type="text" class="quantity_input" value="1">
							<span>
								<button class="plus_btn">+</button>
								<button class="minus_btn">-</button>
							</span>
						</div>
						<div class="button_set">
							<a class="btn_cart">장바구니 담기</a>
							<a class="btn_buy">바로구매</a>
						</div>
					</div>
				</div>
			</div>
			
			<div class="line">
			</div>			
			
			
				
			<div class="content_middle">
				<div class="book_intro">
					${goodsInfo.bookIntro}
				</div>
				<div class="book_content">
					${goodsInfo.bookContents }
				</div>
			</div>
			<div class="line">
			</div>				
			
			<div class="content_bottom">
			 
			 <div class="reply_subject">
			  <h2>리뷰</h2>
			 </div>
			 
			 <c:if test="${member != null}">
			 <div class="reply_button_wrap">
			  <button> 리뷰 쓰기</button> 
			 </div>	 
			 </c:if>
			</div>
			
			
			
			<!-- 주문페이지 form -->
			<form action="/order/${member.memberId}" method="get" class="order_form">
			
			<input type="hidden" name="orders[0].bookId" value="${goodsInfo.bookId}">
			<input type="hidden" name="orders[0].bookCount" value="">
			</form>
			
			</div>
		
<%@include file="./include/user/footer.jsp"%>
		
		
<script>

$(document).ready(function(){
	
	const bobj = $(".image_wrap");
	
	if(bobj.data("bookid")){
		const uploadPath = bobj.data("path");
		const uuid = bobj.data("uuid");
		const fileName = bobj.data("filename");
		const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
		
		bobj.find("img").attr("src", "/display?fileName=" + fileCallPath);
		
	}else{
		bobj.find("img").attr("src", "/resources/img/goodsNoImage.png");
	} 
	
	/* publeyear */
	const year = "${goodsInfo.publeYear}";
	let tempYear = year.substr(0,10);
	let yearArray = tempYear.split("-");
	let publeYear = yearArray[0] + "년 " + yearArray[1] + "월 " + yearArray[2] + "일 ";
	$(".publeyear").html(publeYear);
	
		
});


/*  포인트 삽입  */
// salePrice할인 판매 가격을 계산하여 저장
let salePrice = "${goodsInfo.bookPrice - (goodsInfo.bookPrice*goodsInfo.bookDiscount)}";
// 계산한 값에 0.05를  곱해서 포인트 값 계산 
let point = salePrice * 0.05;
// 소수점 나머지가 생길 경우 버리도록 Math.floor() 메서드를 사용
point = Math.floor(point);
$(".point_span").text(point);


  //수량버튼 조작 
  let quantity = $(".quantity_input").val();
  
  $(".plus_btn").on("click", function(){
	  $(".quantity_input").val(++quantity);
  });
  $(".minus_btn").on("click", function(){
	  $(".quantity_input").val(--quantity);
  });
  
//서버로 전송할 데이터  
  const form = {
		  memberId :'${member.memberId}',
		  bookId :'${goodsInfo.bookId}',
		  bookCount : ''
  }
  
 // 장바구니 추가 버튼
	$(".btn_cart").on("click", function(e){
		
		form.bookCount = $(".quantity_input").val();
		$.ajax({
			url: '/cart/add',
			type: 'POST',
			data: form,
			success: function(result){
				cartAlert(result);
			}
		})
		
	});
	
  function cartAlert(result){
		if(result == '0'){
			alert("장바구니에 추가를 하지 못하였습니다.");
		} else if(result == '1'){
			alert("장바구니에 추가되었습니다.");
		} else if(result == '2'){
			alert("장바구니에 이미 추가되어져 있습니다.");
		} else if(result == '5'){
			alert("로그인이 필요합니다.");	
		}
	};
	
	/* 바로구매 */
	$(".btn_buy").on("click", function(){
		//버튼수량 구매
		let bookCount = $(".quantity_input").val();
		$(".order_form").find("input[name='orders[0].bookCount']").val(bookCount);
		$(".order_form").submit();
	});
	
	
 
	/* 리뷰 쓰기 */
	$(".reply_button_wrap").on("click", function(e){
		
		e.preventDefault();
		
		const memberId = '${member.memberId}';
		const bookId = '${goodsInfo.bookId}';
		
		$.ajax({
			data : {
				bookId : bookId,
				memberId : memberId
			},
			// 컨트롤러에 등록된 매핑주소 
			url : '/reply/check',
			type : 'post',
			success : function(result){
				if(result == '1'){
					alert("이미 등록된 리뷰가 존재합니다. ")
				
				}else if(result == '0'){
					// 등록된 리뷰가없을때 등록되게끔
					let popUrl = "/replyEnroll/" + memberId + "?bookId=" + bookId;
					console.log(popUrl);
					let popOption = "width= 490px, height = 490px, top= 300px, left=300px, scrollbars=yes";
					window.open(popUrl, "리뷰쓰기", popOption);
				}
			}
		});
		
	});
  	
 
  	
  	


 </script>
</body>
</html>