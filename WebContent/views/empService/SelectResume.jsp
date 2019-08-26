<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="empService.model.vo.Resume, common.model.vo.Attachment"%>
<%
Resume resume = (Resume)request.getAttribute("resume");

int rNum = resume.getrNum();
String eName = resume.geteName();
int phone = resume.getPhone();
String email = resume.getEmail();
String district = resume.getDistrict();
String type = resume.getType();
String comment = resume.getComment();
Date updateDate = resume.getUpdateDate();
String desireForm = resume.getDesireForm();
int desireIncome = resume.getDesireIncome();
String edu = resume.getEdu();


Attachment at = (Attachment)request.getAttribute("at");

%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>이력서 보기</title>
</head>
<body>	
	
<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			

	작성 페이지와 비슷
	 수정 updateResume.es input resume,at
	 삭제 deleteResume.es input rNum
	 
	 사진예제
	 <div id="titleImgArea" align="center">
		<img id="titleImg" src="<%= request.getContextPath() %>/<%= at.getChangeName() %>">
	</div>
	
	
			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
	

</body>
</html>