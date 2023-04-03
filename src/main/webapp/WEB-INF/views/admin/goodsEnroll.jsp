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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/26.0.0/classic/ckeditor.js"></script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

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
						<input id="authName_input" readonly="readonly">
						<input id="authorId_input" name="authorId" type="hidden">
						<button class="authorId_btn">작가선택</button>
						
					</div>
				</div>

				<div class="form_section">
					<div class="form_section_title">
						<label> 출판일 </label>
					</div>

					<div class="form_section_content">
						<input name="publeYear" autocomplete="off" readonly="readonly">

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
						<label>책 카테고리</label>
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


/* 캘린더 위젯 적용 */
 
/* 설정 */
const config = {
		dateFormat: 'yy-mm-dd',
		showOn : "button",
		buttonText:"날짜 선택",
		prevText: '이전 달 ',
		nextText:'다음 달 ',
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    dayNames: ['일','월','화','수','목','금','토'],
	    dayNamesShort: ['일','월','화','수','목','금','토'],
	    dayNamesMin: ['일','월','화','수','목','금','토'],
	    yearSuffix: '년',
        changeMonth: true,
        changeYear: true
		
	
};
	

 $(function(){
	$("input[name='publeYear']").datepicker(config); 
 });
 
 /* 작가 선택 버튼 */
$(".authorId_btn").on("click", function(e){
	e.preventDefault();
	
	let popUrl =  "/admin/authorPop";
	let popOption =  "width = 600px, height = 500px, top=300px, left=300px, scrollbars=yes";
	window.open(popUrl, "작가찾기 ", popOption);
	
});
 
 
 $(document).ready(function(){
	console.log('${cateList}'); 
 });
 
</script>



</body>
</html>