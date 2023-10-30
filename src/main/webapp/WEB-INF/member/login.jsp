<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="form-signin w-25 position-absolute top-50 start-50 translate-middle">
  <form action="../member/login-process" method="post" >
    
    <h1 class="h3 mb-3 fw-normal">로그인</h1>

    <div class="form-floating mb-3">
    <label for="userID">아이디</label>
      <input type="text" class="form-control" id="userID" placeholder="ID" name="userID" 
      value="${cookie.saveIDCookie.value}"> 
      
    </div>
    <div class="form-floating mb-3">
    <label for="userPW">비밀번호</label>
      <input type="password" class="form-control" id="userPW" placeholder="Password" name="userPW">      
    </div>

    <div class="checks mb-4">    	
      <div class="yuji mb-3">
        <input class="form-check-input1" type="checkbox" value="rememberMe" id="saveID" name="saveID"
          <c:if test="${not empty cookie.saveIDCookie }">checked</c:if>>
          <label class="form-check-label1" for="saveID">
          아이디 기억하기
        </label>
      </div>
      
      <div class="radio-enterprise mb-3">
        <!--  <input class="form-check-input1" type="radio" value="imMember" id="imMember" name="imMember">
        <label class="form-check-label1" for="imMember"> 개인회원</label>
        <input class="form-check-input1" type="radio" value="imEnterprise" id="isEnterprise" name="isEnterprise"> 
        <label class="form-check-label1" for="isEnterprise"> 사업자회원</label>-->
        
        <div class="form-check">
  			<input class="form-check-input" type="radio" name="isEnterprise" id="imMember" value="member" checked="checked">
  			<label class="form-check-label" for="imMember">개인회원</label> 
  			<input class="form-check-input1" type="radio" name="isEnterprise" id="imEnterprise" value="enterprise">
  			<label class="form-check-label" for="imEnterprise">사업자회원</label>
         </div>

     </div>
    
    <button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
  </form>
  
  <div> <!-- 회원가입버튼 누르면 개인회원/사업자회원 선택창으로 연결 -->
  <a href="../member/join-select" class="nav-link"><button class="btn btn-primary w-100 py-2 mt-3" type="submit">회원가입</button></a>
  </div>
</div>

<%@ include file="../include/footer.jsp"%>