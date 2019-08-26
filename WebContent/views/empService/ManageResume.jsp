<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="emp.model.vo.Emp, empService.model.vo.Resume, java.util.ArrayList"%>
	
<%
Emp emp = (Emp) session.getAttribute("loginUser");
String name = emp.geteName();

ArrayList<Resume> list = (ArrayList<Resume>)request.getAttribute("list");

for(Resume r : list){
	// 본문에 이력서의 컬럼들 출력
}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>이력서 관리</title>
</head>
<body>


<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			
	이력서 리스트 출력
	이력서 선텍 selectResume.es input rNum
	<br>
	<%= name %>

	<div id="makeResume" onclick="location.href='<%=request.getContextPath()%>/makeResume.es';">이력서 작성하기</div>

	<div>
		* 권고사항 

	</div>
			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
	



</body>
</html>