<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header-member.jsp"%>



<form action="../member/member-join-process" method="post" enctype="multipart/form-data">
      <div class="form-join m-auto">        
			<h1 class="h3 mb-5 fw-normal">개인 회원가입</h1>
			<span class="border-bottom border-dark-subtle"></span>
			<div class="mb-3"><!--닉네임-->
          
          <label for="nickname" class="form-label">닉네임</label>
          <input type="text" class="form-control" id="nickname" name="nickname" required/>
        </div>
        
        <div class="mb-3"><!--이메일-->          
          <label for="email" class="form-label">이메일</label>
          <input type="email" class="form-control" id="email" name="email" required/>
        </div>
        
        <div class="mb-3"><!--이름-->
          
          <label for="name" class="form-label">이름</label>
          <input type="text" class="form-control" id="name" name="name" required/>
        </div>
        
        
        <div class="form-check form-check-inline"><!--성별-->
          <input type="radio" class="form-check-input" id="gender-f" name="gender" value="f" required>
          <label for="gender-f" class="form-label">여성</label>
          </div>
          <div class="form-check form-check-inline mb-4">
          <input type="radio" class="form-check-input" id="gender-m" name="gender" value="m">
          <label for="gender-m" class="form-label">남성</label>          
        </div>
        
         <div class="mb-3"> <!-- 생년월일 -->          
          <label for="birth" class="form-label">생년월일</label>
          <input type="date" class="form-control" id="birth" name="birth" required/>
        </div>
        
        
         <div class="row d-flex mt-5 w-100"> <!-- 아이디 -->
				<div>
					<div class="mb-3">
						<div class="row">
							<div class="col-6">
								<label for="id" class="form-label">아이디</label> 
								<input type="text" class="form-control" id="id"
								placeholder="user id" name="id" required/>
							</div>
							<div class="col-6  mt-3 d-flex align-items-baseline px-0">
								<button class="btn btn-primary mt-3" id="btnIDCheck" >아이디 중복 확인</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			    
        <div class="mb-3"><!--비번-->
          
          <label for="password" class="form-label">비밀번호</label>
          <input type="password" class="form-control" id="password" name="pw" oninput="check()" required/>
        </div>
        <div class="mb-3"><!--비번확인-->
          
          <label for="password2" class="form-label">비밀번호 확인</label>
          <input type="password" class="form-control mb-2" id="password2" name="pw2" oninput="check()" required/>
          <span id="pwConfirm"></span>
        </div> 
          
        <div class="mb-3"><!--사업장소재지,우편번호찾기 API 연동-->
          
          <label for="address" class="form-label">주소</label>
          <input type="hidden" id="sample4_postcode" placeholder="우편번호">
		  <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
		  <input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address">
		  <input type="text" id="sample4_jibunAddress" placeholder="지번주소">
		  <span id="guide" style="color:#999;display:none"></span>
		  <input type="text" id="sample4_detailAddress" placeholder="상세주소"name="addressDetail">
		  <input type="text" id="sample4_extraAddress" placeholder="참고항목">

		
        </div>
        <!-- 프로필 이미지 삽입 -->
        <label for="profile">프로필 사진</label>
        <div class="mb-3">
			<div class="col-20 mt-3 ">	
            	<input type="file" class="form-control" id="profile" placeholder="png,jpg" name="profile"
            	accept="image/gif, image/jpeg, image/png" />
			</div>
		<input type="hidden" name="grade" value="10" >
		
        <div class="mt-3 form-check">
          <input type="checkbox" class="form-check-input mt-5" required/>
          <label class="form-check-label w-100 mt-5" for="accepted"  >
          (필수) <a href="../useAgree.jsp" target="_blank">이용약관</a>과 <a href="../personal.jsp" target="_blank">개인정보 수집 및 이용</a>에 동의합니다.
          </label>
          
        </div>
        <button type="submit" class="btn btn-primary w-100 mt-20" name="">회원가입 신청하기</button>
      </div>
    </form>
    
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!--API연결-->
    
<script> <!--JS 주소찾기, 아이디중복체크-->
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

<script>    
    	//2. 아이디 중복체크
	   $('#btnIDCheck').on('click', function(){
		   if($("#id").val().trim()=== ""){
				alert("아이디는 반드시 입력해야합니다.");
				$("#id").val("");
				$("#id").focus();
				return false;
			}
	       $.ajax({
	          url:"../member/id-check",
	          data: {
	        	  id: $("#id").val()
	          },
	          method: "get",  //없어도 get으로 처리됨
	          success: function(data){
	        	  console.log(data)
	             if(data.count>0){
	                alert("이미 사용중인 아이디입니다.")
	                $("#id").val("");
	                $("#id").focus();
	             }else{
	            	const useID = confirm("쓸 수 있는 아이디. 사용하시겠어요?");
	                if(id) $("#id").attr("readonly", true);
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

<%@ include file="../include/footer.jsp"%>