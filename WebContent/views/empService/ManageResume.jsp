<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="emp.model.vo.Emp, empService.model.vo.Resume, java.util.ArrayList"%>
	
<%
Emp emp = (Emp) session.getAttribute("loginUser");
String name = emp.geteName();

ArrayList<Resume> list = (ArrayList<Resume>)request.getAttribute("list");

for(Resume r : list){
	// 본문에 이력서의 컬럼들 출력
}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<%@ include file="../empService/resources.jsp"%>
<title>이력서 관리</title>
</head>
<body>


<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			<!--===============================================================================================-->	
			<div class="limiter">
			<div class="container-table100">
				<div class="wrap-table100">
					<div class="table100 ver5 m-b-110">
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
									<tr class="row100 body">
										<td class="cell100 column1">Like a butterfly</td>
										<td class="cell100 column2">Boxing</td>
										<td class="cell100 column3">9:00 AM - 11:00 AM</td>
										<td class="cell100 column4">Aaron Chapman</td>
										<td class="cell100 column5">10</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			</div>
			<!--===============================================================================================-->	
		
			이력서 리스트 출력
			이력서 선텍 selectResume.es input rNum
			<br>
			<%= name %>
		
			<div id="makeResume" onclick="location.href='<%=request.getContextPath()%>/makeResume.es';">이력서 작성하기</div>
		
			<div>
				* 권고사항 
		
			</div>
	
			
			
			
		</div> <!-- /메인콘텐트 -->
		
	<div id="content-right"></div>
	
	</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
	



</body>
</html>