<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.IncruitProduct"%>
<%
	ArrayList<IncruitProduct> list = (ArrayList<IncruitProduct>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/includeTable.jsp"%>


<style>

.column1 {
  width: 30%;
  padding-left: 40px;
   text-align: center;
}

.column2 {
  width: 50%;
  text-align: center;
}

.column3 {
  width: 20%;
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
			<div class="limiter">
			<div class="container-table100">
				<div class="wrap-table100">
					<div class="table100 ver4 ">
						<div class="table100-head">
							<table>
								<thead>
									<tr class="row100 head">
										<th class="cell100 column1">상품명</th>
										<th class="cell100 column2">상품 설명</th>
										<th class="cell100 column3">요금(일)</th>
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
										for(IncruitProduct a : list) {%>
										<tr class="row100 body" style="height:50px;">
											<td class="cell100 column1"><%=a.getpTitle()%></td>
											<td class="cell100 column2"><%=a.getpExplain()%>
											<td class="cell100 column3"><%=a.getpPay()%>원</td>
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


			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->
	

</body>
</html>