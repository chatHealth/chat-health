<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/header-member.jsp" %>

<style>
  
  .certain-width{
  width: 83%;
  table-layout: fixed;
  }
  certain-width th, certain-width td {
  width: 50%; 
  padding: 5px; 
  text-align: center; 
}
ul {
text-align: center;
}


a {
  text-decoration-line: none;
  color: #111;
  }

.admin-sidebar{
 text-align: center;
}
</style>

<div class="main-category">
<div class="d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary text-btLine" style="width: 280px; height:100%;"> <!-- 어드민 사이드바 메뉴 목록 -->
  

    <!-- Sidebar -->
    <div class="col sidebar admin-sidebar">
      <h3 style="color: #347F5C;">관리자 페이지</h3></br>
      <p style="color: #409C71;">어서오세요, admin님</p></br>
      <a href="../member/logout"><button type="button" class="btn btn-outline-secondary">로그아웃</button></a>
      <span style="border-top: 2px solid #ccc; display: block; margin: 10px 0;"></span></div>
      <ul class="nav nav-pills flex-column mb-auto"> <!-- 메인화면으로 돌아가기 링크 추가하기 -->
      	<li><a href="../index/index"><img alt="홈 로고" src="../img/home.png">메인 페이지</a></li>
      	<span style="border-top: 1px solid #ccc; display: block; margin: 10px 13px;"></span>
        <li><a href="../personal/member-manage"><img alt="개인 로고" src="../img/account.png">개인회원 관리</a></li>
        <span style="border-top: 1px solid #ccc; display: block; margin: 10px 13px;"></span>
        <li><a href="../personal/enterprise-manage"><img alt="사업자 로고" src="../img/office.png">사업자회원 관리</a></li>
        <span style="border-top: 1px solid #ccc; display: block; margin: 10px 13px;"></span>
        <li><a href="../personal/admin-accept-info"><img alt="승인 로고" src="../img/check.png">사업자회원 승인</a></li>
      </ul>
    
 </div>
