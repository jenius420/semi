<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, ownerService.model.vo.Appliant"%>
<%
ArrayList<Appliant> list = (ArrayList<Appliant>)request.getAttribute("list");
%>
<!DOCTYPE html >
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
  width: 20%;
  text-align: center;
}

.column3 {
  width: 15%;
  text-align: center;
}

.column4 {
  width: 15%;
   text-align: center;
}

.column5 {
  width: 10%;
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
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			<form action="" id="detailForm" method="post">
			<!--===============================================================================================-->	
				<div class="limiter">
					<div class="container-table100">
						<div class="wrap-table100">
							<div class="table100 ver4">
								<div class="table100-head">
									<table>
										<thead>
											<tr class="row100 head">
												<th class="cell100 column1">제목</th>
												<th class="cell100 column2">업체명</th>
												<th class="cell100 column3">마감일</th>
												<th class="cell100 column4">지원일</th>
												<th class="cell100 column5">지원상태</th>
												<th class="cell100 column6">지원 취소</th>
											</tr>
										</thead>
									</table>
								</div>
			
								<div class="table100-body js-pscroll">
									<table>
										<tbody>
											<%if(list.isEmpty()){%>
												<tr class="row100 body"  style="height:200px;"><td colspan="5" style="text-align:center">존재하는 내용이 없습니다</td></tr>
											<%}else{ 
												for(Appliant a : list) {
													String status = null;
													switch(a.getPassOrFail()){
														case "UC" : status = "사장님 확인 전"; break;
														case "C" : status = "사장님 확인함"; break;
														case "P" : status = "합격!"; break;
														case "F" : status = "탈락"; break;
														case "R" : status = "구직자 취소"; break;	
													}%>
												<tr class="row100 body" style="height:60px;">
													<td class="cell100 column1"><%=a.getwTitle()%></td>
													<td class="cell100 column2"><%=a.getOpName()%>
													<td class="cell100 column3"><%=a.getEndDate()%></td>
													<td class="cell100 column4"><%=a.getApplyDate()%></td>
													<td class="cell100 column5"><%=status%></td>
													<td class="cell100 column6"><%if(!a.getPassOrFail().equals("P")) {%><input type="button" class="gs-btn" style="padding: 10px 10px" value="취소" onclick="cancleAppliant(<%=a.getApplyNum()%>);"><%} %></td>	
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
			</form>
			
			<script>
				function cancleAppliant(applyNum){
						
					var con = confirm("지원을 취소하시겠습니까?");
					
					if(con){
						$("#detailForm").attr("action", "<%=request.getContextPath()%>/cancleAppliant.es?applyNum="+applyNum);
						$("#detailForm").submit();
					}else{
						return false;
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