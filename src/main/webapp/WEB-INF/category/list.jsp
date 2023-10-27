<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header-main.jsp"%>
<%@ include file="../include/nav.jsp"%>


<div class="">

	<!-- 1. show material -->
	<div>
	
	</div>
	
	
	<div class="container album py-5 bg-light">
		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
			
			<!-- 2. no content -->
			<c:choose>
				<c:when test="${ empty postList }">
					<div class="no-category-content"> <h2> 게시글이 없습니다</h2></div>
				</c:when>	
			<c:otherwise>
				
	
			<!-- 3. show postList -->
			<c:forEach items="${ postList }" var="post" varStatus="status">

				<div class="col">
					<div class="card shadow-sm">
						<a href="../view/product?no=${post.postNo }"> <svg class="bd-placeholder-img card-img-top"
								width="100%" height="225" xmlns="http://www.w3.org/2000/svg"
								role="img" aria-label="Placeholder: Thumbnail"
								preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title>
						<rect width="100%" height="100%" fill="#55595c"></rect>
						<image href="${ post.postImg }" height="100%" width="100%" />
						<text x="50%" y="50%" fill="#eceeef" dy=".3em"> </text>
					</svg>
						</a>

						<div class="card-body">
							<a href="../view/product?no=${post.postNo }"><p class="card-text category-title">${ post.title } </p> </a>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-outline-secondary">수정</button>
									<button type="button" class="btn btn-sm btn-outline-secondary">삭제</button>
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
</div>



<%@ include file="../include/footer.jsp"%>