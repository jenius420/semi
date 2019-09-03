<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, sort.model.vo.*" %>
<%
ArrayList<Recruit> list = (ArrayList<Recruit>)request.getAttribute("list");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정렬</title>
</head>
<style>
	a{
	 	text-decoration:none;
	}
 	.sorta{
 		color:purple;
 		font-size:15px;
 	}
 	.sorta:hover{
 		text-decoration:underline;
 	}
 	.headTr th{
 		font-size:15px;
 		color:purple;
 	}
 	.sortDiv{
 		border:1px solid purple;
 		width:810px;
 	}
 	.listDiv{
 		border:1px solid purple;
 		width:810px;
 	}
 	table{
 		width:810px;
 		text-align:center;
 	}
 	#detailTable{
 		width:810px;
 	}
</style>
<body>

	<div class=sortDiv>
       <a class="sorta" id="recently">등록일순</a>
       <a class="sorta" id="hourly">시급순</a>
       <a class="sorta" id="dayly">일급순</a>
       <a class="sorta" id="monthly">월급순</a>
       <a class="sorta" id="yearly">연봉순</a>
	</div>
	
	<div class="listDiv">
	 <table>
		 <colgroup>
			<col width="80px" />
			<col width="100px" />
			<col width="100px" />
			<col width="200px" />
			<col width="80px" />
			<col width="80px" />
			<col width="90px" />
			<col width="80px" />
		</colgroup>
	 
        <tr class="headTr">
			<th scope="col">글번호</th>
			<th scope="col">지역</th>
			<th scope="col">기업명</th>
			<th scope="col">모집제목</th>
			<th scope="col">급여형태</th>
			<th scope="col">급여</th>
			<th scope="col">근무시간</th>
			<th scope="col">등록일</th>
		</tr>
		</table>
		
		<!-- 리스트나올 테이블  -->
		<table id="detailTable">
			<% for(Recruit r : list){ %>
			<tr>
	            <td><%= r.getrNum() %></td>
	            <td><%= r.getArea() %></td>
	            <td><%= r.getCorName() %></td>
	            <td><%= r.getTitle() %></td>
	            <td><%= r.getWorkform() %></td>
	            <td><%= r.getSalary() %></td>
	            <td><%= r.getTime() %></td>
	            <td><%= r.getEnDate() %></td>
	        </tr>
			<% } %>
		</table>
		
	</div>
	

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	
	<script>
		
		// 1. 등록일순 출력하는 함수
		$(function(){
			console.log(<%=list%>);
	 		$("#recently").click(function(){
			
	 			$.ajax({
	 				url:"ajax1.do",
	 				dataType:"json",
	 				type:"get",
	 				success:function(list1){
	 					
	 					var $detailTable = $("#detailTable"); // <table></table>
						
						$detailTable.html(""); // 기존 테이블 정보 초기화
						
						$.each(list1, function(index, value){
							
							var $tr = $("<tr>");
							var $rNumTd = $("<td>").text(value.rNum).css("width", "80px");
							var $areaTd = $("<td>").text(value.area).css("width", "100px");
							var $corNameTd = $("<td>").text(value.corName).css("width", "100px");
							var $titleTd = $("<td>").text(value.title).css("width", "200px");
							var $workformTd = $("<td>").text(value.workform).css("width", "80px");
							var $salaryTd = $("<td>").text(value.salary).css("width", "80px");
							var $timeTd = $("<td>").text(value.time).css("width", "90px");
							var $enDateTd = $("<td>").text(value.enDate).css("width", "80px");
							
							$tr.append($rNumTd);
							$tr.append($areaTd);
							$tr.append($corNameTd);
							$tr.append($titleTd);
							$tr.append($workformTd);
							$tr.append($salaryTd);
							$tr.append($timeTd);
							$tr.append($enDateTd);
							
							$detailTable.append($tr);
							
						});
	 				},
	 				error:function(){
	 					console.log("ajax 통신 실패");
	 				}
	 			});
	 		});
	 	});
		
		
		// 2. 시급순 출력하는 함수
		$(function(){
	 		$("#hourly").click(function(){
			
	 			$.ajax({
	 				url:"ajax2.do",
	 				dataType:"json",
	 				type:"get",
	 				success:function(list2){
	 					
	 					var $detailTable = $("#detailTable"); // <table></table>
						
						$detailTable.html(""); // 기존 테이블 정보 초기화
						
						$.each(list2, function(index, value){
							
							var $tr = $("<tr>");
							var $rNumTd = $("<td>").text(value.rNum).css("width", "80px");
							var $areaTd = $("<td>").text(value.area).css("width", "100px");
							var $corNameTd = $("<td>").text(value.corName).css("width", "100px");
							var $titleTd = $("<td>").text(value.title).css("width", "200px");
							var $workformTd = $("<td>").text(value.workform).css("width", "80px");
							var $salaryTd = $("<td>").text(value.salary).css("width", "80px");
							var $timeTd = $("<td>").text(value.time).css("width", "90px");
							var $enDateTd = $("<td>").text(value.enDate).css("width", "80px");
							
							$tr.append($rNumTd);
							$tr.append($areaTd);
							$tr.append($corNameTd);
							$tr.append($titleTd);
							$tr.append($workformTd);
							$tr.append($salaryTd);
							$tr.append($timeTd);
							$tr.append($enDateTd);
							
							$detailTable.append($tr);
							
						});
	 				},
	 				error:function(){
	 					console.log("ajax 통신 실패");
	 				}
	 			});
	 		});
	 	});
		
		// 3. 일급순 출력하는 함수
		$(function(){
	 		$("#dayly").click(function(){
	 			
	 			$.ajax({
	 				url:"ajax3.do",
	 				dataType:"json",
	 				type:"get",
	 				success:function(list3){
	 					
	 					var $detailTable = $("#detailTable"); // <table></table>
						
						$detailTable.html(""); // 기존 테이블 정보 초기화
						
						$.each(list3, function(index, value){
							
							var $tr = $("<tr>");
							var $rNumTd = $("<td>").text(value.rNum).css("width", "80px");
							var $areaTd = $("<td>").text(value.area).css("width", "100px");
							var $corNameTd = $("<td>").text(value.corName).css("width", "100px");
							var $titleTd = $("<td>").text(value.title).css("width", "200px");
							var $workformTd = $("<td>").text(value.workform).css("width", "80px");
							var $salaryTd = $("<td>").text(value.salary).css("width", "80px");
							var $timeTd = $("<td>").text(value.time).css("width", "90px");
							var $enDateTd = $("<td>").text(value.enDate).css("width", "80px");
							
							$tr.append($rNumTd);
							$tr.append($areaTd);
							$tr.append($corNameTd);
							$tr.append($titleTd);
							$tr.append($workformTd);
							$tr.append($salaryTd);
							$tr.append($timeTd);
							$tr.append($enDateTd);
							
							$detailTable.append($tr);
							
						});
	 				},
	 				error:function(){
	 					console.log("ajax 통신 실패");
	 				}
	 			});
	 		});
	 	});
		
		// 4. 월급순 출력하는 함수
		$(function(){
	 		$("#monthly").click(function(){
			
	 			$.ajax({
	 				url:"ajax4.do",
	 				dataType:"json",
	 				type:"get",
	 				success:function(list4){
	 					
	 					var $detailTable = $("#detailTable"); // <table></table>
						
						$detailTable.html(""); // 기존 테이블 정보 초기화
						
						$.each(list4, function(index, value){
							
							var $tr = $("<tr>");
							var $rNumTd = $("<td>").text(value.rNum).css("width", "80px");
							var $areaTd = $("<td>").text(value.area).css("width", "100px");
							var $corNameTd = $("<td>").text(value.corName).css("width", "100px");
							var $titleTd = $("<td>").text(value.title).css("width", "200px");
							var $workformTd = $("<td>").text(value.workform).css("width", "80px");
							var $salaryTd = $("<td>").text(value.salary).css("width", "80px");
							var $timeTd = $("<td>").text(value.time).css("width", "90px");
							var $enDateTd = $("<td>").text(value.enDate).css("width", "80px");
							
							$tr.append($rNumTd);
							$tr.append($areaTd);
							$tr.append($corNameTd);
							$tr.append($titleTd);
							$tr.append($workformTd);
							$tr.append($salaryTd);
							$tr.append($timeTd);
							$tr.append($enDateTd);
							
							$detailTable.append($tr);
							
						});
	 				},
	 				error:function(){
	 					console.log("ajax 통신 실패");
	 				}
	 			});
	 		});
	 	});
		
		// 5. 연봉순 출력하는 함수
		$(function(){
	 		$("#yearly").click(function(){
			
	 			$.ajax({
	 				url:"ajax5.do",
	 				dataType:"json",
	 				type:"get",
	 				success:function(list5){
	 					
	 					var $detailTable = $("#detailTable"); // <table></table>
						
						$detailTable.html(""); // 기존 테이블 정보 초기화
						
						$.each(list5, function(index, value){
							
							var $tr = $("<tr>");
							var $rNumTd = $("<td>").text(value.rNum).css("width", "80px");
							var $areaTd = $("<td>").text(value.area).css("width", "100px");
							var $corNameTd = $("<td>").text(value.corName).css("width", "100px");
							var $titleTd = $("<td>").text(value.title).css("width", "200px");
							var $workformTd = $("<td>").text(value.workform).css("width", "80px");
							var $salaryTd = $("<td>").text(value.salary).css("width", "80px");
							var $timeTd = $("<td>").text(value.time).css("width", "90px");
							var $enDateTd = $("<td>").text(value.enDate).css("width", "80px");
							
							$tr.append($rNumTd);
							$tr.append($areaTd);
							$tr.append($corNameTd);
							$tr.append($titleTd);
							$tr.append($workformTd);
							$tr.append($salaryTd);
							$tr.append($timeTd);
							$tr.append($enDateTd);
							
							$detailTable.append($tr);
							
						});
	 				},
	 				error:function(){
	 					console.log("ajax 통신 실패");
	 				}
	 			});
	 		});
	 	});
	
	</script>
</body>
</html>