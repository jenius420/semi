<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.Incruit, ownerService.model.vo.Owner, common.model.vo.Attachment, empService.model.vo.*"%>
    
<%
Incruit i = (Incruit)request.getAttribute("incruit");
Owner owner= (Owner) request.getAttribute("owner");
Attachment at = (Attachment)request.getAttribute("at");
ArrayList<Resume> list = (ArrayList<Resume>)request.getAttribute("list");
String msg = (String)request.getAttribute("msg");
ArrayList<EmpEvaluation> eList = (ArrayList<EmpEvaluation>)request.getAttribute("eList");

int sum = 0;
int avg = 0;
double avg2 = 0;

if(eList.size() > 0){
for(EmpEvaluation e: eList){ sum+= e.getSevalPoint(); }
avg = (int)Math.round(sum/eList.size());
avg2 = (double)(Math.round(sum*10/eList.size()))/10;// 구직자 평점
}

%>
<!DOCTYPE html >
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/form/css/form.css" rel="stylesheet" media="all">
<link href="resources/form/css/checkbox.css" rel="stylesheet" media="all">
<link rel="stylesheet" type="text/css" href="resources/css/starability-all.min.css">
<%@ include file="../common/includeTable.jsp"%>
<script>
function pop(){
 var str = <%=msg%>;
 if(str != null){
	 alert(str);
 }
return;
}

window.onload = pop;
</script>

<style>
.divArea{
display: inline-block;
}

.lLabel{
color:purple !important;
}
.rlabel{
width:auto !important;
text-align: left !important;
}

.form-row{
margin:10px !important;
}

.evalArea{
font-weight: 400;
font-size: 14px;
}

.tt{
vertical-align:middle;
width:20px;
height:20px;
background-image: url('<%= request.getContextPath()%>/resources/images/star.png') !important;
background-size: cover;
display: inline-block;
}

