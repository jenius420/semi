<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.IncruitProduct"%>
<%
	ArrayList<IncruitProduct> list = (ArrayList<IncruitProduct>)request.getAttribute("list");
%>
<!DOCTYPE html >
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ include file="../common/includeTable.jsp"%>
<link href="resources/form/css/form.css" rel="stylesheet" media="all">

<style>

.column1 {
  width: 20%;

   text-align: center;
}

.column2 {
  width: 40%;
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



.cell100 input, .cell100 textarea{
margin:auto; 
text-align:center;
border: 1px outset #e0e0e0 !important;
vertical-align: middle ;
box-shadow: 3px 3px 4px rgba(0, 0, 0.15, 0.15);
resize: none;
}

input:focus, textarea:focus , tr:focus{
border:2px solid #df9dfb !important;

}


td:hover{
cursor: default !important;
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
		
		
			<form action="" id="detailForm" method="post">
				<!--===============================================================================================-->	
				<div class="limiter">
					<div class="container-table100">
						<div class="wrap-table100">
							<div class="table100 ver5 ">
								<div class="table100-head">
									<table>
										<thead>
											<tr class="row100 head">
												<th class="cell100 column1">상품명</th>
												<th class="cell100 column2">상품 설명</th>
												<th class="cell100 column3">요금(일)</th>
												<th class="cell100 column4">등록/수정</th>
											</tr>
										</thead>
									</table>
								</div>
								
								<div class="table100-body js-pscroll">
									<table>
										<tbody>
										
											<tr class="row100 body" style="height:200px; ">
		
												<td class="cell100 column1"><input type="text" name="newpTitle"  style="width:200px;"></td>
												<td class="cell100 column2"><textarea name="newpExplain" rows="3" cols="50"></textarea> <!-- style="width:450px; min-height:80px; -->
												<td class="cell100 column3"><input type="text" name="newpPay"></td>
												<td class="cell100 column4">
													<input type="button" class="gs-btn" style="padding: 10px 10px" value="등록" onclick="enrollProduct();">						
														<!-- <input type="hidden" name="sevalNum" value=""> -->						
												</td>
												
											</tr>
											<tr style="height:50px;> <td colspan="4" ></td></tr>
											<%int count = 0; %>
											<%for(IncruitProduct a : list) {%>
												<tr class="row100 body" style="height:100px; ">
													<td class="cell100 column1"><input type="text" name="pTitle<%=count%>" value="<%=a.getpTitle()%>" style="width:200px;"></td>
													<td class="cell100 column2"><textarea name="pExplain<%=count%>" rows="3" cols="50" ><%=a.getpExplain()%></textarea> <!-- style="width:450px; min-height:80px; -->
													<td class="cell100 column3"><input type="text" name="pPay<%=count%>" value="<%=a.getpPay()%>"></td>
													<td class="cell100 column4">
														<input type="button" class="gs-btn" style="padding: 10px 10px" value="수정" onclick="updateProduct(<%=count%>);">						
														<input type="hidden" name="pCode<%=count%>" value="<%=a.getpCode() %>">				
													</td>
												</tr>
											<%count++; }%>
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
				function enrollProduct(){
						$("#detailForm").attr("action", "<%=request.getContextPath()%>/insertProduct.as");
						$("#detailForm").submit();
				}
				
				function updateProduct(count){
					var con = confirm("상품 정보를 수정하시겠습니까?");
					
					if(con){
						$("#detailForm").attr("action", "<%=request.getContextPath()%>/updateProduct.as?count="+count);
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