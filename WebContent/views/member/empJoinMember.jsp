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

	input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    
}



</style>



</head>
<body>

	


	<div class="output">
		<br>
		<h2 align="center">개인회원 가입</h2>
		
		<!--<b>이용약관에 모두 동의 합니다</b>
		<input type="checkbox">-->
			
			<hr>
			
			
			
			
			<br><br>
			
			<form id="joinForm" onsubmit="return joinValidate();" method="post" action="<%= request.getContextPath()%>/empInsert.me ">
				<table class="table2">
				

					<tr>
						<td><b>아이디</b></td>
						<td><input name="id" id="id" type="text" size="35" maxlength="15" placeholder="4~15자 영문, 숫자(영문 소문자 시작)"></input></td>
						<td width="170px"><label id="idResult"></label></td>
					</tr>

					<tr>
						<td><b>비밀번호</b></td>
						<td><input name="pwd" id="pwd" type="password" size="35" maxlength="16" placeholder="8~16자 영문, 숫자, 특수문자 입력"></input></td>
						<td><label id="pwdResult1"></label></td>
					</tr>
			
					<tr>
						<td><b>비밀번호확인</b></td>
						<td><input id="pwd2" type="password" size="35" maxlength="16" placeholder="비밀번호 확인"></td>		
						<td><label id="pwdResult2"></label></td>
					</tr>

					<tr>
						<td><b>성명</b></td>
						<td><input id="name" name="name" type="text" size="35" maxlength="5" placeholder="성명 입력"></input></td>
						<td><label id="nameResult"></label></td>
					</tr>
				
					<tr>
						<td><b>주민등록번호</b></td>
						<td>
							<input id="ecNum1" name="ecNum1" type="number" size="13" maxlength="6" placeholder=""></input> - 
							<input id="ecNum2" name="ecNum2" type="password" size="14" maxlength="7" placeholder=""></input>
							<td><label id="ecNumResult"></label></td>
						</td>
					</tr>

					<tr>
						<td><b>메일주소</b></td>
						<td>
							<input id="email1" name="email1" type="text" size="17"></input> @
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
							<input type="number" size="23" maxlength="8" placeholder="- 제외하고 입력 해주세요">
						</td>
						<td></td>
						
					</tr>

					<tr>
						<td></td>
						<td>
							<input name="mailaccept" type="checkbox" value="checkEmail"> 이메일 수신 동의
							<input name="smsaccept" type="checkbox" value="checkPhone"> 문자수신 동의</td>
						</td>

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

		var id = document.getElementById("id");
		var idResult = document.getElementById("idResult");
		var pwd = document.getElementById("pwd");
		var pwdResult1 = document.getElementById("pwdResult1");
		var pwdw = document.getElementById("pwdw");
		var pwdResult2 = document.getElementById("pwdResult2");
		var name = document.getElementById("name");
		var nameResult = document.getElementById("nameResult");
		var email1 = document.getElementById("email1");
		var email2 = document.getElementById("email2");
		var emailResult = document.getElementById("emailResult");

		function onreset(){
			
		}

		$(function(){
			$(id).on('blur', function(e){
				
				if(!(/^[a-z0-9]{4,}$/.test(id.value))){
					$(idResult).text("사용할 수 없는 아이디 입니다.");
					
					id.focus();
								
				}else{
					$(idResult).text("사용 가능한 아이디 입니다.");
				}


			});

			$(pwd).on('blur', function(e){

				if(!(/^[a-zA-Z0-9!@#$%^&*]{8,}$/.test(pwd.value))){
					$(pwdResult1).text("비밀번호를 확인 해주세요.");					
					pwd.value="";
					pwd2.value="";
					pwd.focus();
				}else{
					$(pwdResult1).text("사용 가능한 비밀번호 입니다.");
					
				}
			});
			
			$(pwd2).on('blur', function(e){
				if(pwd.value != pwd2.value){
					$(pwdResult2).text("비밀번호가 일치 하지 않습니다.");
					pwd.value="";
					pwd2.value="";
					pwd.focus();
				}else{
					$(pwdResult2).text("비밀번호가 일치 합니다.");
				}
			});

			$(name).on('blur', function(e){
				if(!(/^[가-힣]{2,5}$/.test(name.value))){
					$(nameResult).text("성명을 확인 해주세요.");
					name.focus();
				}
			});


			$(email1).on('blur', function(e){
				if(!(/^[a-z0-9]{,}$/.test(email1.value))){
					$(emailResult).text("이메일을 확인 해주세요");
					email1.value="";
					email1.focus();
				}

			});







			
		});
			




	
	</script>



</body>
</html>