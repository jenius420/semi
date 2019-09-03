<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.text.SimpleDateFormat" %>
<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
<link rel="stylesheet" type="text/css" href="resources/css/display.css">
<script src="resources/table/vendor/jquery/jquery-3.2.1.min.js"></script>
<title>개인서비스 메뉴바</title>
<style>
	
.esMenubar{
	position: fixed;
	left: 0x;
	top: 300px;
	clear: both;
    margin: 0;
    padding: 10px;
    width: 170px;
   

}
.esm1{
 	padding: 6px 14px;
    background-color: rgb(176,18,241);
    color: white;
    height:35px;
    font-weight:bold;
    text-shadow: 2px 8px 6px rgba(0,0,0,0.2), 0px -3px 20px rgba(255,255,255,0.4);
}
.esLink{
    color: #000;
    padding: 8px 17px;
    cursor: pointer;
    font-size: 14px;
     background-color: #f1f1f1;
}

.esLink:hover:not(.active) {
    background-color: #ddccff;
    color: white;
    text-shadow: 2px 2px 2px gray;
}
.space{
	height: 14px;
	
}

</style>
</head>
<body>

<div class="esMenubar">
    <div>
    	<div class="esm1">이력서</div>
       	<div class="esLink" onclick="location.href='<%=request.getContextPath()%>/manageResume.es';">이력서 관리</div>
        <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/makeResume.es';">이력서 작성</div>
        <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/suitableIncruit.es';">이력서 맞춤 알바는 후순위..</div>
    </div>
    <div class="space"></div>
    
    <div>
        <div class="esm1">알바 활동</div>
        <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/applicationState.es';">알바 지원 현황</div>
        <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/empEvaluationManagement.es';">알바 후기 관리</div>
   	</div>
    <div class="space"></div>
    
    <div>
        <div class="esm1">관심 정보</div>
       	<div class="esLink" onclick="location.href='<%=request.getContextPath()%>/interestOwner.es';">관심 기업</div>
	</div>
    <div class="space"></div>
    
    <div>
        <div class="esm1">회원 정보</div>
        <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/';">회원 정보 변경</div>
    </div>
    <div class="space"></div>

</div>
    
</body>
</html>