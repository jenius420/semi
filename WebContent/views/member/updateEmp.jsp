<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member)session.getAttribute("loginUser");
	String contextPath = request.getContextPath();

	String eId = m.geteId();
	String eName = m.geteName();
	String email = m.getEmail();
	String phone = m.getPhone();
	String mailAccept = m.getMailAccept();
	String smsAccept = m.getSmsAccept();
	String eAddress = m.geteAddress();
	
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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<title>Insert title here</title>
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


    .btn{
        color: white;
        background:  rgb(176, 19, 242);
        border-radius: 10px 10px 10px 10px;
        border:none;
        height: 50px;
        width: 130px;
    }


</style>
</head>
<body>
    <b>
        
        <form action="">
                <h3 align="center">정보 수정</h3>
        
                <hr>
            <table name="idPwd">
                <tr>
                    <td width="150"><b>아이디</b></td>
                    <td width="170px"><input value="<%= eId %>"></input></td>
                </tr>
        
                <tr>
                    <td><b>비밀번호</b></td>
                    <td><input id="pwd" type="password" size="28" maxlength="16" placeholder="현재 비밀번호를 입력하세요"></td>		
                </tr>

            </table>

            <hr>

            <table class="table2">				

                <tr>
                    <td><b>성명</b></td>
                    <td><input id="name" name="name" type="text" size="35" maxlength="5" readonly value="<%= eName %>"></input></td>
                    <td><label id="nameResult"></label></td>
                </tr>
            

                </tr>

                <tr>
                    <td><b>메일주소</b></td>
                    <td>
                        <input id="email1" name="email1" type="email" size="35" value="<%= email %>"></input>
                        
                    </td>
                    <td><label id="emailResult"></label></td>
                    
                </tr>
                <tr>
                    <td><b>휴대전화</b></td>
                    <td>
                        <select style="width:45px;" name="phone1">
							<option value="010" <%if(phone.substring(0,3).equals("010")) {%>selected<%} %>>010</option>
							<option value="011" <%if(phone.substring(0,3).equals("011")) {%>selected<%} %>>011</option>
							<option value="016" <%if(phone.substring(0,3).equals("016")) {%>selected<%} %>>016</option>
							<option value="017" <%if(phone.substring(0,3).equals("017")) {%>selected<%} %>>017</option>
							<option value="018" <%if(phone.substring(0,3).equals("018")) {%>selected<%} %>>018</option>
							<option value="019" <%if(phone.substring(0,3).equals("019")) {%>selected<%} %>>019</option>
						</select> - 
						<input type="number" name="phone2" style="width:50px;" oninput="maxLengthCheck(this)" maxlength="4" value<%= phone.substring(4,8) %>> -
						<input type="number" name="phone3" style="width:50px;" oninput="maxLengthCheck(this)" maxlength="4" value<%= phone.substring(9,11) %>>
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <input name="mailaccept" type="checkbox" value="checkEmail" <%if(mailAccept.equals("Y")) {%>checked<%} %>>  이메일 수신 동의
                        <input name="smsaccept" type="checkbox" value="checkPhone" <%if(smsAccept.equals("Y")) {%>checked<%} %>> 문자수신 동의</td>
                    </td>
                </tr>

                <tr>
                    <td><b>주소</b></td>
                    <td colspan="2"><input type="text" id="address" size="35" id="postcodify" name="" class="postcodify_address" readonly /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="text" size="35" id="details" name="" class="extra_info" value="<%= eAddress %>" <% %>></td>
                    
                </tr>


        </table>
            

            <br>

            <div style="text-align:center">
                <button type="button"  name="updatePwd" class="btn btn-secondary" onclick="updatePwd();">비밀번호 수정</button>
                <button type="submit"  name="insertBtn" class="btn btn-secondary">수정완료</button>
            </div>
            
        </form>

    </div>

    <!-- 검색 기능을 표시할 <div>를 생성한다 -->
    <div id="postcodify"></div>
    
    <!-- 주소와 우편번호를 입력할 <input>들을 생성하고 적당한 name과 id를 부여한다 -->
    <!-- 
    <input type="text" name="" id="postcode" value="" /><br />
    <input type="text" name="" id="address" value="" /><br />
    <input type="text" name="" id="details" value="" /><br />
    <input type="text" name="" id="extra_info" value="" /><br />
    -->
    

    <script>
        /*
        $(function() { 
            $("#postcodify_search_button").postcodifyPopUp({ forceDisplayPostcode : true }); 
        }); 
        */
         $(function() { 

             $("#postcodify").postcodifyPopUp({
        
        /*
        insertPostcode5 : "#postcode",
        insertAddress : "#address",
        insertDetails : "#details",
        insertExtraInfo : "#extra_info",
        hideOldAddresses : false
        */
            }); 

        });

        function maxLengthCheck(object){
   			if (object.value.length > object.maxLength){
    			object.value = object.value.slice(0, object.maxLength);
   			}   
  		}
        
        function updatePwd() {
			location.href="<%= contextPath %>/updatePwdForm.me"
		}

          

        
    </script>
    

</body>
</html>