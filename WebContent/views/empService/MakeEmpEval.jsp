<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, empService.model.vo.EmpEvaluation"%>
<%
int applyNum = (int)request.getAttribute("applyNum");
int oNum = (int)request.getAttribute("oNum");
ArrayList<EmpEvaluation> list = (ArrayList<EmpEvaluation>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>알바 후기 작성</title>
</head>
<body>


	
<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		

	기업 간단 정보
	해당 기업에 대한 평가들
	
	내 평가 입력 제출 submitEmpEval.es input applyNum,oNum,point,comment
	

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->

</body>
</html>