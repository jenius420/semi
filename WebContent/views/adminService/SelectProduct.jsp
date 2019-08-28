<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.IncruitProduct"%>
<%
	IncruitProduct prod = (IncruitProduct)request.getAttribute("prod");

int pCode = prod.getpCode();
String pTitle = prod.getpTitle();
String pExplain = prod.getpExplain();
int pPay = prod.getpPay();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>공고 상품 수정</title>
</head>
<body>


	

<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../adminService/AdminServiceMenubar.jsp"%></div>
		
		<div id="content-center">
	
	등록 페이지와 형태는 동일
	
	수정 updateProduct.as input 4개다
	취소-뒤로가기
	
	

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->

</body>
</html>