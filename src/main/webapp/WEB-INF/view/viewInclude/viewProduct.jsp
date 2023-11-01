<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div class="productbox">
			<div class="box">
				<div class="imgbox">
					<img src="${postInfo.POSTIMG }" alt="" class="imgtest">
				</div>
			</div>
			<div class="box2">

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
					<button class="productLike" type="sumbit">제품좋아요</button>
				</div>
				</form>
			</div>
		</div>
