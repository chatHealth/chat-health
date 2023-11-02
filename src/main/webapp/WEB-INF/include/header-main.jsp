<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<header class="pb-3 mb-4 border-bottom header-main-jsp">
      <div class="row align-items-center py-3 px-xl-5 ">
		<div class="d-flex ">
	
		<!--  1. logo -->
		<a href="../index/index" class="text-decoration-none mt-3">
			<h1 class="m-0 display-5 font-weight-bold main-logo-chat-health col-2">chat-health</h1>
		</a>
		
		
		
		<!-- 2. info -->
			<div class="category-info container mt-2">
				<c:choose>
					<c:when test="${not empty info }">
					
						<div class="container align-items-center py-3 px-xl-5 info-div">
							<span class="badge rounded-pill fill-main-color">${info }</span>
						</div>
					
					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>
			</div>



			<!-- 3. serch place -->
		<div class=" button-box text-right d-flex justify-content-end container-fluid mr-5 mt-2">
			<div class="text-left mt-3">
			<form action="../category/list" method="get">
				<div class="input-group main-header-search-part ">
					<input type="text" class="search_input " placeholder="Search for products" name="keyword" id="keyword">
			
					<div class="input-group-append ">
					
						<button class="btn main-header-search-button mt-1">  	
							<svg  width="25" height="25" fill="#347F5C" class="bi bi-search" viewBox="0 0 16 16">

  								<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
							</svg>
              			</button>
					</div>
				</div>
			</form>
		</div>
		</div>
	

	</div> </div>
    </header>
    
    
  <script>
	// 1. 빈칸검색 막기
		$(".main-header-search-button").on("click", function(e) {
			if ($("#keyword").val().trim() === "") {
				alert("검색어를입력하세요");
				$("#keyword").val("");
				$("#keyword").focus();
				return false;
			}
		});
</script>