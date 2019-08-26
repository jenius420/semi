<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, empService.model.vo.EmpEvaluation, empService.model.vo.EmpEvaluationBefore"%>
<%
ArrayList<EmpEvaluation> empEval = (ArrayList<EmpEvaluation>)request.getAttribute("empEval");
ArrayList<EmpEvaluationBefore> empEvalBf = (ArrayList<EmpEvaluationBefore>)request.getAttribute("empEvalBf");
 %>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>알바 후기 관리</title>
</head>
<body>


<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		

탭형식으로 이미작성한평가/아직미작성평가 출력
작성한 평가 - 삭제 deleteEval.es input sevalNum
미작성평가 - 작성 makeEmpEval.es input onum, applyNum

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->


</body>
</html>