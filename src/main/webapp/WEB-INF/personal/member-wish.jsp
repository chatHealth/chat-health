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
<c:if test="${not empty userLikes}">
			<div class="row min-h300 wishes">
				<c:forEach items="${userLikes }" var="image" varStatus="loop">
				<div class="col-md-3">
					<div class="card">
						<div class="item"><a href="../view/product?no=${image.postNo }">
						<img src="${image.postImg }" alt="" class="card-img-top img150">
						</a></div>
						<div class="card-body entP">
							<a href="../view/product?no=${image.postNo }">
								<p class="card-text" style="height:50px;">${image.title }</p></a>
								<div>
							<button onclick="btnLike(${image.postNo})" style="border:none; background: none;
							"><img src="../img/heart.png" class="img20" id="heart${image.postNo}"/></button>
							</div>
						</div>
					</div>

				</div>
					<%-- 매 4번째 이미지마다 새로운 행 시작 --%>
				<c:if test="${loop.index % 4 == 3}">
				</div>
				<div class="row min-h300 wishes">
				</c:if>
				</c:forEach>
			</div>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${start ne 1}">
				<li class="page-item">
					<a class="page-link btn-green" href="../personal/member-wish?idx=${page}&group=${group}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>
			<c:forEach var="page" begin="${start}" end="${end}">
				<c:choose>
					<c:when test="${idx eq page}">
						<li class="page-item"><a class="page-link btn-ygreen" href=".../personal/member-wish?idx=${page}&group=${group}">${page}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link btn-green" href="../personal/member-wish?idx=${page}&group=${group}">${page}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${group ne totalGroup}">
				<li class="page-item">
					<a class="page-link btn-green" href="../personal/member-wish?idx=${idx*5 -4}&group=${group + 1}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
		</ul>
	</nav>
</c:if>
		</div>
	</div>
</div>

<script>
function btnLike(s) {
	$.ajax({
		type: "GET", // 또는 "GET" 등 요청 메서드 선택
		url: "../personal/delete-wish", // AJAX 요청을 처리할 서버 측 엔드포인트 URL
		data: { postNo: s,
				userNo: ${userNo}}, // 요청 데이터 (요소의 값을 전달)
		success: function(data) {
			if(data.count>0){
			if (data.states === 0) {
				document.getElementById("heart"+s).src = "../img/empty-heart.png";
			} else {
				document.getElementById("heart"+s).src = "../img/heart.png";
			}}
		},
		error: function (xhr, status, error) {
			// 오류
			// 처리
			console.error("Error: " + error);
		}
		});
}
</script>
<%@ include file="../include/footer.jsp" %>