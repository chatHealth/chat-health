<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/26/23
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/member-side.jsp" %>

<!-- Content -->
  <h1>Edit Enterprise Profile</h1>
  <form action="../personal/enterprise-modify-process" method="post">
    <div class="mb-3">
      <label for="enterprise-tel" class=form-label">Tel</label>
      <%--					<span class="input-group-text">@</span>--%>
      <input type="tel" class="form-control" id="enterprise-tel" name="tel" value=${loggedEnterprise.tel }>

    </div>
    <div class="mb-3">
      <label for="enterprise-ceo" class="form-label">CEO</label>
      <input type="text" class="form-control" id="enterprise-ceo" name="ceo" value=${loggedEnterprise.ceo }>
    </div>
    <div class="mb-3">
      <label for="enterprise-address" class="form-label">Address</label>
      <input type="text" class="form-control" id="enterprise-address" readonly name="address" value=${loggedEnterprise.address }>
    </div>
    <div class="mb-3">
      <label for="enterprise-detail" class="form-label">Address Detail</label>
      <input type="text" class="form-control" id="enterprise-detail" name="addressDetail" value=${loggedEnterprise.addressDetail }>
    </div>
    <button type="submit" class="btn btn-primary">Update Profile</button>
  </form>
</div>
</div>
</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
  window.onload = function(){
    document.getElementById("enterprise-address").addEventListener("click", function(){ //주소입력칸을 클릭하면
      //카카오 지도 발생
      new daum.Postcode({
        oncomplete: function(data) { //선택시 입력값 세팅
          document.getElementById("enterprise-address").value = data.address; // 주소 넣기
          document.querySelector("input[name=addressDetail]").focus(); //상세입력 포커싱
        }
      }).open();
    });
  }
</script>

<%@ include file="../include/footer.jsp"%>
