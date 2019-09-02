<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title>Insert title here</title>

<style>
    #btn{
        text-align: center;
    }

    .btn{
        height: 50px;
        width: 130px;
        background: rgb(176, 19, 242);
        border: none;
    }

</style>

</head>
<body>

    <div>
        <h3 align="center">회원탈퇴</h3>

        <h5 align="center">회원 탈퇴 시 아래 사항을 확인 해주세요.</h5>
    
        <hr>
        <form onsubmit="deleteValidate();" method="post" action="<%= request.getContextPath()%>/delete.me ">
            <h4>1. 해당 아이디로 재가입 불가능</h4>
            <p>회원탈퇴를 하시면 해당 아이디는 즉시탈퇴 처리되며 동일한 아이디로 재가입/로그인이 불가능 합니다.</p>

            <h4>2. 회원정보 및 서비스 정보 삭제</h4>
            <p>
            	회원탈퇴 시 즉시 회원님의 모든 정보가 삭제 됩니다. <br>
               	 단, 공공적 성격의 게시물은 삭제되지 않으므로 삭제를 원하실 경우 삭제를 완료하신 후 탈퇴를 신청하세기 바랍니다.
            </p>

            <br>
            <p align="center">알바문 고객센터</p>
            <p align="center" style="color:rgb(176, 19, 242)">010-3514-1361</p>

            <p align="center"><input type="checkbox" id="checkbox"><label for="checkbox">안내사항을 모두 확인 하였으며, 이에 동의합니다.</label></p>


            <div id="btn">
                <button type="submit" name="insertBtn" class="btn btn-secondary" disabled>회원탈퇴</button>
            </div>
            
            <script>
                
                /*
                if($(".checkbox").is("checked") == true){
                    $(".btn").prop("disabled", false);
                }else{
                    $(".btn").prop("disabled", true);
                }
                */
                
                /*
                $(".checkbox").is("checked", function(){
                    $(".btn").attr("disabled" , false);
                });
                */

                $("#checkbox").change(function(){
                    if($("#checkbox").is(":checked")){
                        $(".btn").prop("disabled", false);
                    }else{
                        $(".btn").prop("disabled", true);
                    }
                });


            
            </script>



        </form>
    </div>
</body>
</html>