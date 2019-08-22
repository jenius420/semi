<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	 <div>
	 	<img src="<%=request.getContextPath() %>/resources/uploadFiles/<%=at.getSaveName() %>" width="200" height="150">
	 </div>

</body>
</html>