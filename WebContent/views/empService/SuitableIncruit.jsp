<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<title>이력서 맞춤 알바</title>
</head>
<body>



<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
				
비동기 배우고나서 함

이력서 선택 버튼 > 팝업으로 선택 처리
<div id="selectResume" onclick="selectResume();">이력서 선택</div>
<script>
    function selectResume(){
        window.open("여기에 팝업 여는 서블릿으로 처리해야함.인풋=empnum views/empService/SelectResumePU.jsp", "이력서 선택", "width=1000, height=300, left=100, top=50");
    }
    function setChildValue(value){
        document.getElementById("test").innerHTML = value;
    }
</script>

선택한 이력서의 간략한 정보 출력 (선택 전에는 숨김) > 팝업에서 선택한 정보를 가져와야함 : 서블릿 추가
공고 리스트 > 그 정보에 맞는 조건쿼리로 리스트 가져와야 함 selectSuitableIncruit.es 호출 input rNum...... 이부분 어려운데 비동기로 해야할지?
공고 선택 시 watchingIncruit2.es input wNum

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
	


</body>
</html>