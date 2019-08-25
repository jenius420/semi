<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>회원 리스트</title>

</head>
<body>



<div id="div">

	<div id="header"></div>
	
	<div id="content">
	
		<div id="content-left"><%@ include file="../adminService/AdminServiceMenubar.jsp"%></div>
		
		<div id="content-center">
				구직자/사업자  탭으로 구분하여 출력
			경고 warnMem.as(구직자만 경고 가능한지 결정해야함)
			탈퇴 deleteMem.as
		</div>
		
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
	
	<div id="footer"></div>

</div> <!-- /화면 -->

</body>
</html>