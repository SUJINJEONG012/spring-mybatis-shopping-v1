<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>


<body>

	<div class="join_wrap">
		<div class="join_box">
          
          <h1 class="logo" lang="en">BOOK SHOPPING</h1>

			
			<form id="login_form" method="post">
				<div class="input_wrap">
					
					<span class="input_label">아이디</span>
					<input type="text" name="memberId" placeholder="이름" class="cm_input full">
				</div>
				
				<div class="input_wrap">
					<span class="input_label">비밀번호</span>
					<input type="text" name="memberPw" placeholder="비밀번호" class="cm_input full">
				</div>

				<c:if test="${result == 0}">
					<div class="login_warn">사용자 ID 또는 비밀번호를 잘못 입력하셨습니다.</div>
				</c:if>
			</form>
			
			<div class="button_wrap">
					<input type="button" class="login_button" value="로그인">
			</div>
				

		</div>
	</div>


	<script>
		$(".login_button").click(function() {
			alert("로그인 버튼 적용");
			$("#login_form").attr("action", "/member/login");
			$("#login_form").submit();
		});
	</script>
</body>
</html>