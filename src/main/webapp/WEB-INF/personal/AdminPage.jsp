<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/admin-side.jsp"%>

<div class="admin-contents text-center">
	<table class="table table-striped table-hover">
		<tr>
			<td>회원번호</td>
			<td>아이디</td>
			<td>닉네임</td>
			<td>이름</td>
			<td>성별</td>
			<td>가입 일자</td>
			<td>탈퇴</td>
		</tr>
		<c:forEach items="${userList}" var="item">
			<c:if test="${empty item.deletedDate}">
				<tr data-no="${item.userNo}">
					<td>${item.userNo}</td>
					<td>${item.id}</td>
					<td>${item.nickName}</td>
					<td>${item.name}</td>
					<td>${item.gender}</td>
					<td>${item.joinDate}</td>
					<td style="display: none;">${item.deletedDate}</td>
					<td><button type="button" data-userno="${item.userNo}"
							class="btn btn-delete btn-outline-danger btn-sm"
							data-bs-toggle="modal" data-bs-target="#exampleModal">강제
							탈퇴</button></td>
				</tr>
			</c:if>
		</c:forEach>

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
				<button type="button" class="btn btn-danger" id="memWithdraw">삭제하기</button>
			</div>
		</div>
	</div>
</div>
<p>${item.userNo}</p>
<script>
	console.log($("#memWithdraw"));
	let sendUserNo = null;
	$(".btn-delete").on("click", function() {
		console.log($(this));
		sendUserNo = $(this).data("userno");
	})

	$("#memWithdraw").on("click", function() {
		console.log("삭제하기 눌렀음");
		// Ajax 요청을 보내고 백엔드 코드 실행
		$.ajax({
			type : "POST", // 또는 "GET" 등 HTTP 메소드 설정
			data : {
				userNo : sendUserNo
			},
			url : "../personal/admin-withdraw",
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