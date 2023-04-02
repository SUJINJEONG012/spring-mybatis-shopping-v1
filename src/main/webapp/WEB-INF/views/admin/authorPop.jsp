<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작가 선택 팝업창</title>
<link rel="stylesheet" href="../resources/css/admin/authorPop.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<div class="subject_name_warp">
		<span>작가 선택</span>
	</div>

	<div class="content_wrap">

		<div class="author_table_wrap">

			<c:if test="${listCheck != 'empty' }">
				<div class="table_exist">
					
					<table class="author_table">
						<thead>
							<tr>
								<td class="th_column_1">작가번호</td>
								<td class="th_column_2">작가이름</td>
								<td class="th_column_3">작가국가</td>
							</tr>
						</thead>
						<c:forEach items="${list}" var="list">
							<tr>
								<td><c:out value="${list.authorId}"></c:out></td>
								<td><c:out value="${list.authName}"></c:out></td>
								<td><c:out value="${list.nationName}"></c:out></td>
							</tr>
						</c:forEach>
					</table>
					
					
				</div>
			</c:if>
			
			<c:if test="${listCheck == 'empty' }">
				<div class="table_empty">등록된 작가가 없습니다.</div>
			</c:if>


			<!-- 검색 영역 -->
			<div class="search_wrap">
				<form id="searchForm" action="/admin/authorPop" method="get">
					<div class="search_input">
						<input type="text" name="keyword"
							value='<c:out value="${pageMaker.cri.keyword}"></c:out>'>

						<input type="text" name="pageNum"
							value='<c:out value="${pageMaker.cri.pageNum}"></c:out>'>

						<input type="text" name="amount"
							value='<c:out value="${pageMaker.cri.amount}"></c:out>'>

						<button class="btn search_btn">검색</button>
					</div>
				</form>
			</div>

			<!-- 페이지 이동 인터페이스 영역 -->
			<div class="pageMaker_warp">

				<ul class="pageMaker">
					<c:if test="${pageMaker.prev}">
						<li class="pageMaker_btn prev"><a
							href="${pageMaker.pageStart -1 }">이전</a></li>
					</c:if>

                     <!-- 페이지 번호 -->
	                    	<c:forEach begin="${pageMaker.pageStart}" end="${pageMaker.pageEnd}" var="num">
	                    		<li class="pageMaker_btn ${pageMaker.cri.pageNum == num ? "active":""}">
	                    			<a href="${num}">${num}</a>
	                    		</li>
	                    	</c:forEach>
					

					<c:if test="${pageMaker.next}">
						<li class="pageMaker_btn next"><a
							href="${pageMaker.pageEnd + 1 }">다음</a></li>
					</c:if>
				</ul>

				<form id="moveForm" action="/admin/authorPop" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }"> 
					<input type="hidden" name="amount" value="${pageMaker.cri.amount }"> 
					<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
				</form>

			</div>


		</div>
		<!-- table_wrap end  -->

	</div>
	
	<script>
	let searchForm = $("#searchForm");
	let moveForm = $("#moveForm");
	
	/* 작가 검색 버튼 */
	$("#searchForm button").on("click", function(e){
		e.preventDefault();
		if(!searchForm.find("input[name='keyword']").val()){
			alert("키워드를 입력해주세요.");
			return false;
		}
		searchForm.find("input[name='pageNum']").val("1");
		searchForm.submit();
			
	});
	
	$(".pageMaker_btn a").on("click", function(e){
		e.preventDefault();
		console.log($(this).attr("href"));
		moveForm.find("input[name='pageNum']").val($(this).attr("href"));
		moveForm.submit();
	});
	</script>

</body>
</html>