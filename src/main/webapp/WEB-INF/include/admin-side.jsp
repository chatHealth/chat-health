<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
	.admin-contents{
	width:100vw;
	
  }
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

  .content {
    background-color: #ffffff;
    padding: 20px;
    margin-left: 240px; /* Adjust this margin for the initial sidebar width */
  }

  .profile-picture {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    overflow: hidden;
    position: relative;
    margin: 0 auto;
  }

  .profile-picture img {
    width: 100%;
    height: 100%;
  }

  .edit-button {
    position: absolute;
    bottom: 10px;
    right: 10px;
  }

  .table-container {
    position: relative;
  }

  .info-text {
    position: absolute;
    top: 0;
    right: 0;
    font-size: 0.8rem;
    color: #6c757d;
  }

  @media (max-width: 768px) {
    .sidebar {
      width: 0;
    }
    .content {
      margin-left: 0;
    }
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
      	<li><a href="../category/index/index"><img alt="홈 로고" src="../img/home.png">메인 페이지</a></li>
      	<span style="border-top: 1px solid #ccc; display: block; margin: 10px 13px;"></span>
        <li><a href="../personal/member-manage"><img alt="개인 로고" src="../img/account.png">개인회원 관리</a></li>
        <span style="border-top: 1px solid #ccc; display: block; margin: 10px 13px;"></span>
        <li><a href="../personal/enterprise-manage"><img alt="사업자 로고" src="../img/office.png">사업자회원 관리</a></li>
      </ul>
    </div>
 </div>
</div>