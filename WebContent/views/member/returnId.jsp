<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = (String)request.getAttribute("userId");
	int kind = (int)(request.getAttribute("kind"));
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%if(kind == 1){%>
		<label>회원님의 아이디는 <%= userId %> 입니다.</label>		
		<%}else{ %>
		<label>회원님의 아이디는 <%= userId %> 입니다.</label>		
		<%} %>
		
			
	</div>
</body>
</html>