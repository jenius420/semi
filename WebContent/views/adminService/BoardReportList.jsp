<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.Board"%>
<%
	ArrayList<Board> empList = (ArrayList<Board>)request.getAttribute("list");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>게시글 신고 내역</title>
</head>
<body>



	

<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../adminService/AdminServiceMenubar.jsp"%></div>
		
		<div id="content-center">
	
	체크박스 경고 warnMem.as input String[] memArr, flag 1구직자 2사업자
	삭제 deleteBoard.as input String[] tNumArr
	

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->

</body>
</html>