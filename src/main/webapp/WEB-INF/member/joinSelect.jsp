<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="container class="ratio ratio-1x3"">
	<h3 class="text-primary-emphasis">회원 유형을 선택해주세요.</h3>
	<div class="selectbox m-0 border-0">
		<button type="button" class="btn btn-outline-primary btn-lg" onclick="location.href='/chat-health/member/member-join'">개인 회원가입</button>
		<button type="button" class="btn btn-outline-success btn-lg" onclick="location.href='/chat-health/member/enterprise-join'">사업자 회원가입</button>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>