<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header-member.jsp"%>


<div class="form-join m-auto">
	<form action="../member/enterprise-join-process" method="post"
		enctype="multipart/form-data">

		<h1 class="mb-5 text-center fw-semibold" style="color: #347F5C;">🙌사업자 회원가입🙌</h1>
		<div class="mb-3">
			<!--사업자번호-->
			<div class="d-flex flex-row">
			<label for="code" class="form-label">사업자번호</label><p style="color: red;">*</p></div>
			<input type="text"
				class="form-control" id="code" aria-describedby="idHelp" name="code"
				placeholder="000-00-00000" />
			<div id="idHelp" class="form-text">사업자 회원은 사업자번호를 아이디로 사용하게
				됩니다.</div>
			<div class="col-6 mb-2 align-items-baseline px-0">
				<button class="btn btn-outline-success mt-3" id="btnIDCheck">아이디 중복 확인</button>
			</div>

		</div>



		<div class="mb-3"><!--상호명-->
			<div class="d-flex flex-row">
			<label for="companyName" class="form-label">상호명</label><p style="color: red;">*</p></div>
			<input type="text" class="form-control" id="companyName" name="name" placeholder="ex) 챗헬스 주식회사" required />
		</div>

		<div class="mb-3">
			<!--대표자-->
			<div class="d-flex flex-row">
			<label for="ceo" class="form-label">대표자명</label><p style="color: red;">*</p></div>
			<input type="text"
				class="form-control" id="ceo" name="ceo" placeholder="ex) 곽두팔"
				required />
		</div>
		<div class="mb-3">
			<!--전화번호-->
			<div class="d-flex flex-row">
			<label for="tel" class="form-label">사업장 연락처</label><p style="color: red;">*</p></div>
			<input type="text" class="form-control" id="tel" name="tel"
				placeholder="ex) 02-123-1234" required />
		</div>

		<div class="mb-3"><!--비번-->
			
			<div class="d-flex flex-row">
			<label for="password" class="form-label">비밀번호</label><p style="color: red;">*</p></div>
			<input type="password" class="form-control" id="password" name="pw"
				oninput="check()" required />
		</div>
		<div class="mb-3"><!--비번확인-->
			
			<div class="d-flex flex-row">
			<label for="password2" class="form-label">비밀번호 확인</label><p style="color: red;">*</p></div>
			<input type="password" class="form-control mb-2" id="password2" name="pw2" oninput="check()" required />
			<span id="pwConfirm"></span>
		</div>
		<div class="mb-3">
			<!--사업장소재지,우편번호찾기 API 연동-->
			<div class="d-flex flex-row">
			<label for="address" class="form-label">사업장 소재지</label></br><p style="color: red;">*</p></div>
			<input type="text" id="sample4_postcode" placeholder="우편번호">
			<input type="button" class=" btn btn-sm btn-outline-success" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address" required> <input type="text" id="sample4_jibunAddress"
				placeholder="지번주소">
			<span id="guide" style="color: #999; display: none"></span>
			<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="addressDetail">
			<input type="text" class="hidden" id="sample4_extraAddress" placeholder="참고항목">
		</div>


		<!-- 프로필 이미지 삽입 -->
		<label for="profile">프로필 사진</label>
		<div class="mb-5">
			<div class="col-20 mt-3 ">
				<input type="file" class="form-control" id="profile"
					placeholder="png,jpg" name="profile"
					accept="image/gif, image/jpeg, image/png" />
			</div>


			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="accepted"
					name="accepted" value="0" required /> <label
					class="form-check-label w-100" name="accepted" for="accepted">사업자
					회원은 가입신청 후 승인완료 되면 활동 하실 수 있습니다.</label>
			</div>
			<button type="submit" class="btn btn btn-success w-100" name="">회원가입
				신청하기</button>
		</div>
	</form>
</div>

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script> <!-- 주소입력 -->
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
<script> <!-- 비밀번호 일치 여부 확인 -->
  function check(){
	  
    if ($("#password").val() == $("#password2").val()) {
      // 비밀번호 일치
    	$("#pwConfirm").text("비밀번호가 일치합니다.").css('color','green');
    } else {
      // 비밀번호 불일치 시 사용자 정의 유효성 메시지 설정
    	 $("#pwConfirm").text("비밀번호가 일치하지 않습니다.").css('color','red');
    }
  };
</script>
<script> <!-- 아이디 중복 여부 확인 -->
$('#btnIDCheck').on('click', function(){
	if($("#code").val().trim()=== ""){
		alert("사업자번호는 반드시 입력해야합니다.");
		$("#code").val("");
		$("#code").focus();
		return false;
	}
	
    $.ajax({
       url:"../member/id-check",
       data: {
     	  id: $("#code").val()
       },
       method: "get",  //없어도 get으로 처리됨
       success: function(data){
          if(data.count>0){
             alert("이미 사용중인 아이디입니다.")
             $("#code").val("");
             $("#code").focus();
          }else{
         	const useID = confirm("쓸 수 있는 아이디. 사용하시겠어요?");
             if(id) $("#code").attr("readonly", true);
             isIDCheck = true;
          }
       },
       fail:function(error){
          console.log(error);
       },
       
       complete:function(data){	             
       }
    });	       
    return false;
 });
</script>
<%@ include file="../include/footer.jsp"%>