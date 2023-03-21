<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/main.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>


<body>
	<div class="wrapper">

		<div class="wrap">

			<div class="logo_wrap">
				<span>Book Mall</span>
			</div>

			<form id="login_form" method="post">
				<div class="login_wrap">

					<div class="id_wrap">
						<div class="id_input_box">
							<input type="text" class="id_input" name="memberId">
						</div>
					</div>

					<div class="pw_wrap">
						<div class="pw_input_box">
							<input type="text" class="pw_input" name="memberPw" >
						</div>
					</div>
					
					<div class="login_warn">사용자 ID 또는 비밀번호를 잘못 입력하셨습니다.</div>
					
					<div class="login_button_wrap">
						<input type="button" class="login_button" value="로그인">
					</div>

				</div>
			</form>
		</div>
	</div>
	
	
	<script>
	$(".login_button").click(function(){
		alert("로그인 버튼 적용");
		$("#login_form").attr("action", "/member/login");
		$("#login_form").submit();
	});
	</script>
</body>
</html>