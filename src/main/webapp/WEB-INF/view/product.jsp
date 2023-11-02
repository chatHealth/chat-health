<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header-main.jsp"%>
<%@ include file="../include/nav.jsp"%>

<div class="viewBody">
<div class="container marketing">

	<!-- 제품 정보 헤드 -->

	<%@ include file="viewInclude/viewProduct.jsp"%>


	<hr class="featurette-divider">
	<!-- 제품정보 -->
	<div class="row featurette">
		<div class="col-md-7">
			${postInfo.CONTENT}
		</div>
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
			<input type="hidden" name="no" value="${param.no}" />
			<input class="reviewtitle" type="text" id="retitle" name="retitle"	placeholder="리뷰 제목" />
			<div class="commetbox">
				<input class="reviewtext" type="text" id="recontent"	name="recontent" placeholder="리뷰글 작성" />
				<button value="submit">리뷰등록</button>
			</div>
		</div>
	</form>
	</c:when>
	<c:otherwise>
	 <div>
			
			<div class="commetbox">
			<h2>댓글을 작성하려면 로그인하세요.
				<form action="../member/login" method="post">
				<button valuew="submit">로그인</button>
				</form>
			</h2>
			</div>
		</div>
	</c:otherwise>
	</c:choose>
</div>



<%@ include file="../include/footer.jsp"%>


<script>
// 1. delete modal 처리(rang 건들지 마시오)

$("#modalAccept").on("click", function() {
<<<<<<< HEAD

=======
	if($("#modal-title").text().trim()==="게시물 삭제"){
>>>>>>> 0c6a726c6a46f3440b70b0f0c79f072ce182831a
	$.ajax({
		type : "POST", 
		data : {postNo : ${postInfo.POSTNO} },
		url : "../post/delete-process",
		
		success : function(data) {
			if (data.isAccepted === "ok") {

				location.href="../category/list";
			}
		},
		error : function(error) {

			history.back();
		}
	});
<<<<<<< HEAD
=======
	}
>>>>>>> 0c6a726c6a46f3440b70b0f0c79f072ce182831a
});



</script>




