<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작가등록</title>
</head>
<body>
 <%@include file="../include/admin/header.jsp" %>
<style>
.admin_list_03{
    background-color: #c8c8c8;
} 

</style>
                
                <div class="admin_content_wrap">
                    
                    <div class="admin_content_subject"><span>작가 등록</span></div>
                    
                    
                    <div class="admin_content_main">
                    	<form action="/admin/authorEnroll" method="post" id="enrollForm">
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>작가 이름</label>
                    			</div>
                    			
                    			<div class="form_section_content">
                    				<input name="authName">
                    				<span id="warn_authName">작가이름을 입력해주세요.</span>
                    			</div>
                    		</div>
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>소속 국가</label>
                    			</div>
                    			<div class="form_section_content">
                    				<select name="nationId">
                    					<option value="none" selected>=== 선택 ===</option>
                    					<option value="01">국내</option>
                    					<option value="02">국외</option>
                    				</select>
                    				<span id="warn_nationId">소속 국가를 선택해주세요.</span>
                    			</div>
                    		</div>	
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>작가소개</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="authorIntro" type="text">
                    				<span id="warn_authorIntro">작가 소개를 입력해주세요.</span>
                    			</div>
                    		</div>
                   		</form>
                   			
                   			<div class="btn_section">
                   				<button id="cancelBtn" class="btn">취 소</button>
	                    		<button id="enrollBtn" class="btn enroll_btn">등 록</button>
	                    	</div> 
                    </div>
                    
  
                </div>
                <!-- admin_content_wrap end -->
               
       
 <%@include file="../include/admin/footer.jsp" %>
<script>
$("#enrollBtn").click(function(){
	
	 //초기세팅 
	let nameCheck = false;
	let nationCheck = false;
	let introCheck = false;
	
	
	//입력값 변수
	let authName = $("input[name=authName]").val();
	let nationId = $("select[name=nationId]").val();
	let authorIntro = $("input[name=authorIntro]").val();

	
	// 유효성 태그
	let wAuthName= $("#warn_authName");
	let wNationId = $("#warn_nationId");
	let wAuthorIntro = $("#warn_authorIntro");
	
	if(authName === ""){
		wAuthName.css("display","block");
		nameCheck = false;
	}else{
		wAuthName.css("display","none");
		nameCheck = true;
	}
	
	if(nationId === ""){
		wNationId.css("display","block");
		nationCheck = false;
	}else{
		wNationId.css("display","none");
		nationCheck = true;
	}
	
	
	if(authorIntro === ""){
		wAuthorIntro.css("display","block");
		introCheck = false;
	}else{
		wAuthorIntro.css("display","none");
		introCheck = true;
	}
	
	$("#enrollForm").submit();
	
	
	if(nameCheck && nationCheck && introCheck){
		$("#enrollForm").submit();
	}else{
		return;
	}
	 
	
});


//취소버튼
$("#cancelBtn").click(function(){
	location.href="/admin/authorManage";
});


</script> 
</body>
</html>