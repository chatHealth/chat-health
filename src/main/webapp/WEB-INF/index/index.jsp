<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<div class="container container_rang py-4">

		<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom" style="position:sticky; top:-10px; background:white; opacity:0.9">
			<div class="col-md-3 mb-2 mb-md-0">
				<a href="../index/index" class="d-inline-flex link-body-emphasis text-decoration-none">
					<img src="../img/logo.png" style="height:100px;"/>
				</a>
			</div>

				<c:choose>
				<c:when test="${ not empty loggedMember }">
				<div class="col-md-3 text-end double-btn">
					<a href="../personal/member-info" class="btn  mt-3 btn-green"> ${loggedMember.nickName } </a>
					<a href="../member/logout" class="btn  mt-3 btn-green"> 로그아웃 </a>
				</div>
				</c:when>

				<c:when test="${ not empty loggedEnterprise }">
				<div class="col-md-3 text-end double-btn">
					<a href="../personal/member-info" class="btn  mt-3 btn-green"> ${loggedEnterprise.name } </a>
					<a href="../member/logout" class="btn  mt-3 btn-green"> 로그아웃 </a>
				</div>
				</c:when>

				<c:when test="${ not empty loggedAdmin }">
				<div class="col-md-3 text-end double-btn">
					<a href="../personal/member-manage" class="btn  mt-3 btn-green"> ${loggedAdmin.nickName } </a>
					<a href="../member/logout" class="btn  mt-3 btn-green"> 로그아웃 </a>
				</div>
				</c:when>

				<c:otherwise>
				<div class="col-md-3 text-end double-btn">
					<a href="../member/join-select" class="btn  mt-3 btn-green"> 회원가입 </a>
					<a href="../member/login" class="btn  mt-3 btn-green"> 로그인 </a>
				</div>
				</c:otherwise>
				</c:choose>
    </header>



	<!-- 2. search place -->
    <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">

      	<div class="Phrases-part mx-auto text-center">
       	 	<h1 class="display-5 fw-bold use-main-color"> CHAT HEALTH </h1>
        	<p class="fs-4 use-main-color">대한민국 건강을 말하다</p>
        </div>

		<div class="container col-lg-6 col-6  text-left mt-5 d-flex justify-content-center width80">
			<form action="../category/list" method="get" class="width100">
				<div class="input-group main-search-part" style="width:100%">
					<input type="text" class="form-control " placeholder="Search for products" name="keyword" id="keyword">

					<div class="input-group-append ">
						<button class="btn  main-search-button btn-ygreen">
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
								<button type="button" class="btn  main-category-buttons-element btn-green">
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
	// 1. 빈칸검색 막기
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