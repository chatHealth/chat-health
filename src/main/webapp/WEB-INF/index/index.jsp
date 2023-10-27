<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<!-- 1. main header) logo/ button-box -->
<div class="row align-items-center py-3 px-xl-5 ">
	<div class="d-flex ">
	
		<a href="../index/index" class="text-decoration-none">
			<h1 class="m-0 display-5 font-weight-bold main-logo-chat-health col-3">chaht-health</h1>
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
	
	</div></div>
</div>


<!-- 2. search place -->
<div class="container col-lg-6 col-6  text-left mt-5">
	<form action="../category/list">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="Search for products">
			
			<div class="input-group-append">
				<button type="button" class="btn btn-primary">  	
                	search
					<svg  width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  						<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
					</svg>
              </button>
			</div>
		</div>
	</form>
</div>



<!-- 3. category button -->
    <ul class="">
      
      <c:forEach items="${ symptomList }" var="symptom" varStatus="status">
      <li>
        <a href="#sympNo" class="nav-link link-body-emphasis">
          ${symptom.symptomName }
        </a>
      </li>
     </c:forEach>
      
    </ul>
    
    
<%@ include file="../include/footer.jsp"%>