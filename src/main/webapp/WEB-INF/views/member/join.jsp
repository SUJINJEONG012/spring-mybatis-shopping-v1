<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

</head>
<body style="background: #0b514e;">



<div class="mem_wrap">
		
		<div class="mem_box">
		
		<h1 class="logo" lang="en">BOOK SHOPPING</h1>
		
		
		<form action="" id="join_form" method="post">
			<div class="input_wrap">
				<span class="input_label">아이디</span>
				
				<input class="id_input input" name="memberId">	
				
				<span class="id_input_re_1">사용가능한 아이디 입니다.</span>
				<span class="id_input_re_2">아이디가 이미 존재합니다.</span>
				<span class="final_id_ck">아이디를 입력해주세요.</span>
			</div>
			
			<div class="input_wrap">
				
				<span class="input_label">비밀번호</span>
				<div class="pw_input_box">
					<input class="pw_input input" name="memberPw">
				</div>
				<span class="final_pw_ck">비밀번호를 입력해주세요.</span>
			</div>
			
			<div class="input_wrap">
				
				<span class="input_label">비밀번호 확인</span>
				<div class="pwck_input_box">
					<input class="pwck_input input">
				</div>
				<span class="final_pwck_ck">비밀번호 확인을 입력해주세요.??</span>
				<span class="pwck_input_re_1">비밀번호가 일치합니다.</span>
				<span class="pwck_input_re_2">비밀번호가 일치하지 않습니다.</span>
			</div>
			
			<div class="input_wrap"> 
			 <span class="input_label">이름</span>	
				<div class="user_input_box">
					<input class="user_input input" name="memberName">
				</div>
				<span class="final_name_ck">이름을 입력해주세요.</span>
			</div>
			
			<div class="input_wrap">
				
				<span class="input_label">이메일</span>	
				<div class="input_box">
					<input class="mail_input input" name="memberMail">
					<div class="mail_check_button">
						<span class="btn">인증번호 전송</span>
				    </div>	
				</div>
				
					
				<span class="final_mail_ck">이메일을 입력해주세요.</span>
				<span class="mail_input_box_warn"></span>
				
				<div class="mail_check_wrap">
				    
					<div class="mail_check_input_box" id="mail_check_input_box_false">
						<input class="mail_check_input input" placeholder="인증번호" disabled="disabled">
					</div>
					<span id="mail_check_input_box_warn"></span>
				</div>
			</div>
			
			
			<div class="input_wrap">
				<span class="input_label">주소</span>	
				<div class="address_input_1_wrap">
					<div class="address_input_1_box input_box">
						<input class="address_input_1 input" name="memberAddr1" readonly="readonly">
					</div>
					
					<div class="address_button" onclick="execution_daum_address()">
						<span>주소 찾기</span>
					</div>
					
				</div>
				<div class ="address_input_2_wrap">
					<div class="address_input_2_box input_box">
						<input class="address_input_2 input" name="memberAddr2" readonly="readonly">
					</div>
				</div>
				<div class ="address_input_3_wrap">
					<div class="address_input_3_box input_box">
						<input class="address_input_3 input" name="memberAddr3" readonly="readonly" placeholder="나머지 주소를 입력해주세요.">
					</div>
				</div>
				<span class="final_addr_ck">주소를 입력해주세요.</span>
			</div>
				
		</form>

		<div class="button_wrap">
				<input type="button" class="join_button input" value="가입하기" >
				<!-- <input type="button" class="join_button" value="가입하기2"  onclick="check_reg()"> -->
		</div>
		
		
		</div>
</div>

	
	
	
<!--  주소 api 라이브러리 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script src="../resources/js/join.js"></script>

</body>
</html>