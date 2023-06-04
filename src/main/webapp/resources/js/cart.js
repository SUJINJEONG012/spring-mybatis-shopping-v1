$(document).ready(function(){
	
			/* 종합 정보 섹션 정보 삽입 */	
			setTotalInfo();	
			
			 /* 이미지 삽입 */
			/* $(".image_wrap").each(function(i, obj){
				const bobj = $(obj);
				
				if(bobj.data("bookid")){
					
					const uploadPath = bobj.data("path"); 
					const uuid = bobj.data("uuid");
					const fileName = bobj.data("filename");
					
					const fileCallPath = encodeURLComponent(uploadPath + "/s_" + uuid + "_" + fileName);
					
					$(this).find("img").attr('src', 'display?fileName=' + fileCallPath);
				
				} else{
					$(this).find("img").attr("src", "/resources/img/goodsNoImage.png");
				}
			}); */
			/* 이미지 삽입 */
			$(".image_wrap").each(function(i, obj){
			
				const bobj = $(obj);
				
				if(bobj.data("bookid")){
					const uploadPath = bobj.data("path");
					const uuid = bobj.data("uuid");
					const fileName = bobj.data("filename");
					
					const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
					
					$(this).find("img").attr('src', '/display?fileName=' + fileCallPath);
				} else {
					$(this).find("img").attr('src', '/resources/img/goodsNoImage.png');
				}
				
			});
			
			
			
		});//ready end

		//체크 여부에 따라 종합 정보 변화 
		$(".individual_cart_checkbox").on("change", function(){
			setTotalInfo($(".cart_info_td"));
		});
		
		/* 체크박스 전체 선택 */
		$(".all_check_input").on("click", function(){
			/* 체크박스 체크/해제 */
			if($(".all_check_input").prop("checked")){
				$(".individual_cart_checkbox").attr("checked", true);
			}else{
				$(".individual_cart_checkbox").attr("checked", false);
			}
			
			/* 총 주문 정보 세팅 (배송비, 총 가격, 마일리지, 물품 수, 종류 )*/
			setTotalInfo($(".cart_info_td"));
		});
		
		
		// 총 주문 정보 세팅 (배송비, 총 가격, 마일리지, 수량 수, 종류)
		function setTotalInfo(){
			let totalPrice = 0;
			let totalCount = 0;
			let totalKind = 0;
			let totalPoint= 0;
			let deliveryPrice = 0 ;
			let finalTotalPrice = 0;	
			
			
			$(".cart_info_td").each(function(index, element){
				
				//체크여부 
				if($(element).find(".individual_cart_checkbox").is(":checked") === true){
					// 총 가격
					totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
					// 총 갯수
					totalCount += parseInt($(element).find(".individual_bookCount_input").val());
					// 총 종류
					totalKind += 1;
					// 총 마일리지
					totalPoint += parseInt($(element).find(".individual_totalPoint_input").val());		
				}
		});
		
			
			
			/* 배송비 결정 */
			if(totalPrice >= 30000){
				deliveryPrice = 0;
			} else if(totalPrice == 0){
				deliveryPrice = 0;
			} else {
				deliveryPrice = 3000;	
			}
			
			finalTotalPrice = totalPrice + deliveryPrice;
		
		
			// 총 가격
			$(".totalPrice_span").text(totalPrice.toLocaleString());
			// 총 갯수
			$(".totalCount_span").text(totalCount);
			// 총 종류
			$(".totalKind_span").text(totalKind);
			// 총 마일리지
			$(".totalPoint_span").text(totalPoint.toLocaleString());
			// 배송비
			$(".delivery_price").text(deliveryPrice);	
			// 최종 가격(총 가격 + 배송비)
			$(".finalTotalPrice_span").text(finalTotalPrice.toLocaleString());	
		
		}
		
		
		/* 수량 버튼 */
		$(".plus_btn").on("click", function(){
			let quantity = $(this).parent("div").find("input").val();
			$(this).parent("div").find("input").val(++quantity);
		});
		
		$(".minus_btn").on("click", function(){
			let quantity = $(this).parent("div").find("input").val();
			if( quantity > 1) {
			$(this).parent("div").find("input").val(--quantity);
			}
		});
		
		/* 수량 수정 버튼 */
		$(".quantity_modify_btn").on("click", function(){
			let cartId = $(this).data("cartid");
			let bookCount = $(this).parent("td").find("input").val();
			$(".update_cartId").val(cartId);
			$(".update_bookCount").val(bookCount);
			$(".quantity_update_form").submit();
		});
		
		
		/* 삭제 요청 버튼 */
		$(".delete_btn").on("click", function(e){
			e.preventDefault();
			const cartId= $(this).data("cartid"); 
			$(".delete_cartId").val(cartId);
			$(".quantity_delete_form").submit();
			
		});
		
		/* 주문 페이지 이동 */	
		$(".btn_black").on("click", function(){
			
			let form_contents ='';
			let orderNumber = 0;
			
			$(".cart_info_td").each(function(index, element){
				
				if($(element).find(".individual_cart_checkbox").is(":checked") === true){	//체크여부
					
					let bookId = $(element).find(".individual_bookId_input").val();
					let bookCount = $(element).find(".individual_bookCount_input").val();
					
					let bookId_input = "<input name='orders[" + orderNumber + "].bookId' type='hidden' value='" + bookId + "'>";
					form_contents += bookId_input;
					
					let bookCount_input = "<input name='orders[" + orderNumber + "].bookCount' type='hidden' value='" + bookCount + "'>";
					form_contents += bookCount_input;
					
					orderNumber += 1;
					
				}
			});	

			$(".order_form").html(form_contents);
			$(".order_form").submit();
			
		});