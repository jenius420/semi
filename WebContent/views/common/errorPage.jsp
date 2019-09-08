<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<% String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
	<style>
		
		.goMain,.goBack{
			background:rgb(176,18,241);
			color:white;
		}	
		.goMain:hover,.goBack:hover{
			background: violet;
			cursor: pointer;
		}
	</style>
</head>
<body>
	
	<div>
        <img src="../resources/images/errorIcon.jpg" art="error" width="400">
		<h1>Error :(</h1>
		<h4><%= msg %></h4>
	</div>
	
	<div>
		  <div class="goMain" onclick="location.href='<%=request.getContextPath()%>'">메인으로</div>
		<div class="goBack" onclick="history.back();">이전 화면으로</div>
	</div>

</body>
</html>