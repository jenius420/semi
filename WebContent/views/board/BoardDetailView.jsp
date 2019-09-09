<%@page import="common.model.vo.Attachment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Board b = (Board)request.getAttribute("b");
	ArrayList<Attachment> fileList = (ArrayList<Attachment>)request.getAttribute("fileList");
	String contextPath = request.getContextPath();
/* 	 String[] arr = b.geteName().split(","); 
	//arr[0] ==> "회원번호"
	// arr[1] ==> "회원명"
	
	int eNum = Integer.parseInt(arr[0]); // 회원번호
	String eName = arr[1]; // 회원명  */
%>

    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BoardDetail</title>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>
	
	.all{
		width:1000px;
		height:1000px;
		background:#ffe6f9;
		margin-left:auto;
		margin-right:auto;
	
	}


	.outer{
		width:800px;
		height:500px;
		color:purple;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}

	
	.tableArea{
		width:800px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
	th{
		background:#ff33ff;
		color:black;
		width:130px;
		text-align: center; !important;
		border : 1px solid purple;
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
	
	.btnArea{
		width:150px;
		margin-left:auto;
		margin-right:auto;
	}
	
		.photo, .detailImgArea{
		padding:0px; !important;
		width:250px; !important;
	
	}
	
</style>







</head>
<body>



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
    	<p align="center" style="font-size:20px">게시판 상세보기</p>
  		<hr>
		
		<div class="tableArea">
			
			<table align="center" width="800px" class="listArea">
				<tr>
					<td colspan="6" height=30px></td>
				</tr>
				<tr>
					<th style="text-align:center">제목</th>
					<td colspan="5" style="padding-left:30px"><%= b.getTitle() %></td>
				</tr>
				<tr>
					<th style="text-align:center">작성자</th>
					<td style="text-align:center"><%= b.geteName() %></td>
					<th style="text-align:center">작성일</th>
					<td style="text-align:center"><%= b.getUpdateDate() %></td>
					<th style="text-align:center">조회수</th>
					<td style="text-align:center"><%= b.getBoardCount() %></td>
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
				
				
				<% if(fileList.size()>0) { %>
				
					<tr>
						<th colspan="6"  style="text-align:center">첨부 사진</th>
					</tr> 
					<tr>
					<% for(int i=0; i<fileList.size(); i++){%>
							<td colspan="2" class="photo">
									<div class="detailImgArea" style="width:250" style="height:200">
										<img width="250" height="200" src="<%=contextPath%>/photo/attachment/<%=fileList.get(i).getChangeName()%>">
									</div>
							</td>
		
					<% } %>
					<% for(int i=0; i<3-fileList.size(); i++){%>
							<td colspan="2" class="photo">
									<div class="detailImgArea"  style="width:250" style="height:200" >
										<img width="250" height="200" src="<%=contextPath%>/photo/attachment/null.PNG">
									</div>
							</td>
					<% } %>
					</tr>
				<% } %>
				<tr>
    				<td colspan="5">
    			</tr>
			</table>
			
	<div class="replyArea">
		<div class="replyWriterArea">
			<table align="center">
				
				<tr>
					<td colspan="6" style="height:50px"></th>
				</tr>
				<tr>
					<td style="width:50px"> </td>
					<td><textarea rows="3" cols="80" id="replyContent" style="resize:none;"></textarea></td>
					<td><button id="addReply">댓글 등록</button></td>
				</tr>
				<tr>
					<td colspan="6" style="height:50px"></th>
				</tr>
			</table>
		</div>
	
	
	
		<div id="replySelectArea">
			<table id="replySelectTable" border="1" align="center">
				<tr>
					<td colspan="6" style="height:10px"></th>
				</tr>
			</table>
		</div>
	
	</div>
	
	
	
	
			<div align="center">
			<br>
			<br>
				<button onclick="location.href='<%= contextPath %>/list.bo'">이전으로</button>
				
				<% if(b.geteNum() == loginUser.geteNum()){ %>
					<button type="button" onclick="updateForm();">수정하기</button>
					<button type="button" onclick="deleteBoard();">삭제하기</button>
				<%} %>
			</div>
		</div>
	</div>
</div>
	
	
	
	
	
	
	
	
	
	
	
	<form action="" id="detailForm" method="post">
		<input type="hidden" name="tNum" value="<%= b.gettNum() %>">
	</form>
	
	<script>
		function updateForm(){
			//location.href="<%=request.getContextPath()%>/updateForm.bo?tNum=" + <%= b.gettNum() %>;
			
			$("#detailForm").attr("action", "<%=request.getContextPath()%>/updateForm.bo");
			$("#detailForm").submit();
			
		}
		function deleteBoard(){
			$("#detailForm").attr("action", "<%=request.getContextPath()%>/delete.bo");
			$("#detailForm").submit();
		}
		
		function selectRlist(){
			var tNum = <%= b.gettNum() %>;
			
			$.ajax({
				url:"rlist.bo",
				data:{tNum:tNum},
				type:"get",
				success:function(list){
					
					var $replyTable = $("#replySelectTable"); 
					
					$replyTable.html(""); 
					
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
	
	
	
	
	
	
	
	
	
		<br />
		<br />
		<br /> 
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br /> 
		<br />		
		<br />
		<br />
		<br />
		<br />
		<br />
		<br /> 
		<br />		
		<br />
		<br />
		<br />
		<br /> 
		<br />
		<br />
		<br />
		<br />
		<br />
	
	<%@ include file="../common/footer.jsp" %>
	
	

</body>
</html>