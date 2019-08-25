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
<title>이력서 보기</title>
</head>
<body>

	작성 페이지와 비슷
	 수정 updateResume.es
	 삭제 deleteResume.es
	 
	 사진예제
	 
	 <div id="titleImgArea" align="center">
		<img id="titleImg" src="<%= request.getContextPath() %>/resources/uploadFiles/<%= at.getChangeName() %>">
	</div>

</body>
</html>