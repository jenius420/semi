<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int kind = (Integer)request.getAttribute("kind");
	String id= (String)request.getAttribute("id");

%>
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
    .outer{
        /* border: 1px solid black; */
        
        text-align: center;
        margin-left: auto;
        margin-right: auto;
        width: 410px;
        height: 250px;
        resize: none;
        
    }

    form{
        
        /* border: 1px solid black; */
        width: 500px;
        resize: none;
    }

    table{

        background: white;
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
        font-size: 15px;
    }
    .btn{
        height: 50px;
        width: 200px;
        background: rgb(176, 19, 242);
        border: none;
        
    }

</style>
</head>
<body>
    <div class="outer">
        
        <form action="<%= request.getContextPath() %>/updatePwd.me" method="post" onsubmit="retrun validate();">
                <h3 align="center">비밀번호 변경</h3>
        
                <hr>
            <table>
                <tr>
                    <td width="150"><b>현재 비밀번호</b></td>
                    <td><input name="pwd" id="pwd" type="password" size="28" maxlength="16" placeholder="8~16자 영문, 숫자, 특수문자 입력"></input></td>
                    <td width="170px"><label id="pwdResult1"></label></td>
                </tr>
        
                <tr>
                    <td><b>새로운비밀번호</b></td>
                    <td><input id="newPwd" type="password" size="28" maxlength="16" placeholder="새로운 비밀번호"></td>		
                    <td><label id="pwdResult2"></label></td>
                </tr>

                <tr>
                    <td><b>비밀번호확인</b></td>
                    <td><input id="newPwd2" type="password" size="28" maxlength="16" placeholder="비밀번호 확인"></td>
                    <td><label id="pwdResult3"></label></td>
                </tr>

            </table>

            <br>
            
            <div align="center"><b>안전한 비밀번호를 사용하는 방법!</b></div>

            <br>

            <ul>
                <li>영문, 숫자, 특수기호 3자기 모두 조합하세요.</li>
                <li>아이디와 동일한 비밀번호는 사용하지 마세요.</li>
                <li>개인정보를 포함하는 비밀번호는 사용하지 마세요.</li>
                <li>비밀번호는 주기적으로 변경해주세요</li>
            </ul>


            <br>
            
            <input type="hidden" name ="kind" value="<%=kind %>" />
            <input type="hidden" name ="id" value="<%=id %>" />

            <div style="text-align:center">
                <button type="submit"  name="insertBtn" class="btn btn-secondary">수정완료</button>
            </div>

        </form>

    </div>

	<script type="text/javascript">

        var pwd = document.getElementById("pwd");
        var newPwd = document.getElementById("newPwd");
        var newPwd2 = document.getElementById("newPwd2");
        var pwdResult1 = document.getElementById("pwdResult1");
        var pwdResult2 = document.getElementById("pwdResult2");
        var pwdResult3 = document.getElementById("pwdResult3");

		$(pwd).on('blur', function(e){

			if(!(/^[a-zA-Z0-9!@#$%^&*]{8,}$/.test(pwd.value))){
									
				$(pwdResult1).text("비밀번호를 확인 해주세요.");					
				pwd.value="";
				//pwd.focus();
			}else{
				
				$(pwdResult1).text("");
				
			}
		});
			
		$(newPwd).on('blur', function(e){

			if(!(/^[a-zA-Z0-9!@#$%^&*]{8,}$/.test(pwd.value))){
									
				$(pwdResult2).text("비밀번호를 확인 해주세요.");					
				newPwd.value="";
				newPwd2.value="";
				//pwd.focus();
			}else{
				
				$(pwdResult2).text("사용 가능한 비밀번호 입니다.");
				
			}
		});
		
		$(newPwd2).on('blur', function(e){
			if(newPwd.value != newPwd2.value){
				
				$(pwdResult3).text("비밀번호가 일치 하지 않습니다.");
				newPwd.value="";
				newPwd2.value="";
				// pwd.focus();
			}else{
				
				$(pwdResult3).text("비밀번호가 일치 합니다.");
			}
		});
		
		
			
	
		function validate(){
			
			if($(pwd).val().trim().length == 0){
				$(pwdResult1).text("");
				$(pwdResult1).text("비밀번호를 입력해주세요");
				$(pwd).focus();
                return false;
			}
			
			if($(newPwd).val().trim().length == 0){
				$(pwdResult2).text("");
				$(pwdResult2).text("비밀번호를 입력해주세요");
				$(newPwd).focus();
                return false;
			}
			
			if($(newPwd2).val().trim().length == 0){
				$(pwdResult3).text("");
				$(pwdResult3).text("비밀번호를 입력해주세요");
				$(newPwd2).focus();
                return false;
			}

			
		}
	
	
	</script>
	


</body>
</html>