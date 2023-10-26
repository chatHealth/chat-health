<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/nav.jsp"%>

<div class="container ">

	<h2>Write</h2>

	<form action="../post/write-process" method="post" enctype="multipart/form-data">
		<input type="hidden" name="enterpriseNo" value="123">

		<div class="form-floating mb-3">
			<input type="text" class="form-control" id="title"
				placeholder="title" name="title"> <label for="title">title</label>
		</div>
		<div class="form-floating">
			<textarea class="form-control" id="content" name="content"> </textarea>
		</div>



		<div class="row">
			<div class="col-3 mt-3 ">
				<input type="file" class="form-control" id="titleImg"
					placeholder="png,jpg" name="titleImg"
					accept="image/gif, image/jpeg, image/png" />
				<!-- <label for="titleImg" class="form-label"> 제품대표 이미지  </label>  -->
			</div>

			<div class="col-3 mt-3">
				<select id="symptomOptions" name="symptomOptions"
					multiple="multiple" data-placeholder="증상"
					class="form-select form-select-sm selectpicker"
					aria-label="Small select example" data-style="btn-primary">
					<c:forEach items="${ symptomList }" var="symptom"
						varStatus="status">
						<option value="${symptom.sympNo }">
							${symptom.symptomName}</option>
					</c:forEach>
				</select>
			</div>

			<div class="col-3 mt-3">
				<select id="materialOptions" name="materialOptions"
					multiple="multiple" data-placeholder="원재료"
					class="form-select form-select-sm selectpicker"
					aria-label="Small select example" data-style="btn-primary">
					<c:forEach items="${ materialList }" var="material"
						varStatus="status">
						<option value="${material.materialNo }">
							${material.materialName}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="mt-5 mb-5 d-flex justify-content-center ">
			<button class="btn btn-primary mx-2" id="btnSubmit" >확인</button>
			<button type="reset" class="btn btn-secondary">취소</button>
		</div>
	</form>
</div>



<script
	src="https://cdn.ckeditor.com/ckeditor5/39.0.2/classic/ckeditor.js"></script>

<script>

// 1. ck editor
let ckEditor=null;
ClassicEditor
.create(document.querySelector("#content"),
    {
        language: "ko",
        simpleUpload:
        {
            uploadUrl: "../post/img-upload",
            withCredentials: true,
        }
    })
.then(newEditor => {
	ckEditor = newEditor;
})
.catch(error => {
    console.error(error);
});

// 2. multi select

$( '#symptomOptions' ).select2( {
    theme: "bootstrap-5",
    width: $( this ).data( 'width' ) ? $( this ).data( 'width' ) : $( this ).hasClass( 'w-100' ) ? '100%' : 'style',
    placeholder: $( this ).data( 'placeholder' ),
    closeOnSelect: false,
} );
$( '#materialOptions' ).select2( {
    theme: "bootstrap-5",
    width: $( this ).data( 'width' ) ? $( this ).data( 'width' ) : $( this ).hasClass( 'w-100' ) ? '100%' : 'style',
    placeholder: $( this ).data( 'placeholder' ),
    closeOnSelect: false,
} );


// 3. 제목.내용 입력했는지 확인
$("#btnSubmit").on("click", function(e){

        if($("#title").val().trim()==="") {
            alert("제목을 입력해주세요");
            $("#title").val("");
            $("#title").focus();
            return false;
        } else if(ckEditor.getData().trim()==="") {
            alert("내용을 입력해주세요");
            //ckEditor.setData("");
            ckEditor.focus();
            return false;
        } 
    }); 
    
</script>

<%@ include file="../include/footer.jsp"%>



