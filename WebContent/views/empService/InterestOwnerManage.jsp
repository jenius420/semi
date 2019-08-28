<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, ownerService.model.vo.Incruit, empService.model.vo.HopeEnt"%>
<%
ArrayList<HopeEnt> oList = (ArrayList<HopeEnt>)request.getAttribute("oList");
ArrayList<Incruit> wList = (ArrayList<Incruit>)request.getAttribute("wList");
%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/includeTable.jsp"%>
<title>ALBAMOON</title>

<style>

.column1 {
  width: 20%;
  padding-left: 40px;
   text-align: center;
}

.column2 {
  width: 40%;
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
</style>
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
						<div class="table100 ver4m-t-70">
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
										<%if(oList.isEmpty()){%>
											<tr class="row100 body"><td colspan="5" style="text-align:center">존재하는 내용이 없습니다</td></tr>
										<%}else{ %>
											<%for(HopeEnt a : oList) {%>
											<tr class="row100 body">
												<td class="cell100 column1"><%=a.getOpName()%></td>
												<td class="cell100 column2"><%=a.getOpAddress()%></td>
												<td class="cell100 column3"><%=a.getPhone()%></td>
												<td class="cell100 column4"><%=a.getType()%></td>
												<td class="cell100 column5"><input type="button" class="gs-btn" style="padding: 10px 10px" value="삭제" onclick="deleteInter('<%=a.getoNum() %>');"></td>
											</tr>
											<%}}%>
										<script>
											function deleteInter(oNum){
												if(confirm("삭제 하시겠습니까")){
													location.href='<%=request.getContextPath()%>/deleteInterestOwnerServlet.es?oNum'+oNum;
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
			
			<div class="gs-btn-parent">
				<button class="gs-btn" onclick="location.href='<%=request.getContextPath()%>/비동기 처리';">관심기업 추가</button>
			</div>
			
			<div id="empEvalBfBox" class="box">
				<!--===============================================================================================-->	
				<div class="limiter">
				<div class="container-table100">
					<div class="wrap-table100">
						<div class="table100 ver5 m-t-30">
							<div class="table100-head">
								<table>
									<thead>
										<tr class="row100 head">
											<th class="cell100 column1">업체명</th>
											<th class="cell100 column2">제목</th>
											<th class="cell100 column3">근무일</th>
											<th class="cell100 column4">근무시간</th>
											<th class="cell100 column5">모집현황</th>
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
											<tr class="row100 body select">
												<td class="cell100 column1"><%=a.getOpName()%></td>
												<td class="cell100 column2"><%=a.getwTitle()%></td>
												<td class="cell100 column3"><%=a.getWorkStartTerm()%> ~ <%=a.getWorkEndTerm()%></td>
												<td class="cell100 column4"><%=a.getWorkStartTime()%> ~ <%=a.getWorkEndTime()%></td>
												<td class="cell100 column5"><%=a.getStatus()%></td>
												<td style="width:0%;"><span style="display:none;"><%=a.getwNum()%></span></td>
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
				<script>
				$(function(){
					$(".select td").click(function(){
						var num = $(this).parent().children().eq(5).text();
						location.href="<%=request.getContextPath()%>/watchingIncruit2.es?wNum=" + num;
					});
				});
				</script>
			</div>
		
	조회: 관심기업 테이블 생성

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