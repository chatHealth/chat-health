<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/23/23
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../include/member-side.jsp" %>

		<!-- Content -->
		<div class="col-9 content">
			<h4 class="mb-3">비밀번호 변경</h4>
			<form action="../personal/member-password-process" class="needs-validation" novalidate="" method="post">
				<div class="row g-3">
					<c:choose>
						<c:when test="${loggedMember ne null}">
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
					<div class="col-12">
						<label for="new-password" class="form-label">새로운 비밀번호</label>
						<div class="input-group has-validation">
<%--							<span class="input-group-text">@</span>--%>
							<input type="password" class="form-control" id="new-password" placeholder="new password" name="newPassword">
							<div class="invalid-feedback">
							</div>
						</div>
					</div>
						</c:when>
						<c:when test="${loggedEnterprise ne null}"></c:when>
					</c:choose>
				<button class="w-100 btn btn-primary btn-lg" type="submit">비밀번호 변경</button>
				<button class="w-100 btn btn-primary btn-lg" type="submit">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>