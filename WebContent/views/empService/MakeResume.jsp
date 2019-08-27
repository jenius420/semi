<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	
	//String eName = emp.geteName();
	//int phone = emp.getPhone();
	//String address = emp.getAddress();
	//String email = emp.getEmail();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../empService/resources.jsp"%>
<title>이력서 등록</title>
</head>
<body>

<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			<form id="resumeForm" action="<%=request.getContextPath()%>/submitResume.es" method="POST" enctype="multipart/form-data">
				
				제목 <input type="text" name="resumeTitle" id="resumeTitle"
					placeholder="이력서 제목">
					
				이름
				전화번호
				이메일
				
				사진
				<div id="titleImgArea">
					<img id="titleImg" width="350" height="200">
				</div>
				
				<div id="fileArea">
					<input type="file" multiple name="thumbnailImg1" id="thumbnailImg1" onchange="loadImg(this);">
		
				</div>
				
				<script>
					
					// 파일 첨부했을 때 미리보기 공간에 미리보기 가능하게 하는 함수
					function loadImg(value){
						// value => input태그
						// num => 조건문으로 작업
						
						// file이 존재하는지 
						if(value.files && value.files[0]){
		
							var reader = new FileReader();
		
							reader.onload = function(e){	
								$("#titleImg").attr("src", e.target.result);
							}
		
							reader.readAsDataURL(value.files[0]);
							
						}
					}
				</script>
				
				희망근무지(구) 
				<select name="district" id="district">
					<option value="강남구">강남구</option>
				</select> 
				
				희망업직종 
				<select name="type" id="type">
					<option value="IT">IT</option>
				</select> 
				
				최종학력 
				<select name="edu" id="edu">
					<option value="대학졸업">대학졸업</option>
				</select> 
				
				희망급여형태 
				<select name="desireForm" id="desireForm">
					<option value="시급">시급</option>
				</select> 
				
				희망급여 
				<input type="text" name="desireIncome" id="desireIncome">원
				
				
				
				하고싶은말
				<textarea name="comment" id="comment" cols="30" rows="10" style="resize:none;"></textarea>
				
				이력서공개설정 	
				<input type="checkbox" name="openSet" id="openSet"  value="Y" checked>
				
				<input type="hidden" value="보여주면 안 되는데 같이 넘겨야 하는 경우">
				
				<input type="submit" value="저장완료" validation 작성해야함>
				<input type="reset" value="초기화">
				<button type="button" onclick="javascript:history.back();">이전 화면으로</button>
		
			</form>
			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
	

</body>
</html>