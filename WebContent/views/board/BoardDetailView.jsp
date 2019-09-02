<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--     <%
	Board b = (Board)request.getAttribute("b");

	String[] arr = b.geteName().split(","); 
	// arr[0] ==> "회원번호"
	// arr[1] ==> "회원명"
	
	int eNum = Integer.parseInt(arr[0]); // 회원번호
	String eName = arr[1]; // 회원명
%> --%>

<% Board b = new Board();%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>




<style>
	.outer{
		width:800px;
		height:500px;
		background:white;
		color:purple;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	table{
	}
	
	.tableArea{
		width:800px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
	th{
		background:lightgray;
		color:black;
	}
	tr{
	border-top: 1px solid black;!important;
		border:1px solid purple;
	}
	
	#content{
		height:230px;
		border : 1px solid purple;
	}
	#photo{
		height:130px;
		border : 1px solid purple;
	}
	
	button{
		background:white;
		color:purple;
		padding-right:10px;
		padding-left:10px;
	}
</style>







</head>
<body>


	<div class="outer">
		<br>
		
		<h2 align="center">게시판 상세보기</h2>
		
		<div class="tableArea">
			
			<table align="center" width="800px" class="listArea">
				<tr>
				<td colspan="6" height=30px></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="5"><%= b.getTitle() %></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%= b.geteName() %></td>
					<th>작성일</th>
					<td><%= b.getUpdateDate() %></td>
					<th>조회수</th>
					<td><%= b.getBoardCount() %></td>
				</tr>
				<tr>
				<td colspan="6" height=30px></td>
				</tr>
				<tr>
					<th colspan="6"></th>
				</tr>
				<tr>
					
					<td colspan="6">
						<p id="content"><%= b.getbBody() %></p>
					</td>
					
				</tr>
				<tr>
					<th colspan="6">첨부사진</th>
				</tr> 
				<tr>
					
					<td colspan="6">
						<p id="photo"><%= b.getPhoto() %></p>
					</td>
					
				</tr>
			</table>
			
			<div align="center">
				<button type="button" onclick="history.go(-1);">이전으로</button>
				
				<%-- <% if(eNum == loginUser.getUserNo()){ %> --%>
					<button type="button" onclick="updateForm();">수정하기</button>
					<button type="button" onclick="deleteBoard();">삭제하기</button>
				<%-- <%} %> --%>
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
		
		
		
		
		
		
		
		
		
		
		
		// 댓글 리스트 출력하는 함수
		function selectRlist(){
			
			// 전달하고자 하는 게시글 번호
			var tNum = <%= b.gettNum() %>;
			
			$.ajax({
				url:"rlist.bo",
				data:{tNum:tNum},
				type:"get",
				success:function(list){
					
					var $replyTable = $("#replySelectTable"); // <table></table>
					
					$replyTable.html(""); // 기존 테이블 정보 초기화
					
					$.each(list, function(index, value){
						
						var $tr = $("<tr>");
						var $eName = $("<td>").text(value.eName).css("width","100px");
						var $commentExplain = $("<td>").text(value.commentExplain).css("width","400px");
						var $enrollDate = $("<td>").text(value.enrollDate).css("width","200px")
						
						$tr.append($eName);
						$tr.append($commentExplain);
						$tr.append($enrollDate);
						
						$replyTable.append($tr);
						
					});
					
				},
				error:function(){
					console.log("통신 실패");
				}
			});
			
		}
		
		$(function(){
			selectRlist();
			
			$("#addReply").click(function(){
				
				var commentExplain = $("#replyContent").val();
				var tNum = <%= b.gettNum() %>;
				
				var eNum = <%=b.geteNum()%>;
				
				$.ajax({
					url:"rinsert.bo",
					type:"post",
					data:{commentExplain:commentExplain, tNum:tNum, eNum:eNum},
					success:function(){
						selectRlist();
						
						$("#replyContent").val("");
					}
				});
				
			});
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>