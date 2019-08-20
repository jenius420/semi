<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<% String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>
<body>

	<div>
        <img src="../resources/image/errorIcon.jpg" art="error" width="400">
		<h1>Error :(</h1>
		<h4><%= msg %></h1>
	</div>
	
	<div>
		<div onclick="<%response.sendRedirect("index.jsp");%>">메인으로</div>
		<div onclick="history.back();">이전 화면으로</div>
	</div>

</body>
</html>