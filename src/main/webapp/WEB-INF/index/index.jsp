<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<div class="container container_rang py-4">

	<!-- 1. main header) logo/ button-box -->
    <header class="pb-3 mb-4 border-bottom">
      <div class="row align-items-center py-3 px-xl-5 ">
		<div class="d-flex ">
	
		<a href="../index/index" class="text-decoration-none">
			<h1 class="m-0 display-5 font-weight-bold main-logo-chat-health col-3">chat-health</h1>
		</a>
		
		<div class=" button-box text-right d-flex justify-content-end container-fluid ">
		<div class="">
		<c:choose>
			<c:when test="${ not empty loggedMember }">
					<a href="../personal/member-info" class="btn btn-outline-primary mt-3"> ${loggedMember.nickName } </a> 
					<a href="../member/logout" class="btn btn-outline-primary mt-3"> 로그아웃 </a>
			</c:when>

			<c:when test="${ not empty loggedEnterprise }">
					<a href="../personal/enterprise-info" class="btn btn-outline-primary mt-3"> ${loggedEnterprise.name } </a> 
					<a href="../member/logout" class="btn btn-outline-primary mt-3"> 로그아웃 </a>
			</c:when>
			
			<c:when test="${ not empty loggedAdmin }">
					<a href="../personal/member-manage" class="btn btn-outline-primary mt-3"> ${loggedAdmin.nickName } </a> 
					<a href="../member/logout" class="btn btn-outline-primary mt-3"> 로그아웃 </a>
			</c:when>
			
			<c:otherwise>
					<a href="../member/member-join" class="btn btn-outline-primary mt-3"> 회원가입 </a> 
					<a href="../member/login" class="btn btn-outline-primary mt-3"> 로그인 </a>
			</c:otherwise>
		</c:choose>
	</div>
	
	</div></div> </div>
    </header>



	<!-- 2. search place -->	
    <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
      
      	<div class="Phrases-part mx-auto text-center">
       	 	<h1 class="display-5 fw-bold"> 안내내용 </h1>
        	<p class="fs-4">홍보문구 주절주절</p>
        </div>
        
		<div class="container col-lg-6 col-6  text-left mt-5">
			<form action="../category/list" method="get">
				<div class="input-group main-search-part ">
					<input type="text" class="form-control " placeholder="Search for products" name="keyword" id="keyword">
			
					<div class="input-group-append ">
						<button class="btn btn-primary main-search-button ">  	
            		    	search
							<svg  width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  								<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
							</svg>
              			</button>
					</div>
				</div>
			</form>
		</div>
        
      </div>
    </div>


	
	
	<!-- 3. category button -->
	<div class="row align-items-md-stretch">
		<div class="h-100 p-5 bg-body-tertiary border rounded-3">


			<div class="container main-category-buttons">
				<div class="row ">
				
					<c:forEach items="${ symptomList }" var="symptom"
						varStatus="status">

						<div class="col-md-3 ">
							<a href="../category/list?symp=${ symptom.sympNo }"
								class="nav-link link-body-emphasis">
								<button type="button" class="btn btn-outline-primary main-category-buttons-element">
									${symptom.symptomName }</button>
							</a>
						</div>

					</c:forEach>
					
				</div>
			</div>

		</div>
	</div>





	<!-- footer -->
    <footer class="pt-3 mt-4 text-body-secondary border-top">
    </footer>



	<script>
		$(".main-search-button").on("click", function(e) {
			if ($("#keyword").val().trim() === "") {
				alert("검색어를입력하세요");
				$("#keyword").val("");
				$("#keyword").focus();
				return false;
			}
		});
	</script>
	
	
    
  <%@ include file="../include/footer.jsp"%>