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
<title>회원가입 선택</title>

<style>

    div{
        /* border: 1px solid black; */
        
        text-align: center;
        margin-left: auto;
        margin-right: auto;
        
    }

    table{
        /* border: 1px solid black; */
        background: rgb(176, 19, 242);
        border-radius: 10px 10px 10px 10px;
        color: white;
    }

    td{
        vertical-align: middle;
        width: 350px;
        height: 45px;
        
    }

    .btn{
        background: rgb(176, 19, 242);
        width: 200px;
        border: none;
    }



</style>


</head>
<body>

    <div>
            <h2>회원가입</h2>
            <br>
        <table>
            <tr>
                <th><h4>개인회원</h4></th>
                <th><h4>기업회원</h4></th>
            </tr>
            <tr>
                <td>알바정보가 필요한 분</td>
                <td>알바생정보가 필요한 분</td>
            </tr>
            </table>
            
            <br>
            
            <table>
                <tr>
                    <td>
                        <button type="button" class="btn btn-secondary" onclick="empJoinMember();">개인회원 회원가입</button>
                    </td>
                    
                    <td>
                        <button type="button" class="btn btn-secondary" onclick="ownerJoinMember();">기업회원 회원가입</button>
                        
                    </td>

                </tr>
            </table>
        </div>
        
        <script>
        

        	function empJoinMember(){
        		
        		//window.opener.location.href = "<%= contextPath %>/views/member/ownerJoinMember.jsp";
        		window.opener.location.href = "<%= contextPath %>/empJoinMember.me";
        		window.close();
        		
        	}

        	function ownerJoinMember(){
        		
        		//window.opener.location.href = "<%= contextPath %>/views/member/ownerJoinMember.jsp";
        		window.opener.location.href = "<%= contextPath %>/ownerJoinMember.me";
        		
        		window.close();
        		
        	}
        
        
        </script>

  

</body>
</html>