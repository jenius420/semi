<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member)session.getAttribute("loginUser");
	
	int kind = m.getKind();
	int no;
	if(kind == 1){
		no = m.geteNum();
	}else{
		no = m.getoNum();
	}
	

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title>Insert title here</title>

<style>
    
    .btn{
        height: 50px;
        width: 130px;
        background: rgb(176, 19, 242);
        color: white;
        border: none;
    }

    form{
        text-align: center;
    }

    h1{
        font-size: 50px;
    }

    h2{
        font-size: 25px;
    }

    p{
        font-size: 15px;
    }

</style>

</head>
<body>
	<div id="header"><%@ include file="../common/header.jsp"%>
		<div class="jumbotron" id="jumbotron">
	      <div class="container">
	      	<br /><br /><br /><br /><br /><br /><br /><br />
	      </div>
	 	</div>
     </div>
     
     <div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
 	
    <div class="outer">
        <h1 align="center">회원탈퇴</h1>
        <br>
        <h2 align="center">회원 탈퇴 시 아래 사항을 확인 해주세요.</h2>
    
        <hr>
        <form onsubmit="deleteValidate();" method="post" action="<%= request.getContextPath()%>/delete.me ">
            
            <h2>1. 해당 아이디로 재가입 불가능</h2>
            <p>회원탈퇴를 하시면 해당 아이디는 즉시탈퇴 처리되며 동일한 아이디로 재가입/로그인이 불가능 합니다.</p>

            <h2>2. 회원정보 및 서비스 정보 삭제</h2>
            <p>
                회원탈퇴 시 즉시 회원님의 모든 정보가 삭제 됩니다. <br>
                    단, 공공적 성격의 게시물은 삭제되지 않으므로 삭제를 원하실 경우 삭제를 완료하신 후 탈퇴를 신청하시기 바랍니다.
            </p>
           

            <br>
            <p align="center">알바문 고객센터</p>
            <p align="center" style="color:rgb(176, 19, 242)">010-3514-1361</p>

            <p align="center"><input type="checkbox" id="checkbox"><label for="checkbox">안내사항을 모두 확인 하였으며, 이에 동의합니다.</label></p>
			
			<input type="hidden" name="kind" value="<%=kind%>">
			<input type="hidden" name="no" value="<%=no%>">
            
            <br>
            <hr>
            <br>
            <div id="btn" align="center">
                <button type="submit" name="insertBtn" class="btn btn-secondary" disabled>회원탈퇴</button>
            </div>
            
            </div> <!-- /메인콘텐트 -->
			
			<div id="content-right"></div>
		
			</div> <!-- /콘텐트 -->
		
			<div id="footer"><%@ include file="../common/footer.jsp" %></div>
            
            
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