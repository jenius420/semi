<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>인재 검색</title>
</head>
<body>

	
	
	

<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../ownerService/OwnerServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		

	output 해당 조건에 맞는 이력서 리스트
	
	호출서블랫: searchResumeList.os input 필터(district,type,desireForm,desireIncome,finalEdu), keyword
	
	이력서 선택시 해당 이력서 보여주기 watchingResume.os input rNum (아님 이거 같은 화면에 비동기로 보여줄지?)

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
	
</body>
</html>