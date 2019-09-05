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
<title>아이디 찾기</title>
<style>
    form{
        /* border: 1px solid black; */
        width: 390px;
        resize: none;
        margin-left: auto;
        margin-right: auto;
        margin-top: 50px;

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
        <form form id="findIdForm" onsubmit="return Validate();" method="post" action="<%= request.getContextPath()%>/findId.me ">
            <div align="center">
                <span><input type="radio" name="kind" value="1" id="emp" checked><label for="emp">개인회원</label></span>
                <span><input type="radio" name="kind" value="2" id="own"><label for="own">기업회원</label></span>
            </div>

            <table>
                
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="name" id="name" maxlength="15"></td>
                    <td rowspan="2"><button type="submit" id="findId" class="btn btn-secondary" onclick="findId();">아이디찾기</button></td>
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
            <div>
                <div class="btn-group" role="group" aria-label="First group">
                    <button type="button" class="btn btn-secondary" onclick="location.href=<%= contextPath %>/findId.me">아이디 찾기</button>
                    <button type="button" class="btn btn-secondary" onclick="location.href=<%= contextPath %>/findPwd.me">비밀번호 찾기</button>
                    <button type="button" class="btn btn-secondary" onclick="window.open('joinSelect.jsp', '_self', '회원가입')">회원가입</button>
                </div>
                
            </div>




        </form>
    </div>

    <script>

        var ecNum1 = document.getElementById("ecNum1");
        var ecNum2 = document.getElementById("ecNum2");
        
        function maxLengthCheck(object){
   			if (object.value.length > object.maxLength){
    			object.value = object.value.slice(0, object.maxLength);
   			}   
  		}
        
        function login(){
            if($("#name").val().trim().length == 0){
                alert("아이디를 입력해주세요.");
                $("#name").focus();
                return false;
            }
            
            if($("#ecNum1").val().trim().length == 0){
                alert("주민등록번호를 입력해주세요");
                $("#ecNum1").focus();
                return false;
            }
            
            if($("#ecNum2").val().trim().length == 0){
                alert("주민등록번호를 입력해주세요");
                $("#ecNum2").focus();
                return false;
            }

            var arrNum1 = new Array();
            var arrNum2 = new Array();

            for (var i=0; i<ocNum1.value.length; i++) {
                arrNum1[i] = ocNum1.value.charAt(i);
            } // 주민번호 앞자리를 배열에 순서대로 담는다.

            for (var i=0; i<ocNum2.value.length; i++) {
                arrNum2[i] = ocNum2.value.charAt(i);
            } // 주민번호 뒷자리를 배열에 순서대로 담는다.

            var tempSum=0;

            for (var i=0; i<ocNum1.value.length; i++) {
                tempSum += arrNum1[i] * (2+i);
            } // 주민번호 검사방법을 적용하여 앞 번호를 모두 계산하여 더함

            for (var i=0; i<ocNum2.value.length-1; i++) {
                if(i>=2) {
                    tempSum += arrNum2[i] * i;
                }
                else {
                    tempSum += arrNum2[i] * (8+i);
                }
            } // 같은방식으로 앞 번호 계산한것의 합에 뒷번호 계산한것을 모두 더함

            if((11-(tempSum%11))%10!=arrNum2[6]) {
                alert("주민등록번호를 확인 해주세요.");
                ocNum1.value = "";
                ocNum2.value = "";
                return false;
            }else{
                $(ocNumResult).text("");
            }
        }
        
        
    
    
    </script>



</body>
</html>