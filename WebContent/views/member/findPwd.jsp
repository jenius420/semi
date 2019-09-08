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
<title>비밀번호 찾기</title>
<style>
    form{
        /* border: 1px solid black; */
        width: 390px;
        resize: none;
        margin-left: auto;
        margin-right: auto;
        margin-top: 50px;
        text-align: center;
    }

    input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;

	}

    .btn{
        height: 50px;
        width: 130px;
        border:none;
        background: rgb(176, 18, 241); 
    }

    #findId{
        height: 65px;
    }



</style>

</head>
<body>

	<div>
        <form action="findPwd.me" method="post">
            <div align="center">
                <span><input type="radio" name="kind" value="1" id="emp" checked><label for="emp">개인회원</label></span>
                <span><input type="radio" name="kind" value="2" id="own"><label for="own">기업회원</label></span>
            </div>

            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="id" id="id" maxlength="15"></td>
                    <td rowspan="3"><button type="submit" id="findId" class="btn btn-secondary">비밀번호찾기</button></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="name" id="name" maxlength="5"></td>
                </tr>
                <tr>
                    <td>주민번호</td>
                    <td>
                        <input id="ecNum1" name="ecNum1" type="number"  style="width:85px;" oninput="maxLengthCheck(this)" maxlength="6"></input> - 
                        <input id="ecNum2" name="ecNum2" type="password" style="width:85px;" maxlength="7"></input>
                    </td>
                </tr>
                <tr>

                </tr>
            </table>
            <br>
            <div class="btn-group" role="group" aria-label="First group" align="center">
                <button type="button" class="btn btn-secondary" onclick="window.open('findId.jsp', '_self', '비밀번호 찾기')">아이디 찾기</button>
                <button type="button" class="btn btn-secondary" onclick="window.open('joinSelect.jsp', '_self', '회원가입')">회원가입</button>
            </div>
        </form>

    </div>

    <script>
        function maxLengthCheck(object){
   			if (object.value.length > object.maxLength){
    			object.value = object.value.slice(0, object.maxLength);
   			}   
  		}
    
    
    </script>



</body>
</html>