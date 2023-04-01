<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="../resources/css/admin/page.css">
<link rel="stylesheet" href="../resources/css/admin/goodsEnroll.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
 <script src="https://cdn.ckeditor.com/ckeditor5/26.0.0/classic/ckeditor.js"></script>

</head>
<body>

	<style>
.admin_list_01 {
	background-color: #c8c8c8;
}
</style>
	<%@include file="./include/admin/header.jsp"%>

	<div class="admin_content_wrap">

		<div class="admin_content_subject">
			<span>상품 등록</span>
		</div>


		<div class="admin_content_main">
			<form action="/admin/goodsEnroll" method="post" id="enrollForm">

				<div class="form_section">
					<div class="form_section_title">
						<label>책 제목</label>
					</div>

					<div class="form_section_content">
						<input name="bookName"> <span
							class="ck_warn bookName_warn">책이름을 입력해주세요.</span>
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label>작가 </label>
					</div>

					<div class="form_section_content">
						<input type="text" name="authName" value="0">
						<!-- <input id="authName_input" readonly="readonly"> <input
							id="authorId_input" name="authorId" type="hidden">
						<button class="authorId_btn">작가선택</button>
						<span class="ck_warn authorId_warn">작가를 선택해주세요</span> -->
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label> 출판일 </label>
					</div>

					<div class="form_section_content">
						<input name="publeYear">
					
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label>출판사 </label>
					</div>

					<div class="form_section_content">
						<input name="publisher"> 
						<!-- <span
							class="ck_warn publisher_warn"> 출판사를 입력해주세요.</span> -->
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label>책 카태고리</label>
					</div>
					<div class="form_section_content">
					 <input name="cateCode">
					</div>
				</div>


				<div class="form_section">
					<div class="form_section_title">
						<label>상품가격 </label>
					</div>

					<div class="form_section_content">
						<input name="bookPrice" value="0">
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label>상품재고 </label>
					</div>

					<div class="form_section_content">
						<input name="bookStock" value="0">
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label>상품할인율 </label>
					</div>

					<div class="form_section_content">
						<input name="bookDiscount" value="0">
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label>책 소개 </label>
					</div>

					<div class="form_section_content">
						<textarea name="bookIntro" id="bookIntro_textarea"></textarea>
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label>책 목차</label>
					</div>

					<div class="form_section_content">
						<textarea name="bookContents" id="bookContents_textarea"></textarea>
					</div>
				</div>

			</form>

			<div class="btn_section">
				<button id="cancelBtn" class="btn">취소</button>
				<button id="enrollBtn" class="btn enroll_btn">등록</button>
			</div>

		</div>

	</div>

	<%@include file="./include/admin/footer.jsp"%>

<script>

let enrollForm = $("#enrollForm")
	
/* 취소 버튼 */
$("#cancelBtn").click(function(){
	
	location.href="/admin/goodsManage"
	
});

/* 상품 등록 버튼 */
$("#enrollBtn").on("click",function(e){
	
	e.preventDefault();
	 
	enrollForm.submit();
	
});

/* 위지윅 적용 */

/* 책 소개 */
ClassicEditor
.create(document.querySelector('#bookIntro_textarea'))
.catch(error=>{
	console.error(error);
});

/* 책 목차 */
ClassicEditor
.create(document.querySelector('#bookContents_textarea'))
.catch(error => {
	console.error(error);
});
 

</script> 	



</body>
</html>