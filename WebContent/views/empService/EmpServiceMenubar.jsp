<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.text.SimpleDateFormat, emp.model.vo.Emp" %>
<%
	Emp emp = (Emp) session.getAttribute("loginUser");

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인서비스 메뉴바</title>
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
        <span>이력서</span>
       	<div class="esLink" onclick="location.href='<%=request.getContextPath()%>/manageResume.es';">이력서 관리</div>
        <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/makeResume.es';">이력서 작성</div>
        <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/suitableRecruit.es';">이력서 맞춤 알바</div>
    </div>
    <div class="space"></div>
    <div>
        <span>알바 활동</span>
        <ul>
            <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/applicationState.es';">알바 지원 현황</div>
            <div class="esLink" onclick="location.href='<%=request.getContextPath()%>/empEvaluationManagement.es';">알바 후기 관리</div>
        </ul>
    </div>
    <div class="space"></div>
    <div>
        <span>관심 정보</span>
        <ul>
        	<div class="esLink" onclick="location.href='<%=request.getContextPath()%>/interestOwner.es';">관심 기업</div>
        </ul>
    </div>
    <div class="space"></div>
    <div>
        <span>회원 정보 관리</span>
        <ul>
            <li>회원 정보 변경</li>
        </ul>
    </div>

</div>
    
</body>
</html>