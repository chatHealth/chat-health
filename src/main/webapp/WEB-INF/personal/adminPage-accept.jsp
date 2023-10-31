<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/admin-side.jsp"%>

<div class="admin-contents text-center">
	<!-- 사업자 가입승인 테이블 -->
	<table class="table table-striped certain-width">

		<thead>
			<tr>
				<th>회원 번호</th>
				<th>아이디</th>
				<th>상호명</th>
				<th>가입승인하기</th>
				<th>가입거절하기</th>
			</tr>
		</thead>
		<tbody class="table-hover">
			<c:forEach items="${userList}" var="item">
				<c:if test="${item.accepted == 0 && empty item.deletedDate}">
					<tr data-no="${item.enterpriseNo}">
						<td>${item.enterpriseNo}</td>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td style="display: none;">${item.deletedDate}</td>
						<td><button type="button" data-userno="${item.enterpriseNo}"
								class="btn btn-accept btn-outline-primary btn-sm"
								data-bs-toggle="modal" data-bs-target="#exampleModal">가입승인</button></td>
						<td><button type="button" data-userno="${item.enterpriseNo}"
								class="btn btn-reject btn-outline-danger btn-sm">가입거절</button></td>
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
				<h1 class="modal-title fs-5" id="exampleModalLabel"></h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="close"></button>
			</div>
			<div class="modal-body">사업자 회원가입을 승인하시겠습니까?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">승인 취소하기</button>
				<button type="button" class="btn btn-primary"
					data-bs-dismiss="modal" id="entAccept">승인</button>
			</div>
		</div>
	</div>
</div>
<p>${item.enterpriseNo}</p>
<script>
	<!-- 승인 처리 -->
	let sendenterpriseNo = null;
	$(".btn-accept").on("click", function() {
		sendEnterpriseNo = $(this).data("userno");
	})

	$("#entAccept").on("click", function() {
		console.log(sendEnterpriseNo);
		// Ajax 요청을 보내고 백엔드 코드 실행
		$.ajax({
			type : "POST", // 또는 "GET" 등 HTTP 메소드 설정
			data : {
				userNo : sendEnterpriseNo
			},
			url : "../personal/admin-entAccept-process",
			success : function(data) {
				// 백엔드에서 반환된 데이터를 처리
				console.log(data);
				if (data.isAccepted === "ok") {

					alert("승인 완료")
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
	
	<!-- 거절처리 -->
	//let sendenterpriseNo = null;
	$(".btn-reject").on("click", function() {
		console.log("reject");
		sendEnterpriseNo = $(this).data("userno");
		$.ajax({
			type : "POST", // 또는 "GET" 등 HTTP 메소드 설정
			data : {
				userNo : sendEnterpriseNo
			},
			url : "../personal/admin-entReject-process",
			success : function(data) {
				// 백엔드에서 반환된 데이터를 처리
				console.log(data);
				if (data.isRejected === "ok") {

					alert("거절 완료")
					location.reload();
				}
			},
			error : function(error) {
				// 오류 처리

				alert("알수 없는 오류가 발생. 시스템관리자에게 문의하세요")
				location.reload();
			}
		});
	})

	$("#entAccept").on("click", function() {
		// Ajax 요청을 보내고 백엔드 코드 실행
		$.ajax({
			type : "POST", // 또는 "GET" 등 HTTP 메소드 설정
			data : {
				userNo : sendEnterpriseNo
			},
			url : "../personal/admin-entAccept-process",
			success : function(data) {
				// 백엔드에서 반환된 데이터를 처리
				console.log(data);
				if (data.isAccepted === "ok") {

					alert("승인 완료")
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