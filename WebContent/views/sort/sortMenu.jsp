<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
	/* ArrayList<> list = (ArrayList<>)request.getAttribute("list"); */ /* 구인글 리스트 넣기 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정렬</title>
</head>
<style>
	a{
	 	text-decoration:none;
	}
 	div{
 		float:right;
 	}
 	.sorta{
 		color:purple;
 	}
 	.sorta:hover{
 		text-decoration:underline;
 	}
</style>
<body>

	<div>
       <a class="sorta" id="recently">등록일순</a>
       <a class="sorta" id="hourly">시급순</a>
       <a class="sorta" id="dayly">일급순</a>
       <a class="sorta" id="monthly">월급순</a>
       <a class="sorta" id="yearly">연봉순</a>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<script>
	
		// 1. 등록일순 출력하는 함수
		$(function(){
	 		$("").click(function(){
			
	 		});
	 	});
		// 2. 시급순 출력하는 함수
		function hourly(){
			
		}
		
		// 3. 일급순 출력하는 함수
		function dayly(){
			
		}
		
		// 4. 월급순 출력하는 함수
		function monthly(){
			
		}
		
		// 5. 연봉순 출력하는 함수
		function yearly(){
			
		}
	
	</script>
</body>
</html>