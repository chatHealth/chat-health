<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel"> ${myModal.title }</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
			</div>
			
			<div class="modal-body"> ${myModal.content } </div>
			<div class="modal-footer">
			
				<button type="button" class="btn btn-primary"" data-bs-dismiss="modal" id="modalAccept"> ${myModal.button1 }</button>
				<c:if test="${myModal.button2 ne null }">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" > ${myModal.button2 }</button>
				</c:if>
				
			</div>
		</div>
	</div>
</div>