<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>지원자모음에서 이력서 조회</title>
</head>
<body>



<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../ownerService/OwnerServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
	기본적으로 이력서 등록 페이지랑 같게 구성
	화면 하단에 채용/반려 가능(value P or F + applyNum) passYn.os 호출
	채용/반려 취소(상태를 CHECK로 수정) checkResume.os 호출

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
</body>
</html>