<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/27/23
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../include/member-side.jsp"%>

<table class="table">
	<h2>my review</h2>
	<thead>
	<tr>
		<th scope="col">#</th>
		<th scope="col" colspan="2" style="text-align: center">상품</th>
		<th scope="col">리뷰</th>
		<th scope="col">등록일</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${reviews }" var="review" varStatus="loop">
		<tr>
			<th scope="row">${review.ROWNUM }</th>
			<c:choose>
				<c:when test="${review.POSTDELEDDATE eq null}">
					<td class="entP"><a href="../view/product?no=${review.POSTNO}"><img src="/upload/${review.POSTIMG}" style="height:100px"  alt="postImg"/></a></td>
					<td class="entP"><a href="../view/product?no=${review.POSTNO}">${review.POSTTITLE}</a></td>
				</c:when>
				<c:otherwise>
					<td class="entP">삭제된 상품입니다.</td>
				</c:otherwise>
			</c:choose>
			<td class="entP"><a href="#">${review.TITLE }</a></td>
			<td class="entP">${review.REGDATE }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
<%@ include file="../include/footer.jsp"%>