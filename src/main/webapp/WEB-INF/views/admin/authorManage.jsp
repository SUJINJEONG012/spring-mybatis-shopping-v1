<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작가 관리</title>

</head>
<body>
	<style>
.admin_navi_wrap li a.admin_list_04 {
	display: inline-block;
	background: #2d2f4f;
	color: #fff;
}
</style>

	<%@include file="../include/admin/header.jsp"%>




	<div class="admin_content_wrap">


		<div class="admin_content">


			<div class="admin_bg">

				<div class="admin_content_box">



					<div class="admin_content_subject">
						<span>작가 관리</span>
					</div>

					<div class="author_table_wrap">
						<c:if test="${listCheck != 'empty' }">
							<table class="tbl-type01">
								<thead>
									<tr>
										<td class="th_column_1">작가 번호</td>
										<td class="th_column_1">작가 이름</td>
										<td class="th_column_1">작가 국가</td>
										<td class="th_column_1">등록 날짜</td>
										<td class="th_column_1">수정 날짜</td>
									</tr>
								</thead>

								<c:forEach items="${list}" var="list">
									<tbody>
										<tr>
											<td lang="en"><c:out value="${list.authorId}"></c:out></td>
											<td><a class="move"
												href='<c:out value="${list.authorId}"/>'> <c:out
														value="${list.authName}"></c:out>
											</a></td>

											<td lang="en"><c:out value="${list.nationName}"></c:out></td>
											<td lang="en"><fmt:formatDate value="${list.regDate}"
													pattern="yyyy-MM-dd" /></td>
											<td lang="en"><fmt:formatDate value="${list.updateDate}"
													pattern="yyyy-MM-dd" /></td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</c:if>

						<c:if test="${listCheck == 'empty'}">
							<div class="table_empty">등록된 작가가 없습니다.</div>
						</c:if>
					</div>

					<!-- 검색 영역 -->
					<div class="search_wrap">
						<form id="searchForm" action="/admin/authorManage" method="get">
							<div class="search_input">
								<input type="text" name="keyword"
									value='<c:out value="${pageMaker.cri.keyword}"></c:out>'>
								<input type="hidden" name="pageNum"
									value='<c:out value="${pageMaker.cri.pageNum}"></c:out>'>
								<input type="hidden" name="amount"
									value='${pageMaker.cri.amount}'>
								<button class="btn search_btn">검 색</button>
							</div>
						</form>
					</div>
					<!-- 검색 영역 -->

					<!-- 페이지 이동 인터페이스 영역 -->
					<div class="pageMaker_wrap">

						<ul class="pageMaker">

							<!-- 이전 버튼 -->
							<c:if test="${pageMaker.prev}">
								<li class="pageMaker_btn prev"><a
									href="${pageMaker.pageStart -1}">이전</a></li>
							</c:if>

							<!-- 페이지 번호 -->
							<c:forEach begin="${pageMaker.pageStart}"
								end="${pageMaker.pageEnd}" var="num">

								<li class="pageMaker_btn ${pageMaker.cri.pageNum == num ? "active":""}">
									<a href="${num}">${num}</a>
								</li>

							</c:forEach>

							<!-- 다음 버튼 -->
							<c:if test="${pageMaker.next}">
								<li class="pageMaker_btn next"><a
									href="${pageMaker.pageEnd + 1}">다음</a></li>
							</c:if>

						</ul>

					</div>

					<!-- 페이지 이동 인터페이스 영역 -->

					<form id="moveForm" action="/admin/authorManage" method="get">
						<input type="hidden" name="pageNum"
							value="${pageMaker.cri.pageNum}"> <input type="hidden"
							name="amount" value="${pageMaker.cri.amount}"> <input
							type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
					</form>

				</div>
			</div>

		</div>

	</div>

	<!-- end -->

	<script>
		$(document).ready(function() {
			let result = '<c:out value="${enroll_result}"/>';
			let mresult = '<c:out value="${modify_result}"/>';

			checkResult(result);
			checkmResult(mresult);

			function checkResult(result) {
				if (result === '') {
					return;
				}
				alert(" 작가 '${enroll_result}' 을 등록하였습니다.");
			}

			function checkmResult(mresult) {
				if (mresult === '1') {
					alert("작가정보를 수정하였습니다.");
				} else if (mresult === '0') {
					alert("작가 수정 정보를 수정하지 못하였습니다.");
				}
			}

			/* 삭제 경고창 */
			let delete_result = '${delete_result}';

			if (delete_result == 1) {
				alert("삭제 완료");
			} else if (delete_result == 2) {
				alert("해당 작가 데이터를 사용하고 있는 데이터가 있어서 삭제할 수 없습니다.");
			}

		});

		let moveForm = $('#moveForm');
		let searchForm = $('#searchForm');

		/* 페이지 이동 버튼 */
		$(".pageMaker_btn a").on("click", function(e) {

			e.preventDefault();
			moveForm.find("input[name='pageNum']").val($(this).attr("href"));
			moveForm.submit();
		});

		/* 작가 검색 버튼 동작 */
		$("#searchForm button").on("click", function(e) {

			e.preventDefault();
			/* 검색 키워드 유효성 검사 */
			if (!searchForm.find("input[name='keyword']").val()) {
				alert("키워드를 입력하세요.!");
				return false;
			}

			searchForm.find("input[name='pageNum']").val("1");
			searchForm.submit();

		});

		/* 작가 상세 페이지 이동 */
		$(".move")
				.on(
						"click",
						function(e) {

							e.preventDefault();

							moveForm
									.append("<input type='hidden' name='authorId' value='"
											+ $(this).attr("href") + "'>");
							moveForm.attr("action", "/admin/authorDetail");
							moveForm.submit();

						});
	</script>


</body>
</html>