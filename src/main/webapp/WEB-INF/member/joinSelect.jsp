<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>chat health</title>


<script src="../js/jquery-3.7.1.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/bootstrap.bundle.min.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet" />


<!-- post) ckeditor  -->
<script src="../js/ckeditor.js"></script>
<!-- multi select -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" />
<link rel="stylesheet" href="../css/select2-bootstrap-5-theme.min.css" />
<link rel="stylesheet"
	href="../css/select2-bootstrap-5-theme.rtl.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.full.min.js"></script>

<style type="text/css">
.selectContainer {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

.selectbox {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background-color: #f0f0f0;
  border-radius: 10px;
  padding: 20px;
  width: 400px;
  height: 480px;
  text-align: center;
}

.selectbox {
	margin-top: 20px;
}
</style>
</head>
<body>


	<main class="main ">

		<div class="selectContainer">
			<div class="selectbox">
				<h3 class="text-body-secondary fw-semibold selet-title">회원 유형을 선택해주세요.</h3>
				</br>
				</br>
				</br>
				<div class="selectButtons m-0">
					<button type="button" class="btn btn-outline-primary btn-lg"
						onclick="location.href='/chat-health/member/member-join'">개인
						회원가입</button>
					<button type="button" class="btn btn-outline-success btn-lg"
						onclick="location.href='/chat-health/member/enterprise-join'">사업자
						회원가입</button>
				</div>
			</div>
		</div>
		<%@ include file="../include/footer.jsp"%>