<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="empService.model.vo.Emp, ownerService.model.vo.Owner"%>
<%
	ArrayList<Emp> empList = (ArrayList<Emp>)request.getAttribute("empList");
	ArrayList<Owner> ownerList = (ArrayList<Owner>)request.getAttribute("ownerList");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="charset=UTF-8">

<title>회원 리스트</title>

</head>
<body>



<div id="div">

	<div id="header"></div>
	
	<div id="content">
	
		<div id="content-left"><%@ include file="../adminService/AdminServiceMenubar.jsp"%></div>
		
		<div id="content-center">
			구직자/사업자  탭으로 구분하여 출력
			경고 warnMem.as(구직자만 경고 가능한지 결정해야함) input String[] memArr, flag 1구직자 2사업자
			탈퇴 deleteMem.as  input String[] memArr, flag 1구직자 2사업자
		</div>
		
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
	
	<div id="footer"></div>

</div> <!-- /화면 -->

</body>
</html>