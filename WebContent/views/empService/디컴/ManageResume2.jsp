<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="empService.model.vo.Emp, empService.model.vo.Resume, java.util.ArrayList"%>
	
<%
Emp emp = (Emp) session.getAttribute("emp");
String name = emp.geteName();
String phone = emp.getPhone();
String address = emp.getAddress();
String email = emp.getEmail();

ArrayList<Resume> list = (ArrayList<Resume>)request.getAttribute("list");

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ include file="../common/includeTable.jsp"%>

<style>

.column1 {
  width: 20%;
  padding-left: 40px;
   text-align: center;
}

.column2 {
  width: 30%;
  text-align: center;
}

.column3 {
  width: 20%;
   text-align: center;
}

.column4 {
  width: 15%;
   text-align: center;
}

.column5 {
  width: 15%;
   text-align: center;
}


</style>
<title>이력서 관리</title>
</head>
<body>


<div id="div">

	<div id="header"><%@ include file="../common/header.jsp"%></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">

			
			<!--===============================================================================================-->	
			<div class="limiter " >
			<div class="container-table100">
				<div class="wrap-table100">
					<div class="table100 ver5 m-t-40">
						<div class="table100-head">
							<table>
								<thead>
									<tr class="row100 head">
										<th class="cell100 column1">희망근무지(구)</th>
										<th class="cell100 column2">희망업종</th>
										<th class="cell100 column3">희망급여</th>
										<th class="cell100 column4">등록일</th>
										<th class="cell100 column5">이력서 공개여부</th>
									</tr>
								</thead>
							</table>
						</div>
	
						<div class="table100-body js-pscroll">
							<table>
								<tbody>
								
									<%if(list.isEmpty()){%>
										<tr class="row100 body"><td colspan="5" style="text-align:center">존재하는 내용이 없습니다</td></tr>
									<%}else{ %>
										<% for(Resume a : list) {
											String openSet = null;
											if(a.getOpenSet().equals("Y")){openSet = "공개";}else{openSet="비공개";}%>
										<tr class="row100 body" onclick="selectResume(<%=a.getrNum()%>);">
											<td class="cell100 column1"><%=a.getDistrict()%></td>
											<td class="cell100 column2"><%=a.getCategory()%> :: <%=a.getType()%></td>
											<td class="cell100 column3"><%=a.getDesireForm()%> <%=a.getDesireIncome()%>원</td>
											<td class="cell100 column4"><%=a.getUpdateDate()%></td>
											<td class="cell100 column5"><%=openSet%></td>
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
		
			
			<br>
			<div class="gs-btn-parent">
				<button class="gs-btn" onclick="location.href='<%=request.getContextPath()%>/makeResume.es';" >이력서 작성하기</button>
			</div>
			
			<script>
				
				function selectResume(rNum){
					location.href='<%=request.getContextPath()%>/selectResume.es?rNum='+ rNum;
				}
			</script>
			
			
		
		
		</div> <!-- /메인콘텐트 -->
		
	<div id="content-right"></div>
	
	</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
	



</body>
</html>