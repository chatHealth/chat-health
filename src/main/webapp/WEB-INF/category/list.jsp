<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header-main.jsp"%>
<%@ include file="../include/nav.jsp"%>


<div class="">

	<!-- 1. show material -->
	<div></div>




	<!-- 2. no content -->
	<c:choose>
		<c:when test="${ empty postList }">
			<div class="no-category-content">
				<h2>게시글이 없습니다</h2>
			</div>
		</c:when>
		<c:otherwise>


			<!-- 3. show postList -->
			<div class="sort-select">
			<form action="../category/list" method="get" name="sort-select" id="sort-select">
				<select class="form-select" aria-label="Default select example" name="sort" id="sort">
					<option value="recent" ${param.sort=='recent'?'selected':null }>최신순</option> 
					<option value="recommended" ${param.sort=='recommended'?'selected':null }>추천순</option>
					<option value="reviewed" ${param.sort=='reviewed'?'selected':null }>리뷰순</option>
				</select>
			</form>
			</div>
			
			<script >
			$("#sort").on('change', function(){
				console.log($(this).val());
			 $("#sort-select").submit();
			});
			
			</script>

			<div class="container album py-5 bg-light">
				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
					<c:forEach items="${ postList }" var="post" varStatus="status">

						<div class="col">
							<div class="card shadow-sm">
								<a href="../view/product?no=${post.postNo }"> 
								<svg class="bd-placeholder-img card-img-top" width="100%"
										height="225" xmlns="http://www.w3.org/2000/svg" role="img"
										aria-label="Placeholder: Thumbnail"
										preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title>
						<rect width="100%" height="100%" fill="#55595c"></rect>
						<image href="${ post.postImg }" height="100%" width="100%" />
						<text x="50%" y="50%" fill="#eceeef" dy=".3em"> </text>
					</svg>
								</a>

								<div class="card-body">
									<a href="../view/product?no=${post.postNo }"><p
											class="card-text category-title">${ post.title }</p> </a>
									<div class="d-flex justify-content-between align-items-center">
										<div class="btn-group">
											<button type="button"
												class="btn btn-sm btn-outline-secondary">수정</button>
											<button type="button"
												class="btn btn-sm btn-outline-secondary">삭제</button>
										</div>
										<small class="text-muted"> 회사명 </small>
									</div>
								</div>
							</div>
						</div>


					</c:forEach>
		</c:otherwise>
	</c:choose>


</div>
</div>
	
	
	
	
	<!-- 4. review -->


</div>



<%@ include file="../include/footer.jsp"%>