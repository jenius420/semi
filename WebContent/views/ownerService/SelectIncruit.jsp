<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.Incruit"%>
<%
Incruit incruit = (Incruit)request.getAttribute("incruit");

int wNum = incruit.getwNum();
String wTitle = incruit.getwTitle();
String opName = incruit.getOpName();
Date workStartTerm = incruit.getWorkStartTerm();
Date wprlEndTerm = incruit.getWorkEndTerm();
String workDay = incruit.getWorkDay();
String workStartTime = incruit.getWorkStartTime();
String workEndTime = incruit.getWorkEndTime();
String term = incruit.getTermName();
String gender = incruit.getGender();
int age = incruit.getAge();
String edu = incruit.getEdu();
Date enrollDate = incruit.getEnrollDate();
String status = incruit.getStatus();
Date doneDate = incruit.getDoneDate();
String salaryForm = incruit.getSalaryForm();
int salary = incruit.getSalary();
String product = incruit.getProduct();
String description = incruit.getDescription();
int peopleCount = incruit.getPeopleCount();
String dong = incruit.getDong();
String district = incruit.getDistrict();
String type = incruit.getType();

%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>공고 보기</title>
</head>
<body>




<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../ownerService/OwnerServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
수정 updateIncruit.os (등록날짜,마감날짜는 수정못함) wnum, incruit객체
마감 closeIncruit.os input wNum
목록으로

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->

</body>
</html>