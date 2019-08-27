<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="emp.model.vo.Emp, empService.model.vo.Resume, java.util.ArrayList"%>
	
<%
Emp emp = (Emp) session.getAttribute("loginUser");
String name = emp.geteName();

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
  width: 20%;
  text-align: center;
}

.column3 {
  width: 20%;
   text-align: center;
}

.column4 {
  width: 20%;
   text-align: center;
}

.column5 {
  width: 20%;
   text-align: center;
}


</style>
<title>이력서 관리</title>
</head>
<body>


<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">

			
			
			<!--===============================================================================================-->	
			<div class="limiter " >
			<div class="container-table100">
				<div class="wrap-table100">
					<div class="table100 ver4 m-t-100">
						<div class="table100-head">
							<table>
								<thead>
									<tr class="row100 head">
										<th class="cell100 column1">Class name</th>
										<th class="cell100 column2">Type</th>
										<th class="cell100 column3">Hours</th>
										<th class="cell100 column4">Trainer</th>
										<th class="cell100 column5">Spots</th>
									</tr>
								</thead>
							</table>
						</div>
	
						<div class="table100-body js-pscroll">
							<table>
								<tbody>
									<%if(list.isEmpty()){%>
										<tr class="row100 body"><td colspan="5" style="text-align:center">존재하는 내용이 없습니다</td></tr>
									<%}else{ 
										for(Resume a : list) {%>
										<tr class="row100 body">
											<td class="cell100 column1"><%=a.getrNum()%></td>
											<td class="cell100 column2"></td>
											<td class="cell100 column3"></td>
											<td class="cell100 column4"></td>
											<td class="cell100 column5"><input type="checkbox" id="applyArr" name="applyArr" value=""></td>
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
				<button class="gs-btn" onclick="location.href='<%=request.getContextPath()%>/makeResume.es';">이력서 작성하기</button>
			</div>
			
			<div id="makeResume" onclick="location.href='<%=request.getContextPath()%>/makeResume.es';">이력서 작성하기</div>
		
			<div>
				* 권고사항 
		
			</div>
			다른 테이블 형태 쓰자
			이력서 선텍 selectResume.es input rNum
			
			
			
		</div> <!-- /메인콘텐트 -->
		
	<div id="content-right"></div>
	
	</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
	



</body>
</html>