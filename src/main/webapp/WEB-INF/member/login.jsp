<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="form-signin w-100 m-auto">
  <form action="../member/login-process" method="post" >
    
    <h1 class="h3 mb-3 fw-normal">로그인</h1>

    <div class="form-floating">
    <label for="userID">아이디</label>
      <input type="text" class="form-control" id="userID" placeholder="ID" name="userID" 
      value="${cookie.saveIDCookie.value}"> 
      
    </div>
    <div class="form-floating">
    <label for="userPW">비밀번호</label>
      <input type="password" class="form-control" id="userPW" placeholder="Password" name="userPW">      
    </div>

    <div class="checks">    	
      <div class="yuji">
        <input class="form-check-input1" type="checkbox" value="rememberMe" id="saveID" name="saveID"
          <c:if test="${not empty cookie.saveIDCookie }">checked</c:if>>
          <label class="form-check-label1" for="saveID">
          로그인 유지
        </label>
      </div>
      
      <div class="checkbox-enterprise">
        <input class="form-check-input1" type="checkbox" value="imEnterprise" id="isEnterprise" name="isEnterprise">
          <label class="form-check-label1" for="isEnterprise"> 사업자회원</label>
      </div>
      	
     </div>
    
    <button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
    
    <!--  <p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>-->
  </form>
  <div> <!-- 회원가입버튼 누르면 연결되는 페이지 연동 필요 -->
  <a href="../member/enterprise-join" class="nav-link"><button class="btn btn-primary w-100 pu-2 mt-3" type="submit">회원가입</button></a>
  </div>
</div>

<%@ include file="../include/footer.jsp"%>