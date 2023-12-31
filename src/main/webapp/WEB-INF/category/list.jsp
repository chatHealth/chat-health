<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header-main.jsp"%>
<%@ include file="../include/nav.jsp"%>


<div class="container">

	<!-- 1. show material -->

	<c:if test="${ materialList ne null}">
			<div class="show-material">
				<div class="row align-items-md-stretch">
					<div class="h-100 p-5 bg-body-tertiary border rounded-3">


						<div class="container main-category-buttons">
							<div class="row ">

								<c:forEach items="${ materialList }" var="material" varStatus="status">

									<div class="col-md-3 ">
										<a href="../category/list?sort=${sort }&symp=${sympNo }&material=${ material.materialNo }" class="nav-link link-body-emphasis">
											${material.materialName } 
										</a>
									</div>

								</c:forEach>

							</div>
						</div>

					</div>
				</div>
			</div>
</c:if>



			<!-- 2. no content -->
			<c:choose>
				<c:when test="${ empty postList }">
					<div class="no-category-content d-flex align-items-center justify-content-center">
						<h2 class="use-main-color">게시글이 없습니다</h2>
					</div>
				</c:when>
				<c:otherwise>



			<!-- 3. show postList -->
			<div class="sort-select d-flex justify-content-start">
				<form action="../category/list?" method="get" name="sort-select"
					id="sort-select">
				<form action="../category/list" method="get" name="sort-select" id="sort-select">
					<input type="hidden" name="symp" value="${sympNo}">
      				<input type="hidden" name="material" value="${materialNo}">
      				<input type="hidden" name="keyword" value="${keyword}">
      				
					<select class="form-select" aria-label="Default select example" name="sort" id="sort" style="width: 150px;">
						<option value="recent" ${sort=='recent'?'selected':null }>최신순</option>
						<option value="old" ${sort=='old'?'selected':null }>오래된순</option>
					</select>
				</form>
			</div>
			<script>
			// select 변하면, symp,material hidden으로 값보내기 (쿼리스트링X)
				$("#sort").on('change', function() {
					$("#sort-select").submit();
				});
			</script>


			<div class="container album py-5 bg-light">
						<div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
							<c:forEach items="${ postList }" var="post" varStatus="status">

								<div class="col">
									<div class="card shadow-sm">
										<a href="../view/product?no=${post.postNo }"> 
										<svg
												class="bd-placeholder-img card-img-top" width="100%"
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
											<div class="card-body-title">
											<a href="../view/product?no=${post.postNo }">
												<p class="card-text category-title">${ post.title }</p> 
											</a>
											</div>
										
											<div class="d-flex  salign-items-center  mh-50">
											<c:if test="${loggedAdmin ne null || loggedEnterprise.enterpriseNo == post.enterpriseNo}">
												<div class="btn-group">
													<a href="../post/modify?no=${post.postNo }" class="btn btn-outline-secondary " id="btn-modify" >수정</a>
													<a href="../post/delete?no=${post.postNo }" class="btn btn-outline-secondary " id="btn-delete">삭제</a>
												</div>
											</c:if>
											
												<small class="text-muted ">${post.name }</small>

											</div>
									
										</div>
									</div>
								</div>


							</c:forEach>
				</c:otherwise>
			</c:choose>
</div>
</div>
	
	
	
	
	<!-- 4. pagenation -->
	<form action="../category/list" method="get" class="convey-form">
		<input type="hidden" name="symp" value="${sympNo}">
		<input type="hidden" name="material" value="${materialNo}">
		<input type="hidden" name="keyword" value="${keyword}">
 		<input type="hidden" name="idx" value=""> 
 		
 		<div id="pageTotal" data-total="${pageTotal}"></div>
 		<div id="idx" data-total="${idx}"></div>
    			
	<c:choose>
		<c:when test="${ ps=='all' }">
			<div class="d-flex align-items-center justify-content-center">
			<input type="hidden" name="ps" value="all">

				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item">
						<a class="page-link convey-btn page-previous-btn" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a>
						</li>
						
						<c:forEach var="page" begin="1" end="${pageTotal}">
							<li class="page-item">
								<a class="page-link convey-btn" data-page="${page}"> ${page} </a>
							</li>
						</c:forEach>
						
						<li class="page-item">
						<a class="page-link convey-btn page-next-btn" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a>
						</li>
					</ul>
				</nav>

			</div>
		</c:when>

		<c:when test="${ postTotal > 8 }"> 
		<div class="d-flex align-items-center justify-content-center">
			<a class="btn btn-outline-secondary mt-3 convey-btn" >
				모든글보기
				<input type="hidden" name="ps" value="all">
			</a>
		</div> 	
	</c:when>
	</c:choose>

	</form>

	</div>


<%@ include file="../include/footer.jsp"%>


<script>

//1. 수정 -> 모달 인정버튼 -> modify 페이지로
$("#modalAccept").on("click", function() {
	if($("#modal-title").text().trim()==="게시물 수정"){
	location.href="../post/modify";
	}
});



// 2. symp, material 숨겨서 보내기
// 3. pagination 다음버튼 보내기
$(".convey-btn").on('click', function() {
    const this_btn = $(this);
    const pageTotal = $("#pageTotal").data("total");
    const currentPage = $("#idx").data("total");
   
    if (this_btn.hasClass('page-previous-btn')) {   // 이전 버튼을 클릭한 경우
    	if (currentPage > 1) {
            $("input[name='idx']").val(currentPage - 1);
            $(".convey-form").submit();
        }
    } else if (this_btn.hasClass('page-next-btn')) {  // 다음 버튼을 클릭한 경우
        if (currentPage < pageTotal) {
            $("input[name='idx']").val(currentPage + 1);
            $(".convey-form").submit();
        }

	} else if (this_btn.hasClass('page-link')) { // 일반 페이지 버튼을 클릭한 경우
			const page = $(this).data("page");
			if (page != currentPage) {
				$("input[name='idx']").val(page);
				$(".convey-form").submit();
			}
		} else {
			$(".convey-form").submit();
		}

		return false;
	});
</script>
