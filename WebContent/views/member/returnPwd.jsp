<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int kind = (Integer)request.getAttribute("kind");
String name = (String)request.getAttribute("name");
String cNum=(String)request.getAttribute("cNum");
String id= (String)request.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title>비밀번호 변경</title>
<style>
    .outer{
        /* border: 1px solid black; */
        width: 390px;
        resize: none;
        margin-left: auto;
        margin-right: auto;
        margin-top: 50px;
    }

    .btn{
        height: 80px;
        width: 120px;
        background: rgb(176, 19, 242);
        border: none;  
    }

    td{
        width: 250px;
        height: 50px;
        resize: none;
    }
    
    input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
	}

</style>


</head>
<body>
    <div>
        <form id="updatePwd" onsubmit="return Validate();" method="post" action="<%= request.getContextPath()%>/changePwd.me ">

            <table>
                
                <tr>
                    <td>
                        새로운 <br> 
                        비밀번호
                        <input type="hidden" name ="kind" value="<%=kind %>" />
                        <input type="hidden" name ="name" value="<%=name %>" />
                        <input type="hidden" name ="id" value="<%=id %>" />
                        <input type="hidden" name ="cNum" value="<%=cNum %>" />
                    </td>
                    <td><input type="password" name="pwd" id="pwd" maxlength="15"></td>
                    <td rowspan="2"><button type="submit" id="findId" class="btn btn-secondary" onclick="returnPwd();">비밀번호 <br> 변경</button></td>
                </tr>
                <tr>
                    <td>
                        비밀번호 <br>
                        확인
                    </td>
                    <td>
                        <input id="pwd2" name="pwd2" type="password"  maxlength="7"></input>
                    </td>
                </tr>
                
            </table>

            
        </form>
    </div>
</body>
</html>