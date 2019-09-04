<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<title>기업 회원 가입</title>
<style>

	form{
		border: 1px solid white;
		width: 650px;
        resize: none;
		
	}

	table{
		
		margin-left: auto;
		margin-right: auto;
		margin-top: auto;
	}

	td{
		border: 1px solid white;
		font-size: 10px;
		padding: 7px;
	}
	b{
		font-size: 20px;
	}

	#btn{
		text-align: center;
	}

	.btn{
		height: 50px;
        width: 130px;
        border:none;
        background: rgb(176, 19, 242); 
	}

	select{
		height: 20px;
	}

	input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;

	}

	.postcodify:hover{
		cursor: pointer;
	}

	



</style>



</head>
<body>

	

	
	<div class="output" align="center">
		
		<!--<b>이용약관에 모두 동의 합니다</b>
			<input type="checkbox">-->
			
			
			<br><br>
			
			<form id="joinForm" onsubmit="return joinValidate();" method="post" action="<%= request.getContextPath()%>/insertOwn.me ">
			
				<h2>기업회원 가입</h2>
				
				<hr>		
				
				<table  class="table2">
					<tr>
						<td><b>아이디</b></td>
						<td><input name="oId" id="oId" type="text" size="30" maxlength="15" placeholder="4~15자 영문(소문자),숫자"></input></td>
						<td width="170px"><label id="idResult"></label></td>
					</tr>

					<tr>
						<td><b>비밀번호</b></td>
						<td><input name="pwd" id="pwd" type="password" size="30" maxlength="16" placeholder="8~16자 영문, 숫자 특수문자"></input></td>
						<td><label id="pwdResult1"></label></td>
					</tr>
			
					<tr>
						<td><b>비밀번호확인</b></td>
						<td><input id="pwd2" type="password" size="30" maxlength="16" placeholder="비밀번호 확인"></td>		
						<td><label id="pwdResult2"></label></td>
					</tr>

					<tr>
						<td><b>사업장명</b></td>
						<td><input type="text" name="opName" id="opName" size="30" placeholder="사업장명 입력"></td>

					</tr>

					<tr>
						<td><b>사업자번호</b></td>
						<td>
							<input type="number" name="opNum1" style="width:45px;" oninput="maxLengthCheck(this)" maxlength="3"> - 
							<input type="number" name="opNum2" style="width:35px;" oninput="maxLengthCheck(this)" maxlength="2"> -
							<input type="number" name="opNum3" style="width:65px;" oninput="maxLengthCheck(this)" maxlength="5">


						</td>

					</tr>

					<tr>
						<td><b>성명</b></td>
						<td><input id="oName" name="oName" type="text" size="30" maxlength="5" placeholder="성명 입력"></input></td>
						<td><label id="nameResult"></label></td>
					</tr>
				
					<tr>
						<td><b>주민등록번호</b></td>
						<td>
							<input id="ocNum1" name="ocNum1" type="number"  style="width:80px;" oninput="maxLengthCheck(this)" maxlength="6"></input> - 
							<input id="ocNum2" name="ocNum2" type="password" size="11" maxlength="7"></input>
							<td><label id="ecNumResult"></label></td>
						</td>
					</tr>

				</tr>

				<tr>
					<td><b>전화번호</b></td>
					<td>
						<select name="tel1" id="">
							<option value="02">02</option>
							<option value="070">070</option>
							<option value="080">080</option>
							<option value="0502">0502</option>
							<option value="0503">0503</option>
							<option value="0504">0504</option>
							<option value="0505">0505</option>
							<option value="0506">0506</option>
							<option value="0507">0507</option>
							<option value="0508">0508</option>
							<option value="0303">0303</option>
							<option value="013">013</option>
						</select> - 
						<input type="number" name="tel2" style="width:50px;" oninput="maxLengthCheck(this)" maxlength="4"> - 
						<input type="number" name="tel3" style="width:50px;" oninput="maxLengthCheck(this)" maxlength="4">


					</td>


				</tr>


				<tr>
					<td><b>휴대전화</b></td>
					<td>
						<select style="width:45px;" name="phone1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
						</select> - 
						<input type="number" name="phone2" style="width:50px;" oninput="maxLengthCheck(this)" maxlength="4"> -
						<input type="number" name="phone3" style="width:50px;" oninput="maxLengthCheck(this)" maxlength="4">
					</td>
					<td></td>
				</tr>

				


				<tr>
					<td><b>메일주소</b></td>
					<td>
						<input id="email1" name="email1" type="text" size="13"></input> @
						<select id="email2" name="email2"> 
							<option value="@gmail.com">gmail.com</option>
							<option value="@naver.com">naver.com</option>
							<option value="@daum.net">daum.net</option>
							<option value="@nate.com">nate.com</option>
						</select>
						
					</td>
					<td><label id="emailResult"></label></td>
					
				
				</tr>
				
				<tr>
					<td><b>업직종명</b></td>
					<td>
						<select>
							<option></option>
						</select>
					</td>
					<td></td>
				</tr>

				<tr>
					<td></td>
					<td>
							<input name="mailAccept" id="mailAccept" type="checkbox" value="N"><label for="mailAccept">이메일 수신 동의</label> 
							<input name="smsAccept" id="smsAccept" type="checkbox" value="N"><label for="smsAccept">문자수신 동의</label> 
					</td>

				</tr>

					
				<tr>
					<td><b>주소</b></td>
					<td colspan="2">
						<input type="text" size="80" id="address" name="address" class="postcodify_address postcodify" readonly placeholder="주소입력" />	
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><input type="text" size="80" id="oAddress" name="oAddress" class="extra_info" placeholder="상세주소"></td>
					
				</tr>
					



			</table>
			<br><br>
			<div id="btn">
				<button type="reset" name="insertBtn" class="btn btn-secondary">다시입력</button>
				<button type="submit" name="insertBtn" class="btn btn-secondary">회원가입</button>
			</div>
		</form>
	</div>

	<script>

		var oId = document.getElementById("oId");
		var idResult = document.getElementById("idResult");
		var pwd = document.getElementById("pwd");
		var pwdResult1 = document.getElementById("pwdResult1");
		var pwdw = document.getElementById("pwdw");
		var pwdResult2 = document.getElementById("pwdResult2");
		var oName = document.getElementById("oName");
		var nameResult = document.getElementById("nameResult");
		var email1 = document.getElementById("email1");
		var email2 = document.getElementById("email2");
		var emailResult = document.getElementById("emailResult");
		


		$(function(){
			$(oId).on('blur', function(e){
				
				if(!(/^[a-z0-9]{4,}$/.test(oId.value))){
					$(idResult).text();
					$(idResult).text("사용할 수 없는 아이디 입니다.");
					oId.value="";
					//id.focus();
								
				}else{
					$(idResult).text();
					$(idResult).text("사용 가능한 아이디 입니다.");
				}


			});

			$(pwd).on('blur', function(e){

				if(!(/^[a-zA-Z0-9!@#$%^&*]{8,}$/.test(pwd.value))){
										
					$(pwdResult1).text("비밀번호를 확인 해주세요.");					
					pwd.value="";
					pwd2.value="";
					//pwd.focus();
				}else{
					
					$(pwdResult1).text("사용 가능한 비밀번호 입니다.");
					
				}
			});
			
			$(pwd2).on('blur', function(e){
				if(pwd.value != pwd2.value){
					
					$(pwdResult2).text("비밀번호가 일치 하지 않습니다.");
					pwd.value="";
					pwd2.value="";
					// pwd.focus();
				}else{
					
					$(pwdResult2).text("비밀번호가 일치 합니다.");
				}
			});

			$(oName).on('blur', function(e){
				if(!(/^[가-힣]{2,5}$/.test(oName.value))){
					oName.value="";
					$(nameResult).text("성명을 확인 해주세요.");
					//eName.focus();
				}
			});

			$(email1).on('blur', function(){
				if(!(/^[a-z0-9]{4,}$/.test(email1.value))){
					$(emailResult).text("이메일을 확인 해주세요.");
					email1.value="";
				}
			});

			$(".postcodify").postcodifyPopUp({
        
			/*
			insertPostcode5 : "#postcode",
			insertAddress : "#address",
			insertDetails : "#details",
			insertExtraInfo : "#extra_info",
			hideOldAddresses : false
			*/
			}); 
			
			$("#mailAccept").on("cheked", function(){
				$("#mailAccept").value="Y";
			});

			$("#smsAccept").on("cheked", function(){
				$("#smsAccept").value="Y";
			});


			
		});

		function maxLengthCheck(object){
   			if (object.value.length > object.maxLength){
    			object.value = object.value.slice(0, object.maxLength);
   			}   
  		}

			




	
	</script>



</body>
</html>