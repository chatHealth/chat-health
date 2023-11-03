<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header-member.jsp"%>

<div class="form-signin translate-middle w-25 position-absolute top-50 start-50">
<h1 class="h3 mb-5 fw-normal" style="color: #347F5C;">로그인</h1>
  <form action="../member/login-process" method="post" >
    
    

    <div class="mb-2">
    <label for="userID" class="mb-3">아이디</label>
      <input type="text" class="form-control" id="userID" placeholder="아이디" name="userID" 
      value="${cookie.saveIDCookie.value}" autofocus required> 
      
    </div>
    <div class="mb-2">
    <label for="userPW" class="mb-3">비밀번호</label>
      <input type="password" class="form-control" id="userPW" placeholder="비밀번호" name="userPW" required>      
    </div>

    <div class="checks mb-4">    	
      <div class="yuji mb-3">
        <input class="form-check-input" type="checkbox" value="rememberMe" id="saveID" name="saveID"
          <c:if test="${not empty cookie.saveIDCookie }">checked</c:if>>
          <label class="form-check-label1" for="saveID">
          아이디 기억하기
        </label>
      </div>
      
      <div class="radio-enterprise mb-3">
        
        <div class="form-check">
  			<input class="form-check-input" type="radio" name="isEnterprise" id="imMember" value="member" checked="checked">
  			<label class="form-check-label" for="imMember">개인회원</label> 
  			<input class="form-check-input1" type="radio" name="isEnterprise" id="imEnterprise" value="enterprise">
  			<label class="form-check-label" for="imEnterprise">사업자회원</label>
         </div>

     </div>
    
    <button class="btn btn-outline-success w-100 py-2" type="submit">로그인</button>
  </form>
  
 
  <p class="mt-4" style="text-align: center;">아직 회원이 아니신가요? <a href="../member/join-select">여기</a>를 눌러 회원가입 하기</p>
  
</div>
<%@ include file="../include/footer.jsp"%>