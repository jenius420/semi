<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.*, common.model.vo.PageInfo"%>
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

<link rel="stylesheet" href="resources/css/templatemo_style.css">

<title>게시판</title>
</head>
<body>

	<div class="outer">
	<br>
		<div class="tableArea">
			<table align="center" id="listArea">
				<tr>
					<th width="100">글번호</th>
					<!-- <th width="100">카테고리</th> -->
					<th width="300">글제목</th>
					<th width="100">작성자</th>
					<th width="100">조회수</th>
					<th width="150">작성일</th>
					<!-- <th width="150">photo</th> -->
				</tr>
				<% if(list.isEmpty()){ %>
					<tr>
						<td colspan="6">조회된 리스트가 없습니다</td>
					</tr>
				<% }else{ %>
					
					<% for(Board b : list){ %>
					<tr>
						<td><%= b.gettNum() %></td>
						<%-- <td><%= b.getCategory() %></td> --%>
						<td><%= b.getTitle() %></td>
						<td><%= b.geteName() %></td>
						<td><%= b.getBoardCount() %></td>
						<td><%= b.getUpdateDate() %></td>
						<!-- <td><%= b.getPhoto() %></td> -->
					</tr>
					<% } %>
				<% } %>
			</table>
		</div>
		
		<!-- 페이징바 -->
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/boardList.bo?currentPage=1'"> &lt;&lt; </button>
			
			<!-- 맨처음으로 (<<) -->
			<button onclick="location.href='<%= request.getContextPath() %>/boardList.bo?currentPage=1'"> &lt;&lt; </button>
			
			<!-- 이전페이지로(<) -->
			<% if(currentPage == 1){ %>
				<button disabled> &lt; </button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/boardList.bo?currentPage=<%=currentPage-1%>'"> &lt; </button>
			<% } %>
			
			
			
			<!-- 10개의 페이지 목록 -->
			<%for(int p = startPage; p <= endPage; p++){ %>
				
				<%if(p == currentPage){ %>
					<button disabled> <%= p %> </button>
				<%}else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/boardList.bo?currentPage=<%=p%>'"><%=p%></button>
				<%} %>
			<% } %>
		
		
			<!-- 다음페이지로(>) -->
			<% if(currentPage == maxPage){ %>
				<button disabled> &gt; </button>
			<% }else{ %>
				<button onclick="location.href='<%=request.getContextPath()%>/boardList.bo?currentPage=<%=currentPage+1%>'"> &gt; </button>
			<% } %>
		
		
			<!-- 맨끝으로(>>) -->
			<button onclick="location.href='<%=request.getContextPath()%>/boardList.bo?currentPage=<%=maxPage%>'"> &gt;&gt; </button>
		</div>
		
		
		<div class="searchArea" align="center">
			<select id="searchCondition" name="searchCondition">
				<option>----</option>
				<option value="category">카테고리</option>
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search">
			
			<button type="submit">검색하기</button>
			
			<%if(loginUser != null){ %>
			<button onclick="location.href='<%= request.getContextPath() %>/insertForm.bo'">작성하기</button>
			<%} %>
			
		</div>
		
		<script>
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"rgb(176,18,241)", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css("background", "rgb(176,18,241)");
			}).click(function(){
				
				var bId = $(this).parent().children().eq(0).text();
				
				<% if(loginUser != null){ %> // 로그인한 회원만 이용가능하게
					location.href="<%= request.getContextPath() %>/detail.bo?tNum=" + tNum;
				<%}else{ %>
					alert("로그인해야만 상세보기가 가능합니다!");
				<%}%>
			});
		});
	</script>
		
		
		
		
	</div>

</body>
</html>









