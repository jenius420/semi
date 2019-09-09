<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#jumbotron {
	background-image:
		url('<%=request.getContextPath()%>/resources/images/slide2.jpg');
}
</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div></div>
	<div class="jumbotron" id="jumbotron">
		<div class="container">
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
		</div>
	</div>
	<br />
	<br />
<div align="center" style="width: 100%;">
<div><h1>현재 비밀번호를 입력하세요</h1></div>
<input type="password" id="pwd" />
<button onclick="changePwd();">확인</button>
</div>

<script>
	function changePwd() {
		var pwd= $('#pwd').val();
		if(pwd=='<%=loginUser.getePwd()%>'){
			location.href='<%=request.getContextPath()%>/updateEmp.me';
		}else{
			alert('비밀번호가 틀립니다');
			$('#pwd').focus();
		}
	}
</script>
</body>
</html>