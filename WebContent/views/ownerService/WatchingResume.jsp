<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="empService.model.vo.Resume, common.model.vo.Attachment"%>
<%
Resume resume = (Resume)request.getAttribute("resume");

Attachment at = (Attachment)request.getAttribute("at");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이력서 검색 조회</title>
</head>
<body>

	기본적으로 이력서 등록 페이지랑 같게 구성
	
	하단에 확인(뒤로가기)버튼만. 혹은 비동기시 따로 버튼 필요 없음
	
	<div id="titleImgArea" align="center">
		<img id="titleImg" src="<%= request.getContextPath() %>/resources/uploadFiles/<%= at.getChangeName() %>">
	</div>


</body>
</html>