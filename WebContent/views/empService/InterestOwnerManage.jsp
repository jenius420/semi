<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, ownerService.model.vo.Incruit, empService.model.vo.HopeEnt"%>
<%
ArrayList<HopeEnt> hList = (ArrayList<HopeEnt>)request.getAttribute("hList");
ArrayList<Incruit> wList = (ArrayList<Incruit>)request.getAttribute("wList");
%>
<!DOCTYPE >
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/includeTable.jsp"%>


<style>

.column1 {
  width: 20%;
  padding-left: 40px;
   text-align: center;
}

.column2 {
  width: 25%;
  text-align: center;
}

.column3 {
  width: 15%;
   text-align: center;
}

.column4 {
  width: 25%;
   text-align: center;
}
.column5 {
  width: 10%;
   text-align: center;
}

.column11 {
  width: 25%;
  padding-left: 40px;
   text-align: center;
}

.column22 {
  width: 15%;
  text-align: center;
}

.column33 {
  width: 15%;
   text-align: center;
}

.column44 {
  width: 25%;
   text-align: center;
}
.column55 {
  width: 10%;
   text-align: center;
}

.column66 {
  width: 10%;
   text-align: center;
}

#hopeOwnerIncruitBox{
display:none;
}

.tab_container [id^="hope"]{
  display: none;
}

.tab_container [id^="hope"]:checked + label {
  background: white;
  color: #555;
  border: 1px solid #ddd;
  border-bottom:1px solid #ffffff;
  box-shadow: inset 0 3px rgb(176,18,241);
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
		
			<div class="tab_container m-t-40 m-l-80" >
				<input type="radio" name="hopeOwner" onclick="showBox(this);" id="hopeOwner" checked><label for="hopeOwner">관심기업</label>
				<input type="radio" name="hopeOwner" onclick="showBox(this);"  id="hopeOwnerIncruit"><label for="hopeOwnerIncruit">관심기업 공고</label>		
			</div>
		
			<form action="" id="deleteForm" method="post">
			<div id="hopeOwnerBox" class="box">
				<!--===============================================================================================-->	
				<div class="limiter">
				<div class="container-table100">
					<div class="wrap-table100">
						<div class="table100 ver4">
							<div class="table100-head">
								<table>
									<thead>
										<tr class="row100 head">
											<th class="cell100 column1">업체명</th>
											<th class="cell100 column2">주소</th>
											<th class="cell100 column3">전화번호</th>
											<th class="cell100 column4">업종</th>
											<th class="cell100 column5"></th>
										</tr>
									</thead>
								</table>
							</div>
		
							<div class="table100-body js-pscroll">
								<table>
									<tbody>
										<%if(hList.isEmpty()){%>
											<tr class="row100 body"><td colspan="5" rowspan="2" style="text-align:center;height:100px;">존재하는 내용이 없습니다</td></tr>
										<%}else{ %>
											<%for(HopeEnt a : hList) {%>
											<tr class="row100 body" style="height:40px;">
												<td class="cell100 column1"><%=a.getOpName()%></td>
												<td class="cell100 column2">
												<%if(a.getRoadName() != null) {%>
													<%=a.getDistrict()%> <%=a.getRoadName()%> <%=a.getRoadMain()%>
												<%}else{%>
													<%if(a.getOpAddress() !=null){%>
											  	 		<%=a.getOpAddress()%>
											  	 	<%}else{ %>
											  	 		미확인
											  	 	<%}%>
												<%} %>
												</td>
												<td class="cell100 column3"><%=a.getPhone()%></td>
												<td class="cell100 column4"><%=a.getCategory()%> :: <%=a.getType()%></td>
												<td class="cell100 column5"><input type="button" class="gs-btn" style="padding: 10px 10px" value="삭제" onclick="deleteInterest(<%=a.gethNum()%>);"></td>
											</tr>
											<%}}%>
											<script>		
												function deleteInterest(hNo){
													
													var con = confirm("관심기업에서 삭제 하시겠습니까");
													
													if(con){
														$("#deleteForm").attr("action", "<%=request.getContextPath()%>/deleteInterestOwnerServlet.es?hNo="+hNo);
														$("#deleteForm").submit();
													}else{
														return false;
													}
												}
											</script>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				</div>
				<!--===============================================================================================-->	
				
			</div>
			</form>
			
			
			<div id="hopeOwnerIncruitBox" class="box">
				<!--===============================================================================================-->	
				<div class="limiter">
				<div class="container-table100">
					<div class="wrap-table100">
						<div class="table100 ver5">
							<div class="table100-head">
								<table>
									<thead>
										<tr class="row100 head">
											<th class="cell100 column11">공고 제목</th>
											<th class="cell100 column22">업체명</th>
											<th class="cell100 column33">희망 나이/성별</th>
											<th class="cell100 column44">근무시간</th>
											<th class="cell100 column55">급여</th>
											<th class="cell100 column66">공고 마감일</th>
										</tr>
									</thead>
								</table>
							</div>
		
							<div class="table100-body js-pscroll">
								<table>
									<tbody>
										<%if(wList.isEmpty()){%>
											<tr class="row100 body"><td colspan="5" style="text-align:center">존재하는 내용이 없습니다</td></tr>
										<%}else{ 
											for(Incruit a : wList) {%>
											<tr class="row100 body select" onclick="selectIncruit(<%=a.getwNum()%>);">
												<td class="cell100 column11" style="font-size: 13px;"><%=a.getwTitle()%></td>
												<td class="cell100 column22" style="font-size: 13px;"><%=a.getOpName()%></td>
												<td class="cell100 column33" style="font-size: 13px;"><%=a.getAge()%> / <%=a.getGender()%></td>
												<td class="cell100 column44" style="font-size: 13px;"><%=a.getTermName()%> / <%=a.getWorkDay()%> / <%=a.getWorkTime()%></td>
												<td class="cell100 column55" style="font-size: 13px;"><%=a.getSalaryForm()%> <%if(a.getSalaryForm().equals("협의")){}else{ %><%=a.getSalary()%>원<% }%></td>
												<td class="cell100 column66" style="font-size: 13px;"><%=a.getDoneDate()%></td>
		
											</tr>
											<%}}%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				</div>
				<!--===============================================================================================-->	
				</div>
				
				
				<script>
				
				</script>
				<script>
					function selectIncruit(wNum){
						location.href='<%=request.getContextPath()%>/watchingIncruit2.es?wNum='+ wNum;
					}
				
					function showBox(element){
						var tag = document.getElementsByClassName("box");
						var addBtn = document.getElementsByClassName("gs-btn-parent");
						
						for(var i=0 ; i<tag.length ; i++){
							if(element.id+"Box" == tag[i].id){
								tag[i].style.display = "block";
									//if(i==0){addBtn[0].style.display = "block";}else{addBtn[0].style.display = "none";}
							}else{
								tag[i].style.display = "none";
							}
						}
					}
	
				</script>
		
	

		</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->

</body>
</html>