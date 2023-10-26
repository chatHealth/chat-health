<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	
<div class="d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary" style="width: 280px;">
    
    
    			<c:choose>
				<c:when test="${ empty loggedID }">
				
					<div class="d-flex justify-content-center">
					<img src="../img/basic_profile.svg" class="profile-small mt-3 ">
					</div>
					<a href="../member/login" class="btn btn-outline-primary mt-3" > login</a>
					
				</c:when>
				<c:otherwise>
					
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
  
  
  <%@ include file="../include/footer.jsp"%>