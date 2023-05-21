<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="login_success_area">	
							<ul>
							<li>회원 : <span>${member.memberName }</span></li>
							<li>충전금액 : <span><fmt:formatNumber value="${member.money }" pattern="#,###.##" />원</span></li>
							<li>포인트 : <span><fmt:formatNumber value="${member.point }" pattern="#,###" />원</span></li>
							</ul>			
						</div>
</body>
</html>