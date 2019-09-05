<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="empService.model.vo.Emp, ownerService.model.vo.Owner"%>
<%
	ArrayList<Emp> empList = (ArrayList<Emp>)request.getAttribute("empList");
	//ArrayList<Owner> ownerList = (ArrayList<Owner>)request.getAttribute("ownerList");
%>
<!DOCTYPE html >
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<meta http-equiv="Content-Type" content="charset=UTF-8">
<%@ include file="../common/includeTable.jsp"%>

<style>

.column0 {
  width: 15%;
  padding-left: 40px;
   text-align: center;
}
.column1 {
  width: 10%;
   text-align: center;
}
.column2 {
  width: 10%;
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
  width: 15%;
   text-align: center;
}
.column6 {
  width: 8%;
   text-align: center;
}
.column7 {
  width: 7%;
   text-align: center;
}


#empDropBox{
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

	<div id="header"><%@ include file="../common/header.jsp"%>
		<div class="jumbotron" id="jumbotron">
	      <div class="container">
	      	<br /><br /><br /><br /><br /><br /><br /><br />
	      </div>
	 	</div>
 	</div>
	
	<div id="content">
	
		<div id="content-left"><%@ include file="../adminService/AdminServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			<div class="tab_container m-t-40 m-l-80" >
				<input type="radio" name="emp" onclick="showBox(this);" id="emp" checked><label for="emp">사용중 회원</label>
				<input type="radio" name="emp" onclick="showBox(this);" id="empDrop"><label for="empDrop">탈퇴 회원</label>		
			</div>
		
			<div id="empBox" class="box " >
				<!--===============================================================================================-->	
				<div class="limiter">
				<div class="container-table100">
					<div class="wrap-table100" style="width:100%">
						<div class="table100 ver4">
							<div class="table100-head">
								<table>
									<thead>
										<tr class="row100 head">
											<th class="cell100 column0">고유 번호</th>
											<th class="cell100 column1">아이디</th>
											<th class="cell100 column2">이름</th>
											<th class="cell100 column3">주민등록번호</th>
											<th class="cell100 column4">전화번호</th>
											<th class="cell100 column5">이메일</th>
											<th class="cell100 column6">경고 횟수</th>
											<th class="cell100 column7"></th>
										</tr>
									</thead>
								</table>
							</div>
		
							<div class="table100-body js-pscroll">
								<table>
									<tbody>
										<%if(empList.isEmpty()){%>
											<tr class="row100 body"><td colspan="6" style="text-align:center">존재하는 내용이 없습니다</td></tr>
										<%}else{ %>
											<%for(Emp a : empList) {
												if(a.getInvalid().equals("N")){%>
											<tr class="row100 body">
												<td class="cell100 column0"><%=a.getEmpNum()%></td>
												<td class="cell100 column1"><%=a.geteId()%></td>
												<td class="cell100 column2"><%=a.geteName()%></td>
												<td class="cell100 column3"><%=a.getEcNum().substring(0,8)%>******</td>
												<td class="cell100 column4"><%=a.getPhone()%></td>
												<td class="cell100 column5"><%=a.getEmail()%></td>
												<td class="cell100 column6"><%=a.getWarningCount()%></td>
												<td class="cell100 column7"><input type="button" class="gs-btn" style="padding: 10px 10px" value="탈퇴" onclick="deleteInter();">
												<form action="" id="detailForm" method="post">
													<input type="hidden" name="hNo" value="">
												</form></td>
											</tr>
											<%}}}%>
											<script>		
												function deleteInter(){
													
													var con = confirm("관심기업에서 삭제 하시겠습니까");
													
													if(con){
														$("#detailForm").attr("action", "<%=request.getContextPath()%>/deleteInterestOwnerServlet.es");
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
			
			
			
			<div id="empDropBox" class="box">
				<!--===============================================================================================-->	
				<div class="limiter">
				<div class="container-table100">
					<div class="wrap-table100" style="width:100%">
						<div class="table100 ver4">
							<div class="table100-head">
								<table>
									<thead>
										<tr class="row100 head">
											<th class="cell100 column0">고유 번호</th>
											<th class="cell100 column1">아이디</th>
											<th class="cell100 column2">이름</th>
											<th class="cell100 column3">주민등록번호</th>
											<th class="cell100 column4">전화번호</th>
											<th class="cell100 column5">이메일</th>
											<th class="cell100 column6">경고 횟수</th>
											<th class="cell100 column7"></th>
										</tr>
									</thead>
								</table>
							</div>
		
							<div class="table100-body js-pscroll">
								<table>
									<tbody>
										<%if(empList.isEmpty()){%>
											<tr class="row100 body"><td colspan="6" style="text-align:center">존재하는 내용이 없습니다</td></tr>
										<%}else{ %>
											<%for(Emp a : empList) {
												if(a.getInvalid().equals("Y")){%>
											<tr class="row100 body">
												<td class="cell100 column0"><%=a.getEmpNum()%></td>
												<td class="cell100 column1"><%=a.geteId()%></td>
												<td class="cell100 column2"><%=a.geteName()%></td>
												<td class="cell100 column3"><%=a.getEcNum().substring(0,8)%>******</td>
												<td class="cell100 column4"><%=a.getPhone()%></td>
												<td class="cell100 column5"><%=a.getEmail()%></td>
												<td class="cell100 column6"><%=a.getWarningCount()%></td>
												<td class="cell100 column7"><input type="button" class="gs-btn" style="padding: 10px 10px" value="복구" onclick="deleteInter();">
												<form action="" id="detailForm" method="post">
													<input type="hidden" name="hNo" value="">
												</form></td>
											</tr>
											<%}}}%>
											
											<script>		
												function deleteInter(){
													
													var con = confirm("관심기업에서 삭제 하시겠습니까");
													
													if(con){
														$("#detailForm").attr("action", "<%=request.getContextPath()%>/deleteInterestOwnerServlet.es");
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
				
				
				<script>
					$(function(){
						$(".select td").click(function(){
							var num = $(this).parent().children().eq(5).text();
							location.href="<%=request.getContextPath()%>/watchingIncruit2.es?wNum=" + num;
						});
					});
				</script>
				<script>
					function selectIncruit(wNum){
						location.href='<%=request.getContextPath()%>/watchingIncruit2.es?wNum='+ wNum;
					}
				
					function showBox(element){
						var tag = document.getElementsByClassName("box");
						var addBtn = document.getElementsByClassName("gs-btn-parent");
						
						for(var i=0 ; i<tag.length ; i++){
							if(element.id+"Box" == tag[i].id){
								tag[i].style.display = "block";
									//if(i==0){addBtn[0].style.display = "block";}else{addBtn[0].style.display = "none";}
							}else{
								tag[i].style.display = "none";
							}
						}
					}
	
				</script>
		
		
		
		
		
		
		
		
		
		
		
		
		

			경고 warnMem.as(구직자만 경고 가능한지 결정해야함) input String[] memArr, flag 1구직자 2사업자
			탈퇴 deleteMem.as  input String[] memArr, flag 1구직자 2사업자
		</div>
		
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
	
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>

</div> <!-- /화면 -->

</body>
</html>