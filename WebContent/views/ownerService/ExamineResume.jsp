<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="empService.model.vo.Resume"%>
<%
	Resume resume = (Resume)request.getAttribute("resume");

int rNum = resume.getrNum();
String eName = resume.geteName();
String phone = resume.getPhone();
String email = resume.getEmail();
String district = resume.getDistrict();
String type = resume.getType();
String comment = resume.getComment();
Date updateDate = resume.getUpdateDate();
String desireForm = resume.getDesireForm();
int desireIncome = resume.getDesireIncome();
String edu = resume.getEdu();
%>
<!DOCTYPE html ">
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>



<div id="div">

	<div id="header"><%@ include file="../common/header.jsp"%>
		<div class="jumbotron" id="jumbotron">
	      <div class="container">
	      	<br /><br /><br /><br /><br /><br /><br /><br />
	      </div>
	 	</div>
 	</div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../ownerService/OwnerServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
	기본적으로 이력서 등록 페이지랑 같게 구성
	화면 하단에 채용/반려 가능 passYn.os 호출 input P or F + applyNum
	채용/반려 취소(상태를 CHECK로 수정) checkResume.os 호출 iuput rNum

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->
</body>
</html>