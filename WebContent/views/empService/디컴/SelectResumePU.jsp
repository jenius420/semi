<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>이력서 선택</title>
</head>
<body>

<input type="button" value="테스트" onclick="sendChildValue();" />

<script>
	function sendChildValue(){
		
	   	 var name = 123;
	    
	   	 
	   	location.href="<%=request.getContextPath()%>/watchingIncruit2.es?wNum=" + num;
	   	
		 opener.setChildValue(name); // 비동기처리
		
		 window.close();
	
	 }
	


</script>


</body>
</html>