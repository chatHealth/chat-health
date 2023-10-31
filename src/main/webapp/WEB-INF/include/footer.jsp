<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	</main>


<c:if test="${myModal.state eq 'show' || param.state eq 'show' }">
		<jsp:include page="/WEB-INF/include/modal.jsp"></jsp:include>
</c:if>

</body>
</html>


<script>
		const myModal = new bootstrap.Modal("#myModal");
		myModal.show();
</script>