<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.model.vo.OwnerMember"%>
<%@ include file="../ownerService/OwnerServiceMenubar.jsp"%>
<%	
	OwnerMember owner= (OwnerMember) session.getAttribute("loginUser");
	Boolean accessAuth = true;
	String opName = ""; // 업체명
	String type = ""; // 업직종
	String oName = ""; // 업자명
	int phone = 0; // 전화번호
	
	if(owner == null){
		accessAuth = false;
	}else{
		opName = owner.getOpName();
		type = owner.getType();
		oName = owner.getoName();
		phone = owner.getPhone();
	}
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공고 작성</title>
</head>
<body>

	<form id="incruitForm" action="<%=request.getContextPath()%>/submitIncruit.os" method="POST">
		
		제목 <input type="text" name="incruitTitle" id="incruitTitle"
			placeholder="공고 제목">
			
		업체명 <%= opName %>
		업직종 <%= type %>
		업자명 <%= oName %>
		전화번호 <%= phone %>
		
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
		
		사진
		
		하고싶은말
		<textarea name="comment" id="comment" cols="30" rows="10"></textarea>
		
		이력서공개설정 
		<input type="checkbox" name="openSet" id="openSet"  value="Y" checked>
		
		<input type="submit" value="저장완료">
		<input type="reset" value="초기화">
		<button onclick="history.back();">이전 화면으로</button>

	</form>

각 항목 수정
공고상품 검색해서 삽입하는 부분은 ajax 배운 후에 가능

</body>
</html>