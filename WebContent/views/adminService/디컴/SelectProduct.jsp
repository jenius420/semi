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
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>


	

<div id="div">

	<div id="header"><%@ include file="../common/header.jsp"%>
		<div class="jumbotron" id="jumbotron">
	      <div class="container">
	      	<br /><br /><br /><br /><br /><br /><br /><br />
	      </div>
	 	</div>
 	</div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../adminService/AdminServiceMenubar.jsp"%></div>
		
		<div id="content-center">
	
	등록 페이지와 형태는 동일
	
	수정 updateProduct.as input 4개다
	취소-뒤로가기
	
	코드 이름 내용 비용

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->

</body>
</html>