<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="empService.model.vo.Emp"%>
<%
	ArrayList<Emp> empList = (ArrayList<Emp>)request.getAttribute("empList");
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
  width: 10%;
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
  width: 10%;
   text-align: center;
}
.column4 {
  width: 15%;
   text-align: center;
}
.column5 {
  width: 12%;
   text-align: center;
}
.column6 {
  width: 15%;
   text-align: center;
}
.column7 {
  width: 12%;
   text-align: center;
}
.column8 {
  width: 8%;
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
											<th class="cell100 column3">나이/성별</th>
											<th class="cell100 column4">주민등록번호</th>
											<th class="cell100 column5">전화번호</th>
											<th class="cell100 column6">이메일</th>
											<th class="cell100 column7">메일/SMS수신</th>
											<th class="cell100 column8"></th>
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
												<td class="cell100 column3"><%=a.getAge() %> <%=a.getGender()%></td>
												<td class="cell100 column4"><%=a.getEcNum().substring(0,8)%>******</td>
												<td class="cell100 column5"><%=a.getPhone()%></td>
												<td class="cell100 column6"><%=a.getEmail()%></td>
												<td class="cell100 column7"><%=a.getMailAccept()%> / <%=a.getSmsAccept()%></td>
												<td class="cell100 column8"><input type="button" class="gs-btn" style="padding: 10px 10px" value="탈퇴" onclick="deleteEmp('<%=a.geteName()%>', '<%=a.geteId()%>', '<%=a.getEmpNum() %>');">
							
											</tr>
											<%}}}%>
											
											<script>		
												function deleteEmp(name, id, num){
													
													var con = confirm(name + "(" + id + ")" + " 회원을 탈퇴시키겠습니까?");
													
													if(con){
														$("#detailForm").attr("action", "<%=request.getContextPath()%>/deleteEmp.as?eNum="+num);
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
			
			
			<form action="" id="detailForm" method="post">
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
											<th class="cell100 column3">나이/성별</th>
											<th class="cell100 column4">주민등록번호</th>
											<th class="cell100 column5">전화번호</th>
											<th class="cell100 column6">이메일</th>
											<th class="cell100 column7">메일/SMS수신</th>
											<th class="cell100 column8"></th>
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
												<td class="cell100 column3"><%=a.getAge() %> <%=a.getGender()%></td>
												<td class="cell100 column4"><%=a.getEcNum().substring(0,8)%>******</td>
												<td class="cell100 column5"><%=a.getPhone()%></td>
												<td class="cell100 column6"><%=a.getEmail()%></td>
												<td class="cell100 column7"><%=a.getMailAccept()%> / <%=a.getSmsAccept()%></td>
												<td class="cell100 column8"><input type="button" class="gs-btn" style="padding: 10px 10px" value="복구" onclick="restoreEmp(<%=a.getEmpNum()%>);">									
											</tr>
											<%}}}%>
											
											<script>		
												function restoreEmp(eNum){
													
													$("#detailForm").attr("action", "<%=request.getContextPath()%>/restoreEmp.as?eNum="+eNum);
													$("#detailForm").submit();

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
				</form></td>
	
				<script>
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
		

		</div>
		
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
	
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>

</div> <!-- /화면 -->

</body>
</html>