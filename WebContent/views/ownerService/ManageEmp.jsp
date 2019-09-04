<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.Appliant, ownerService.model.vo.Incruit, empService.model.vo.Resume"%>
<%
	ArrayList<Appliant> alist = (ArrayList<Appliant>)request.getAttribute("alist");
	ArrayList<Incruit> list = (ArrayList<Incruit>)request.getAttribute("list");
	ArrayList<Resume> rlist = (ArrayList<Resume>)request.getAttribute("rlist");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/includeTable.jsp"%>
<link href="resources/form/css/form.css" rel="stylesheet" media="all">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

<title>지원자 관리</title>

<style>

.column1 {
  width: 25%;
  padding-left: 40px;
   text-align: center;
}

.column2 {
  width: 20%;
  text-align: center;
}

.column3 {
  width: 20%;
   text-align: center;
}

.column4 {
  width: 10%;
   text-align: center;
}
.column5 {
  width: 15%;
   text-align: center;
}
.column6 {
  width: 10%;
   text-align: center;
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
		
			<%for(Incruit i : list){ %>
				<!--===============================================================================================-->	
					<div class="limiter" >
						<div class="container-table100" >
							<div class="wrap-table100" style="width:100%;">
								<div class="table100 ver1" >
									<div class="table100-head">
										<table>
											<thead>
												<tr class="row100 head" >
													<th class="cell100 column1"><%=i.getwTitle()%></th>
													<th class="cell100 column2"><%=i.getTermName()%> / <%=i.getWorkDay()%> / <%=i.getWorkTime()%></th>
													<th class="cell100 column3"><%=i.getEnrollDate()%> ~ <%=i.getDoneDate()%></th>
													<th class="cell100 column4"><%=i.getSalaryForm()%> <%if(i.getSalaryForm().equals("협의")){}else{ %><%=i.getSalary()%>원<% }%></th>
													<th class="cell100 column5"><%=i.getProduct()%></th>
													<th class="cell100 column6"><%if(i.getStatus().equals("Y")){%>진행중<%}else{%>마감<%} %></th>
												</tr>
											</thead>
										</table>
									</div>
				
									<div class="table100-body js-pscroll ">
										<table >
											<tbody >
												<%if(alist.isEmpty()){%>
													<tr class="row100 body"><td colspan="6" style="text-align:center">지원자가 없습니다.</td></tr>
												<%}else{ %>
													<%for(int j=0; j<alist.size(); j++) {%>
														<%if(alist.get(j).getwNum() == i.getwNum()){ %>
															<%for(Resume r : rlist){ %>
																<%if(alist.get(j).getrNum() == r.getrNum()){ %>
																	<tr class="row100 body " onclick="selectIncruit();">
																		<td class="cell100 column1"><%=r.geteName()%></td>
																		
																		<td class="cell100 column2">19 남</td>
																		<td class="cell100 column3"><%=r.getPhone()%></td>
																		<td class="cell100 column4"><%=r.getDesireForm()%> <%=r.getDesireIncome()%>원</td>
																		<td class="cell100 column5"><%=alist.get(j).getApplyDate()%></td>
																		<td class="cell100 column6">
																			<%if(alist.get(j).getPassOrFail().equals("UC")){%>확인전
																			<%}else if(alist.get(j).getPassOrFail().equals("C")){%>확인함
																			<%}else if(alist.get(j).getPassOrFail().equals("P")){%>합격
																			<%}else if(alist.get(j).getPassOrFail().equals("F")){%>탈락
																			<%}%>
																		</td>
																	</tr>	
												<%}}}}}%>
											</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--===============================================================================================-->	
					<%} %>
					 <script>

		   			 </script>
				<br><br><br><br><br><br><br><br><br><br><br>
<div>
진행중/마감 탭으로 보이도록
 공고 클릭시 지원자리스트가 나옴. 클릭시(examineResume.os input rnum) 해당 이력서로 넘어가서  채용/반려 선택
마감은 이력서 안 넘어감
</div>

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
	
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->

</body>
</html>