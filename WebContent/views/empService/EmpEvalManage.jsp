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
<link rel="stylesheet" type="text/css" href="resources/css/starability-all.min.css">
<link href="resources/form/css/form.css" rel="stylesheet" media="all">

<title>알바 후기 관리</title>


<style>

.column1 {
  width: 15%;
  padding-left: 40px;
   text-align: center;
}

.column2 {
  width: 10%;
  text-align: center;
}

.column3 {
  width: 45%;
   text-align: center;
}

.column4 {
  width: 15%;
   text-align: center;
}
.column5 {
  width: 5%;
   text-align: center;
}

.column11 {
  width: 20%;
  padding-left: 20px;
   text-align: center;
}

.column22 {
  width: 15%;
  text-align: center;
}

.column33 {
  width: 35%;
   text-align: center;
}

.column44 {
  width: 15%;
   text-align: center;
}

.column55 {
  width: 5%;
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
											<th class="cell100 column2">작성일</th>
											<th class="cell100 column3">내용</th>
											<th class="cell100 column4">별점(1~5)</th>
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
												<td class="cell100 column2" style="padding-left:10px;"><%=a.getEnrollDate()%></td>
												<td class="cell100 column3" style="text-align:left;  padding-left:20px;"><%=a.geteComment()%></td>
												<td class="cell100 column4">
													<fieldset class="starability-basic" style="width:100%; padding-top:15px; padding-left:40px;"> 
													    <%for(int i=1; i<=a.getSevalPoint(); i++){ %>
													    <label for="rate<%=i %>" style="cursor:default;"></label>
													    <% }%>
												
													  </fieldset>
												</td>
												<td class="cell100 column5"><input type="button" class="gs-btn" style="padding: 10px 10px" value="삭제" onclick="deleteEval();">
												<form action="" id="detailForm" method="post">
													<input type="hidden" name="sevalNum" value="<%=a.getSevalNum()%>">
												</form></td>
											</tr>
											<%}}%>
										<script>		
											function deleteEval(){
												
												var con = confirm("평가를 삭제하시겠습니까");
												
												if(con){
													$("#detailForm").attr("action", "<%=request.getContextPath()%>/deleteEval.es");
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
			
			<form action="" id="detailForm2" method="post">
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
											<th class="cell100 column11">공고 제목</th>
											<th class="cell100 column22">업체명</th>
											<th class="cell100 column33">내용</th>
											<th class="cell100 column44">별점(1~5)</th>
											<th class="cell100 column55"></th>
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
												<td class="cell100 column11" style="padding-left:40px;"><%=a.getwTitle()%></td>
												<td class="cell100 column22" style="padding-left:50px;"><%=a.getOpName()%></td>
												<td class="cell100 column33">
													<div class='form-row' style="padding-left:30px;">
													  <textarea id='comment' name='eComment' style="width:450px; min-height:80px; margin-top:12px;"></textarea>
													</div>
												</td>
												<td class="cell100 column44">
													<fieldset class="starability-basic" style="width:100%; padding-top:15px; padding-left:28px;"> 
													    <input type="radio" id="rate5" name="sevalPoint" value="5" />
													    <label for="rate5" title="Amazing">5 stars</label>
													
													    <input type="radio" id="rate4" name="sevalPoint" value="4" />
													    <label for="rate4" title="Very good">4 stars</label>
													
													    <input type="radio" id="rate3" name="sevalPoint" value="3" />
													    <label for="rate3" title="Average">3 stars</label>
													
													    <input type="radio" id="rate2" name="sevalPoint" value="2" />
													    <label for="rate2" title="Not good">2 stars</label>
													
													    <input type="radio" id="rate1" name="sevalPoint" value="1" />
													    <label for="rate1" title="Terrible">1 star</label>
													  </fieldset>
												</td>
												<td class="cell100 column55"><input type="button" class="gs-btn" style="padding: 10px 10px" value="등록" onclick="makeEmpEval();">
													<input type="hidden" name="oNum" value="<%=a.getoNum()%>">
													<input type="hidden" name="applyNum" value="<%=a.getApplyNum()%>">
												</td> 
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
			</form>
			
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
				
				function makeEmpEval(){
					
					var con = confirm("후기를 등록하시겠습니까?");
					
					if(con){
						$("#detailForm2").attr("action", "<%=request.getContextPath()%>/makeEmpEval.es");
						$("#detailForm2").submit();
					}else{
						return false;
					}
				}
		  	</script>
			<form>
  
</form>

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->


</body>
</html>