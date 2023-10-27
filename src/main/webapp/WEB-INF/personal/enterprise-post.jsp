<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/27/23
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../include/member-side.jsp"%>

<table class="table">
	<h2>내 상품 관리</h2>
	<thead>
	<tr>
		<th scope="col">#</th>
		<th scope="col">제목</th>
		<th scope="col">등록 일자</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${posts }" var="post" varStatus="loop">
	<tr>
		<th scope="row">${post.rowNum }</th>
		<td class="entP"><a href="#">${post.title }</a></td>
		<td>${post.regDate }</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<%--<nav aria-label="Page navigation example" >--%>
<%--	<ul class="pagination">--%>
<%--		<li class="page-item">--%>
<%--			<a class="page-link" href="#" aria-label="Previous">--%>
<%--				<span aria-hidden="true">&laquo;</span>--%>
<%--			</a>--%>
<%--		</li>--%>
<%--		<li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--		<li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--		<li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--		<li class="page-item">--%>
<%--			<a class="page-link" href="#" aria-label="Next">--%>
<%--				<span aria-hidden="true">&raquo;</span>--%>
<%--			</a>--%>
<%--		</li>--%>
<%--	</ul>--%>
<%--</nav>--%>
</div>
<%@ include file="../include/footer.jsp"%>