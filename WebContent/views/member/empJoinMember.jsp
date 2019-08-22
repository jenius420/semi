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
<title>Insert title here</title>
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


</style>



</head>
<body>

	


	<div class="output">
		<br>
		<h2 align="center">개인회원 가입</h2>
		
		//<b>이용약관에 모두 동의 합니다</b>
		//<td colspan="3"><input type="checkbox">
			
			<hr>
			
			
			
			
			<br><br>
			
			<form id="joinForm" onsubmit="return joinValidate();" method="post" action="<%= request.getContextPath()%>/empInsert.me ">
				<table class="table2">
				

					<tr>
						<td><b>아이디</b></td>
						<td><input name="eId" id="eId" type="text" size="28" maxlength="15" placeholder="4~15자 영문, 숫자(영문 소문자 시작)"></input></td>
						<td><label id="eIdResult"></label></td>
					</tr>

					<tr>
						<td><b>비밀번호</b></td>
						<td><input name="ePwd" id="ePwd" type="password" size="28" maxlength="16" placeholder="8~16자 영문, 숫자, 특수문자 입력"></input></td>
						<td><label id="pwdResult1"></label></td>
					</tr>
			
					<tr>
						<td><b>비밀번호확인</b></td>
						<td><input id="pwd" type="password" size="28" maxlength="16" placeholder="비밀번호 확인"></td>		
						<td><label id="pwdResult2"></label></td>
					</tr>

					<tr>
						<td><b>성명</b></td>
						<td><input id="eName" name="eName" type="text" size="28" maxlength="5" placeholder="성명 입력"></input></td>
						<td><label id="nameResult"></label></td>
					</tr>
				
					<tr>
						<td><b>주민등록번호</b></td>
						<td>
							<input name="ecNum1" type="text" size="10" maxlength="6" placeholder=""></input> - 
							<input name="ecNum2" type="password" size="11" maxlength="7" placeholder=""></input>
							<td><label></label></td>
						</td>
					</tr>

					<tr>
						<td><b>메일주소</b></td>
						<td>
							<input name="email1" type="text" size="10"></input> @
							<select name="email2"> 
								<option value="@gmail.com">gmail.com</option>
								<option value="@naver.com">naver.com</option>
								<option value="@daum.net">daum.net</option>
								<option value="@nate.com">nate.com</option>
							</select>
							
						</td>
						<td><input name="mailaccept" type="checkbox" value="checkEmail"> 이메일 수신 동의</td>
						
					</tr>
					<tr>
						<td><b>휴대전화</b></td>
						<td>
							<select name="phone1">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="107">017</option>
								<option value="108">018</option>
								<option value="109">019</option>
							</select> - 
							<input type="text" size="5" maxlength="4"> -
							<input type="text" size="5" maxlength="4">
						</td>
						<td><input name="smsaccept" type="checkbox" value="checkPhone"> 문자수신 동의</td>
						
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
		var eIdResult = document.getElementById("eIdResult");
		var ePwd = document.getElementById("ePwd");
		var pwdResult1 = document.getElementById("pwdResult1");
		var pwd = document.getElementById("pwd");
		var pwdResult2 = document.getElementById("pwdResult2");
		var eName = document.getElementById("eName");
		var nameResult = document.getElementById("nameResult");



		function onreset(){
			
		}

		$(function(){
			$(eId).on('blur', function(e){
				
				if(!(/^[a-z][a-z0-9]{3,}$/.test(eId.value))){
					$(eIdResult).text("사용할 수 없는 아이디 입니다.");
					eId.focus();
								
				}else{
					$(eIdResult).text("사용 가능한 아이디 입니다.");
				}
			});

			$(ePwd).on('blur', function(e){

				if(!(/^[a-zA-Z0-9!@#$%^&*]{8,16}$/.test(ePwd.value))){
					$(pwdResult1).text("비밀번호를 확인 해주세요.");
					ePwd.focus();
					ePwd.value="";
					pwd.value="";
				}else{
					$(pwdResult1).text("사용 가능한 비밀번호 입니다.");
					
				}
			});
			
			$(pwd).on('blur', function(e){
				if(ePwd.value != pwd.value){
					$(pwdResult2).text("비밀번호가 일치 하지 않습니다.");
					ePwd.value="";
					pwd.value="";
					ePwd.focus();
				}else{
					$(pwdResult2).text("비밀번호가 일치 합니다.");
				}
			});

			$(eName).on('blur', function(e){
				if(!(/^[가-힣]{2,5}$/.test(eName.value))){
					$(nameResult).text("성명을 확인 해주세요.");
					eName.focus();
				}else{
					$(nameResult).text(eName.value);
				}
			});

			


			
		});
			




	
	</script>



</body>
</html>