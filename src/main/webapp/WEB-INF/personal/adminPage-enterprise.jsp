<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/admin-side.jsp"%>

<div class="admin-contents text-center">
<h3 class="text-start fw-semibold" style="color: #347F5C;">사업자회원 관리</h3> </br>
	<!-- 사업자 강제탈퇴 -->
	<table class="table table-striped certain-width">
		<thead>
			<tr>
				<th>회원 번호</th>
				<th>아이디</th>
				<th>상호명</th>
				<th>탈퇴</th>
			</tr>
		</thead>
		<tbody class="table-hover">
			<c:forEach items="${userList}" var="item">
				<c:if test="${empty item.deletedDate && item.accepted == 1}">
					<tr data-no="${item.enterpriseNo}">
						<td>${item.enterpriseNo}</td>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td style="display: none;">${item.deletedDate}</td>
						<td><button type="button" data-userno="${item.enterpriseNo}"
								class="btn btn-delete btn-outline-danger btn-sm"
								data-bs-toggle="modal" data-bs-target="#exampleModal">강제
								탈퇴</button></td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">진짜로 회원을
					강제탈퇴 시키시겠습니까?</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="close"></button>
			</div>
			<div class="modal-body">한번 탈퇴시키면 다시 원복할 수 없습니다.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">삭제 취소하기</button>
				<button type="button" class="btn btn-danger" data-bs-dismiss="modal"
					id="memWithdraw">삭제하기</button>
			</div>
		</div>
	</div>
</div>
<p>${item.enterpriseNo}</p>
<script>
	console.log($("#memWithdraw"));
	let sendenterpriseNo = null;
	$(".btn-delete").on("click", function() {
		sendEnterpriseNo = $(this).data("userno");
	})

	$("#memWithdraw").on("click", function() {
		console.log(sendEnterpriseNo);
		// Ajax 요청을 보내고 백엔드 코드 실행
		$.ajax({
			type : "POST", // 또는 "GET" 등 HTTP 메소드 설정
			data : {
				userNo : sendEnterpriseNo
			},
			url : "../personal/admin-entWithdraw-process",
			success : function(data) {
				// 백엔드에서 반환된 데이터를 처리
				console.log(data);
				if (data.isDelete === "ok") {

					alert("강제 탈퇴 완료")
					location.reload();
				}
			},
			error : function(error) {
				// 오류 처리

				alert("알수 없는 오류가 발생. 시스템관리자에게 문의하세요")
				location.reload();
			}
		});
	});
</script>

<%@ include file="../include/footer.jsp"%>