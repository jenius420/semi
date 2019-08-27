<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.IncruitProduct"%>
<%
	ArrayList<IncruitProduct> list = (ArrayList<IncruitProduct>)request.getAttribute("list");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>공고 상품 관리</title>
</head>
<body>


	
	
<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../adminService/AdminServiceMenubar.jsp"%></div>
		
		<div id="content-center">
	상품 리스트 출력
	
	등록 
	<button onclick="Location.href='<%= request.getContextPath()%>/enrollProduct.as'">등록하기</button>

	클릭시 수정페이지 이동  selectProduct.as  input pCode
	
	
	삭제는 없는걸로 
	

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->

</body>
</html>