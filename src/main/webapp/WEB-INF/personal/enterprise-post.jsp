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
    <c:if test="${sort eq 1}">
        <th scope="col">#</th>
        <th scope="col">상품</th>
        <th scope="col">
            <a class="page-link" href="../personal/enterprise-post?sort=2&by=1&idx=${idx}&group=${group}">상품명
                <img src="../img/sorting.png" class="img20"/></a></th>
        <th scope="col"><a class="page-link" href="../personal/enterprise-post?sort=2&by=2&idx=${idx}&group=${group}">등록일
            <img src="../img/sorting.png" class="img20"/></a></th>
        <th scope="col">
            <a class="page-link" href="../personal/enterprise-post?sort=2&by=3&idx=${idx}&group=${group}">
                <img src="../img/heart.png" class="img20"/>
                <img src="../img/sorting.png" class="img20"/></a></th>
        <th scope="col">수정/삭제</th>
    </c:if>
    <c:if test="${sort eq 2}">
        <th scope="col">#</th>
        <th scope="col">상품</th>
        <th scope="col">
            <a class="page-link" href="../personal/enterprise-post?sort=1&by=1&idx=${idx}&group=${group}">상품명
                <img src="../img/sorting.png" class="img20"/></a></th>
        <th scope="col"><a class="page-link" href="../personal/enterprise-post?sort=1&by=2&idx=${idx}&group=${group}">등록일
            <img src="../img/sorting.png" class="img20"/></a></th>
        <th scope="col">
            <a class="page-link" href="../personal/enterprise-post?sort=1&by=3&idx=${idx}&group=${group}">
                <img src="../img/heart.png" class="img20"/>
                <img src="../img/sorting.png" class="img20"/></a></th>
        <th scope="col">수정/삭제</th>
    </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${posts }" var="post" varStatus="loop">
        <tr>
            <th scope="col">${post.rNum}</th>
            <td class="entP" style="width:150px"><a href="../view/product?no=${post.postNo}"><img src="${post.postImg}"
                                                                              class="img100"></a></td>
            <td class="entP"><a href="../view/product?no=${post.postNo}">${post.title }</a></td>
            <td>${post.regDate }</td>
            <td class="entP">${post.likes}</td>
            <td style="margin-bottom:0">
                <a href="../personal/modify-ent?no=${post.postNo }" class="btn btn-sm btn-green">수정</a>
                <a href="../post/delete-ent?no=${post.postNo }" class="btn btn-sm btn-green" onclick="return confirm('${post.title}을(를) 삭제하시겠습니까?');"  >삭제</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    <nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:if test="${start ne 1}">
            <li class="page-item">
                <a class="page-link btn-green" href="../personal/enterprise-post?sort=${sort}&by=${by}&idx=${start-5}&group=${group-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:forEach var="page" begin="${start}" end="${end}">
            <c:choose>
                <c:when test="${idx eq page}">
                    <li class="page-item"><a class="page-link btn-ygreen" href="../personal/enterprise-post?sort=${sort}&by=${by}&idx=${page}&group=${group}">${page}</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link btn-green" href="../personal/enterprise-post?sort=${sort}&by=${by}&idx=${page}&group=${group}">${page}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${group ne totalGroup}">
            <li class="page-item">
                <a class="page-link btn-green" href="../personal/enterprise-post?sort=${sort}&by=${by}&idx=${start+5}&group=${group + 1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
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