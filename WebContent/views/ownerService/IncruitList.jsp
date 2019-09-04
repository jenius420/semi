<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.Incruit"
%>
<%
	ArrayList<Incruit> list = (ArrayList<Incruit>)request.getAttribute("list");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/includeTable.jsp"%>
<link href="resources/form/css/form.css" rel="stylesheet" media="all">
<title>공고 리스트</title>

<style>

.column1 {
  width: 25%;

   text-align: center;
}

.column2 {
  width: 28%;
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
  width: 10%;
   text-align: center;
}
.column6 {
  width: 7%;
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
		

				<!--===============================================================================================-->	
				<div class="limiter" >
					<div class="container-table100" >
						<div class="wrap-table100" style="width:100%;">
							<div class="table100 ver5" >
								<div class="table100-head">
									<table>
										<thead>
											<tr class="row100 head" >
												<th class="cell100 column1">제목</th>
												<th class="cell100 column2">근무시간</th>
												<th class="cell100 column3">등록일/마감일</th>
												<th class="cell100 column4">급여</th>
												<th class="cell100 column5">적용 상품</th>
												<th class="cell100 column6">진행 상태</th>
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
												<%for(Incruit a : list) {%>
										
														<tr class="row100 body" onclick="selectIncruit(<%=a.getwNum()%>);">
															<td class="cell100 column1"><%=a.getwTitle()%></td>
															<td class="cell100 column2"><%=a.getTermName()%> / <%=a.getWorkDay()%> / <%=a.getWorkTime()%></td>
															<td class="cell100 column3"><%=a.getEnrollDate()%> ~ <%=a.getDoneDate()%></td>
															<td class="cell100 column4"><%=a.getSalaryForm()%> <%if(a.getSalaryForm().equals("협의")){}else{ %><%=a.getSalary()%>원<% }%></td>
															<td class="cell100 column5"><%=a.getProduct()%></td>
															<td class="cell100 column6"><%if(a.getStatus().equals("Y")){%>진행중<%}else{%>마감<%} %></td>
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
			
				<div class="gs-btn-parent">
					<button class="gs-btn" onclick="location.href='<%=request.getContextPath()%>/makeIncruit.os';" >공고 작성하기</button>
				</div>
			
				<script>
					function selectIncruit(wNum){
						location.href='<%=request.getContextPath()%>/selectIncruit.os?wNum='+ wNum;
					}
				</script>
	
			
			</div>
		
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
	
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>

</div> <!-- /화면 -->

	

</body>
</html>