.evalArea{
margin: 30px;
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
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			<div class="outer">
	
				<form action="<%=request.getContextPath()%>/apply.es" method="post" class='speaker-form'  style="width:1150px; height: 850px;">
				<input type="hidden" name="wNum" value="<%=i.getwNum() %>">
					
					<div class='form-row' style="border-bottom: 1px solid gray" >
					  <label for='full-name' style="width:auto; margin-bottom:15px;"><%=i.getwTitle() %></label>
					</div>
					
						<br><br>
						
					<div class="divArea" style="vertical-align: top;">
					
						<div style="margin-bottom: 40px;">
							<img style="margin:auto;" id="titleImg" width="300"  src="<%=request.getContextPath()%>/photo/logoImages/<%= at.getChangeName() %>">
						</div>
						
						<div style="padding-left:40px; ">
							<div class='form-row'>
							  <label class="lLabel">회사명 |</label><p class="rLabel" style="width:180px;"><%=i.getOpName()%></p>
							</div>
							
							<div class='form-row'>	
							  <label class='lLabel'>전화번호 |</label><p class="rLabel">
							  	<%if(owner.getPhone() == null){%>
							  	 	없음
							  	 <%}else{ %>
							  	 	<%=owner.getPhone()%>
							  	 <%}%>
							  </p>
							</div>
							
							<div class='form-row'>
							  <label class='lLabel'>주소 |</label> <p class="rLabel">
								<%if(owner.getRoadName() != null){%>
							  	 	서울특별시 <%=owner.getDistrict()%> <%=owner.getRoadName()%> <%=owner.getRoadMain()%>
							  	 <%}else{ %>
							  	 	<%if(owner.getOpAddress() !=null){%>
							  	 		<%=owner.getOpAddress()%>
							  	 	<%}else{ %>
							  	 		미확인
							  	 	<%}%>
							  	 <%}%></p>
							</div>
							
							<div class='form-row'>
							  <label class='lLabel'>업종 |</label>
							  <p class="rLabel" style="width:auto;"><%=owner.getCategory() %> :: <%=owner.getType() %></p>
							</div>
							
							<div class='form-row'>
							  <label class='lLabel'>평점 (<%=avg2 %>) |</label>
							 	 <%for(int j=1; j<=avg; j++){ %>
								    <div class="tt" style="margin-top:4px;"></div>
							    <% }%>
							    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="rlabel" >참여:<%=eList.size() %>건</label>
							</div>
						</div>
						
						
						<div style="margin-top:80px; margin-left:60px; width:80%; align-items: center; ">
							<%for(EmpEvaluation e : eList) {%>
							<div class="evalArea">
								<div>
									<%=e.geteId()%> &nbsp;|&nbsp; <%=e.getEnrollDate()%>&nbsp; |&nbsp;
				
								    <%for(int j=1; j<=e.getSevalPoint(); j++){ %>
								    <div class="tt"></div>
								    <% }%>
								</div>
								<div style="margin-top:7px;">
									&quot;<%=e.geteComment()%>&quot;
								</div>
							</div>
							<%} %>
						</div>
						
						
					</div>
						
						
					<div class="divArea">
						<div class='form-row'>
							<label class='lLabel' >공고 마감일 |</label>
							<label class="rlabel"><%=i.getDoneDate() %></label>
						</div>
		
						<div class='form-row'>
						  <label class='lLabel' for='workDay'><span>근무 요일 |</span></label>
							<label  class="rlabel"><%=i.getWorkDay() %></label>
						</div>
						
						<div class='form-row'>
						  <label class='lLabel' for='termNo'>근무 기간 |</label>
						   <label class="rlabel"><%=i.getTermName() %>(<%=i.getTermBigName() %>)</label>
	
						</div>
						
						<div class='form-row'>
						  <label class='lLabel' for='workTime'>근무 시간 |</label>
							<label  class="rlabel"><%=i.getWorkTime() %></label>
						</div>
						
						<div class='form-row'>
						  <label class='lLabel' for='workAge1'>희망 연령 |</label>
						<label class="rlabel"><%=i.getAge() %></label>
						</div>
						
						<div class='form-row'>
						  <label class='lLabel' for='workGender'>희망 성별 |</label>
						  <label  class="rlabel" ><%=i.getGender()%></label>
			
						</div>
						
						<div class='form-row'>
						  <label class='lLabel'for='workEdu'>희망 학력 |</label>
						  <label  class="rlabel" ><%=i.getEdu()%></label>
						</div>
						
						<div class='form-row'>
						  <label class='lLabel' for='workForm'>희망 급여 |</label>
						  <label  class="rlabel" ><%=i.getSalaryForm()%> <%=i.getSalary()%>원</label>
						</div>
						
						<div class='form-row'>
						  <label class='lLabel' for='peopleCount'>모집 인원 |</label>
							 <label  class="rlabel" ><%=i.getPeopleCount()%></label>
						</div>
		
						<div class='form-row'>
						  <label class='lLabel' for='rExplain'>상세 내역 |</label>
						  <textarea  class="rlabel" style="background-color: #f6f2fa; border-color: #f6f2fa; font-weight: 700; font-size: inherit; padding:2px; " cols="30" rows="7" ><%=i.getDescription()%></textarea>
						</div>
						
						<div class='form-row' style="height:50px; padding-top:0px; ">
							<label class='lLabel'>지원 이력서</label>
							  <select id='rNum' name='rNum' style="width:auto;">
							   	<%for(Resume a : list) {%>
						  			<option value='<%=a.getrNum()%>' ><%=a.getDistrict()%> :: <%=a.getType()%> :: <%=a.getDesireForm()%> <%=a.getDesireIncome()%>원</option>
						  		<%}%>
							  </select>
						</div>
						
						<div class='form-row' style="margin-top:300px;">
						  <button type="submit" class="btn" onclick="return submitCheck();" style="margin-left: 50px;">지원하기</button>
						   <button type="button" class="btn" onclick="location.href='<%=request.getContextPath()%>/interestOwner.es';" style="margin-left:20px; padding-left:30px; padding-right:30px;">뒤로가기</button>
						</div>
		
					</div>
					<br><br>

					<script>
						function submitCheck(){
							var result = confirm("지원 하시겠습니까");
							if(result){
								//$(".speaker-form").submit();
								return true;
							}else{	
								return false;
							}
						}
					</script>
				</form>
			</div>
		
			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->

</body>
</html>