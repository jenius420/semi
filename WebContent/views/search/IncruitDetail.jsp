<%@page import="search.model.vo.OPhoto"%>
<%@page import="search.model.vo.IncruitInfo"%>
<%@page import="empService.model.vo.EmpEvaluation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	IncruitInfo i = (IncruitInfo)request.getAttribute("info");
	OPhoto p = (OPhoto)request.getAttribute("logo");
	ArrayList<OPhoto> pList = (ArrayList<OPhoto>)request.getAttribute("pList");
	ArrayList<EmpEvaluation> eList = (ArrayList<EmpEvaluation>)request.getAttribute("eList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">
<style>
#jumbotron {
	background-image:
		url('<%=request.getContextPath()%>/resources/images/slide2.jpg');
}
.evalArea{
font-weight: 400;
font-size: 14px;
}

.star{
vertical-align:middle;
width:20px;
height:20px;
background-image: url('<%= request.getContextPath()%>/resources/images/star.png') !important;
background-size: cover;
display: inline-block;
}
</style>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
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
	<div class="row"
		style="padding-top: 50px; padding-left: 150px; padding-right: 150px;">
		<input type="hidden" value="<%=i.getNum() %>" />
		<p><%=i.getStartDate() %></p>
		<div class="col-sm-12" style="border: 1px solid lightgrey;"><%=i.getTitle() %></div>
		<div class="col-sm-2">
			<button class="btn btn-sm" style="background: rgb(176,18,241); color:white;">관심 기업추가</button>
		</div>
		<div class="col-sm-4"
			style="height: 250px; border: 1px solid lightgrey;">
			<img class="card-img-top col-lg-12 col-sm-12" style="padding-top:50px; width: auto; height: auto; max-width:300px ;max-height: 200px;" 
				<% if(p==null){%>
					src="<%=request.getContextPath() %>/photo/logoImages/noLogo.jpg" 
				<%}else{ %>
					src="<%=request.getContextPath() %>/photo/logoImages/<%=p.getSaveName() %>" 
				<%} %>/>
				
		</div>
		<div class="col-sm-4"
			style="height: 250px;padding-top:50px; border: 1px solid lightgrey;">
			<p>회사명 : <%=i.getOpName() %></p>
			<p>대표자명 : <%=i.getoName() %></p>
			<p>
				업종 :
				<%=i.getCategoryName()%>,
				<%=i.getTypeName() %></p>
			<p>
				주소 : 서울특별시
				<%=i.getDistrictName() %>
				<%=i.getRoadName() %>
				<%=i.getRoadMain() %>
				<%if(i.getRoadSub()!=0){ %>-<%=i.getRoadSub() %>
				<%} %>
			</p>
			<p>
				마감일 :
				<%=i.getEndDate() %></p>
		</div>
		<div class="col-sm-6" style="padding-left:200px;padding-right: 100px; padding-top: 70px;">
			<p>
				급여 : <strong><%=i.getWorkForm() %></strong><%=i.getSalary() %>원
			</p>
			<p>
				근무기간 :
				<%=i.getTermName() %>(<%=i.getTermBigName() %>)
			</p>
			<p>
				근무요일 :
				<%=i.getWorkDay() %></p>
			<p>
				근무시간 :
				<%=i.getWorkTime() %></p>
		</div>
		<div class="col-sm-6" style=" padding-top: 70px;">
			<p>
				인원 :
				<%=i.getPeopleCount() %></p>
			<p>
				성별 :
				<%=i.getWorkGender() %></p>
			<p>
				연령 :
				<%=i.getWorkAge() %></p>
			<p>
				학력 :
				<%=i.getWorkEdu() %></p>
		</div>
		<div class="col-sm-12" style="height: 100px;"></div>
		<div class="col-sm-12">
			<div class="col-sm-12" id="photo">
				<%if(pList!=null){ %>
					<%for(int j=0; j<pList.size(); j++){ %>
						<img src="<%=request.getContextPath()%>/..../<%= pList.get(j).getSaveName() %>"/>
					<%} %>
				<%} %>
			</div>
			
			<!-- 평가 시작 -->
			
			<div class="col-sm-12" style=" height: 200px;width:60%; align-items: center; ">
				<%for(EmpEvaluation e : eList) {%>
					<div class="col-sm-12 evalArea">
						<div>
							<%=e.geteId()%> &nbsp;|&nbsp; <%=e.getEnrollDate()%>&nbsp; |&nbsp;
		
						    <%for(int j=1; j<=e.getSevalPoint(); j++){ %>
						 	   <div class="star"></div>
						    <% }%>
						</div>
						<div style="margin-top:7px;">
							&quot;<%=e.geteComment()%>&quot;
						</div>
					</div>
					<%} %>
				</div>
			
			<!-- 평가 끝 -->
			
			<div class="col-sm-12" style="height: 700px;">
				<hr />
				<div class="col-sm-12"
					style="padding-left: 50px; padding-right: 50px;" align="left">
					<%if(i.getrExplain()==null||i.getrExplain().equals("")){ %>
						<p><%=i.getTotalInfo() %></p>
					<%}else{ %>
						<p><%=i.getrExplain() %></p>
					<%} %>
				</div>
			</div>
			
			
			
				<%if(loginUser!=null){ %>
				<div class="buttons" style="padding-left: 450px;">
					<button class="btn btn-default" onclick="supply();">지원하기</button>
				</div>
				<%} %>
					
					
		</div>
		<script>
			function supply(){
				location.href='<%=request.getContextPath()%>/resumeCheck.se?wNum=<%=i.getNum() %>';
			}
		</script>
		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>