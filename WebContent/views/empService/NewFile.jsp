<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

서블렛에서 서블렛 호출
//response.sendRedirect("manageResume.es"); 이런식으로 서블렛을 바로 부를 수도 있고
//response.sendRedirect("manageResume.es?empNum="+empNum); 해당서블렛에서 사용될 변수가 있으면 이렇게 추가하면 됨

스트링형태로 변환
String.valueOf(asdfasdf); 

이전페이지로
onclick="history.go(-1);"

<!-- 게시글 마우스오버/클릭 시 스크립트 -->
<script>
	$(function(){
		$("#listArea td(선택자)").mouserenter(function(){
			$(this).parent().css({"background":"하고싶은색", "cursor":"pointer"});
		}).mouseout(function(){
			$(this).parent().css("background","원래색");
		}).click(function(){
			var num = $(this).parent().children().eq(0).text();
			location.href="<%=request.getContextPath()%>/test.no?tNum=" + num;
		});
	});
	
	서블렛에서는 아래로 받아줘야함
	int tNum = Integer.parseInt(requset.getParameter("tNum"));

</script>



서블릿에 안 보이게 넘기는 방법
<form action="" id="id" method="post">
	<input type="hidden" name="num" value ="<%=num %>">
</form>
<script>
	function f(){
		$("#id").attr("action", "<%=request.getContextPath()%>/servlet.so");
		$("#id").submit();
	}
</script>



</body>
</html>