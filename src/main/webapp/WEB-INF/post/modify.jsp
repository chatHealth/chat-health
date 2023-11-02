<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header-main.jsp"%>
<%@ include file="../include/nav.jsp"%>


<div class="container">


	<h2>Write</h2>

<<<<<<< HEAD
	<form action="../post/modify-process" method="post" enctype="multipart/form-data">
		<input type="hidden" name="admin" value="${loggedAdmin.userNo }">
		<input type="hidden" name="enpriseNo" value="${loggedEnterprise.enterpriseNo }">
		<input type="hidden" name="postNo" value="${post.postNo }">
		<input type="hidden" name="selectedSymptomList" value="${selectedSymptomList }">
		<input type="hidden" name="selectedMaterialList" value="${selectedMaterialList }">

		<div class="form-floating mb-3">
			<input type="text" class="form-control" id="title" placeholder="title" name="title" value="${post.title }"> 
			<label for="title">title</label>
=======
	<form action="../post/modify-process" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="admin" value="${loggedAdmin.userNo }">
		<input type="hidden" name="enpriseNo"
			value="${loggedEnterprise.enterpriseNo }"> <input
			type="hidden" name="postNo" value="${post.postNo }"> <input
			type="hidden" name="selectedSymptomList"
			value="${selectedSymptomList }"> <input type="hidden"
			name="selectedMaterialList" value="${selectedMaterialList }">

		<div class="form-floating mb-3">
			<input type="text" class="form-control" id="title"
				placeholder="title" name="title" value="${post.title }"> <label
				for="title">title</label>
>>>>>>> 0c6a726c6a46f3440b70b0f0c79f072ce182831a
		</div>
		<div class="form-floating">
			<textarea class="form-control" id="content" name="content"> ${post.content } </textarea>
		</div>



		<div class="row">
			<div class="col-3 mt-3 ">
				<input type="file" class="form-control" id="titleImg"
					placeholder="png,jpg" name="titleImg"
<<<<<<< HEAD
					accept="image/gif, image/jpeg, image/png" value="${post.postImg }"/>
=======
					accept="image/gif, image/jpeg, image/png" value="${post.postImg }" />
>>>>>>> 0c6a726c6a46f3440b70b0f0c79f072ce182831a
				<!-- <label for="titleImg" class="form-label"> 제품대표 이미지  </label>  -->
			</div>

			<div class="col-3 mt-3">
				<select id="symptomOptions" name="symptomOptions"
					multiple="multiple" data-placeholder="증상"
					class="form-select form-select-sm selectpicker"
					aria-label="Small select example" data-style="btn-primary">
					<c:forEach items="${ symptomList }" var="symptom"
						varStatus="status">
<<<<<<< HEAD
						<option value="${symptom.sympNo }"> ${symptom.symptomName}</option>
					</c:forEach>
				</select>
				
		
			</div>

			<div class="col-3 mt-3">
=======
						<option value="${symptom.sympNo }">
							${symptom.symptomName}</option>
					</c:forEach>
				</select>


			</div>

			<div class="col-3 mt-3 " data-select2-id="4">
>>>>>>> 0c6a726c6a46f3440b70b0f0c79f072ce182831a
				<select id="materialOptions" name="materialOptions"
					multiple="multiple" data-placeholder="원재료"
					class="form-select form-select-sm selectpicker"
					aria-label="Small select example" data-style="btn-primary">
<<<<<<< HEAD
					<c:forEach items="${ materialList }" var="material" varStatus="status">
						<option value="${material.materialNo }"> ${material.materialName}</option>
					</c:forEach>
				</select>
=======
					<c:forEach items="${ materialList }" var="material"
						varStatus="status">
						<option value="${material.materialNo }">
							${material.materialName}</option>
					</c:forEach>
				</select> 
				
>>>>>>> 0c6a726c6a46f3440b70b0f0c79f072ce182831a
				
			</div>
		</div>

		<div class="mt-5 mb-5 d-flex justify-content-center ">
<<<<<<< HEAD
			<button class="btn btn-primary mx-2" id="btnSubmit" >확인</button>
=======
			<button class="btn btn-primary mx-2" id="btnSubmit">확인</button>
>>>>>>> 0c6a726c6a46f3440b70b0f0c79f072ce182831a
			<button type="reset" class="btn btn-secondary">취소</button>
		</div>
	</form>
</div>


</div>

<script>

// 1. ck editor
let ckEditor=null;
ClassicEditor
.create(document.querySelector("#content"),
    {
        language: "ko",
        ckfinder:
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
<<<<<<< HEAD
    
=======
   
  // 4. 미리 선택된 증상, 원재료 넣기
  //console.log(${selectedSymptomList});
  	const selectedSymptomList = ${selectedSymptomList};
	const symptomOptions = $("#symptomOptions");
	symptomOptions.val(selectedSymptomList).trigger('change');
	
	const selectedMaterialList = ${selectedMaterialList};
	const materialOptions = $("#materialOptions");
	materialOptions.val(selectedMaterialList).trigger('change');
  
>>>>>>> 0c6a726c6a46f3440b70b0f0c79f072ce182831a
</script>


<%@ include file="../include/footer.jsp"%>