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
  width: 10%;
  padding-left: 40px;
   text-align: center;
}
.column1 {
  width: 24%;
   text-align: center;
}
.column2 {
  width: 10%;
  text-align: center;
}
.column3 {
  width: 1%;
   text-align: center;
}
.column4 {
  width: 10%;
   text-align: center;
}
.column5 {
  width: 15%;
   text-align: center;
}
.column6 {
  width: 10%;
   text-align: center;
}
.column7 {
  width: 10%;
   text-align: center;
}
.column8 {
  width: 10%;
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
				<input type="radio" name="owner" onclick="showBox(this);" id="ownerDrop"><label for="ownerDrop">탈퇴 회원</label>
				<input type="radio" name="owner" onclick="showBox(this);" id="ownerNoCertify"><label for="ownerNoCertify">사업자 미인증 회원</label>	
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
												<th class="cell100 column3"></th>
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
															<td class="cell100 column2">&nbsp; <%=a.getOpNum()%></td>
															<td class="cell100 column3"></td>
															<td class="cell100 column4">&nbsp;&nbsp;&nbsp;&nbsp;<%=a.getoTel()%></td>
															<td class="cell100 column5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=a.getoName()%></td>
															<td class="cell100 column6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=a.getPhone()%></td>
															<td class="cell100 column7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=a.getEmail()%></td>
															<td class="cell100 column8"><input type="button" class="gs-btn" style="padding: 10px 10px" value="탈퇴" onclick="deleteOwner(<%=a.getoNum() %>,'<%=a.getoName() %>');">
															<form action="" id="detailForm" method="post">
																<input type="hidden" name="oNum" value="<%=a.getoNum() %>">
															</form></td>
														</tr>
											<%}}}%>
											<script>		
												function deleteOwner(num,name){		
													var con = confirm(name + " 회원을 탈퇴시키겠습니까?");
													
													if(con){
														$("#detailForm").attr("action", "<%=request.getContextPath()%>/deleteOwner.as?oNum="+num);
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
			
			
			<div id="ownerNoCertifyBox" class="box">
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
												<th class="cell100 column3"></th>
												<th class="cell100 column4">전화번호</th>
												<th class="cell100 column5">이름</th>
												<th class="cell100 column6">휴대폰번호</th>
												<th class="cell100 column7">이메일</th>
												<th class="cell100 column8">인증 대상</th>
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
													if(a.getCheckONum().equals("N")){%>
														<tr class="row100 body" style="height:70px;">
								
															<td class="cell100 column0"><%=a.getoId()%></td>
															<td class="cell100 column1"><%=a.getOpName()%></td>
															<td class="cell100 column2"><%=a.getOpNum()%></td>
															<td class="cell100 column3"></td>
															<td class="cell100 column4"><%=a.getoTel()%></td>
															<td class="cell100 column5"><%=a.getoName()%></td>
															<td class="cell100 column6"><%=a.getPhone()%></td>
															<td class="cell100 column7"><%=a.getEmail()%></td>
															<td class="cell100 column8"><input type="checkbox" name="oNumArr" value="<%=a.getoNum()%>" style="margin-left:70px;"></td>
														</tr>
											<%}}}%>
					
										</tbody>
									</table>
									
									<div style="text-align: right;">
										<button type="button" class="gs-btn" onclick="certifyOwner();" style="padding: 10px 10px; margin-right:40px;">인증하기</button>
									</div>
									
									<script>
				
										function certifyOwner(){
												
											var	oNumArr = "";
	
											var arrLength = $("input:checkbox[name='oNumArr']:checked").length;
											
											$("input:checkbox[name='oNumArr']:checked").each(function(index){
												oNumArr += $(this).val() +",";
											});
										
											if(arrLength>0){
												$("#detailForm").attr("action", "<%=request.getContextPath()%>/certifyOwner.as?oNumArr="+oNumArr);
												$("#detailForm").submit();
											}else{
												alert("1개 이상을 선택해야 합니다");
												return false;
											}
										}
									
									</script>
								</div>
							</div>
						</div>
					</div>
				</div>`
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
												<th class="cell100 column3"></th>
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
															<td class="cell100 column3"></td>
															<td class="cell100 column4"><%=a.getoTel()%></td>
															<td class="cell100 column5"><%=a.getoName()%></td>
															<td class="cell100 column6"><%=a.getPhone()%></td>
															<td class="cell100 column7"><%=a.getEmail()%></td>
															<td class="cell100 column8"><input type="button" class="gs-btn" style="padding: 10px 10px" value="복구" onclick="restoreOwner(<%=a.getoNum()%>,'<%=a.getoName()%>');">
														</tr>
											<%}}}%>
											
											<script>		
												function restoreOwner(num,name){
													
													var con = confirm(name + " 회원을 복구시키겠습니까?");
													
													if(con){
														$("#detailForm").attr("action", "<%=request.getContextPath()%>/restoreOwner.as?oNum="+num);
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