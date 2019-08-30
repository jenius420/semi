<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String contextPath = request.getContextPath();

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
<title>로그인창</title>
<style>

    form{
        /* border: 1px solid black; */
        width: 390px;
        resize: none;
        margin-left: auto;
        margin-right: auto;
        margin-top: 50px;

    }

    #userId, #userPwd{
        height: 35px;
        width: 250px;
    }

    .btn{
        height: 50px;
        width: 130px;
        border:none;
        background: rgb(176, 18, 241); 
    }

    #login{
        height: 75.5px;
    }

    #joinMember{
        font-weight: bold;    
    }



</style>

</head>
<body>

    <div>

    </div>

    <div>
        
        <form action="<%= contextPath %>/login.me" method="post" onsubmit="return validate();">
            
            <span><input type="radio" name="kind" value="1" id="emp" checked><label for="emp">개인회원</label></span>
            <span><input type="radio" name="kind" value="2" id="own"><label for="own">기업회원</label></span>
            <table>
                <tr>
                    <td><input type="text" name="userId" id="userId" maxlength="15" placeholder="아이디"></td>
                    <td rowspan="2"><button type="submit" id="login" class="btn btn-secondary">로그인</button></td>
                </tr>
                <tr>
                    <td><input type="password" name="userPwd" id="userPwd" maxlength="16" placeholder="비밀번호"></td>
                </tr>
                <tr>

                </tr>
            </table>
            <br>
            <div>
                <div class="btn-group" role="group" aria-label="First group">
                    <button type="button" class="btn btn-secondary" onclick="location.href=<%= contextPath %>/findId.me">아이디 찾기</button>
                    <button type="button" class="btn btn-secondary" onclick="location.href=<%= contextPath %>/findPwd.me">비밀번호 찾기</button>
                    <button type="button" class="btn btn-secondary" onclick="window.open('selectJoin.jsp', '_self', '회원가입')">회원가입</button>
                </div>
                
            </div>
        </form>

    </div>
    
    <script type="text/javascript">
    	function validate(){
    		if($("#userId").val().trim().length == 0){
    			alert("아이디를 입력해주세요.");
    			$("#userId").focus();
    			return false;
    		}
    		
    		if($("#userPwd").val().trim().length == 0){
    			alert("비밀번호를 입력해주세요.");
    			$("#userPwd").focus();
    			return false;
    		}
    		return true;
    	}
    	
    </script>
    

    
  

</body>
</html>