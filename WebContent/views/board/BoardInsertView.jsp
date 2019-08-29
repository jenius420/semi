<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	.outer{
		width:900px;
		height:500px;
		background:white;
		color:purple;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	table{
		border:1px solid purple;
	}
	.tableArea{
		width:500px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
	
	td{
		width:100px;
	}
	th{
		width:50px;
	}
	.btnArea{
		width:150px;
		margin-left:auto;
		margin-right:auto;
	}
	#contentImgArea1, #contentImgArea2, #contentImgArea3{
		width:120px;
		height:100px;
		border:2px solid darkgray;
		display:table-cell;
	}
	#contentImgArea1:hover, #contentImgArea2:hover, #contentImgArea3:hover{
		cursor:pointer;
	}
	
	#fileArea{
		display:none;
	}
	
</style>
</head>
<body>

	<div class="outer">
		<br>
		
		<h2 align="center">게시판 작성</h2>
		
		<!-- 파일 업로드를 위해 enctype을 지정해줘야된다. -->
		<form action="<%= request.getContextPath() %>/insert.bo" method="post" enctype="multipart/form-data">
		
		<div class="tableArea">
				<table align="center">
					<tr>
						<th width="100px">제목</th>
						<td colspan="3"><input type="text" size="60" name="title"></td>
					</tr>
					<tr>
						<th>첨부</th>
						<td>
							<div id="contentImgArea1">
								<img id="contentImg1" width="120" height="100">
							</div>
						</td>
						<td>
							<div id="contentImgArea2">
								<img id="contentImg2" width="120" height="100">
							</div>
						</td>
						<td>
							<div id="contentImgArea3">
								<img id="contentImg3" width="120" height="100">
							</div>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="15" cols="60" name="content" style="resize:none;"></textarea>
						</td>
					</tr>
				</table>
				
				
				
				<!-- 파일 업로드 하는 div -->
				<div id="fileArea">
					<input type="file" multiple name="thumbnailImg1" id="thumbnailImg1" onchange="loadImg(this, 1);">
					<input type="file" multiple name="thumbnailImg2" id="thumbnailImg2" onchange="loadImg(this, 2);">
					<input type="file" multiple name="thumbnailImg3" id="thumbnailImg3" onchange="loadImg(this, 3);">
				</div>
				
				
				
				<script>
					// 미리보기 이미지 영역을 클릭할 때 파일 첨부 창이 뜨도록!
					$(function(){						
						$("#contentImgArea1").click(function(){
							$("#thumbnailImg1").click();
						});
						$("#contentImgArea2").click(function(){
							$("#thumbnailImg2").click();
						});
						$("#contentImgArea3").click(function(){
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
								case 1: $("#contentImg1").attr("src", e.target.result); break;
								case 2: $("#contentImg2").attr("src", e.target.result); break;
								case 3: $("#contentImg3").attr("src", e.target.result); break;
								}
								
							}
							
							// 파일 읽어주는 메소드
							reader.readAsDataURL(value.files[0]);
							
							
						}
					}
				</script>
				
				
				
				
				
				
				
				<br>
				
				<div align="center">
					<button type="reset">취소하기</button>
					<button type="submit">등록하기</button>
				</div>
		</div>
			</form>
		</div>
	
</body>
</html>






