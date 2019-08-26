<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.Incruit"
%>
<%
	ArrayList<Incruit> list = (ArrayList<Incruit>)request.getAttribute("list");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>공고 리스트</title>
<style>


</style>
</head>
<body>

<div id="div">
	
	<div id="header"></div>
	
		<div id="content">
		
		<div id="content-left"><%@ include file="../ownerService/OwnerServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			단순 리스트 출력
			탭형식으로 진행중/마감된 나누면 좋겠음
			클릭시 selectIncruit.os input wnum
			
			<div class="tableArea"></div>
			</div>
		
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
	
	<div id="footer"></div>

</div> <!-- /화면 -->

	

</body>
</html>