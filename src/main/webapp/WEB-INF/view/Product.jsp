<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row product_row">
			<div class="box">
				<svg
					class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
					width="500" height="500" xmlns="http://www.w3.org/2000/svg"
					role="img" aria-label="Placeholder: 500x500"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="var(--bs-secondary-bg)"></rect>
					<text x="50%" y="50%" fill="var(--bs-secondary-color)" dy=".3em">500x500</text></svg>
				<img src="" alt="">
			</div>
			<!-- /.col-lg-4 -->
			<div class="box2">
				<div id="titile">제품이름</div>
				<div id="Name">회사이름</div>
				<div id="RegDate">등록날자</div>
				<div id="MaterialNo">주성분</div>
			</div>
			<!-- /.col-lg-4 -->
		</div>


		<!-- START THE FEATURETTES -->

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading fw-normal lh-1">
					First featurette heading. <span class="text-body-secondary">It’ll
						blow your mind.</span>
				</h2>
				<p class="lead">Some great placeholder content for the first
					featurette here. Imagine some exciting prose here.</p>
			</div>
		</div>

		<hr class="featurette-divider">
		<div class="wrap_tabcont">
			<!---->
			
			<!--                          리뷰                         -->
			
			<div class="sec_tabcont is_show ng-star-inserted"
				data-tiara-layer="review">
				<fu-view-product-review-tab>
				<fu-view-product-review-summary class="ng-star-inserted">
				<h4 class="screen_out">리뷰</h4>
				<div class="wrap_totalscore ng-star-inserted">
					<div class="head_group has_ect ng-star-inserted">
					</div>
				</div>
				<!----><!----><!----><!----><!----><!----><!----><!----><!----><!----></fu-view-product-review-summary>
				<div class="wrap_reviewcard ng-star-inserted">
					<div class="head_group has_ect ng-star-inserted">
						<h4 class="tit_group">리뷰 제목</h4>
					</div>
					<!---->
					<div class="list_review">
						<cu-infinite-scroll>
						<div infinitescroll="" class="ng-star-inserted">
							<div class="cmptype_col2 ng-star-inserted">
								<ul class="list-loader">
									<li class="item-container box_review ng-star-inserted"><fu-view-review><!---->
										<div class="wrap_writerinfo ng-star-inserted">
											<div class="area_photo">

												<!---->
											</div>
											<div class="info_write">
												<div class="review _data">
													<div class="" id="nickName">작성자</div>
													<div class="" id="RegDate">작성일</div>
													
												</div>		
												<div class="good_btn">	
													<button cutiara="" data-tiara-action-name="리뷰 도움돼요 버튼 클릭"
													data-tiara-layer="btn_review_helpful"
													class="btn_comm btn_like">
													<span class="img_shop"></span>도움돼요
													<!---->
													</button>
												</div>
												</ul>
											</div>
										</div>
										<!---->
										<div data-tiara-layer="list" class="wrap_detail">
											<!---->
											<div class="area_reviewdetail">
												<div class="inner_reviedetail">
													<!---->
													<p class="txt_review">
														잘이용할께요~<br>덕구온천 가끔 가는데<br>너무 좋아요~^^
													</p>
												</div>
											</div>
											<button class="btn_more ng-star-inserted">
												<span class="img_shop ico_arr"></span>더보기
											</button>
											<!---->
											<div cutiara="" data-tiara-action-name="리뷰 공유 버튼 클릭"
												data-tiara-layer="btn_review_share"
												class="wrap_etcbtn ng-star-inserted">
											
											</div>
											<!---->
											<!---->
											<!---->
											<!---->
										</div>
										</fu-view-review></li>
									<!---->
								</ul>
							</div>
							<!---->
							<div style="visibility: hidden;"></div>
						</div>
						<!----><!----></cu-infinite-scroll>
						<!---->
					</div>
					<!---->
				</div>
				<!----><!----><!----></fu-view-product-review-tab>
			</div>
			
			<!--                    리뷰끝                    -->
		<form action="reviewAdd" method="post">
			<hr class="featurette-divider">
				<div class="commet_box">
				 <input class="comment_text" type="text"  id="content" placeholder="리뷰글 작성"/>
				 <button value="submit">리뷰등록</button>
			</div>
		</form>

<!--  -->
		<!-- /END THE FEATURETTES -->

	</div>



<%@ include file="../include/footer.jsp"%>






