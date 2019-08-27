<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, empService.model.vo.EmpEvaluation, empService.model.vo.EmpEvaluationBefore"%>
<%
ArrayList<EmpEvaluation> empEval = (ArrayList<EmpEvaluation>)request.getAttribute("empEval");
ArrayList<EmpEvaluationBefore> empEvalBf = (ArrayList<EmpEvaluationBefore>)request.getAttribute("empEvalBf");
 
 %>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/includeTable.jsp"%>

<title>알바 후기 관리</title>


<style>

.column1 {
  width: 30%;
  padding-left: 40px;
   text-align: center;
}

.column2 {
  width: 29%;
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
  width: 1%;
   text-align: center;
}

#empEvalBfBox{
display:none;
}

.tab_container [id^="emp"]{
  display: none;
}

.tab_container [id^="emp"]:checked + label {
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
				<input type="radio" name="empEval" onclick="showBox(this);" id="empEval" checked><label for="empEval">작성한 평가</label>
				<input type="radio" name="empEval" onclick="showBox(this);"  id="empEvalBf"><label for="empEvalBf">미작성 평가</label>		
			</div>
			
			<div id="empEvalBox" class="box">
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
											<th class="cell100 column2">근무일</th>
											<th class="cell100 column3">작성일</th>
											<th class="cell100 column4"></th>
											<th class="cell100 column5"></th>
										</tr>
									</thead>
								</table>
							</div>
		
							<div class="table100-body js-pscroll">
								<table>
									<tbody>
										<%if(empEval.isEmpty()){%>
											<tr class="row100 body"><td colspan="5" style="text-align:center">존재하는 내용이 없습니다</td></tr>
										<%}else{ 
											for(EmpEvaluation a : empEval) {%>
											<tr class="row100 body">
												<td class="cell100 column1"><%=a.getOpName()%></td>
												<td class="cell100 column2"><%=a.getWorkStartTerm()%> ~ <%=a.getWorkEndTerm()%></td>
												<td class="cell100 column3"><%=a.getEnrollDate()%></td>
												<td class="cell100 column4"><input type="button" class="gs-btn" style="padding: 10px 10px" value="삭제" onclick="deleteEval();"></td>
												<td class="cell100 column5"></td>
											</tr>
											<%}}%>
										<script>
											function deleteEval(){
												if(confirm("삭제 하시겠습니까")){
													location.href='<%=request.getContextPath()%>/deleteEval.es'
												}else{
													return;
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
			
			<div id="empEvalBfBox" class="box">
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
											<th class="cell100 column3">근무일</th>
											<th class="cell100 column4"></th>
											<th class="cell100 column5"></th>
										</tr>
									</thead>
								</table>
							</div>
		
							<div class="table100-body js-pscroll">
								<table>
									<tbody>
										<%if(empEvalBf.isEmpty()){%>
											<tr class="row100 body"><td colspan="5" style="text-align:center">존재하는 내용이 없습니다</td></tr>
										<%}else{ 
											for(EmpEvaluationBefore a : empEvalBf) {%>
											<tr class="row100 body">
												<td class="cell100 column1"><%=a.getwTitle()%></td>
												<td class="cell100 column2"><%=a.getOpName()%></td>
												<td class="cell100 column3"><%=a.getWorkStartTerm()%> ~ <%=a.getWorkEndTerm()%></td>
												<td class="cell100 column4"><input type="button" class="gs-btn" style="padding: 10px 10px" value="작성" onclick="location.href='<%=request.getContextPath()%>/makeEmpEval.es?oNum='+<%=a.getoNum()%>'&applyNum='<%=a.getApplyNum()%>"></td>
												<td class="cell100 column5"></td>
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
				function showBox(element){
					var tag = document.getElementsByClassName("box");
					
					for(var i=0 ; i<tag.length ; i++){
						if(element.id+"Box" == tag[i].id)
							tag[i].style.display = "block";
						else
							tag[i].style.display = "none";
					}
		
				}
		  	</script>
			
		
<br><br><br><br><br><br><br><br><br><br><br><br><br>
작성한 평가 - 삭제 deleteEval.es input sevalNum
미작성평가 - 작성 makeEmpEval.es input onum, applyNum

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->


</body>
</html>