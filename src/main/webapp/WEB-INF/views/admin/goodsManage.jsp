<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>

<link rel="stylesheet" href="../resources/css/admin/goodsManage.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>

<style>
.admin_list_02 {
	background-color: #c8c8c8;
}
</style>


	<script> 
		
	</script>

<%@include file="./include/admin/header.jsp"%>

				<div class="admin_content_wrap">
					<div class="admin_content_subject">
						<span>상품 관리</span>
					</div>

					<div class="goods_table_wrap">
						<!-- 상품리스트 있을 경우 -->
						<c:if test="${listCheck != 'empty' }">
							<table class="goods_table">
								<thead>
									<tr>
										<td class="th_column_1">상품번호</td>
										<td class="th_column_2">상품이름</td>
										<td class="th_column_3">작가 이름</td>
										<td class="th_column_4">카테고리</td>
										<td class="th_column_5">재고</td>
										<td class="th_column_6">등록날짜</td>
									</tr>
								</thead>
								<c:forEach items="${list}" var="list">
									<tr>
										<td>
										<a class="move" href='<c:out value="${list.bookId}"/>'>
										<c:out value="${list.bookName}"></c:out>
										</a>
										</td>
										<td><c:out value="${list.bookName}"></c:out></td>
										<td><c:out value="${list.authName}"></c:out></td>
										<td><c:out value="${list.cateName}"></c:out></td>
										<td><c:out value="${list.bookStock}"></c:out></td>
										<td><fmt:formatDate value="${list.regDate}"
												pattern="yyyy-mm-dd" /></td>
									</tr>
								</c:forEach>
							</table>
						</c:if>

						<!-- 상품리스트 없을 경우 -->
						<c:if test="${listCheck == 'empty'}">
							<div class="table_empty">등록된 상품이 없습니다.</div>
						</c:if>

					</div>

					<!-- 검색 영역  -->
					<div class="search_wrap">
						<form id="searchForm" action="/admin/goodsManage" method="get">
							<div class="search_input">
								<input type="text" name="keyword"
									value='<c:out value="${pageMaker.cri.keyword}"></c:out>'>
								
								<input type="hidden" name="pageNum"
									value='<c:out value="${pageMaker.cri.pageNum}"></c:out>'>
								
								<input type="hidden" name="amount"
									value='<c:out value="${pageMaker.cri.amount}"></c:out>'>
								<input type="hidden" name="type" value="G">
								<button type="submit" class="btn search_btn">검색</button>

							</div>
						</form>
					</div>
					
					<!-- 페이지 이름 인터페이스 영역 -->
					<div class="pageMaker_wrap">
					<ul class="pageMaker">
					   <c:if test="${pageMaker.prev}">
					   <li class="pageMaker_btn prev">
					   <a href="${pageMaker.pageStart-1 }">이전</a>
					   </li>
					   </c:if>
					   
					   <c:forEach begin="${pageMaker.pageStart}" end="${pageMaker.pageEnd }" var="num">
					    <li class="pageMaker_btn ${pageMaker.cri.pageNum == num ? 'active':''}">
					    <a href="${num}">${num}</a>
					    </li>
					   </c:forEach>
					   
					   <!-- 다음 버튼 -->
	                  <c:if test="${pageMaker.next}">
	                    		<li class="pageMaker_btn next">
	                    			<a href="${pageMaker.pageEnd + 1 }">다음</a>
	                    		</li>
	                  </c:if>
					   
					</ul>
					</div>
					
					
					<form id="moveForm" action="/admin/goodsManage" method="get" >
 						<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
						<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
						<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
                	</form>


				</div>
				<div class="clearfix"></div>
		
		
<script>


$(document).ready(function() {
	
	/* 상품등록 이벤트*/
	let eResult = '<c:out value="${enroll_result}"/>';

	checkResult(eResult);

	function checkResult(result) {
		if (result === '') {
			return;
		}
		alert("상품'" + eResult + "'을 등록하였습니다.");
	}
	
	/* 수정 성공 이벤트 */
	let modify_result = '${modify_result}';
	if(modify_result == 1){
		alert("수정 완료");
	}
	
	/* 삭제 결과 경고창 */
	let delete_result = '${delete_result}';
	if(delete_result == 1){
		alert("삭제 완료");
	}
});



/* 작가 검색 버튼 동작 */
let searchForm = $("#searchForm");
let moveForm = $("#moveForm");


$("#searchForm button").on("click", function(e){
	
	 e.preventDefault();
	
	if(!searchForm.find("input[name='keyword']").val()){
		alert("키워드를 입력해주세요.");
		return false;
	}
	
	searchForm.find("input[name='pageNum']").val("1");
	searchForm.submit();
 }); 
 
 
 /* 페이지 이동 버튼 */
$(".pageMaker_btn a").on("click", function(e){
	e.preventDefault();
	
	moveForm.find("input[name='pageNum']").val($(this).attr("href"));
	moveForm.submit();
});

 
 /* 상품 조회 페이지 */
 $(".move").on("click", function(e){
	e.preventDefault();
	
	moveForm.append("<input type='hidden' name='bookId' value='"+ $(this).attr("href") + "'>");
	moveForm.attr("action", "/admin/goodsDetail");
	moveForm.submit();
 });
 
</script>
		
<%@include file="./include/admin/footer.jsp"%>
</body>
</html>
