<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.*, common.model.vo.PageInfo, member.model.vo.Member"%>
 
 
 
    
<%
	 ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
 	String contextPath = request.getContextPath(); 
	
 	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
 	int listCount = pi.getListCount();
 	int currentPage = pi.getCurrentPage();
 	int maxPage = pi.getMaxPage();
 	int startPage = pi.getStartPage();
 	int endPage = pi.getEndPage();
	
%>    
    
    
    
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 
 
    <title>BoardList</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<style>

	.all{
		width:1000px;
		height:1000px;
		background:#ffe6f9;
		margin-left:auto;
		margin-right:auto;


.tableArea{
	width:800px;
	height:350px;
	margin-left:auto;
	margin-right:auto;
}
.outer{
		width:800px;
		height:500px;
		background:white;
		color:purple;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	button{
		background:white;
		color:purple;
		padding-right:10px;
		padding-left:10px;
		border : 1px solid #d9b3ff; !important;
	}
</style>

</head>
  <body>
  
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 
  <%@ include file="../common/header.jsp"%>
  	<div></div>
	<div class="jumbotron" id="jumbotron">
		<br />
		<br />
		<br /> <br />
		<br />
		<br />
		<br />
		<br />
	</div>
	
	
<div class="all">	
	<div class="outer">
		<br>
		
		<hr>
    	<p align="center" style="font-size:20px">게시판 리스트</p>
  		<hr>

  
  
  <div class="tableArea">
  	<table class="table table-hover" id="listArea">
    	<tr>
      		<th width="100" style="text-align:center">글번호</th>
      		<th width="200">글제목</th>
      		<th width="80">작성자</th>
      		<th width="80" style="text-align:center">조회수</th>
      		<th width="150">작성일</th>
    	</tr>
    	
    	
   	<% if(list.isEmpty()){%>
		<tr>
			<td colspan="5">조회된 리스트가 없습니다</td>
		</tr>
		<% }else{ %>		
			<% for(Board b : list){ %> 
				<%if(b.getIsNotice().equals("Y")){ %> 
					<tr>
						<td style="text-align:center"><%= b.gettNum() %></td>
						<td>※ <%= b.getTitle() %> ※</td>
						<td><%= b.geteName() %></td>
						<td style="text-align:center"><%= b.getBoardCount() %></td>
						<td><%= b.getUpdateDate() %></td>				
					</tr>
				 <%} %> 
			<% } %>
		<% } %>		
	
	 	<tr>
    		<td colspan="5" style="cursor:default"></td>
    	</tr>
 
     	<% if(list.isEmpty()){ %>
		<tr>
			<td colspan="6">조회된 리스트가 없습니다</td>
		</tr>
		<% }else{ %>		
			<% for(Board b : list){ %>
				<%-- <%if(b.getIsNotice().equals("N")){ %> --%>
					<tr>
						<td colspan="1" style="text-align:center"><%= b.gettNum() %></td>
						<td><%= b.getTitle() %></td>
						<td><%= b.geteName() %></td>
						<td style="text-align:center"><%= b.getBoardCount() %></td>
						<td><%= b.getUpdateDate() %></td>				
					</tr>
				<%-- <%} %>	 --%>
			<% } %>
		<% } %>			
	</table>
  </div>
		
		
		
		<!-- 페이징바 만들기 -->
		<div class="pagingArea" align="center">
		
			<!-- 맨처음으로 (<<) -->
			<button onclick="location.href='<%= contextPath %>/list.bo?currentPage=1'"> &lt;&lt; </button>
			
			<!-- 이전페이지로(<) -->
			<%if(currentPage == 1){ %>
			<button disabled> &lt; </button>
			<%}else{ %>
			<button onclick="location.href='<%= contextPath %>/list.bo?currentPage=<%= currentPage-1 %>'"> &lt; </button>
			<%} %>
			
			
			<!-- 10개의 페이지 목록 -->
			<%for(int p=startPage; p<=endPage; p++){ %>
				
				<%if(p == currentPage){ %>
				<button disabled> <%= p %> </button>
				<%}else{ %>
				<button onclick="location.href='<%=contextPath %>/list.bo?currentPage=<%= p %>'"> <%= p %> </button>
				<%} %>
				
			<%} %>
			
			
			<!-- 다음페이지로(>) -->
			<%if(currentPage == maxPage){ %>
			<button disabled> &gt; </button>
			<%}else { %>
			<button onclick="location.href='<%= contextPath %>/list.bo?currentPage=<%= currentPage+1 %>'"> &gt; </button>
			<%} %>
			
			<!-- 맨끝으로(>>) -->
			<button onclick="location.href='<%= contextPath %>/list.bo?currentPage=<%= maxPage %>'"> &gt;&gt; </button>
			
		</div>
		
		
		
		
		
		
		
		
		
		<div class="searchArea" align="center">
			<select id="searchCondition" name="category">
				<option name="category" value="title">제목</option>
				<option name="category" value="eName">작성자</option>
				<option name="category" value="bBody">내용</option>
			</select>
			
			<input type="text" id="BoardListSearch" name="sText">
			
			<button type="button" onclick='search();'>검색하기</button>
			
			
			
			
			
			<%if(loginUser != null){ %>
			<button onclick="location.href='<%= contextPath %>/insertForm.bo'">작성하기</button>
			
				<%if(loginUser.getKind() == 3){ %>
				<button onclick="location.href='<%= contextPath %>/insertPostForm.bo'">공지 작성하기</button>
				<%} %>
				
			<%} %>
			
		</div>
  
  </div>
  
  </div>
  			<script>
				function search() {
					location.href="<%=contextPath%>/search.bo?category=" + $('select[name=category]').val()+"&sText="+$('#BoardListSearch').val();
				}
			</script>
  
  
  <script>
  
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"#d9b3ff", "cursor":"pointer","color":"white"});
			}).mouseout(function(){
				$(this).parent().css({"background":"#ffe6f9","color":"black"});
			}).click(function(){
				
				var tNum = $(this).parent().children().eq(0).text();
					<% if(loginUser != null){ %> 
						location.href="<%= contextPath %>/detail.bo?tNum=" + tNum;
					<%}else{ %>
						alert("로그인해야만 상세보기가 가능합니다!");
					<%}%>
			});
		});
		$(function(){
			$("button").mouseenter(function(){
				$(this).css({"background":"#d9b3ff", "cursor":"pointer","color":"white"});
			}).mouseout(function(){
				$(this).css({"background":"white","color":"black"});	
		
			});
		});
		
	</script>
  
  
  
  		
  	<%@ include file="../common/footer.jsp" %>
  
  
  
  </body>
</html>