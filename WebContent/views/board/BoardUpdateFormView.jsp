<%@page import="java.util.ArrayList"%>
<%@page import="common.model.vo.Attachment"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	Board b = (Board)request.getAttribute("board");
	Attachment at = (Attachment)request.getAttribute("Attachment");
	ArrayList<Attachment> fileList = (ArrayList<Attachment>)request.getAttribute("fileList");
	String contextPath = request.getContextPath();

%>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>



<style>

		.all{
		width:1000px;
		height:1000px;
		background:#f2e6ff;
		margin-left:auto;
		margin-right:auto;
	
	}



	.outer{
		width:800px;
		height:500px;
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
	}
	tr{
	border-top: 1px solid black;!important;
		border:1px solid purple;
	}
	
	#content{
		height:230px;
		border : 1px solid purple;
		font-size:20px;
	}
	#photo{
		height:130px;
		border : 1px solid purple;
	}
	
	button{
		background:white;
		color:#d9b3ff;
		padding-right:10px;
		padding-left:10px;
	}

	.btnArea{
		width:150px;
		margin-left:auto;
		margin-right:auto;
	}
	#detailImgArea1, #detailImgArea2, #detailImgArea3{
		width:250px;
		height:100px;
		border:2px solid #d9b3ff;
		display:table-cell;
	}
	#detailImgArea1:hover, #detailImgArea2:hover, #detailImgArea3:hover{
		cursor:pointer;
	}
	
 	#fileArea{
		display:none;
	} 
	
	input{
		border:0px;
	}
	
	textarea{
	 	width:800px;
	 	height:225px;
	 	resize:none;
	 	border:0px;
	 	color:purple;
	}
	
	.photo{
		padding:0px;
		width:250px;
	
	}
	
	/* td{
		width:100px;
	} */
	
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
    	<p align="center" style="font-size:20px">게시판 수정</p>
  		<hr>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/test.bo" method="get" enctype="multipart/form-data">
			
					<table align="center" width="800px" class="listArea">
				<tr>
					<td colspan="6" height=30px></td>
				</tr>
				<tr>
					<th style="text-align:center">제목</th>
					<td colspan="5"><input type="text" name="title" style="width:390px" value="<%=b.getTitle()%>">
 					<input type="hidden" name="tNum" value="<%=b.gettNum()%>">
					</td>
				</tr>
				<tr>
				<td colspan="6" height=30px></td>
				</tr>
				<tr>
					<th colspan="6" style="text-align:center">내용</th>
				</tr>
				<tr>
					<td colspan="6">
						<p id="content"><textarea name="bBody"><%=b.getbBody()%></textarea></p>
					</td>
				</tr>
				<% if(fileList.size()>0) { %>
				
					<tr>
						<th colspan="6" style="text-align:center">첨부사진</th>
					</tr> 
					<tr>
						
						
					<% for(int i=0; i<fileList.size(); i++){
					%>
							<td colspan="2" class="photo">
									<div id="detailImgArea<%=i+1%>" class="detailImgArea" style="width:250" style="height:200">
										<img id="detailImg<%=i+1%>" class="detailImg" width="250" height="200" src="<%=contextPath%>/photo/attachment/<%=fileList.get(i).getChangeName()%>">
									</div>
							</td>
		
					<% } %>
					<% for(int i=0; i<3-fileList.size(); i++){%>
							<td colspan="2" class="photo">
									<div id="detailImgArea<%=i+2%>"  class="detailImgArea" style="width:250" style="height:200" >
										<img id="detailImg<%=i+2%>"  width="250" height="200" src="<%=contextPath%>/photo/attachment/null.PNG">
									</div>
							</td>
					<% } %>
					</tr>
				<% } %>
				
			</table>
				
				
				
				<br>
				<div align="center">
					<button type="submit" id="updateBtn">수정</button>
					<button onclick="history.go(-1);">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>
	
	
	
	
	

	
	
	
	

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