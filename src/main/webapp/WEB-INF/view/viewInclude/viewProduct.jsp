<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<c:forEach items="${postInfo}" var="post">
	<div class="productbox">
			<div class="box">
				<div class="imgbox">
					<img src="productEx.jpg" alt="" class="imgtest">
				</div>
			</div>
			<div class="box2">
				<h2>${post.TITLE }</h2>
				<div id="Name">${post.NAME }</div>
				<div id="RegDate">${post.REGDATE }</div>
				<div id="MaterialNo"></div>
			</div>
		</div>
	</c:forEach>
	
</body>
</html>