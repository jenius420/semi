<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, ownerService.model.vo.Appliant"%>
<%
ArrayList<Appliant> list = (ArrayList<Appliant>)request.getAttribute("list");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ include file="../empService/resources.jsp"%>

<style>

.column1 {
  width: 30%;
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
  width: 10%;
   text-align: center;
}

</style>

<title>알바 지원 현황</title>
</head>
<body>

<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
		<form action="<%= request.getContextPath() %>/cancleAppliant.es" method="post">
		<!--===============================================================================================-->	
			<div class="limiter">
			<div class="container-table100">
				<div class="wrap-table100">
					<div class="table100 ver4 m-t-20">
						<div class="table100-head">
							<table>
								<thead>
									<tr class="row100 head">
										<th class="cell100 column1">제목</th>
										<th class="cell100 column2">마감일</th>
										<th class="cell100 column3">지원일</th>
										<th class="cell100 column4">지원상태</th>
										<th class="cell100 column5">지원 취소</th>
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
										for(Appliant a : list) {%>
										<tr class="row100 body">
											<td class="cell100 column1"><%=a.getwTitle()%></td>
											<td class="cell100 column2"><%=a.getEndDate()%></td>
											<td class="cell100 column3"><%=a.getApplyDate()%></td>
											<td class="cell100 column4"><%=a.getPassOrFail()%></td>
											<td class="cell100 column5"><input type="checkbox" id="applyArr" name="applyArr" value="<%=a.getApplyNum() %>"></td>
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
		
			<%if(!list.isEmpty()){%>
				<div class="gs-btn-parent">
					<button type="submit" class="gs-btn" id="gs-btn" >취소하기</button>
				</div>
			<%}%>
			
			</form>
			

		</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->

</body>
</html>