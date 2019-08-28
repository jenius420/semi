<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

서블렛에서 서블렛 호출
//response.sendRedirect("manageResume.es"); 이런식으로 서블렛을 바로 부를 수도 있고
//response.sendRedirect("manageResume.es?empNum="+empNum); 해당서블렛에서 사용될 변수가 있으면 이렇게 추가하면 됨

이전페이지로
onclick="history.go(-1);"
<button type="button" onclick="javascript:history.back();">이전 화면으로</button>

<!-- 게시글 마우스오버/클릭 시 스크립트 -->
<script>
	$(function(){
		$("#listArea td(선택자)").mouserenter(function(){
			$(this).parent().css({"background":"하고싶은색", "cursor":"pointer"});
		}).mouseout(function(){
			$(this).parent().css("background","원래색");
		}).click(function(){
			var num = $(this).parent().children().eq(0).text();
			location.href="<%=request.getContextPath()%>/test.no?tNum=" + num;
		});
	});
	

</script>



서블릿에 안 보이게 넘기는 방법
<form action="" id="id" method="post">
	<input type="hidden" name="num" value ="<%=num %>">
</form>
<script>
	function f(){
		$("#id").attr("action", "<%=request.getContextPath()%>/servlet.so");
		$("#id").submit();
	}
</script>


이미지 업로드
이미지 파일 업로드 form태그에는 enctype="multipart/form-data" 속성을 추가해야 함. input타입은 file임

테이블 리스트 출력시
<table id="listArea">
				<tr>
					<th></th>
					<th width="300"></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				<%if(list.isEmpty()){%>
					<tr><td colspan="?">존재하는 내용이 없습니다</td></tr>
				<%}else{ 
				for(Incruit i : list) {%>
				<tr>
			
					
				</tr>
				<%}}%>
				
				
			</table>
			
			
탭형식
<body>
	<fieldset>
		<legend>검색할 항목을 선택하세요.</legend>
		<input type="radio" name="category" onclick="showDiv(this);" id="title"><label for="title">제목</label>&nbsp; &nbsp; 
		<input type="radio" name="category" onclick="showDiv(this);"  id="date"><label for="date">날짜</label>&nbsp; &nbsp; 
		<input type="radio" name="category" onclick="showDiv(this);" id="writer"><label for="writer">작성자</label>&nbsp; &nbsp;
	</fieldset>
	<hr>
	<div id="titleBox" class="box">
		<form method="post" action="">
			<label> 검색할 제목을 입력하세요 : </label>
			<br> 
			<input type="search" name="title" size="50"> &nbsp;
			<input type="submit" value="검색">
		</form>
	</div>
	<div id="dateBox" class="box">
		<form method="post" action="">
			<label> 검색할 날짜를 선택하세요 : </label>
			<br>
			<input type="date" name="start"> - 
			<input type="date" name="end"> &nbsp; 
			<input type="submit" value="검색">
		</form>
	</div>
	<div id="writerBox" class="box">
		<form method="post" action="">
			<label> 검색할 작성자 아이디를 입력하세요 : </label>
			<br>
			<input type="search" name="writer" size="25"> &nbsp; 
			<input type="submit" value="검색">
		</form>
	</div>
	<script>
		
		function showDiv(element){
			var tag = document.getElementsByClassName("box");
			
			for(var i=0 ; i<tag.length ; i++){
				if(element.id+"Box" == tag[i].id)
					tag[i].style.display = "block";
				else
					tag[i].style.display = "none";
			}

		}
  	</script>
  	
  	
ajax 비동기
<script>
function ajax1(){ // js get방식
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){ // 요청이 끝났고 그에 해당하는 응답이 온 경우
			if(xhr.status == 200){ 
				// 성공적 통신
				태그 = xhr.responseText;
				
			}else if(xhr.status == 404){
				// 통신실패
			}
		}
	}
	xhr.open("GET", "<%=request.getContextPath()%>/ajax1.es?name=큐큐", true); // ture가 비동기

	xhr.send();
}

function ajax2(){ // js post방식
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){ // 요청이 끝났고 그에 해당하는 응답이 온 경우
			if(xhr.status == 200){ 
				// 성공적 통신
				태그 = xhr.responseText;
				
			}else if(xhr.status == 404){
				// 통신실패
			}
		}
	}
	xhr.open("POST", "<%=request.getContextPath()%>/ajax2.es", true); // ture가 비동기

	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded;");
	xhr.send("name=김규식");
	
}
</script>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script> 
$(function(){ // get jquery방식
	$("태그선택자").click(function(){
		var inp = $("태그선택자2").val();
		$.ajax({
			url : "ajax3.es", // url은 필수임
			data : {input:inp}, // 키:밸류 형태. 콤마 찍고 여러개 보낼 수 있음
			type : "get",
			success : function(result){ // 성공 시 실행 함수
				//result = 리턴 변수
				$("태그선택자3").val(result);
			},
			error : function(){ // 실패 시 실행 함수
				
			},
			complete : function(){ // 성공실패 관계없이 무조건 수행되는 함수
				
			}
			
		});
	});
});

$(function(){ //json방식
	$("태그선택자").click(function(){
		var inp = $("태그선택자2").val();
		var inp2 = $("태그선택자3").val();
		$.ajax({
			url : "ajax4.es", // url은 필수임
			data : {input1:inp, input2:inp2}, // 키:밸류 형태. 콤마 찍고 여러개 보낼 수 있음
			type : "post",
			dataType: "json",
			success : function(obj){ // 성공 시 실행 함수
				
				var $tableBody = $("선택자 tbody");
			
				 $tableBody.html("");
				
				$.each(data, function(index, value){
					var $tr = $("<tr>"); // <tr></tr>
					var $no = $("<td>").text(value.no);
					var $name = $("<td>").text(value.name);
					
					$tr.append($no);
					$tr.append($name);
				});
			},
			error : function(){ // 실패 시 실행 함수
				
			},
			complete : function(){ // 성공실패 관계없이 무조건 수행되는 함수
				
			}
			
		});
	});
});


</script>

</body>
</html>