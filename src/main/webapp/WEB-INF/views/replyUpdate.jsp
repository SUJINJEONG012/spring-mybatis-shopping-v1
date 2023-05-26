<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>

	${bookInfo} ${memberId}
	
	<div class="wrapper_div">
	 <div class="subject_div">
	   리뷰수정
	 </div>
	 
	 
	 <div class="input_wrap">			
			<div class="bookName_div">
				<h2>${bookInfo.bookName}</h2>
			</div>
			<div class="rating_div">
				<h4>평점</h4>
				<select name="rating">
					<option value="0.5">0.5</option>
					<option value="1.0">1.0</option>
					<option value="1.5">1.5</option>
					<option value="2.0">2.0</option>
					<option value="2.5">2.5</option>
					<option value="3.0">3.0</option>
					<option value="3.5">3.5</option>
					<option value="4.0">4.0</option>
				</select>
			</div>
			<div class="content_div">
				<h4>리뷰</h4>
				<textarea name="content">${replyInfo.content}</textarea>
			</div>
		</div>
		
		<div class="btn_wrap">
			<a class="cancel_btn">취소</a>
			<a class="update_btn">수정</a>
		</div>
		
	</div>
	
	<script>
	
	 $(document).ready(function(){
		let rating = '${replyInfo.rating}';
		$("option").each(function(i,obj){
			if(rating === $(obj).val()){
				$(obj).attr("selected", "selected");
			}
		});
		
		$(".cancel_btn").on("click", function(e){
			window.close();
		});
		
		$(".update_btn").on("click", function(e){
			const replyId = '${replyInfo.replyId}';
			const bookId = '${replyInfo.bookId}';
			const memberId = '${memberId}';
			const rating = $('select').val();
			const content = $("textarea").val();
			
			const data = {
					replyId : replyId,
					bookId : bookId,
					memberId : memberId,
					rating : rating,
					content : content
			}
			
			$.ajax({
				data : data,
				type : 'POST',
				url : '/reply/update',
				success : function(result){
					$(opener.location).attr("href", "javascript:replyListInit();");
					window.close();
				}
			})
		});
		
	 });
	</script>
</body>
</html>