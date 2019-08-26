<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, ownerService.model.vo.Incruit, owner.model.vo.Owner"%>
<%
ArrayList<Owner> oList = (ArrayList<Owner>)request.getAttribute("oList");
ArrayList<Incruit> wList = (ArrayList<Incruit>)request.getAttribute("wList");
%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>관심 기업</title>
</head>
<body>


	
	
<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
	조회: 관심기업 테이블 생성

	추가: 팝업으로 비동기(중복안되게)
	삭제: 각 열 옆에 삭제 버튼 deleteInterestOwnerServlet.es input oNum
	
	공고 클릭 시 watchingIncruit2.es input wnum

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->

</body>
</html>