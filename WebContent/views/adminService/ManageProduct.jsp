<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공고 상품 관리</title>
</head>
<body>

	상품 리스트 출력
	
	등록 
	<button onclick="Location.href='<%= request.getContextPath()%>/enrollProduct.as'">등록하기</button>

	클릭시 수정페이지 이동 input pCode
	selectProduct.as
	
	삭제는 없는걸로 

</body>
</html>