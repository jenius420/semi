<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.Appliant"%>
<%
	ArrayList<Appliant> list = (ArrayList<Appliant>)request.getAttribute("list");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>지원자 관리</title>
</head>
<body>


<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../ownerService/OwnerServiceMenubar.jsp"%></div>
		
		<div id="content-center">

진행중/마감 탭으로 보이도록
진행중은 공고 클릭시 지원자리스트가 나옴. 클릭시(examineResume.os input rnum) 해당 이력서로 넘어가서  채용/반려 선택
마감은 그냥 공고리스트만 볼 수 있도록


			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->

</body>
</html>