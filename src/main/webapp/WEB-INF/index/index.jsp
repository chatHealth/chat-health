<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


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