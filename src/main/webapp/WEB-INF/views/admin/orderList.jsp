<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/admin/page.css">
<link rel="stylesheet" href="../resources/css/admin/orderlist.css">
</head>
<body>

<style>
.admin_navi_wrap li a.admin_list_06 { display:inline-block; background:#2d2f4f; color:#fff; } 

</style>
	<%@include file="../include/admin/header.jsp"%>

	<div class="admin_content_wrap">
	
	 <div class="admin_content">
                    
		<div class="admin_content_subject">
			<span>주문 현황</span>
		</div>
		<div class="author_table_wrap">
			<!-- 게시물 0  -->
			<c:if test="${listCheck != 'empty' }">
				
				<table class="order_table">
					<colgroup>
						<col width="21%">
						<col width="20%">
						<col width="20%">
						<col width="20%">
						<col width="19%">
					</colgroup>
					<thead>
						<tr>
							<td class="th_column_1">주문 번호</td>
							<td class="th_column_1">주문 아이디</td>
							<td class="th_column_1">주문 날짜</td>
							<td class="th_column_1">주문 상태</td>
							<td class="th_column_1">취소</td>
						</tr>
					</thead>

					<c:forEach items="${list}"  var="list">
						<tr>
							<td lang="en"><c:out value="${list.orderId}"></c:out></td>
							<td lang="en"><c:out value="${list.memberId}"></c:out></td>
							<td lang="en"><fmt:formatDate value="${list.orderDate}" pattern="yyyy-MM-dd"/></td>
							<td><c:out value="${list.orderState}"/></td>
							<td>
							 <c:if test="${list.orderState == '배송준비' }">
							  <button class="delete_btn" data-orderid="${list.orderId}">취소</button>
							 </c:if>
							</td>
						</tr>
					</c:forEach>			
				</table>
				
			</c:if>

			<!-- 게시물 x -->
			
			<form id="moveForm" action="/admin/orderList" method="get">
			 <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			 <input type="hidden" name="amount" value="${pageMaker.cri.amount}">
			 <input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
			</form>
			
			<form id="deleteForm" action="/admin/orderCancel" method="post">
			  <input type="hidden" name="orderId">
			  <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			  <input type="hidden" name="amount" value="${pageMaker.cri.amount}">
			  <input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
			  <input type="hidden" name="memberId" value="${member.memberId}">
			</form>

		</div>
	</div>

</div>

<script>
 $(".delete_btn").on("click", function(e){
	 e.preventDefault();
	 let id = $(this).data("orderid");
	 $("#deleteForm").find("input[name='orderId']").val(id);
	 $("#deleteForm").submit();
 });
 
 
</script>
</body>
</html>