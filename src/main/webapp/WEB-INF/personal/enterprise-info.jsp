<%--
  Created by IntelliJ IDEA.
  User: wonu
  Date: 10/26/23
  Time: 09:20
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ include file="../include/member-side.jsp" %>

<!-- Content -->
<div class="col-9 content">
	<!-- Profile Picture and Table on the Same Row -->
	<div class="row" style="padding-top: 10%;">
		<div class="col-4">
			<!-- Profile Picture -->
			<div class="profile-picture">
				<%--                        <img src="https://via.placeholder.com/150" alt="Profile Picture">--%>
				<img src="/uploadProfile/${member.profile }" alt="Profile Picture">
				<div class="edit-button">
					<%--                            <button class="btn btn-primary" style="background: none; border: none; color: white;">Edit</button>--%>
					<%--                        </div>--%>
					<button id="editBtn" class="btn" style="background: none; border: none;">Edit</button>
					<!-- 회원가입 확인 Modal-->
					<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
						 aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="profileModalLabel">프로필 사진 변경</h5>
								</div>
								<form action="../personal/member-profile-image" enctype="multipart/form-data"
									  method="post">
									<div class="modal-body">
										<!-- 프로필 사진 업로드 양식 -->
										<div class="form-group">
											<%--                                    <label for="profileImage">프로필 사진 업로드</label>--%>
											<input type="file" class="form-control-file" id="profileImage"
												   name="profileImage">
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary" data-dismiss="modal" id="close">
											닫기
										</button>
										<button type="submit" class="btn btn-primary">저장</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-8">
			<!-- Profile Info Table and '정보 수정' text -->
			<div class="table-container">
				<h2 class="text-2xl font-weight-bold">Profile Info</h2>
				<table class="table table-striped">
					<tbody>
					<tr>
						<th scope="row" class="w-25">Name</th>
						<td class="w-75">${member.name }</td>
					</tr>
					<tr>
						<th scope="row" class="w-25">NickName</th>
						<td class="w-75">${member.nickname }</td>
					</tr>
					<tr>
						<th scope="row" class="w-25">Address</th>
						<td class="w-75">${member.address }</td>
					</tr>
					<tr>
						<th scope="row" class="w-25">Address Detail</th>
						<td class="w-75">${member.addressDetail }</td>
					</tr>
					<tr>
						<th scope="row" class="w-25">E-Mail</th>
						<td class="w-75">${member.email }</td>
					</tr>
					</tbody>
				</table>
				<div class="info-text"><a href="../personal/member-modify" style="color:inherit">정보 수정</a></div>
			</div>
		</div>
	</div>
</div>
</div>
</div>

<script>
	$('#editBtn').click(function (e) {
		e.preventDefault();
		$('#editModal').modal("show");
	});
	$('#close').click(function (e) {
		e.preventDefault();
		$('#editModal').modal("hide");
	});
</script>
<%@ include file="../include/footer.jsp" %>