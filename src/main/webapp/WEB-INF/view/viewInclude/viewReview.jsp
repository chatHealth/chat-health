<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:forEach items="${reviewList}" var="review">
	<div class="reviewbox">
		<h4 class="reviewtitle">제목 : ${review.TITLE }</h4>
		<div class="list_review">
			<div infinitescroll="" class="ng-star-inserted">
				<div class="cmptype_col2 ng-star-inserted">
					<div class="reviewdata">
						<div class="reviewUserInfo">
							<div class="reviewUser" id="nickName">닉네임 :
								${review.NICKNAME }</div>
							<div class="reviewUser" id="RegDate">${review.REGDATE }</div>
						</div>

						<form action="../review/HelpfulController" method="post">
							<input type="hidden" name="productNo" value="${postInfo.POSTNO}" />
							<input type="hidden" name="reviewNo" value="${review.REVIEWNO}" />
							<div class="btnGood">
								<button class="btnGdfdsf" type="submit">
									<img src="../img/좋아요.png" alt=""> ${review.HELPFULCNT }
								</button>
							</div>
						</form>

					</div>
				</div>
				<!---->
				<div class="reviewContentbox">
					<div class="reviewContent">
						<p class="txt_review">${review.CONTENT }</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr class="featurette-divider">
</c:forEach>
			</div>
		</div>
	</div>
	<hr class="featurette-divider">
</c:forEach>