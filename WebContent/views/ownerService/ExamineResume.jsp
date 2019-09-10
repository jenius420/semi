<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="empService.model.vo.Resume,common.model.vo.Attachment,ownerService.model.vo.Appliant"%>
<%
	Resume resume = (Resume)request.getAttribute("resume");
	Attachment at = (Attachment)request.getAttribute("at");
	Appliant appliant = (Appliant)request.getAttribute("ap");
	
	String ap = appliant.getPassOrFail();
%>
<!DOCTYPE html ">
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/form/css/form.css" rel="stylesheet" media="all">

<style>

.divArea{
display: inline-block;
}

#comment{
background-color: #f6f2fa; 
border-color: #f6f2fa;
min-height: 120px; 
font-weight: 700; 
font-size: inherit; 
padding:1px; 
width:250px;
}

.rlabel{
width:auto !important;
text-align: left !important;
}

button{
margin:10px !important;
}

</style>

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
		
			<div class="outer" style="">
				
				<form action="" method='get' class='speaker-form' style="width: auto; height:auto; margin-left:-200px;">
				
					<div class="divArea" style="vertical-align: top;">
					
						<div class='form-row' id="fileArea" style="margin-bottom:20px; margin-left:60px;">
							<img id="titleImg"  width="200" height="200" src="<%=request.getContextPath()%>/photo/resumeImage/<%= at.getChangeName() %>">
						</div>
		
						<div class='form-row'>
						  <label class="lLabel">이름</label>
						  <p class="rLabel" style="width:180px;"><%=resume.geteName() %></p>
						</div>
						<div class='form-row'>	
						  <label class='lLabel'>나이/성별</label>
						  <p class="rLabel"><%=resume.getAge() %> <%=resume.getGender() %></p>
						</div>
						<div class='form-row'>	
						  <label class='lLabel'>전화번호</label>
						  <p class="rLabel"><%=resume.getPhone() %></p>
						</div>
						<div class='form-row'>
						  <label class='lLabel'>주소</label>
						  <p class="rLabel"><%=resume.getDistrict() %> <%=resume.getRoadName() %> <%=resume.getRoadMain() %> <%=resume.getAddress() %></p>
						</div>
						<div class='form-row'>
						  <label class='lLabel'>이메일</label>
						  <p class="rLabel"><%=resume.getEmail() %></p>
						</div>
						
						<div style="height:30px;"></div>
						
						<div class='form-row'>
							<%if(ap.equals("C") || ap.equals("UC")) {%>
							  <button type="button" class="btn" onclick="passYn('P');" >합격</button>
							  <button type="button" class="btn" onclick="passYn('F');" >탈락</button>
							<%}else if(ap.equals("P")){%>
								<button type="button" class="btn" onclick="passYn('C');">합격 취소</button>
							<%}else if(ap.equals("F")) {%>
								<button type="button" class="btn" onclick="passYn('C');">탈락 취소</button>
							<%} %>
							  <button type="button" class="btn" onclick="location.href='<%=request.getContextPath()%>/manageEmp.os';" >뒤로가기</button>
						</div>
						
					</div>
				
				
					<div class="divArea" style="vertical-align:bottom;" >
						
						<div class='form-row'>
						  <label >공고명</label>
						  <p class="rLabel"><%=appliant.getwTitle() %></p>
						</div>
						
						<div class='form-row'>
						  <label >공고 마감일</label>
						  <p class="rLabel"><%=appliant.getEndDate()%></p>
						</div>
						
						<div class='form-row'>
						  <label>현재 상태</label>
						  <p class="rLabel" style="color:purple; font-style: bold;">
							<%if(appliant.getPassOrFail().equals("UC")){%>
								사장님 확인전
							<%}else if(appliant.getPassOrFail().equals("C")){%>
								사장님 확인함
							<%}else if(appliant.getPassOrFail().equals("P")){%>
								합격
							<%}else if(appliant.getPassOrFail().equals("F")){%>
								탈락
							<%}%>
						  </p>
						</div>
					
						<div style="height:50px;"></div>
			
						<div class='form-row'>
						  <label >지원일</label>
						  <p class="rLabel"><%=appliant.getApplyDate() %></p>
						</div>
						
						<div class='form-row'>
						  <label for='districtNum'>희망근무지(구)</label>
						  <p class="rLabel"><%=resume.getDistrict() %></p>
						</div>
						
						<div class='form-row'>
						  <label for='typeNum'>희망업종</label>
						  <p class="rLabel"><%=resume.getType() %></p>
						</div>
						
						<div class='form-row'>
						  <label for='eduNum'>학력</label>
						  <p class="rLabel"><%=resume.getEdu() %></p>
						</div>
						
						<div class='form-row'>
						  <label for='desireForm'>희망 급여</label>
						  <p class="rLabel"><%=resume.getDesireForm()%> <%=resume.getDesireIncome()%>원</p>
						  
						</div>
		
						<div class='form-row'>
						  <label for='comment'>하고싶은 말</label>
						  <textarea id='comment' name='comment' cols="40" rows="7"  readonly ><%=resume.getComment()%></textarea>
						</div>
						
					</div>
					
				</form>
				
			</div>
	
			<script>
				function passYn(Yn){
					location.href='<%=request.getContextPath()%>/passYn.os?passYn='+Yn+'&applyNum='+<%=appliant.getApplyNum()%>;
				}
			</script>

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->
</body>
</html>