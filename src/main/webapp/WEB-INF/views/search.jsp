<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>

</head>
<body>


<%@include file="./include/user/header.jsp"%>

	<div class="content_area">
				<!-- 게시물 있을 때 -->
				<c:if test="${listcheck != 'empty'}">
				<!-- ${filter_info} -->
				<div class="search_filter">
				
				 <div class="filter_button_wrap">
				  <button class="filter_button filter_active" id="filter_button_a">국내</button>
				  <button class="filter_button" id="filter_button_b">국외</button>
				 </div>
				
				<div class="filter_content filter_a">
				 <c:forEach items="${filter_info}" var="filter">
				 <c:if test="${filter.cateGroup eq '1'}">
				 <a href="${filter.cateCode}">${filter.cateName}(${filter.cateCount})</a>
				 </c:if>
				 </c:forEach>
				</div>
				<div class="filter_content filter_b">
				<c:forEach items="${filter_info}" var="filter">
				 <c:if test="${filter.cateGroup eq '2'}">
				<a href="${filter.cateCode}">${filter.cateName}(${filter.cateCount})</a>
				</c:if>
				</c:forEach>
				
				</div>
				
				<form id="filter_form" action="/search" method="get">
				 <input type="hidden" name="keyword">
				 <input type="hidden" name="cateCode">
				 <input type="hidden" name="type">
				</form>
				
				</div>
				
				
		<div class="list_search_result">
						<table>
							<colgroup>
								<col width="110">
								<col width="*">
								<col width="120">
								<col width="120">
								<col width="120">
							</colgroup>
							<tbody id="searchList">
								<c:forEach items="${bookList}" var="bookList">
									<tr>
										<td class="image">
							

											<div class="image_wrap"
												data-bookid="${bookList.imageList[0].bookId}"
												data-path="${bookList.imageList[0].uploadPath}"
												data-uuid="${bookList.imageList[0].uuid}"
												data-filename="${bookList.imageList[0].fileName}">
												<img>
											</div>

										</td>
										<td class="detail">
											<div class="category">[${bookList.cateName}]</div>
											<div class="title">
											<a href="/goodsDetail/${bookList.bookId}">${bookList.bookName }</a>
											</div>
											<div class="author" lang="en">${bookList.authName }지음 |
												${bookList.publisher} | ${bookList.publeYear}</div>

										</td>
										<td>
											<div class="rating">평점 (추후 추가 )</div>
										</td>
										<td class="price">
											<div class="org_price">
												<del>
													<fmt:formatNumber value="${bookList.bookPrice }"
														pattern="#,###원 " />
												</del>
											</div>
											<div class="sell_price">
												<strong lang="en"> <fmt:formatNumber
														value="${bookList.bookPrice * ( 1 - bookList.bookDiscount)}"
														pattern="#,### 원" />
												</strong>
											</div>
										</td>

										<td class="option"></td>

									</tr>

								</c:forEach>
							</tbody>
						</table>
	        	</div>

					<!-- 페이지 인터페이스 -->
					<div class="pageMaker_wrap">
						<ul class="pageMaker">
							<!-- 이전버튼 -->
							<c:if test="${pageMaker.prev}">
								<li class="pageMaker_btn prev"><a href="${pageMaker.pageStart-1}">이전</a></li>
							</c:if>

							<!-- 페이지 번호  -->
							<c:forEach begin="${pageMaker.pageStart}"
								end="${pageMaker.pageEnd}" var="num">
								<li class="pageMaker_btn ${pageMaker.cri.pageNum == num ? 'active':''}">
									<a href="${num}">${num}</a>
								</li>
							</c:forEach>

							<!-- 다음 버튼 -->
							<c:if test="${pageMaker.next}">
								<li class="pageMaker_btn next">
								<a href="${pageMaker.pageEnd + 1}">다음</a></li>
							</c:if>
						</ul>
					</div>

					<form id="moveForm" action="/search" method="get">
						<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}"> 
						<input type="hidden" name="amout" value="${pageMaker.cri.amount}"> 
						<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
						<input type="hidden" name="cateCode" value="<c:out value="${pageMaker.cri.cateCode}" />">
						<input type="hidden" name="type" value="${pageMaker.cri.type}">
					</form>

				</c:if>
				<!-- 게시물 없을 때 -->
				<c:if test="${listcheck == 'empty'}">
					<div class="table_empty">검색결과가 없습니다.</div>
				</c:if>

			</div>


		
	<script>
		/* gnb_area 로그아웃 버튼 작동 */
		/* $("#gnb_logout_button").click(function() {
			//alert("버튼 작동");
			$.ajax({
				type : "post",
				url : "/member/logout",
				success : function(data) {
					alert("로그아웃 성공");
					document.location.reload();
				}
			}); //ajax
		}) */

		/* 페이지 이동 버튼 */
		const moveForm = $('#moveForm');
		$(".pageMaker_btn a").on("click", function(e) {
			e.preventDefault();
			moveForm.find("input[name='pageNum']").val($(this).attr("href"));
			moveForm.submit();
		});
		
		/* 검색필터 */
		
		let buttonA = $("#filter_button_a");  
		let buttonB = $("#filter_button_b"); 
		
		buttonA.on("click", function(){
	
			$(".filter_b").css("display", "none");
			$(".filter_a").css("display", "block");
			
			buttonA.attr("class", "filter_button filter_active");
			buttonB.attr("class", "filter_button");
		});
		
		
		buttonB.on("click", function(){
			$(".filter_a").css("display", "none");
			$(".filter_b").css("display", "block");
			
			buttonB.attr("class", "filter_button filter_active");
			buttonA.attr("class", "filter_button");
		});
		
		
		/* 필터 태그 동작 */
		$(".filter_content a").on("click", function(e){
			e.preventDefault();
			
			let type ='<c:out value="${pageMaker.cri.type}"/>';
			if(type ==='A' || type === 'T'){
				type= type +  'C';
			}
			// 카테고리 이름 TC = 제목 
			// 카테고리 이름 AC = 작가
			
			let keyword = '<c:out value="${pageMaker.cri.keyword}"/>';
			let cateCode = $(this).attr("href");
			
			$("#filter_form input[name='keyword']").val(keyword);
			$("#filter_form input[name='cateCode']").val(cateCode);
			$("#filter_form input[name='type']").val(type);
			$("#filter_form").submit();
			
		});
		

		/* 검색 타입  */
		$(document).ready(function() {
			const selectedType = '<c:out value="${pageMaker.cri.type}" />';
				if (selectedType != "") {
					$("select[name='type']").val(selectedType).attr("selected", "selected");
						}
					$(".image_wrap").each(function(i, obj) {
						const bobj = $(obj);		
							if(bobj.data("bookid")){
								const uploadPath = bobj.data("path");
								const uuid = bobj.data("uuid");
								const fileName = bobj.data("filename");
								const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
								$(this).find("img").attr('src', '/display?fileName=' + fileCallPath);
								}else{	
								$(this).find("img").attr('src', '/resources/img/goodsNoImage.png');
								}	
							}); 
										
							
			});
		
		
		
	</script>
	
	<%@include file="./include/user/footer.jsp"%>
	
</body>
</html>