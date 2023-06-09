<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">


<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdn.tailwindcss.com"></script>

<style type="text/tailwindcss">
    @layer utilities {
      .content-auto {
        content-visibility: auto;
      }
    }
  </style>

</head>
<body>


<div class="wrapper">

 <header>
   
    <div class="inner">   
      
      <div class="top_sidemenu">  
   
        <ul class="">         
         	 <c:if test="${member == null}">
							<li><a href="/member/login" class="nav-link px-2 text-white">로그인</a></li>
							<li><a href="/member/join" class="nav-link px-2 text-white">회원가입</a></li>
			 </c:if>
						
              <c:if test="${member != null}">
				<c:if test="${member.adminCk == 1}">
					<li><a href="/admin/main">관리자 페이지</a></li>
				</c:if>
					<li><a href="/member/logout" id="gnb_logout_button">로그아웃</a></li>
					<li><a href="/member/${member.memberId}"><i class="fa fa-user-circle" aria-hidden="true">마이페이지</i></a></li>
					<li><a href="/cart/${member.memberId}"><i class="fa fa-shopping-cart" aria-hidden="true"> </i>장바구니</a></li>
				</c:if>
        </ul>
        
      </div>
        

       <div class="top_menu">
        <h1 class="logo">
        <a href="/" lang="en" class="white">BOOK SHOPPING</a></h1>
        
        
        <div class="search_wrap">
        <form id="searchForm" action="/search" method="get">
         
				<select name="type">
					<option value="T">책 제목</option>
					<option value="A">작가</option>
				</select>
								
				<input type="text" name="keyword" class="input" placeholder="검색어를 입력하세요."
					value="<c:out value="${pageMaker.cri.keyword}"/>">
			
					<button class="btn search_btn">
						<i class="fa fa-search" aria-hidden="true"></i>
					</button> 						
		
        		</form>
        	</div>
         
        </div>

      
    </div>
  </header>
 

		
			
</body>
</html>