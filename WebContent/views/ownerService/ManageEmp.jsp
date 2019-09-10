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
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/includeTable.jsp"%>
<link href="resources/form/css/form.css" rel="stylesheet" media="all">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="resources/form/css/checkbox.css" rel="stylesheet" media="all">

<style>

.column1 {
  width: 33%;

   text-align: center;
}

.column2 {
  width: 22%;
  text-align: center;
}

.column3 {
  width: 18%;
   text-align: center;
}

.column4 {
  width: 10%;
   text-align: center;
}
.column5 {
  width: 10%;
   text-align: center;
}
.column6 {
  width: 7%;
   text-align: center;
}


.column00 {
  width: 10%;

   text-align: center;
}
.column11 {
  width: 10%;

   text-align: center;
}

.column22 {
  width: 10%;
  text-align: center;
}

.column33 {
  width: 15%;
   text-align: center;
}

.column44 {
  width: 15%;
   text-align: center;
}
.column55 {
  width: 20%;
   text-align: center;
}
.column66 {
  width: 10%;
   text-align: center;
}
.column77 {
  width: 10%;
   text-align: center;
}

.selectHover:hover td{
 background-color: #f2e6ff;
}

.doneIncruit{
background-color:#d4b3ff !important;
}
.doneIncruit2{
color:#a6a6a6 !important;
}

input[type=checkbox]+label:before{

border: 2px solid gray;
height:1.8em;
width:1.3em;
padding-left:2px;
}
.head th{
font-size: 14px !important;
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
		
		<div id="content-center" style="overflow: hidden; height:auto;">
		
			 <div  class="m-l-25 m-t-30">
			 	<input id='checkbox1' name='checkbox1' type='checkbox' onclick="hideDoneIncruitTable();" />
			 	<label class='checkbox-label' for='checkbox1'><span>&nbsp;마감된 공고 숨기기</span></label>
			 </div>
		
			<%for(Incruit i : list){ %>
				<!--===============================================================================================-->	
					<div class="limiter <%if(i.getStatus().equals("N")){%>doneIncruitTable<%}%>" >
						<div class="container-table100" >
							<div class="wrap-table100" style="width:100%;">
								<div class="table100 ver1 " >
									<div class="table100-head" style="border:1px solid white;">
										<table>
											<thead>
												<tr class="row100 head">
													<th class="cell100 column1 <%if(i.getStatus().equals("N")){%>doneIncruit<%}%>"><%=i.getwTitle()%></th>
													<th class="cell100 column2 <%if(i.getStatus().equals("N")){%>doneIncruit<%}%>"><%=i.getTermName()%> / <%=i.getWorkDay()%> / <%=i.getWorkTime()%></th>
													<th class="cell100 column3 <%if(i.getStatus().equals("N")){%>doneIncruit<%}%>"><%=i.getEnrollDate()%> ~ <%=i.getDoneDate()%></th>
													<th class="cell100 column4 <%if(i.getStatus().equals("N")){%>doneIncruit<%}%>"><%=i.getSalaryForm()%> <%if(i.getSalaryForm().equals("협의")){}else{ %><%=i.getSalary()%>원<% }%></th>
													<th class="cell100 column5 <%if(i.getStatus().equals("N")){%>doneIncruit<%}%>"><%=i.getProduct()%> 상품</th>
													<th class="cell100 column6 <%if(i.getStatus().equals("N")){%>doneIncruit<%}%>"><%if(i.getStatus().equals("Y")){%>진행중<%}else{%>마감<%} %></th>
												</tr>
											</thead>
										</table>
									</div>
				
									<div class="table100-body js-pscroll ">
										<table >
											<tbody >
												<%for(int j=0; j<alist.size(); j++) {%>
													<%for(Resume r : rlist){ %>
														<%if(alist.get(j).getwNum() == i.getwNum() && alist.get(j).getrNum() == r.getrNum()){ %>
															<tr <%if(i.getStatus().equals("N")||r.getInvalid().equals("Y")){%>class="row100 body" <%}else{%> onclick="selectIncruit(<%=r.getrNum()%>);" class="row100 body selectHover" <%} %> >
																<td class="cell100 column00 <%if(i.getStatus().equals("N")){%>doneIncruit2<%}%>"></td>
																<td class="cell100 column11 <%if(i.getStatus().equals("N")){%>doneIncruit2<%}%>"><%=r.geteName()%></td>
																<td class="cell100 column22 <%if(i.getStatus().equals("N")){%>doneIncruit2<%}%>"><%=r.getAge()%> <%=r.getGender()%></td>
																<td class="cell100 column33 <%if(i.getStatus().equals("N")){%>doneIncruit2<%}%>"><%=r.getPhone()%></td>
																<td class="cell100 column44 <%if(i.getStatus().equals("N")){%>doneIncruit2<%}%>">희망 <%=r.getDesireForm()%> <%=r.getDesireIncome()%>원</td>
																<td class="cell100 column55 <%if(i.getStatus().equals("N")){%>doneIncruit2<%}%>">(지원일)&nbsp;<%=alist.get(j).getApplyDate()%></td>
																<td class="cell100 column66 <%if(i.getStatus().equals("N")){%>doneIncruit2<%}%>">
																	<%if(alist.get(j).getPassOrFail().equals("UC")){%>사장님 확인전
																	<%}else if(alist.get(j).getPassOrFail().equals("C")){%>사장님 확인함
																	<%}else if(alist.get(j).getPassOrFail().equals("P")){%>합격
																	<%}else if(alist.get(j).getPassOrFail().equals("F")){%>탈락
																	<%}%>
																	<%if(r.getInvalid().equals("Y")){ %>
																		(이력서 삭제됨)
																	<%} %>
																</td>
																<td class="cell100 column77"></td>
															</tr>	
												<%break;}}}%>
												
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
					 	function selectIncruit(rNum){
							location.href='<%=request.getContextPath()%>/examineResume.os?rNum='+ rNum;
						}
					 	
					 	function hideDoneIncruitTable(){
					 		var cb = document.getElementsByName("checkbox1");
					 		var doneIncruitTable = document.getElementsByClassName("doneIncruitTable");
					 		
					 		if(cb[0].checked){
					 			doneIncruitTable[0].style.display = "none";
					 		}else{
					 			doneIncruitTable[0].style.display = "block";
					 		}
					 	}
		   			 </script>
		   			 
		   			 
		   			 <br><br><br><br><br><br><br><br><br><br><br>
			
				
				
					<div>

					</div>
					

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
	
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->

</body>
</html>