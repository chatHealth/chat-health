<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/23/23
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../include/member-side.jsp" %>

		<!-- Content -->
		<div class="col-9 content">
			<h2>좋아요</h2>
			<div class="row">
				<c:forEach items="${userLikes }" var="image" varStatus="loop">
				<div class="col-md-3">
					<a href="#"><div class="card">
						<img src="/upload/${image.postImg }" alt="" class="card-img-top">
						<div class="card-body">
							<p class="card-text">${image.title }</p>
						</div>
					</div>
					</a>
				</div>
					<%-- 매 4번째 이미지마다 새로운 행 시작 --%>
				<c:if test="${loop.index % 4 == 3}">
			</div>
			<div class="row">
				</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>