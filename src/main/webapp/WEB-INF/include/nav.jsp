<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="main-category">
<div class="d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary nav-jsp" >

 <!-- 1. profile part -->
	<c:choose>
		<c:when test="${ not empty loggedMember }">


			<div class="d-flex justify-content-center">
				<c:choose>
					<c:when test="${ loggedMember.profile eq null }">
						<img src="../img/basic_post.svg" class="profile-small mt-3 ">
					</c:when>
					<c:otherwise>
						<img src="${ loggedMember.profile}" class="profile-small mt-3 ">
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="d-flex justify-content-evenly">
				<a href="../personal/member-info" class="btn btn-outline-primary mt-3">${loggedMember.nickName }</a>
				<a href="../member/logout" class="btn btn-outline-primary mt-3"> 로그아웃 </a>
			</div>

		</c:when>

		<c:when test="${ not empty loggedEnterprise}">
		
			<div class="d-flex justify-content-center">
				<img src="${ loggedEnterprise.profile}" class="profile-small mt-3 ">
			</div>
			
			<div class="d-flex justify-content-evenly">
				<a href="../personal/member-info" class="btn btn-outline-primary mt-3 ">${loggedEnterprise.name }</a>
				<a href="../member/logout" class="btn btn-outline-primary mt-3"> 로그아웃 </a>
			</div>

			<c:if test="${loggedEnterprise.accepted eq 0 }">
				<a href="../member/no-accept" class="btn btn-outline-primary mt-3">글쓰기</a>
			</c:if>
			<c:if test="${loggedEnterprise.accepted eq 1 }">
				<a href="../post/write" class="btn btn-outline-primary mt-3">글쓰기</a>
			</c:if>

		</c:when>
		
		<c:when test="${ not empty loggedAdmin }">

			<div class="d-flex justify-content-center">
				<img src="${loggedAdmin.profile}" class="profile-small mt-3 ">
			</div>
			<div class="d-flex justify-content-evenly">
				<a href="../personal/member-manage" class="btn btn-outline-primary mt-3">${ loggedAdmin.nickName}</a>
				<a href="../member/logout" class="btn btn-outline-primary mt-3"> 로그아웃 </a>
			</div>
			<a href="../post/write" class="btn btn-outline-primary mt-3">글쓰기</a>
		</c:when>
		

		<c:otherwise>

			<div class="d-flex justify-content-center">
				<img src="../img/basic_profile.svg" class="profile-small mt-3 ">
			</div>
			<a href="../member/login" class="btn btn-outline-primary mt-3">login</a>

		</c:otherwise>
	</c:choose>

	<hr>
    
    <!-- 2. symptom list part -->
    <ul class="nav nav-pills flex-column mb-auto">
      <li>
        <a href="../category/list?sort=${sort}" class="nav-link link-body-emphasis">
          전체
        </a>
      </li>
      
      <c:forEach items="${ navSymptomList }" var="symptom" varStatus="status">
      <li>
        <a href="../category/list?sort=${sort}&symp=${ symptom.sympNo }" class="nav-link link-body-emphasis">
          ${symptom.symptomName }
        </a>
      </li>
     </c:forEach>
      
    </ul>
 </div>   
