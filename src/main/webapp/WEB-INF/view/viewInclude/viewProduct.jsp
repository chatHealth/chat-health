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
				<c:forEach items="${ postMeterial}" var="material">
				<div id="MaterialNo"> 주성분 : ${material.MATERIALNAME }</div>
				</c:forEach>
			</div>
		</div>
	
</body>
</html>