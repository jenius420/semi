<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = (String)request.getAttribute("userId");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
label{
font-size:  30px;
text-align: center;

}
.a{
color:purple;
font-style: bold;
}
</style>
</head>
<body>
	<div style="padding-top: 100px; padding-left:100px">
		<label>회원님의 아이디는 <label class="a"><%= userId %></label> 입니다.</label>			
	</div>
</body>
</html>