<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/27/23
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../include/member-side.jsp" %>

<table class="table">
<h2>내 상품 관리</h2>
<c:choose>
    <c:when test="${accepted eq 1}">
<p>내 상품 ${totalMerchandise}개</p>
<c:if test="${empty posts}">
    <p class="fs-5 col-md-8">아직 등록된 상품이 없습니다</p>
    <div class="mb-5">
        <a href="../post/write" class="btn btn-primary btn-lg px-4">새 상품 등록</a>
    </div>
</c:if>
<c:if test="${not empty posts}">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">상품</th>
        <th scope="col">상품명</th>
        <th scope="col">등록 일자</th>
        <th scope="col"><img src="../img/heart.png" class="img20"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${posts }" var="post" varStatus="loop">
        <tr>
            <th scope="col">${post.rNum}</th>
            <td class="entP"><a href="../view/product?no=${post.postNo}"><img src="/upload/${post.postImg}"
                                                                              class="img100"></a></td>
            <td class="entP"><a href="../view/product?no=${post.postNo}">${post.title }</a></td>
            <td>${post.regDate }</td>
            <td class="entP">${post.likes}</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var="page" begin="1" end="${pages }">
                <li class="page-item"><a class="page-link" href="../personal/enterprise-post?idx=${page}">${page}</a>
                </li>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</c:if>
    </c:when>
    <c:otherwise>
        <h4 style="color:red">승인된 사업자만 상품 등록이 가능합니다</h4>
    </c:otherwise>
</c:choose>
</div>
<%@ include file="../include/footer.jsp" %>