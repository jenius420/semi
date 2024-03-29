<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.util.ArrayList, java.text.SimpleDateFormat"%>
<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
%>

<!DOCTYPE html>
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/display.css">

<style>

.osMenubar{
	position: fixed;
	left: 0x;
	top: 350px;
	clear: both;
    margin: 0;
    padding: 10px !important;
    width: 170px;
    
}

.osm1{
 	padding: 6px 14px;
    background-color: rgb(176,18,241);
    color: white;
    height:35px;
    font-weight:bold;
    text-shadow: 2px 8px 6px rgba(0,0,0,0.2), 0px -3px 20px rgba(255,255,255,0.4);
}

.osLink{
    color: #000;
    padding: 8px 17px;
    cursor: pointer;
    font-size: 14px;
    background-color: #f1f1f1;
}

.osLink:hover:not(.active) {
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

<div class="osMenubar">

    <div>
        <div class="osm1">공고</div>
        <div class="osLink" onclick="location.href='<%=request.getContextPath()%>/incruitList.os';">공고 리스트</div>
        <div class="osLink" onclick="location.href='<%=request.getContextPath()%>/makeIncruit.os';">공고 등록</div>
    </div>
    
    <div class="space"></div>
    
    <div>
        <div class="osm1">인재 관리</div>
        <div class="osLink" onclick="location.href='<%=request.getContextPath()%>/manageEmp.os';">지원자 관리</div>
        <div class="osLink" onclick="location.href='<%=request.getContextPath()%>/searchResume.os';">이력서 검색</div>
    </div>
    
    <div class="space"></div>
    
    <div>
        <div class="osm1">기업 상품</div>
        <div class="osLink" onclick="location.href='<%=request.getContextPath()%>/incruitProduct.os';">공고 상품</div>
    </div>
    
    <div class="space"></div>
    
    <div>
        <div class="osm1">회원 정보</div>
		<div class="osLink" onclick="location.href='<%=request.getContextPath()%>/';">회원 정보 변경</div>
		<div class="osLink" onclick="location.href='<%=request.getContextPath()%>/deleteForm.me'">회원탈퇴</div>
    </div>
    
    <div class="space"></div>

</div>
    
</body>
</html>