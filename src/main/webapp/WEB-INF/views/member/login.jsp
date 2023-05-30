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



	<div class="login_page">


		<form id="login_form" method="post">

			<h1 class="logo">Book Shop</h1>


			<div class="login_wrap">

				<div class="id_wrap">
					<div class="id_input_box">
						<input type="text" class="id_input" name="memberId">
					</div>
				</div>

				<div class="pw_wrap">
					<div class="pw_input_box">
						<input type="text" class="pw_input" name="memberPw">
					</div>
				</div>

				<c:if test="${result == 0}">
					<div class="login_warn">사용자 ID 또는 비밀번호를 잘못 입력하셨습니다.</div>
				</c:if>


				<div class="login_button_wrap">
					<input type="button" class="login_button" value="로그인">
				</div>

			</div>
		</form>
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