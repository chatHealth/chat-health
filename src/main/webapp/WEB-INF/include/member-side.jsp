<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/25/23
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/header-main.jsp" %>
<link href="../css/mypage.css" rel="stylesheet" />

<div class="container-fluid centered-page">
  <div class="row">
    <%--        <button class="btn btn-primary mt-2 ml-2" id="sidebar-toggle">Toggle Sidebar</button>--%>

    <!-- Sidebar -->
    <div class="col sidebar">
      <c:choose>
        <c:when test="${loggedMember ne null}">
          <h1>user info</h1>
          <ul>
            <li><a class="nav-link " href="../personal/member-info">내 정보</a></li>
            <li><a class="nav-link " href="../personal/member-password">비밀번호 변경</a></li>
            <li><a class="nav-link " href="../personal/member-wish?idx=1">관심 제품</a></li>
            <li><a class="nav-link " href="../personal/member-review?idx=1">내 리뷰</a></li>
<%--            <li><a class="nav-link " href="../personal/member-comments">내 댓글</a></li>--%>
            <li><a class="nav-link " href="../personal/member-withdraw">회원 탈퇴</a></li>
          </ul>
        </c:when>
        <c:when test="${loggedEnterprise ne null}">
          <h1>enterprise info</h1>
          <ul>
            <li><a class="nav-link " href="../personal/member-info">기업 정보</a></li>
            <li><a class="nav-link " href="../personal/member-password">비밀번호 변경</a></li>
            <li><a class="nav-link " href="../personal/enterprise-post?idx=1">내 상품 관리</a></li>
            <li><a class="nav-link " href="../personal/member-withdraw">회원 탈퇴</a></li>
          </ul>
        </c:when>
        <c:otherwise>

          <script>
            alert("잘못된 접근입니다.");
            history.back();
          </script>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
<div class="col-9 content min-h300">