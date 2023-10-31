<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	</main>


<c:if test="${myModal.state eq 'show'}">
		<jsp:include page="/WEB-INF/include/modal.jsp"></jsp:include>
</c:if>

</body>
</html>


<script>
		const myModal = new bootstrap.Modal("#myModal");
		myModal.show();
		
		$("#modalAccept").on("click", function() {
			$.ajax({
				type : "POST", 
				data : {accept : "yes" },
				url : "../post/modal-delete",
				
			});
		});
		
		$("#modalReject").on("click", function() {
			$.ajax({
				type : "POST", 
				data : {accept : "no" },
				url : "../post/modal-delete",
				
			});
		});
</script>