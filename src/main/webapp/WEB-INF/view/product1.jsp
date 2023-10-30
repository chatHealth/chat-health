<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<div class="container marketing">

	<!-- 제품 정보 헤드 -->

	<%@ include file="viewInclude/viewProduct.jsp"%>


	<hr class="featurette-divider">
	<!-- 제품정보 -->
	<div class="row featurette">
		<div class="col-md-7">
		<h2>${no }</h2>
			<h2 class="featurette-heading fw-normal lh-1">
				First featurette heading. <span class="text-body-secondary">It’ll
					blow your mind.</span>
			</h2>
			<p class="lead">Some great placeholder content for the first
				featurette here. Imagine some exciting prose here.</p>
		</div>
	</div>

	<!--                          리뷰                         -->
	<hr class="featurette-divider">
	<h1 class="reviewStart">리뷰</h1>
	<%@ include file="viewInclude/viewReview.jsp"%>

	<!--                    리뷰끝                    -->
	<hr class="featurette-divider">


	<c:choose >
	<c:when test="${loggedMember ne null }">
	<form action="../review/ReviewAdd" method="post">
		<div>
			<input class="reviewtitle" type="text" id="retitle" name="retitle"				placeholder="리뷰 제목" />
			<div class="commetbox">
				<input class="reviewtext" type="text" id="recontent"					name="recontent" placeholder="리뷰글 작성" />
				<button value="submit">리뷰등록</button>
			</div>
		</div>
	</form>
	</c:when>
	<c:otherwise>
	 <div>
			
			<div class="commetbox">
			<h2>댓글을 작성하려면 로그인하세요.</h2>
			</div>
		</div>
	</c:otherwise>
	</c:choose>
</div>



<%@ include file="../include/footer.jsp"%>




