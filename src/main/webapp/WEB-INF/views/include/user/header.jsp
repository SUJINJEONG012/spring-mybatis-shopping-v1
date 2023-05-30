<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/layout.css">


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>


	<div class="wrapper">
	



 <header class="p-3 text-bg-dark">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        
        <a href="/" lang="en" class="white">Book Shop</a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
         
         	 <c:if test="${member == null }">
							<li><a href="/member/login" class="nav-link px-2 text-white">로그인</a></li>
							<li><a href="/member/join" class="nav-link px-2 text-white">회원가입</a></li>
			 </c:if>
						
          <c:if test="${member != null}">
							<c:if test="${member.adminCk == 1}">
								<li><a href="/admin/main">관리자 페이지</a></li>
							</c:if>
							<li><a href="/member/logout" id="gnb_logout_button">로그아웃</a></li>
							<li><a href="/member/${member.memberId }"><i
									class="fa fa-user-circle" aria-hidden="true">마이페이지</i></a></li>
							<li><a href="/cart/${member.memberId}"><i
									class="fa fa-shopping-cart" aria-hidden="true"> </i>장바구니</a></li>
						</c:if>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search" id="searchForm" action="/search" method="get">
          <div class="search_input">

								<select name="type">
									<option value="T">책 제목</option>
									<option value="A">작가</option>
								</select> <input type="text" name="keyword"class="form-control form-control-dark text-bg-dark" placeholder="Search..."
									value="<c:out value="${pageMaker.cri.keyword}"/>">

								<!-- <i class="fa fa-star" aria-hidden="true">평점</i>
								<i class="fa fa-bell" aria-hidden="true">공지사항 </i>	 -->
								<button class="btn search_btn">
									<i class="fa fa-search" aria-hidden="true">검색</i>
								</button>
							</div>
		
        </form>
        
     
						

        <div class="text-end">
          <button type="button" class="btn btn-outline-light me-2">Login</button>
          <button type="button" class="btn btn-warning">Sign-up</button>
        </div>
      </div>
    </div>
  </header>
 

		
			
</body>
</html>