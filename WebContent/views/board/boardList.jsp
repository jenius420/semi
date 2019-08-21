<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.Board, common.model.vo.PageInfo"%>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>

	<div class="outer">
		<div class="tableArea">
			<table align="center">
				<tr>
					<th width="100">글번호</th>
					<th>컬럼</th>
					<th>컬럼</th>
					<th>컬럼</th>
					<th>컬럼</th>
					<th>컬럼</th>
				</tr>
				<% if(list.isEmpty()){ %>
					<tr>
						<td colspan="n">조회된 리스트가 없습니다</td>
					</tr>
				<% }else{ %>
					
					<% for(Board b : list){ %>
					<tr>
						<td><%= b.get() %></td>
						<td><%= b.get() %></td>
						<td><%= b.get() %></td>
						<td><%= b.get() %></td>
						<td><%= b.get() %></td>
						<td><%= b.get() %></td>
					</tr>
					<% } %>
				<% } %>
			</table>
		</div>
		
		<!-- 페이징바 -->
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/boardList.bo?currentPage=1'"> &lt;&lt; </button>
			
			<% if(currentPage == 1){ %>
				<button disabled> &lt; </button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/boardList.bo?currentPage=<%=currentPage-1%>'"> &lt; </button>
			<% } %>
			
			<%for(int p = startPage; p <= endPage; p++){ %>
				
				<%if(p == currentPage){ %>
					<button disabled> <%= p %> </button>
				<%}else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/boardList.bo?currentPage=<%=p%>'"><%=p%></button>
				<%} %>
			<% } %>
		
			<% if(currentPage == maxPage){ %>
				<button disabled> &gt; </button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/boardList.bo?currentPage=<%=currentPage+1%>'"> &gt; </button>
			<% } %>
		
			<button onclick="location.href='<%=request.getContextPath()%>/boardList.bo?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div>
		
	</div>

</body>
</html>









