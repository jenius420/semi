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

.asMenubar{
	position: fixed;
	left: 0x;
	top: 350px;
	clear: both;
    margin: 0;
    padding: 10px !important;
    width: 170px;
    

}
.asm1{
 	padding: 6px 14px;
    background-color: rgb(176,18,241);
    color: white;
    height:35px;
    font-weight:bold;
    text-shadow: 2px 8px 6px rgba(0,0,0,0.2), 0px -3px 20px rgba(255,255,255,0.4);
}
.asLink{
    color: #000;
    padding: 8px 17px;
    cursor: pointer;
    font-size: 14px;
    background-color: #f1f1f1;
}

.asLink:hover:not(.active) {
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

<div class="asMenubar">

    <div>
        <div class="asm1">회원 관리</div>
       	<div class="asLink" onclick="location.href='<%=request.getContextPath()%>/empList.as';">구직자 회원 관리</div>
       	<div class="asLink" onclick="location.href='<%=request.getContextPath()%>/ownerList.as';">사업자 회원 관리</div>
    </div>
    <div class="space"></div>
    
    <div>
        <div class="asm1">공고 관리</div>
        <!-- <div class="asLink" onclick="location.href='<%=request.getContextPath()%>/ingIncruit.as';">진행중 공고</div> -->
        <!-- <div class="asLink" onclick="location.href='<%=request.getContextPath()%>/doneIncruit.as';">지난 공고</div> -->
        <div class="asLink" onclick="location.href='<%=request.getContextPath()%>/manageProduct.as';">공고 상품 관리</div>
    </div>
    <div class="space"></div>
    
    <!--  
    <div>
        <div class="asm1">게시판 관리</div>
      	<div class="asLink" onclick="location.href='<%=request.getContextPath()%>/boardReportList.as';">신고 글 리스트</div>
      	<div class="asLink" onclick="location.href='<%=request.getContextPath()%>/commentReportList.as';">신고  댓글 리스트</div>
    </div>
    <div class="space"></div>
	-->

</div>
    
</body>
</html>