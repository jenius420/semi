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
		
	   	 var name = document.getElementById("id").innerHTML;
	    
		 opener.setChildValue(name); // 비동기처리
		
		 self.close();
	
	 }
	
	$(function(){
		  $('#confirm_id').click(function(){

		    $(opener.document).find('#id').val('리턴값');

		    self.close();
		  });
		 });

</script>


</body>
</html>