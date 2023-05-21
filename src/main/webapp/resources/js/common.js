 /* gnb_area 로그아웃 버튼 작동 */
$("#gnb_logout_button").click(function(){
	//alert("버튼 작동");
	$.ajax({
		type:"post",
		url: "/member/logout",
		success:function(data){
			alert("로그아웃 성공");
			document.location.reload();
		}
	});
})