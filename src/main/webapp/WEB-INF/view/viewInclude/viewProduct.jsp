<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

				<h2>${postInfo.TITLE }</h2>
				<div id="Name">${postInfo.NAME }</div>
				<div id="RegDate">${postInfo.REGDATE }</div>
				<div id="MaterialNo">
					 주성분 : 
				<c:forEach items="${ postMeterial}" var="material">
					[ ${material.MATERIALNAME } ]
				</c:forEach>
				</div>
				
				<form action="../view/viewlike" method="post">
				<input type="hidden" name="viewLikeNo" value="${postInfo.POSTNO}" />
				<div class="likeProduct">
					<button class="productLike" type="sumbit">
						<c:choose>
							<c:when test="${viewLike ne 0}">
								<img src="../img/빨간하트png.png" alt="" class="viewHt">
							</c:when>
							<c:otherwise>
								<img src="../img/빈하트.png" alt="" class="viewHt">
							</c:otherwise>
						</c:choose>
						<div class="viewLikeNun">${postInfo.USERLIKECNT}</div>
					</button>
				</div>
				</form>
			</div>
		</div>

		<form action="../view/viewlike" method="post">
			<input type="hidden" name="viewLikeNo" value="${postInfo.POSTNO}" />
			<div class="likeProduct">
				<button class="productLike" type="sumbit">
					<c:choose>
						<c:when test="${viewLike ne 0}">
							<img src="../img/빨간하트png.png" alt="" class="viewHt">
						</c:when>
						<c:otherwise>
							<img src="../img/빈하트.png" alt="" class="viewHt">
						</c:otherwise>
					</c:choose>
					<div class="viewLikeNun">${postInfo.USERLIKECNT}</div>
				</button>
			</div>
		</form>

	</div>
</div>