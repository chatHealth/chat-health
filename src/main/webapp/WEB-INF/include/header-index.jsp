<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">


	<title>chat health</title>


	<script src="../js/jquery-3.7.1.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../js/bootstrap.bundle.min.js"></script>
	<link href="../css/bootstrap.min.css" rel="stylesheet" />
	<link href="../css/layout.css" rel="stylesheet" />
	<link href="../css/rang.css" rel="stylesheet" />


	<!-- post) ckeditor  -->
	<script src="../js/ckeditor.js"></script>
	<!-- multi select -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" />
	<link rel="stylesheet" href="../css/select2-bootstrap-5-theme.min.css" />
	<link rel="stylesheet" href="../css/select2-bootstrap-5-theme.rtl.min.css" />
	<script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.full.min.js"></script>


</head>
<body>
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom mt-3" style="position:sticky; top:-10px; background:white; opacity:0.9; z-index:1;">
	<div class="col-md-3 mb-2 mb-md-0" style="margin-left:200px;" >
		<a href="../index/index" class="d-inline-flex link-body-emphasis text-decoration-none">
			<img src="../img/logo.png" style="height:80px;"/>
		</a>
	</div>

	<div style="margin-right:200px;" >
	<c:choose>
		<c:when test="${ not empty loggedMember }">
			<div class="text-end double-btn">
				<a href="../personal/member-info" class="btn  btn-green"> ${loggedMember.nickName } </a>
				<a href="../member/logout" class="btn  btn-green"> 로그아웃 </a>
			</div>
		</c:when>

		<c:when test="${ not empty loggedEnterprise }">
			<div class="text-end double-btn">
				<a href="../personal/member-info" class="btn   btn-green"> ${loggedEnterprise.name } </a>
				<a href="../member/logout" class="btn   btn-green"> 로그아웃 </a>
			</div>
		</c:when>

		<c:when test="${ not empty loggedAdmin }">
			<div class=" text-end double-btn">
				<a href="../personal/member-manage" class="btn   btn-green"> ${loggedAdmin.nickName } </a>
				<a href="../member/logout" class="btn   btn-green"> 로그아웃 </a>
			</div>
		</c:when>

		<c:otherwise>
			<div class=" text-end double-btn">
				<a href="../member/join-select" class="btn   btn-green"> 회원가입 </a>
				<a href="../member/login" class="btn   btn-green"> 로그인 </a>
			</div>
		</c:otherwise>
	</c:choose>
	</div>
</header>

<main class="main ">