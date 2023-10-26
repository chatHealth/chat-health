<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/26/23
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>

<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/25/23
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
	.sidebar {
		background-color: #f8f9fa; /* Lighter color */
		width: 240px; /* Fixed width */
		height: 100%; /* 100% height */
		overflow-y: auto;
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
<div class="container-fluid">
	<div class="row">
		<%--        <button class="btn btn-primary mt-2 ml-2" id="sidebar-toggle">Toggle Sidebar</button>--%>

		<!-- Sidebar -->
		<div class="col sidebar">
			<h1>Sidebar</h1>
			<ul>
				<li><a href="../personal/enterprise-info">내 정보</a></li>
				<li><a href="../personal/enterprise-password">비밀번호 변경</a></li>
				<li><a href="../personal/enterprise-post">내 상품</a></li>
				<li><a href="../personal/member-review">내 리뷰</a></li>
				<li><a href="../personal/member-comments">내 댓글</a></li>
				<li><a href="../personal/member-withdraw">회원 탈퇴</a></li>
			</ul>
		</div>