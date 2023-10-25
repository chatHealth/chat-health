<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/23/23
  Time: 09:39
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
		<!-- Sidebar -->
		<div class="col sidebar">
			<h1>Sidebar</h1>
			<ul>
				<li><a href="../personal/member-info">내 정보</a></li>
				<li><a href="../personal/member-password">비밀번호 변경</a></li>
				<li><a href="../personal/member-wish">관심 제품</a></li>
				<li><a href="../personal/member-review">내 리뷰</a></li>
				<li><a href="../personal/member-comments">내 댓글</a></li>
				<li><a href="../personal/member-withdraw">회원 탈퇴</a></li>
			</ul>
		</div>

		<!-- Content -->
		<div class="col-9 content">
			<h4 class="mb-3">Billing address</h4>
			<form action="../personal/member-password-process" class="needs-validation" novalidate="" method="post">
				<div class="row g-3">
					<div class="col-12">
						<label for="username" class="form-label">비밀번호</label>
						<div class="input-group has-validation">
<%--							<span class="input-group-text">@</span>--%>
							<input type="password" class="form-control" id="username" placeholder="password" required="" name="password">
							<div class="invalid-feedback">
								password
							</div>
						</div>
					</div>
					<div class="col-12">
						<label for="username" class="form-label">비밀번호 확인</label>
						<div class="input-group has-validation">
<%--							<span class="input-group-text">@</span>--%>
							<input type="password" class="form-control" id="username" placeholder="password" required="" name="passwordCheck">
							<div class="invalid-feedback">
							</div>
						</div>
					</div>
					<div class="col-12">
						<label for="username" class="form-label">새로운 비밀번호</label>
						<div class="input-group has-validation">
<%--							<span class="input-group-text">@</span>--%>
							<input type="password" class="form-control" id="username" placeholder="new password" required="" name="newPassword">
							<div class="invalid-feedback">
							</div>
						</div>
					</div>
				<button class="w-100 btn btn-primary btn-lg" type="submit">비밀번호 변경</button>
				<button class="w-100 btn btn-primary btn-lg" type="submit">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>