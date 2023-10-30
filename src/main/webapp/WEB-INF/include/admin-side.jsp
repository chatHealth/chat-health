<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
  .sidebar {
    background-color: #f8f9fa; /* Lighter color */
    width: 240px; /* Fixed width */
    height: 100%; /* 100% height */
    position: fixed;
    left: 0;
  }

  .sidebar h1 {
    color: #000000;
    font-size: 1.5rem;
    margin: 20px;
  }

  .sidebar ul {
    list-style: none;
    padding: 0;
  }

  .sidebar ul li {
    margin-bottom: 10px;
  }

  .sidebar a {
    text-decoration: none;
    color: #000000;
    transition: color 0.3s, background-color 0.3s; /* Transition properties */
    padding: 10px; /* Add padding to create background space */
  }

  .sidebar a:hover {
    color: #6c756d; /* Text color on hover */
    background-color: #f8f9fa; /* Background color on hover */
  }


.admin-contents{
	position: relative;
	left: 241px;
}

  @media (max-width: 768px) {
    .sidebar {
      width: 0;
    }
  }
  
  .certain-width{
  width: 90%;
  table-layout: fixed;
  }
  certain-width th, certain-width td {
  width: 50%; 
  padding: 5px; 
  text-align: center; 
}



</style>

<div class="container-fluid left" style="text-align: center;"> <!-- 어드민 사이드바 메뉴 목록 -->
  <div class="row">

    <!-- Sidebar -->
    <div class="col sidebar">
      <h3>관리자 페이지</h3></br>
      <p >어서오세요, admin님</p>
      <span style="border-top: 2px solid #ccc; display: block; margin: 10px 0;"></span>
      <ul> <!-- 메인화면으로 돌아가기 링크 추가하기 -->
      	<li><a href="../index/index"><img alt="홈 로고" src="../img/home.png">메인 페이지</a></li>
      	<span style="border-top: 1px solid #ccc; display: block; margin: 10px 13px;"></span>
        <li><a href="../personal/member-manage"><img alt="개인 로고" src="../img/account.png">개인회원 관리</a></li>
        <span style="border-top: 1px solid #ccc; display: block; margin: 10px 13px;"></span>
        <li><a href="../personal/enterprise-manage"><img alt="사업자 로고" src="../img/office.png">사업자회원 관리</a></li>
        <span style="border-top: 1px solid #ccc; display: block; margin: 10px 13px;"></span>
        <li><a href="../personal/admin-accept-info"><img alt="승인 로고" src="../img/check.png">사업자회원 승인</a></li>
      </ul>
    </div>
 </div>
</div>