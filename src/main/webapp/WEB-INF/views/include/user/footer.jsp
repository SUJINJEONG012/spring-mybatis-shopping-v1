<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<div class="footer">
			<div class="footer_container inner">
				<div class="foot_box footer_info" >
				 <h2 class="" lang="en">Company Info</h2>
				 <address lang="en"> 부산광역시 © 2023 COPYRIGHT </address>
				</div>
				
				<div class="foot_box footer_contact">
				  <h2 class="" lang="en">Contact </h2>
					<p><span>Tel : </span></p>
					<p><span>Email : </span></p>
				</div>
				
			</div>
		</div>
		<!-- class="footer" -->


	</div>
	<!-- wrapper end -->
	
	
	
	<script>
	
	/* 검색 타입  */
	$(document).ready(
					function() {
						const selectedType = '<c:out value="${pageMaker.cri.type}" />';
						if (selectedType != "") {
							$("select[name='type']").val(selectedType)
									.attr("selected", "selected");
						}
						$(".image_wrap")
								.each(
										function(i, obj) {
											const bobj = $(obj);
											if (bobj.data("bookid")) {
												const uploadPath = bobj
														.data("path");
												const uuid = bobj
														.data("uuid");
												const fileName = bobj
														.data("filename");
												const fileCallPath = encodeURIComponent(uploadPath
														+ "/s_"
														+ uuid
														+ "_" + fileName);
												$(this)
														.find("img")
														.attr(
																'src',
																'/display?fileName='
																		+ fileCallPath);
											} else {
												$(this)
														.find("img")
														.attr('src',
																'/resources/img/goodsNoImage.png');
											}
										});

					});
	</script>

<script src="/resources/js/common.js"></script>
