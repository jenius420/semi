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
<title>Insert title here</title>
<style>
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

    #postcodify{
        font-size: 10px;
    }

    #postcodify:hover{
        cursor: pointer;
    }


</style>
</head>
<body>
    <b>
        
        <form action="">
                <h3 align="center">정보 수정</h3>
        
                <hr>
            <table>
                <tr>
                    <td width="150"><b>아이디</b></td>
                    <td width="170px"><label id=""></label></td>
                </tr>
        
                <tr>
                    <td><b>비밀번호</b></td>
                    <td><input id="newpwd" type="password" size="28" maxlength="16" placeholder="현재 비밀번호를 입력하세요"></td>		
                </tr>

            </table>

            <hr>

            <table class="table2">				

                <tr>
                    <td><b>성명</b></td>
                    <td><input id="name" name="name" type="text" size="35" maxlength="5"></input></td>
                    <td><label id="nameResult"></label></td>
                </tr>
            

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
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <input name="mailaccept" type="checkbox" value="checkEmail"> 이메일 수신 동의
                        <input name="smsaccept" type="checkbox" value="checkPhone"> 문자수신 동의</td>
                    </td>
                </tr>

                <tr>
                    <td><b>주소</b></td>
                    <td colspan="2"><input type="text" id="address" size="35" id="postcodify" name="" class="postcodify_address" readonly placeholder="주소입력" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="text" size="35" id="details" name="" class="extra_info" placeholder="상세주소"></td>
                    
                </tr>


        </table>
            

            <br>

            <div style="text-align:center">
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

        
    </script>
    

</body>
</html>