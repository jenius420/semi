<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, ownerService.model.vo.IncruitProduct"%>
<%
	ArrayList<IncruitProduct> list = (ArrayList<IncruitProduct>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공고상품 조회</title>
</head>
<body>

	<div class="tableArea">
		
			<table id="listArea">
				<tr>
					<th>상품명</th>
					<th width="300">설명</th>
					<th>요금(단위:일)</th>
				</tr>
				<%if(list.isEmpty()){%>
					<tr><td colspan="3">존재하는 상품이 없습니다</td></tr>
				<%}else{ 
				for(IncruitProduct i : list) {%>
				<tr>
					<td><%=i.getpTitle() %></td>
					<td><%=i.getpExplain() %></td>
					<td><%=i.getpPay()%></td>
				</tr>
				<%}}%>
				
				
			</table>
		
		</div>

</body>
</html>