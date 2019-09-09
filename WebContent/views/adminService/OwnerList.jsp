<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.Owner"%>
<%

	ArrayList<Owner> ownerList = (ArrayList<Owner>)request.getAttribute("ownerList");
%>
<!DOCTYPE html>
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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


.column00 {
  width: 15%;
  padding-left: 40px;
   text-align: center;
}
.column11 {
  width: 10%;
   text-align: center;
}
.column22 {
  width: 10%;
  text-align: center;
}
.column33 {
  width: 15%;
   text-align: center;
}
.column44 {
  width: 15%;
   text-align: center;
}
.column55 {
  width: 15%;
   text-align: center;
}
.column66 {
  width: 8%;
   text-align: center;
}


#ownerDropBox, #ownerNoCertifyBox{
display:none;
}

.tab_container [id^="owner"]{
  display: none;
}

.tab_container [id^="owner"]:checked + label {
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
				<input type="radio" name="owner" onclick="showBox(this);" id="owner" checked><label for="owner">사용중 회원</label>
				<input type="radio" name="owner" onclick="showBox(this);" id="ownerNoCertify"><label for="ownerNoCertify">사업자 미인증 회원</label>	
				<input type="radio" name="owner" onclick="showBox(this);" id="ownerDrop"><label for="ownerDrop">탈퇴 회원</label>		
			</div>
		
			<div id="ownerBox" class="box " >
				<!--===============================================================================================-->	
				<div class="limiter">
				<div class="container-table100">
					<div class="wrap-table100" style="width:100%">
						<div class="table100 ver4">
							<div class="table100-head">
								<table>
									<thead>
										<tr class="row100 head">
											<th class="cell100 column0">아이디</th>
											<th class="cell100 column1">업체명</th>
											<th class="cell100 column2">사업자번호</th>
											<th class="cell100 column3">업종</th>
											<th class="cell100 column4">전화번호</th>
											<th class="cell100 column5">이름</th>
											<th class="cell100 column6">휴대폰번호</th>
											<th class="cell100 column7">이메일</th>
											<th class="cell100 column8"></th>
										</tr>
									</thead>
								</table>
							</div>
		
							<div class="table100-body js-pscroll">
								<table>
									<tbody>
										<%if(ownerList.isEmpty()){%>
											<tr class="row100 body"><td colspan="6" style="text-align:center">존재하는 내용이 없습니다.</td></tr>
										<%}else{ %>
											<%for(Owner a : ownerList) {
												if(a.getInvalidId().equals("N")){%>
											<tr class="row100 body">
												<td class="cell100 column0"><%=a.getoId()%></td>
												<td class="cell100 column1"><%=a.getOpName()%></td>
												<td class="cell100 column2"><%=a.getOpNum()%></td>
												<td class="cell100 column3"><%=a.getCategory()%> :: <%=a.getType()%></td>
												<td class="cell100 column4"><%=a.getoTel()%></td>
												<td class="cell100 column5"><%=a.getoName()%></td>
												<td class="cell100 column6"><%=a.getPhone()%></td>
												<td class="cell100 column7"><%=a.getEmail()%></td>
												<td class="cell100 column8"><input type="button" class="gs-btn" style="padding: 10px 10px" value="탈퇴" onclick="deleteOwner(<%=a.getoName() %>);">
												<form action="" id="detailForm" method="post">
													<input type="hidden" name="oNum" value="<%=a.getoNum() %>">
												</form></td>
											</tr>
											<%}}}%>
											<script>		
												function deleteOwner(name){		
													var con = confirm(name + " 회원을 탈퇴시키겠습니까?");
													
													if(con){
														$("#detailForm").attr("action", "<%=request.getContextPath()%>/deleteOwner.as");
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
			
			
			
			<div id="ownerDropBox" class="box">
				<!--===============================================================================================-->	
				<div class="limiter">
				<div class="container-table100">
					<div class="wrap-table100" style="width:100%">
						<div class="table100 ver4">
							<div class="table100-head">
								<table>
									<thead>
										<tr class="row100 head">
											<th class="cell100 column0">아이디</th>
											<th class="cell100 column1">업체명</th>
											<th class="cell100 column2">사업자번호</th>
											<th class="cell100 column3">업종</th>
											<th class="cell100 column4">전화번호</th>
											<th class="cell100 column5">이름</th>
											<th class="cell100 column6">휴대폰번호</th>
											<th class="cell100 column7">이메일</th>
											<th class="cell100 column8"></th>
										</tr>
									</thead>
								</table>
							</div>
		
							<div class="table100-body js-pscroll">
								<table>
									<tbody>
										<%if(ownerList.isEmpty()){%>
											<tr class="row100 body"><td colspan="6" style="text-align:center">존재하는 내용이 없습니다.</td></tr>
										<%}else{ %>
											<%for(Owner a : ownerList) {
												if(a.getInvalidId().equals("Y")){%>
											<tr class="row100 body">
												<td class="cell100 column0"><%=a.getoId()%></td>
												<td class="cell100 column1"><%=a.getOpName()%></td>
												<td class="cell100 column2"><%=a.getOpNum()%></td>
												<td class="cell100 column3"><%=a.getCategory()%> :: <%=a.getType()%></td>
												<td class="cell100 column4"><%=a.getoTel()%></td>
												<td class="cell100 column5"><%=a.getoName()%></td>
												<td class="cell100 column6"><%=a.getPhone()%></td>
												<td class="cell100 column7"><%=a.getEmail()%></td>
												<td class="cell100 column8"><input type="button" class="gs-btn" style="padding: 10px 10px" value="복구" onclick="restoreOwner();">
												<form action="" id="detailForm" method="post">
													<input type="hidden" name="oNum" value="<%=a.getoNum()%>">
												</form></td>
											</tr>
											<%}}}%>
											
											<script>		
												function restoreOwner(){
							
													$("#detailForm").attr("action", "<%=request.getContextPath()%>/restoreOwner.as");
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
			
			<form action="<%=request.getContextPath()%>/certifyOwner.as" id="detailForm" method="post">
			<div id="ownerNoCertify" class="box">
				<!--===============================================================================================-->	
				<div class="limiter">
				<div class="container-table100">
					<div class="wrap-table100" style="width:100%">
						<div class="table100 ver4">
							<div class="table100-head">
								<table>
									<thead>
										<tr class="row100 head">
											<th class="cell100 column0">아이디</th>
											<th class="cell100 column1">업체명</th>
											<th class="cell100 column2">사업자번호</th>
											<th class="cell100 column3">업종</th>
											<th class="cell100 column4">전화번호</th>
											<th class="cell100 column5">이름</th>
											<th class="cell100 column6">휴대폰번호</th>
											<th class="cell100 column7">이메일</th>
											<th class="cell100 column8"></th>
										</tr>
									</thead>
								</table>
							</div>
		
							<div class="table100-body js-pscroll">
								<table>
									<tbody>
										<%if(ownerList.isEmpty()){%>
											<tr class="row100 body"><td colspan="6" style="text-align:center">존재하는 내용이 없습니다.</td></tr>
										<%}else{ %>
											<%for(Owner a : ownerList) {
												if(a.getCheckONum().equals("Y")){%>
											<tr class="row100 body">
					
												<td class="cell100 column0"><%=a.getoId()%></td>
												<td class="cell100 column1"><%=a.getOpName()%></td>
												<td class="cell100 column2"><%=a.getOpNum()%></td>
												<td class="cell100 column3"><%=a.getCategory()%> :: <%=a.getType()%></td>
												<td class="cell100 column4"><%=a.getoTel()%></td>
												<td class="cell100 column5"><%=a.getoName()%></td>
												<td class="cell100 column6"><%=a.getPhone()%></td>
												<td class="cell100 column7"><%=a.getEmail()%></td>
												<td class="cell100 column8"><input type="checkbox" name="oNumArr" value="<%=a.getoNum()%>"></td>
											</tr>
											<%}}}%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				</div>
				<!--===============================================================================================-->	
			</div>
			
			<button type="submit" class="gs-btn" style="padding: 10px 10px" value="인증" "></button>
			</form>

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