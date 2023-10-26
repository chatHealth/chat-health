<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
  .sidebar {
    background-color: #f8f9fa; /* Lighter color */
    width: 15%; /* Fixed width */
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
    color: #6c757d; /* Text color on hover */
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
<div class="container-fluid" style="text-align: center;"> <!-- 어드민 사이드바 메뉴 목록 -->
  <div class="row">
    <%--        <button class="btn btn-primary mt-2 ml-2" id="sidebar-toggle">Toggle Sidebar</button>--%>

    <!-- Sidebar -->
    <div class="col sidebar" id="lnb">
      <h3>관리자 페이지</h3>
      <p >어서오세요, admin님</p>
      <span style="border-top: 1px solid #000; display: block; margin: 10px 0;"></span>
      <ul>
        <li><input type="button" value="memberManage" onclick="acyncMovePage('/test/test.do')"></li>
        <li><input type="button" value="enterpriseManage" onclick="acyncMovePage('/test/test.do')"></li>
      </ul>
    </div>
 </div>
</div>
<div id="bodyContents">

</div>