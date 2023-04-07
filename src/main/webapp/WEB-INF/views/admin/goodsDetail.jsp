<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 페이지</title>
<link rel="stylesheet" href="../resources/css/admin/goodsDetail.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/26.0.0/classic/ckeditor.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

</head>
<body>



	<%@include file="./include/admin/header.jsp"%>
	
	
	
	<div class="admin_content_main">
		
		<div class="admin_content_subject">
			<span>상품 상세</span>
		</div>

		<div class="admin_content_main">

			<div class="form_section">
				<div class="form_section_title">
					<label>책 제목</label>
				</div>
				<div class="form_section_content">
					<input type="text" name="bookName"
						value="<c:out value="${goodsInfo.bookName}" /> " disabled>
				</div>
			</div>


			<div class="form_section">
				<div class="form_section_title">
					<label>등록 날짜</label>
				</div>
				<div class="form_section_content">
					<input
						value="<fmt:formatDate value="${goodsInfo.regDate}" pattern="yyyy-MM-dd" /> "
						disabled>
				</div>
			</div>

			<div class="form_section">
				<div class="form_section_title">
					<label>최근 수정 날짜</label>
				</div>
				<div class="form_section_content">
					<input
						value="<fmt:formatDate value="${goodsInfo.updateDate}" pattern="yyyy-MM-dd" /> "
						disabled>
				</div>
			</div>


			<div class="form_section">
				<div class="form_section_title">
					<label>작가</label>
				</div>
				<div class="form_section_content">
					<input type="text" id="authName_input" readonly="readonly"
						value="<c:out value="${goodsInfo.authName}" /> " disabled>
				</div>
			</div>

			<div class="form_section">
				<div class="form_section_title">
					<label>출판일</label>
				</div>
				<div class="form_section_content">
					<input type="text" name="publeYear" autocomplete="off"
						readonly="readonly"
						value="<c:out value="${goodsInfo.publeYear}" /> " disabled>
				</div>
			</div>


			<div class="form_section">
				<div class="form_section_title">
					<label>출판사</label>
				</div>
				<div class="form_section_content">
					<input type="text" name="publisher"
						value="<c:out value="${goodsInfo.publisher}" /> " disabled>
				</div>
			</div>


			<div class="form_section">
				<div class="form_section_title">
					<label>출판사</label>
				</div>
				<div class="form_section_content">
					<input type="text" name="publisher"
						value="<c:out value="${goodsInfo.publisher}" /> " disabled>
				</div>
			</div>

			<div class="form_section">
				<div class="form_section_title">
					<label>책 카테고리</label>
				</div>
				<div class="form_section_content">
					<div class="cate_wrap">
						<span>대분류</span> <select class="cate1" disabled>
							<option value="none">선택</option>
						</select>
					</div>

					<div class="cate_wrap">
						<span>중분류</span> <select class="cate2" disabled>
							<option value="none">선택</option>
						</select>
					</div>

					<div class="cate_wrap">
						<span>소분류</span> <select class="cate3" name="cateCode" disabled>
							<option value="none">선택</option>
						</select>
					</div>

				</div>
			</div>


			<div class="form_section">
				<div class="form_section_title">
					<label>상품가격</label>
				</div>
				<div class="form_section_content">
					<input type="text" name="bookPrice"
						value="<c:out value="${goodsInfo.bookPrice}" /> " disabled>
				</div>
			</div>


			<div class="form_section">
				<div class="form_section_title">
					<label>상품 재고</label>
				</div>
				<div class="form_section_content">
					<input name="bookStock"
						value="<c:out value="${goodsInfo.bookStock}"/>" disabled>
				</div>
			</div>



			<div class="form_section">
				<div class="form_section_title">
					<label>상품 할인율</label>
				</div>
				<div class="form_section_content">
					<input id="discount_interface" maxlength="2" disabled>
				</div>
			</div>


			<div class="form_section">
				<div class="form_section_title">
					<label>책 소개</label>
				</div>
				<div class="form_section_content bit">
					<textarea name="bookIntro" id="bookIntro_textarea" disabled>${goodsInfo.bookIntro}</textarea>
				</div>
			</div>

			<div class="form_section">
				<div class="form_section_title">
					<label>책 목차</label>
				</div>
				<div class="form_section_content bct">
					<textarea name="bookContents" id="bookContents_textarea" disabled>${goodsInfo.bookContents}</textarea>
				</div>
			</div>


			<div class="btn_section">
				<button id="cancelBtn" class="btn">상품 목록</button>
				<button id="enrollBtn" class="btn enroll_btn">수정</button>
			</div>

		</div>

		<form id="moveForm" action="/admin/goodsManage" method="get">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
			<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
		</form>

	</div>

	<script>
	
	
	$(document).ready(function(){
		alert("dddd");
		//할인율 값 삽입
		let bookDiscount = '<c:out value="${goodsInfo.bookDiscount}"/>' * 100;
		$("#discount_interface").attr("value", bookDiscount);
	
		/* 책 소개 */
		ClassicEditor
			.create(document.querySelector("#bookIntro_textarea"))
			.catch(error=>{
			console.error(error);
		  	 }); 
		
		/* 책 목차 */	
		ClassicEditor
		.create(document.querySelector('#bookContents_textarea'))
		.catch(error=>{
		 	console.error(error);
		   });
			
	
	
	});
	
	
	</script>
	



	<%@include file="./include/admin/footer.jsp"%>
	
	

	
	</body>
</html>