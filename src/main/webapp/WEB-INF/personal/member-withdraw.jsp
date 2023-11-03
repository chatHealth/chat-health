<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/26/23
  Time: 01:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/member-side.jsp" %>

<!-- Content -->
    <h4 class="mb-3">회원 탈퇴</h4>
    <form action="../personal/member-withdraw-process" class="needs-validation" onsubmit="return confirm('정말 탈퇴하시겠습니까?')" method="post">
        <div class="g-3 min-h300">
            <div class="col-12">
                <label for="password" class="form-label">비밀번호</label>
                <div class="input-group has-validation">
                    <%--							<span class="input-group-text">@</span>--%>
                    <input type="password" class="form-control" id="password" placeholder="password" name="password">
                    <div class="invalid-feedback">
                        password
                    </div>
                </div>
            </div>
            <div class="col-12">
                <label for="password-check" class="form-label">비밀번호 확인</label>
                <div class="input-group has-validation">
                    <%--							<span class="input-group-text">@</span>--%>
                    <input type="password" class="form-control" id="password-check" placeholder="password" name="passwordCheck">
                    <div class="invalid-feedback">
                    </div>
                </div>
            </div>
            </div>
            <button class="btn btn-secondary" type="submit">회원 탈퇴</button>
        </div>
    </form>
</div>
</div>
</div>


<%@ include file="../include/footer.jsp" %>