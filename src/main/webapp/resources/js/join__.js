/*
 * 아이디 중복체크, 이메일, 주소, 유효성검사
 */

"use strict";

let code = ""; //이메일 인증번호 저장한 코드


// 회원가입 유효성 검사
const check_reg = function check_reg() {
	
alert("회원가입 버튼을 눌렀습니다.");
  let userId = document.querySelector(".id_input").value; // 유저가 입력한 이름값
  let userPW = document.querySelector(".pw_input").value;
  let userPwChk = document.querySelector(".pwck_input").value;
  let userName = document.querySelector(".user_input").value;
  let userEmail = document.getElementById(".mail_input").value;
  let userEmailChk = document.querySelector(".mail_check_input").value;

  
  //정규식 선언

  //모든 공백 체크 정규식
  let regExp = /\s/g;
  //아이디 정규식   a~z, 0.9로 시작하는 4~12자리 아이디를 만들 수 있다.
  let idReg = /^[a-z0-9]{4,12}$/;
    // 비밀번호 정규식 숫자, 문자로 이루어진 6~12자리의 비밀번호
  let pwReg = /^[A-Za-z0-9]{4,12}$/;
  // 이름 정규식 가~히, 한글로 이루어진 문자만으로 2~6자리
  let nameReg = /^[가-힣]{2,6}$/; 
  // 이메일 검사 정규식
  let emailReg =
    /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

if(!idReg.test(userId) || userId.trim() === ""){
	alert("형식에 맞게 이름을 입력하세요.");
	document.querySelector(".id_input").focus();
	document.querySelector(".id_input").value="";
	return false;
}
  
 
}




/* $(".id_input").on("propertychange change keyup paste input", function(){
	console.log("keyup 테스트");
}); */

//아이디 중복검사
document.querySelector(".id_input").on("propertychange change keyup paste input ", function() {
	
	let memberId = $(".id_input").val();
	let data = { memberId: memberId }

	$.ajax({
		type: "post",
		url: "/member/memberIdChk",
		data: data,
		success: function(result) {
			console.log("성공여부" + result);
			if (result != 'fail') {
				//중복 안될 
				$(".id_input_re_1").css("display", "inline-block");
				$(".id_input_re_2").css("display", "none");
				idckCheck = true;
			} else {
				//중복될때
				$(".id_input_re_1").css("display", "none");
				$(".id_input_re_2").css("display", "inline-block");
				idckCheck = false;
			}
		}
	});

});

/* 비밀번호 확인 일치 유효성 검사 */
$(".pwck_input").on("propertychange keyup paste input", function() {
	let pw = $(".pw_input").val();
	let pwck = $(".pwck_input").val();

	$(".final_pwck_ck").css("display", "none");

	//비밀번호 조건
	if (pw == pwck) {
		$(".pwck_input_re_1").css("display", "block");
		$(".pwck_input_re_2").css("display", "none");
		pwckcorCheck = true;
	} else {
		$(".pwck_input_re_1").css("display", "none");
		$(".pwck_input_re_2").css("display", "block");
		pwckcorCheck = false;
	}


});


	/* 이메일 유효성 검사  */
	function mailFormCheck(email) {
		let emailform = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		return emailform.test(email);

	}
	
	
//인증번호 이메일 전송 => 컨트롤러에 화면이 전횐되면 안되기때문에 ajax 사용(비동기)

$(".mail_check_button").click(function() {
	alert("인증번호를 확인해주세요.");
	console.log("클릭 ? ");
	var email = $(".mail_input").val(); //입력한 이메일
	var checkBox = $(".mail_check_input"); //인증번호 입력
	var boxWrap = $(".mail_check_box"); // 인증번호 입력한 박스
	var warnMsg = $(".mail_input_box_warn"); // 이메일 입력 경고글


	/* 이메일 유효성 검사  */
	if(mailFormCheck(email)){
		warnMsg.html("이메일이 전송되었습니다. 이메일을 확인해주세요.");
		warnMsg.css("display","inline-block");
	}else{
		warnMsg.html("올바르지 않은 이메일 형식입니다.");
		warnMsg.css("display","inline-block");
		return false;
	}

	$.ajax({
		type: "GET",
		url: "mailCheck?email=" + email,
		success: function(data) {
			//console.log("data: " + data);
			checkBox.attr("disabled", false);
			boxWrap.attr("id", "mail_check_input_box_true");
			code = data;
		}
	});
});

/*인증번호 비교*/
$(".mail_check_input").blur(function() {
	var inputCode = $(".mail_check_input").val(); //입력코드
	var checkResult = $("#mail_check_input_box_warn"); // 비교 결과

	if (inputCode == code) {
		checkResult.html("인증번호가 일치합니다.")
		checkResult.attr("class", "correct");
		mailnumCheck = true;  //일치 할 경우
	} else {
		checkResult.html("인증번호를 다시 입력해주세요.")
		checkResult.attr("class", "incorrect");
		mailnumCheck = false; //일치하지 않을경우
	}
});


/* 다음 주소 연동 */
function execution_daum_address() {
	//alert("dd");
	new daum.Postcode({
		//여기서 data는 주소팝업창에서 선택한 주소에 대한 정보를 반환받는 객체 변수
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
			// 예제를 참고하여 다양한 활용법을 확인해 보세요.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				//document.getElementById("sample6_extraAddress").value = extraAddr;

				//주소변수 문자열과 참고항목 문자열 합치기
				addr += extraAddr;
			} else {
				//document.getElementById("sample6_extraAddress").value = '';
				addr += ' ';

			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			//document.getElementById('sample6_postcode').value = data.zonecode;
			//document.getElementById("sample6_address").value = addr;
			$(".address_input_1").val(data.zonecode);
			$(".address_input_2").val(addr);
			// 커서를 상세주소 필드로 이동한다.
			//document.getElementById("sample6_detailAddress").focus();
			$(".address_input_3").attr("readonly", false);
			$(".address_input_3").focus();


		}
	}).open();
}


