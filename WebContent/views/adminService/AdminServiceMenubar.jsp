<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리서비스 메뉴바</title>
<style>
  .esMenubar li{
        color: plum;
        cursor: pointer;
        width: 15%;
        height: 100%;
        margin-right: 0;
        padding-right: 0;
		size:30px;        
        
    }

    .esMenubar span{
        color: purple;
        font-weight: bold;
    }
   	
   	.space{
   		height: 30px;
   	}
</style>
</head>
<body>

<div class="esMenubar">
    <div>
        <span>회원 관리</span>
       	<div class="esLink" onclick="location.href='<%=request.getContextPath()%>/memList.as';">회원 관리</div> 회원들 컬럼 정리해야함
    </div>
    <div class="space"></div>
    <div>
        <span>공고 관리</span>
        <ul>
            <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/ingIncruit.as';">진행중 공고</div>
            <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/doneIncruit.as';">지난 공고</div>
            <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/manageProduct.as';">공고 상품 관리</div>
        </ul>
    </div>
    <div class="space"></div>
    <div>
        <span>게시판 관리</span>
        <ul>
        	<div class="esLink" onclick="location.href='<%=request.getContextPath()%>/boardReportList.as';">게시글 신고내역</div>
        	<div class="esLink" onclick="location.href='<%=request.getContextPath()%>/commentReportList.as';">댓글 신고내역</div>
        </ul>
    </div>
    <div class="space"></div>
    <div>
        <span>관리자 정보</span>
        <ul>
            <li>정보 변경</li>
        </ul>
    </div>

</div>
    
</body>
</html>