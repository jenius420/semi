<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="empService.model.vo.Resume, common.model.vo.Attachment"%>
<%
Resume resume = (Resume)request.getAttribute("resume");

int rNum = resume.getrNum();
String eName = resume.geteName();
String address = resume.getAddress();
String phone = resume.getPhone();
String email = resume.getEmail();
String district = resume.getDistrict();
String type = resume.getType();
String comment = resume.getComment();
Date updateDate = resume.getUpdateDate();
String desireForm = resume.getDesireForm();
int desireIncome = resume.getDesireIncome();
String edu = resume.getEdu();
String openSet = resume.getOpenSet();


Attachment at = (Attachment)request.getAttribute("at");

%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이력서 보기</title>
<link href="resources/form/css/form.css" rel="stylesheet" media="all">
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
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
		<div class="outer">

			<form action="<%=request.getContextPath()%>/submitResume.es;" method='get' class='speaker-form'  enctype="multipart/form-data">
		
				<div class='form-row' id="fileArea" style="margin-bottom:20px;">
				  <label class="lLabel" for="photo" style="vertical-align: bottom;">사진</label>
				<img id="titleImg" dth="100" height="100" src="<%=request.getContextPath()%>/photo/resumeImage/<%= at.getChangeName() %>">
				  <input type="file" multiple name="photo" id="photo" onchange="loadImg(this);">  
				  </div>

	
				<div class='form-row'>
				  <label class="lLabel">이름</label><p class="rLabel" style="width:180px;"><%=eName %></p>
				</div>
				<div class='form-row'>	
				  <label class='lLabel'>전화번호</label><p class="rLabel"><%=phone %></p>
				</div>
				<div class='form-row'>
				  <label class='lLabel'>주소</label><p class="rLabel"><%=address %></p>
				</div>
				<div class='form-row'>
				  <label class='lLabel'>이메일</label><p class="rLabel"><%=email %></p>
				</div>
				<div style="height:30px;"></div>
				
	
				<div class='form-row'>
				  <label for='districtNum'>희망근무지(구)</label>
				  <select id='districtNum' name='districtNum'>
				  		<option><%=district %></option>
				  </select>
				</div>
				
				<div class='form-row'>
				  <label for='typeNum'>희망업종</label>
				  <select id='typeNum' name='typeNum' style="width:300px;">
				  		<option ><%=type%></option>
				  </select>
				</div>
				
				<div class='form-row'>
				  <label for='eduNum'>최종학력</label>
				  <select id='eduNum' name='eduNum'>
				    <option ><%=edu%></option>
				  </select>
				</div>
				
				<div class='form-row'>
				  <label for='desireForm'>희망 급여</label>
				  <select id='desireForm' name='desireForm'>
				    <option ><%=desireForm%></option>
				  </select>
				  <input id='desireIncome' name='desireIncome' type='text' style="margin-left:20px;" value="<%=desireIncome %>" readonly/>
				  <label for='desireIncome' style="text-align:left">원</label>
				  
				</div>

				<div class='form-row'>
				  <label for='comment'>하고싶은 말</label>
				  <textarea id='comment' name='comment' readonly><%=comment %></textarea>
				</div>
	
				<div class='form-row'>
				  <label class='checkbox-label' for='openSet'>
				  <%if(openSet.equals("Y")){ %>
				  	<input id='openSet' name='openSet' type='checkbox' value='Y' checked />
				  <%}else{ %>
				  	<input id='openSet' name='openSet' type='checkbox' value='Y'/>
				  <%} %>
				  <span>이력서 공개 설정</span>
				  </label>
				</div>
				
				<div class='form-row'>

				  <button type="button" class="btn" onclick="deleteResume(<%=rNum %>);">삭제</button>
				  <button type="button" class="btn" onclick="javascript:history.back();" style="margin-left:20px; padding-left:30px; padding-right:30px;">뒤로가기</button>
				</div>
				
			</form>
		</div>
		
		<script>
			function deleteResume(rNum){
				if(confirm("삭제 하시겠습니까")){
					location.href='<%=request.getContextPath()%>/deleteResume.es?rNum='+rNum;
				}else{
					return;
				}
			}
		</script>
		
	'changeName='+'<%=at.getChangeName()%>'
			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->
	

</body>
</html>