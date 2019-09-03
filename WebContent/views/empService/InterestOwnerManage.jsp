<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, ownerService.model.vo.Incruit, empService.model.vo.HopeEnt"%>
<%
ArrayList<HopeEnt> hList = (ArrayList<HopeEnt>)request.getAttribute("hList");
ArrayList<Incruit> wList = (ArrayList<Incruit>)request.getAttribute("wList");
%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/includeTable.jsp"%>
<link href="resources/form/css/form.css" rel="stylesheet" media="all">
<title></title>
<style>

.column1 {
  width: 20%;
  padding-left: 40px;
   text-align: center;
}

.column2 {
  width: 35%;
  text-align: center;
}

.column3 {
  width: 15%;
   text-align: center;
}

.column4 {
  width: 20%;
   text-align: center;
}
.column5 {
  width: 10%;
   text-align: center;
}

.column11 {
  width: 20%;
  padding-left: 40px;
   text-align: center;
}

.column22 {
  width: 15%;
  text-align: center;
}

.column33 {
  width: 20%;
   text-align: center;
}

.column44 {
  width: 20%;
   text-align: center;
}
.column55 {
  width: 13%;
   text-align: center;
}

.column66 {
  width: 12%;
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

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			<div class="tab_container m-t-40 m-l-80" >
				<input type="radio" name="hopeOwner" onclick="showBox(this);" id="hopeOwner" checked><label for="hopeOwner">관심기업</label>
				<input type="radio" name="hopeOwner" onclick="showBox(this);"  id="hopeOwnerIncruit"><label for="hopeOwnerIncruit">관심기업 공고</label>		
			</div>
		
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
											<tr class="row100 body"><td colspan="5" style="text-align:center">존재하는 내용이 없습니다</td></tr>
										<%}else{ %>
											<%for(HopeEnt a : hList) {%>
											<tr class="row100 body">
												<td class="cell100 column1"><%=a.getOpName()%></td>
												<td class="cell100 column2"><%=a.getDong()%> <%=a.getOpAddress()%></td>
												<td class="cell100 column3"><%=a.getPhone()%></td>
												<td class="cell100 column4"><%=a.getCategory()%> :: <%=a.getType()%></td>
												<td class="cell100 column5"><input type="button" class="gs-btn" style="padding: 10px 10px" value="삭제" onclick="deleteInter();">
												<form action="" id="detailForm" method="post">
													<input type="hidden" name="hNo" value="<%=a.gethNum()%>">
												</form></td>
											</tr>
											<%}}%>
											<script>		
												function deleteInter(){
													
													var con = confirm("관심기업에서 삭제 하시겠습니까");
													
													if(con){
														$("#detailForm").attr("action", "<%=request.getContextPath()%>/deleteInterestOwnerServlet.es");
														$("#detailForm").submit();
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
											<th class="cell100 column33">위치</th>
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
												<td class="cell100 column11"><%=a.getwTitle()%></td>
												<td class="cell100 column22"><%=a.getOpName()%></td>
												<td class="cell100 column33">
													<%if(a.getDong() != null){%> <%=a.getDong()%> <%}else{%> <%=a.getRoadName()%> <%}%> <%=a.getAddress()%> 
												</td>
												<td class="cell100 column44"><%=a.getTermName()%> / <%=a.getWorkDay()%> / <%=a.getWorkTime()%></td>
												<td class="cell100 column55"><%=a.getSalaryForm()%> <%if(a.getSalaryForm().equals("협의")){}else{ %><%=a.getSalary()%>원<% }%></td>
												<td class="cell100 column66"><%=a.getDoneDate()%></td>
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
					$(function(){
						$(".select td").click(function(){
							var num = $(this).parent().children().eq(5).text();
							location.href="<%=request.getContextPath()%>/watchingIncruit2.es?wNum=" + num;
						});
					});
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
		
		


	추가: 팝업으로 비동기(중복안되게)
	삭제: 각 열 옆에 삭제 버튼 deleteInterestOwnerServlet.es input oNum
	
	공고 클릭 시 watchingIncruit2.es input wnum

		</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->

</body>
</html>