<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	Board b = (Board)request.getAttribute("b");

	String[] arr = b.geteName().split(","); 
	// arr[0] ==> "회원번호"
	// arr[1] ==> "회원명"
	
	int eNum = Integer.parseInt(arr[0]); // 회원번호
	String eName = arr[1]; // 회원명
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class="outer">
		<br>
		
		<h2 align="center">게시판 상세보기</h2>
		
		<div class="tableArea">
			
			<table align="center" width="800px" class="listArea">
				<tr>
					<%-- <td>분야</td>
					<td><%= b.getCategory() %></td> --%>
					<td>제목</td>
					<td colspan="3"><%= b.getTitle() %></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><%= eName %></td>
					<td>조회수</td>
					<td><%= b.getBoardCount() %></td>
					<td>작성일</td>
					<td><%= b.getUpdateDate() %></td>
				</tr>
				<tr>
					<td colspan="6">내용</td>
				</tr>
				<tr>
					<td colspan="6">
						<p id="content"><%= b.getbBody() %></p>
					</td>
				</tr>
				<!-- <tr>
					<td colspan="6">첨부사진</td>
				</tr> -->
				<tr>
					<td colspan="6">
						<p id="content"><%= b.getPhoto() %></p>
					</td>
				</tr>
			</table>
			
			<div align="center">
				<button type="button" onclick="history.go(-1);">이전으로</button>
				
				<% if(eNum == loginUser.getUserNo()){ %>
					<button type="button" onclick="updateForm();">수정하기</button>
					<button type="button" onclick="deleteBoard();">삭제하기</button>
				<%} %>
			</div>
		</div>
	</div>
	
	<form action="" id="detailForm" method="post">
		<input type="hidden" name="tNum" value="<%= b.gettNum() %>">
	</form>
	
	<script>
		function updateForm(){
			//location.href="<%=request.getContextPath()%>/updateForm.bo?tNum=" + <%= b.gettNum() %>;
			// 위의 방식대로 하면 url에 그대로 노출.. --> 직접 url창에 타고 들어갈수있다!!!
			
			$("#detailForm").attr("action", "<%=request.getContextPath()%>/updateForm.bo");
			$("#detailForm").submit();
			
		}
		function deleteBoard(){
			$("#detailForm").attr("action", "<%=request.getContextPath()%>/delete.bo");
			$("#detailForm").submit();
		}
	</script>

</body>
</html>