<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.*, common.model.vo.PageInfo, member.model.vo.Member"%>
 
 
 
    
<%
	 ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");

	/* Member loginUser = (Member)session.getAttribute("loginUser"); */

 	 String contextPath = request.getContextPath(); 
	
%>    
    
    
    
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>BoardList</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <body>
  
    <h1 align="center">게시판 리스트</h1>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
 	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  
  
  
  <div class="tableArea">
  	<table class="table table-hover" id="listArea">
    	<tr>
      		<th width="100" style="text-align:center">글번호</th>
      		<th width="300">글제목</th>
      		<th width="100">작성자</th>
      		<th width="100">조회수</th>
      		<th width="150">작성일</th>
    	</tr>
    	
    	
    	<% if(list.isEmpty()){ %>
		<tr>
			<td colspan="5">조회된 리스트가 없습니다</td>
		</tr>
		<% }else{ %>		
			<% for(Board b : list){ %>
				<%if(b.getIsNotice().equals("Y")){ %>
					<tr>
						<td style="text-align:center"><img src="<%=contextPath%>/photo/logoImages/postIcon2.jpeg"><%= b.gettNum() %></td>
						<td><img src="<%=contextPath%>/photo/logoImages/postIcon.jpeg"><%= b.getTitle() %></td>
						<td><%= b.geteName() %></td>
						<td><%= b.getBoardCount() %></td>
						<td><%= b.getUpdateDate() %></td>				
					</tr>
				<%} %>
			<% } %>
		<% } %>			
    	
    	
 
     	<% if(list.isEmpty()){ %>
		<tr>
			<td colspan="6">조회된 리스트가 없습니다</td>
		</tr>
		<% }else{ %>		
			<% for(Board b : list){ %>
				<%if(b.getIsNotice().equals("N")){ %>
					<tr>
						<td colspan="1" style="text-align:center"><%= b.gettNum() %></td>
						<td><%= b.getTitle() %></td>
						<td><%= b.geteName() %></td>
						<td><%= b.getBoardCount() %></td>
						<td><%= b.getUpdateDate() %></td>				
					</tr>
				<%} %>	
			<% } %>
		<% } %>			
	</table>
  </div>
		
		<div class="searchArea" align="center">
			<select id="searchCondition" name="searchCondition">
				<option>----</option>
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			
			<input type="search" id="BoardListSearch">
			
			<button type="submit">검색하기</button>
			
			<%-- <%if(loginUser != null){ %> --%>
			<button onclick="location.href='<%= contextPath %>/insertForm.bo'">작성하기</button>
			<%-- <%} %> --%>
			
		</div>
  
  
  
  <script>
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"violet", "cursor":"pointer","color":"white"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white","color":"black"});
			}).click(function(){
				
				var tNum = $(this).parent().children().eq(0).text();
				<%-- <% if(loginUser != null){ %> // 로그인한 회원만 이용가능하게 --%>
					location.href="<%= contextPath %>/detail.bo?tNum=" + tNum;
				<%-- <%}else{ %>
					alert("로그인해야만 상세보기가 가능합니다!");
				<%}%> --%>
			});
		});
	</script>
  
  
  
  
  </body>
</html>