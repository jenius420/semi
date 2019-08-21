<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="output">
				<form onsubmit="return validate();" method="post" action="<%= request.getContextPath()%>/empInsert.me ">
				<br>
				<h2>회원가입</h2>
					
				<b>이용약관에 모두 동의 합니다</b>
				<td colspan="3"><input type="checkbox">
					
				<hr>
	
	
				
	
				<br><br>
	
				<table class="table2">
					
	
					<tr>
						<td><b>아이디</b></td>
						<td><input type="text" size="28" maxlength="15" placeholder="4~15자 영문, 숫자 입력"></input></td>
						<td><label></label></td>
					</tr>
			
					<tr>
						<td><b>비밀번호</b></td>
						<td><input type="password" size="28" maxlength="16" placeholder="8~16자 영문, 숫자 입력"></input></td>
						<td><label></label></td>
					</tr>
			
					<tr>
						<td><b>비밀번호확인</b></td>
						<td><input type="password" size="28" maxlength="16" placeholder="비밀번호 확인"></td>		
						<td><label></label></td>
					</tr>
	
					<tr>
						<td><b>성명</b></td>
						<td><input type="text" size="28" maxlength="5" placeholder="성명입력"></input></td>
					
					</tr>
				
					<tr>
						<td><b>주민등록번호</b></td>
						<td>
							<input type="text" size="10" maxlength="6" placeholder=""></input> - 
							<input type="password" size="11" maxlength="7" placeholder=""></input>
							<td><div></div></td>
						</td>
					</tr>
	
					<tr>
						<td><b>메일주소</b></td>
						<td>
							<input type="email" size="10"></input> @ 
							<select>
								<option>gmail.com</option>
								<option>naver.com</option>
								<option>daum.net</option>
								<option>nate.com</option>
							</select>
							
						</td>
						<td><input type="checkbox" value="checkEmail"> 이메일 수신 동의</td>
						
					</tr>
					<tr>
						<td><b>휴대전화</b></td>
						<td>
							<select>
								<option>010</option>
								<option>011</option>
								<option>016</option>
								<option>017</option>
								<option>018</option>
								<option>019</option>
							</select> - 
							<input type="text" size="5" maxlength="4"> -
							<input type="text" size="5" maxlength="4">
						</td>
						<td><input type="checkbox" value="checkPhone"> 문자수신 동의</td>
						
					</tr>
	
	
			
	
					
			
				</table>
				<br><br>
				<div id="btn">
					<button type="submit" name="insertBtn" class="btn btn-secondary">회원가입</button>
					<button type="reset" name="insertBtn" class="btn btn-secondary">다시입력</button>
				</div>
			</form>
		</div>

</body>
</html>