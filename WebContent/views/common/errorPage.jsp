<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<% String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<style>
	
body{
background-color: #e1d0f5;
}

.goMain,.goBack{
	background:rgb(176,18,241);
	color:white;
	width: 200px;
	margin:20px;
	text-align: center;
	height:50px;

	font-weight: 600;
	border-radius: 5px;
	  display: table-cell;
        vertical-align: middle;
	
}	
.goMain:hover,.goBack:hover{
	background: violet;
	cursor: pointer;
}

.outer{
margin-left:0;
margin-right:0;
margin-top: 100px;
}

.gogo{
margin-top:100px;
display: inline-block;
width:45%;
}

.top{
display: inline-block;
width: 30%;
}

</style>

</head>

<body>
	
	<div class="outer">
		<div class="top"></div>
		<div class="top">
	        <img src="<%= request.getContextPath()%>/resources/images/error2.jpg"  width="400">
		</div>
		<div class="top" >
			<h1>Error  &nbsp;:(</h1>
			<h4 style="color:#1a0033;">"<%= msg %>"</h4>
			<h4 style="color:#350066;">"<%= msg %>"</h4>
			<h4 style="color:#5c00b3;">"<%= msg %>"</h4>
			<h4 style="color:#7700e6;">"<%= msg %>"</h4>
			<h4 style="color:#901aff;">"<%= msg %>"</h4>
			<h4 style="color:#a94dff;">"<%= msg %>"</h4>
			<h4 style="color:#c180ff;">"<%= msg %>"</h4>
			<h4 style="color:#dab3ff;">"<%= msg %>"</h4>
			<h4 style="color:#f3e6ff;">"<%= msg %>"</h4>
		</div>
	</div>
	
	<div>
		<div class="gogo"></div>
		<div class="gogo">
		<div class="goBack" onclick="history.back();">이전 화면으로</div> &nbsp;&nbsp;&nbsp;
			  <div class="goMain" onclick="location.href='<%=request.getContextPath()%>'">메인으로</div>
		</div>
		<div class="gogo"></div>
	</div>

</body>
</html>