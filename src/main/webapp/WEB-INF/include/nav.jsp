<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="main-category">
<div class="d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary" style="width: 280px;">

	<c:choose>
		<c:when test="${ not empty loggedMember }">


			<div class="d-flex justify-content-center">
				<c:choose>
					<c:when test="${ loggedMember.profile eq null }">
						<img src="${pageContext.request.contextPath}/img/basic_post.svg" class="profile-small mt-3 ">
					</c:when>
					<c:otherwise>
						<img src="${ loggedMember.profile}" class="profile-small mt-3 ">
					</c:otherwise>
				</c:choose>
			</div>
			
			<a href="../personal/member-info" class="btn btn-outline-primary mt-3"> ${ loggedMember.nickName} </a>

		</c:when>

		<c:when test="${ not empty loggedEnterprise}">
		
			<div class="d-flex justify-content-center">
				<img src="${ loggedEnterprise.profile}" class="profile-small mt-3 ">
			</div>
			<a href="../personal/enterprise-info" class="btn btn-outline-primary mt-3">${loggedEnterprise.name }</a>
		
		
			<c:if test="${loggedEnterprise.accepted eq 0 }">
				<a href="../member/no-accept" class="btn btn-outline-primary mt-3">글쓰기</a>
			</c:if>
			<c:if test="${loggedEnterprise.accepted eq 1 }">
				<a href="../post/write" class="btn btn-outline-primary mt-3">글쓰기</a>
			</c:if>

		</c:when>
		
		<c:when test="${ not empty loggedAdmin }">

			<div class="d-flex justify-content-center">
				<img src=${loggedAdmin.profile}" class="profile-small mt-3 ">
			</div>
			<a href="../personal/member-manage" class="btn btn-outline-primary mt-3">${ loggedAdmin.nickName}</a>
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
    
    
    <ul class="nav nav-pills flex-column mb-auto">
      
      <c:forEach items="${ navSymptomList }" var="symptom" varStatus="status">
      <li>
        <a href="#sympNo" class="nav-link link-body-emphasis">
          ${symptom.symptomName }
        </a>
      </li>
     </c:forEach>
      
    </ul>
 </div>   
 </div>
  