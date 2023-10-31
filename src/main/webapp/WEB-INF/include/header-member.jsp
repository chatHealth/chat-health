<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<header class="pb-3 mb-4 border-bottom">
      <div class="row align-items-center py-3 px-xl-5 ">
		<div class="d-flex ">
	
		<!--  1. logo -->
		<a href="../index/index" class="text-decoration-none mt-3">
			<h1 class="m-0 display-5 font-weight-bold main-logo-chat-health col-3">chat-health</h1>
		</a>
		
		
		
		<!-- 2. info -->
			<div class="category-info container">
				<c:choose>
					<c:when test="${not empty info }">
					
						<div class="container row align-items-center py-3 px-xl-5">
							<p class="m-0 col-3">${info }</p>
						</div>
					
					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>
			</div>

	
	
	</div> </div>
    </header>