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
<title>개인 회원 가입</title>
<style>

	form{
		/* border: 1px solid black; */
		width: 650px;
        resize: none;
		
	}

	table{
		
		margin-left: auto;
		margin-right: auto;
		margin-top: auto;
	}

	td{
		/* border: 1px solid black; */
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
			
			<form id="joinForm" onsubmit="return joinValidate();" method="post" action="<%= request.getContextPath()%>/insertEmp.me">
			
				<h2>개인회원 가입</h2>
				
				<hr>		
				
				<table  class="table2">
					<tr>
						<td><b>아이디</b></td>
						<td><input name="eId" id="eId" type="text" size="30" maxlength="15" placeholder="4~15자 영문, 숫자(영문 소문자 시작)"></input></td>
						<td width="170px"><label id="idResult"></label></td>
					</tr>

					<tr>
						<td><b>비밀번호</b></td>
						<td><input name="pwd" id="pwd" type="password" size="30" maxlength="16" placeholder="8~16자 영문, 숫자, 특수문자 입력"></input></td>
						<td><label id="pwdResult1"></label></td>
					</tr>
			
					<tr>
						<td><b>비밀번호확인</b></td>
						<td><input id="pwd2" type="password" size="30" maxlength="16" placeholder="비밀번호 확인"></td>		
						<td><label id="pwdResult2"></label></td>
					</tr>

					<tr>
						<td><b>성명</b></td>
						<td><input id="eName" name="eName" type="text" size="30" maxlength="5" placeholder="성명 입력"></input></td>
						<td><label id="nameResult"></label></td>
					</tr>
				
					<tr>
						<td><b>주민등록번호</b></td>
						<td>
							<input id="ecNum1" name="ecNum1" type="number"  style="width:80px;" oninput="maxLengthCheck(this)" maxlength="6"></input> - 
							<input id="ecNum2" name="ecNum2" type="password" size="11" maxlength="7"></input>
							<td><label id="ecNumResult"></label></td>
						</td>
					</tr>

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
						<td></td>
						<td>
							<input name="mailAccept" id="mailAccept" type="checkbox" value="N"><label for="mailAccept">이메일 수신 동의</label> 
							<input name="smsAccept" id="smsAccept" type="checkbox" value="N"><label for="smsAccept">문자수신 동의</label> 
						</td>

					</tr>

					
					<tr>
						<td><b>주소</b></td>
						<td colspan="2">
							<input type="text" size="80" id="addres" name="address" class="postcodify_address postcodify" readonly placeholder="주소입력" />	
						</td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2"><input type="text" size="80" id="eAddress" name="eAddress" class="extra_info" placeholder="상세주소"></td>
						
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

		var eId = document.getElementById("eId");
		var idResult = document.getElementById("idResult");
		var pwd = document.getElementById("pwd");
		var pwdResult1 = document.getElementById("pwdResult1");
		var pwd2 = document.getElementById("pwd2");
		var pwdResult2 = document.getElementById("pwdResult2");
		var eName = document.getElementById("eName");
		var nameResult = document.getElementById("nameResult");
		var ecNum1 = document.getElementById("ecNum1");
		var ecNum1 = document.getElementById("ecNum2");
		var yy = ecnum1.subString(0,2);
		var mm = ecnum1.subString(2,4);
		var dd = ecnum1.subString(4.6);
		var gender = ecnum2.subString(0,1);
		var ck = 0;
		var ecNumResult = document.getElementById("ecNumResult");
		var email1 = document.getElementById("email1");
		var email2 = document.getElementById("email2");
		var emailResult = document.getElementById("emailResult");

		$(function(){
			$(eId).on('blur', function(e){
			
				
				if(!(/^[a-z0-9]{4,}$/.test(eId.value))){
					$(idResult).text("사용할 수 없는 아이디 입니다.");
					eId.value="";
					
								
				}else{
					$(idResult).text("사용 가능한 아이디 입니다.");
				}
				
				/*
				$.ajax({
					
					url : "idCheckEmp.me",
					type : "post",
					data : {userId : userId.val()},
					success : function(result){
						
						if(result == "fail"){
							$(idResult).text("사용할 수 없는 아이디 입니다.");
							id.value="";
						}else{
							$(idResult).text("사용 가능한 아이디 입니다.");
						}
					}
					
				});
				*/


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

			$(eName).on('blur', function(e){
				if(!(/^[가-힣]{2,5}$/.test(eName.value))){
					$(nameResult).text("성명을 확인 해주세요.");
					eName.value="";
				}
			});
			
			
			$(ecNum1).on('blur', function(e){
				if(yy < 20 || mm < 1 || mm > 12 || dd < 0 || dd > 31){
					$(ecNumResult).text("주민등록번호를 확인해주세요.");
					ecNum1.value="";
				}
							
			});
			/*
			$(ecNum2).on('blur', function(e){
				if(){
					
				}
				
			});
			*/

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


			/*
			if($("#mailAccept").is(":checked")){
				$("#mailAccept").value("");
				$("#mailAccept").value("Y");
			}

			if($("#smsAccept").is(":checked")){
				$("#smsAccept").value("");
				$("#smsAccept").value("Y");
			}
			*/
			
		});
			
		function maxLengthCheck(object){
   			if (object.value.length > object.maxLength){
    			object.value = object.value.slice(0, object.maxLength);
   			}   
  		}
		
		function joinValidate(){
			if($(id).val().trim().length == 0){
				$(idResult).text("아이디를 입력해주세요");
				$(id).focus();
				return false;
			}
			
			if($(pwd).val().trim().length == 0){
				$(pwdResult1).text("비밀번호를 입력해주세요");
				return false;
			}
			
			if($(pwd2).val().trim().length == 0){
				$(pwdResult2).text("비밀번호를 입력해주세요");
				return false;
			}
			
			if($(ename).val().trim().length == 0){
				$(nameResult).text("이름을 입력해주세요");
				return false;
			}
			
			
			
			
			
		}
		



	
	</script>



</body>
</html>