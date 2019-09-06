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

		
		


	.outer{
		width:800px;
		height:500px;
		background:white;
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
		background:rgb(255, 225, 255);
		color:black;
		width:130px;
		text-align: center; !important;
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
		color:purple;
		padding-right:10px;
		padding-left:10px;
	}

	.btnArea{
		width:150px;
		margin-left:auto;
		margin-right:auto;
	}
	#detailImgArea1, #detailImgArea2, #detailImgArea3{
		width:120px;
		height:100px;
		border:2px solid violet; !important;
		display:table-cell;
	}
	#detailImgArea1:hover, #detailImgArea2:hover, #detailImgArea3:hover{
		cursor:pointer;
	}
	
 	#fileArea{
		display:none;
	} 
	
	input{
		border: 1px solid white;
		width: 100%;
		font-size : 30px;
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
	
	td{
		width:100px;
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







<div class="outer">
		<br>
		
		<hr>
    	<p align="center" style="font-size:20px">게시판 수정</p>
  		<hr>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/update.bo" method="post" enctype="multipart/form-data">
			
					<table align="center" width="800px" class="listArea">
				<tr>
					<td colspan="6" height=30px></td>
				</tr>
				<tr>
					<th style="text-align:center">제목</th>
					<td colspan="3"><input type="text" name="title" style="width:390px" value="<%=b.getTitle()%>"></td>
					<th style="text-align:center">게시판 번호</th>
					<td><input type="text" name="tNum" value="<%=b.gettNum()%>" readonly></td>
				</tr>
				<tr>
					<th style="text-align:center">작성자</th>
					<td><input type="text" name="eName" value="<%=b.geteName()%>" readonly></td>
					<th style="text-align:center">작성일</th>
					<td><input type="text" name="updateDate" value="<%=b.getUpdateDate()%>" readonly></td>
					<th style="text-align:center">조회수</th>
					<td><input type="text" name="boardCount" value="<%= b.getBoardCount() %>" readonly></td>
				</tr>
				<tr>
				<td colspan="6" height=30px></td>
				</tr>
				<tr>
					<th colspan="6"></th>
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
									<%-- <input type="hidden" name="thumbnailImg<%=i+1%>" value="<%=contextPath%>/photo/attachment/<%=fileList.get(i).getChangeName()%>" /> --%>
									</div>
							</td>
		
					<% } %>
					<% for(int i=0; i<3-fileList.size(); i++){%>
							<td colspan="2" class="photo">
									<div id="detailImgArea<%=i+2%>"  class="detailImgArea" style="width:250" style="height:200" >
										<img id="detailImg<%=i+2%>"  width="250" height="200" src="<%=contextPath%>/photo/attachment/null.PNG">
										<%-- <input type="hidden" name="thumbnailImg<%=i+2%>" value="null" /> --%>
									</div>
							</td>
					<% } %>
					</tr>
				<% } %>
				
			</table>
				
				
				
				
				<%-- 
					  <% for(int i=0; i<fileList.size(); i++){%>		
							<div id="fileArea">
								<input type="file" multiple name="thumbnailImg<%=i+1%>" id="thumbnailImg<%=i+1%>" onchange="loadImg(this, <%=i+1%>);" value="<%=contextPath%>/photo/attachment/<%=fileList.get(i).getChangeName()%>">
								<input type="hidden" name="thumbnailImg<%=i+1%>" value="<%=contextPath%>/photo/attachment/<%=fileList.get(i).getChangeName()%>">
							
							</div>
					<% } %>
					<% for(int i=0; i<3-fileList.size(); i++){%>
							<div id="fileArea">
								<input type="file" multiple name="thumbnailImg<%=i+3%>" id="thumbnailImg<%=i+3%>" onchange="loadImg(this, <%=i+3%>);" value="<%=contextPath%>/photo/attachment/null.PNG">
								<input type="hidden" name="thumbnailImg<%=i+3%>" value="null">
							</div>			
					<% } %>  --%>
	 
	
	
	
	
				
				
				<!-- 파일 업로드 하는 div -->
				 <div id="fileArea">
					<input type="file" multiple name="thumbnailImg1" id="thumbnailImg1" onchange="loadImg(this, 1);">
					<input type="file" multiple name="thumbnailImg2" id="thumbnailImg2" onchange="loadImg(this, 2);">
					<input type="file" multiple name="thumbnailImg3" id="thumbnailImg3" onchange="loadImg(this, 3);">
				</div> 
				
				
				
				<script>
				
				
				$()
				
				
				
				
					// 미리보기 이미지 영역을 클릭할 때 파일 첨부 창이 뜨도록!s
					$(function(){						
						$("#detailImgArea1").click(function(){
							$("#thumbnailImg1").click();
						});
						$("#detailImgArea2").click(function(){
							$("#thumbnailImg2").click();
						});
						$("#detailImgArea3").click(function(){
							$("#thumbnailImg3").click();
						});
					});
					
					// 파일 첨부했을 때 미리보기 공간에 미리보기 가능하게 하는 함수
					// [참고] https://developer.mozilla.org/ko/docs/Web/API/FileReader
					function loadImg(value, num){
						// value => input태그
						// num => 조건문으로 작업
						
						// file이 존재하는지 
						if(value.files && value.files[0]){
							
							// 파일을 읽어들일 FileReader객체 생성
							var reader = new FileReader();
							
							// 파일 읽기가 다 완료되었을 때 실행되는 메소드
							reader.onload = function(e){
								
								switch(num){
								case 1: $("#detailImg1").attr("src", e.target.result); break;
								case 2: $("#detailImg2").attr("src", e.target.result); break;
								case 3: $("#detailImg3").attr("src", e.target.result); break;
								}
								
							}
							
							// 파일 읽어주는 메소드
							reader.readAsDataURL(value.files[0]);
							
							
						}
					}
					
					
					
					function test(){
						if(thumbnailImg1 = null){
							var comSubmit1 = new ComSubmit();
				            comSubmit1.setUrl("<c:url value='<%= request.getContextPath() %>/update.bo'/>");
				            /* comSubmit1.submit(fileList.get(1).getChangeName()); */
				            comSubmit1.addParam("photo1",$("#detailImg1").val(););
						}
						if(thumbnailImg2 = null){
							var comSubmit2 = new ComSubmit();
				            comSubmit2.setUrl("<c:url value='<%= request.getContextPath() %>/update.bo'/>");
				            /* comSubmit2.submit(fileList.get(2).getChangeName()); */
				            comSubmit2.addParam("photo2",$("#detailImg2").val(););
						}
						 if(thumbnailImg3 = null){
							 var comSubmit3 = new ComSubmit();
					         comSubmit3.setUrl("<c:url value='<%= request.getContextPath() %>/update.bo'/>");
					         /* comSubmit3.submit(fileList.get(3).getChangeName()); */
					         comSubmit3.addParam("photo3",$("#detailImg3").val(););
						}
					}
					
						
					
				</script>
				
				<br>
				<div align="center">
					<button type="submit" id="updateBtn" onclick="test();">수정</button>
					<button onclick="history.go(-1);">취소</button>
				</div>
			</form>
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