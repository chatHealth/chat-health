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
			<h2>My Wish</h2>
			<c:if test="${empty userLikes }">
			<p class="fs-5 col-md-8">아직 담은 상품이 없어요</p>
			<div class="mb-5">
				<a href="../category/list" class="btn btn-primary btn-lg px-4">둘러보러 가기</a>
			</div>
			</c:if>
			<div class="row">
				<c:forEach items="${userLikes }" var="image" varStatus="loop">
				<div class="col-md-3">
					<a href="../view/product?no=${image.POSTNO }"><div class="card">
						<img src="/upload/${image.POSTIMG }" alt="" class="card-img-top">
						<div class="card-body">
							<p class="card-text">${image.TITLE }</p>
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
<nav aria-label="Page navigation example">
	<ul class="pagination">
		<li class="page-item">
			<a class="page-link" href="#" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>
		<c:forEach var="page" begin="1" end="${pages }">
			<li class="page-item"><a class="page-link" href="../personal/member-review?idx=${page}">${page}</a></li>
		</c:forEach>
		<li class="page-item">
			<a class="page-link" href="#" aria-label="Next">
				<span aria-hidden="true">&raquo;</span>
			</a>
		</li>
	</ul>
</nav>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>