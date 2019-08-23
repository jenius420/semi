<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이력서 선택</title>
</head>
<body>

<input type="button" value="테스트" onclick="sendChildValue();" />

<script>
	function sendChildValue(){
		
	   	 var name = document.getElementById("id").innerHTML;
	    
		 opener.setChildValue(name); // 비동기처리
		
		 window.close();
	
	 }
</script>


</body>
</html>