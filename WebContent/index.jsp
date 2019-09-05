<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AlbaMoon</title>

<style>
#jumbotron{
	background-image: url('resources/images/slide2.jpg');
}
#choiceAlba{
	padding-left: 150px;
	padding-right: 150px;

}
#category>div:hover, #district>div:hover, .row>div>div>img{
	color:rgb(176,18,241);
	cursor: pointer;
}
input{
  text-align: left;
  font-size: 1px 
}

</style>

<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="views/common/header.jsp" %>


<div></div>
<div class="jumbotron" id="jumbotron">
      <div class="container">
      	<br /><br /><br /><br /><br /><br /><br /><br />
      </div>
 </div>
<br /><br />

<!-- 추천알바 -->
<%if(loginUser != null){ %> <!-- 로그인한 회원만 보이게 -->
<div>
<p style="padding-left: 100px; font-size:25px"><strong>추천알바</strong></p>
<br />
<div class="row" id="choiceAlba1">
    <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt="">
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
    <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;" >
      <div class="card h-10">
        	<img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt="">
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project One</a>
          </h5>
         </div>
      </div><div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;" >
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project One</a>
          </h5>
         </div>
      </div><div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;" >
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project One</a>
          </h5>
         </div>
      </div><div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project One</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project One</a>
          </h5>
         </div>
      </div>  
	</div>
</div>
<% } %>

<script>

	 $(function(){ 
		
		$.ajax({
				url:"test22.sss",
				
				type:"get",
				success:function(data1){  
					
					$.each(data1, function(index, value){
						console.log(value.saveName);
					});					
				
					
					var $platinum = $("#choiceAlba1");
					
					$platinum.html("").css("padding-left","40px").css("padding-right","39px");
					var i =0;
					$.each(data, function(index, value){
						
						var $div = $("<div>").attr("class","col-sm-2 mb-4").css("padding-top","40px"); // <div> </div>
						var $hidden = $("<input>").attr("type","hidden").attr("class","wnum");
						var $div1 = $("<div>").attr("class","card h-10");
						var $div2 = $("<div>").attr("class","card-body");
						var $a = $("<a>") // <a> </a>
						var $a1 = $("<a>").text(value.wTitle).css("height","50px");
						var $h5 = $("<h5>").attr("class","card-title"); // <h5> </h5>
						var $img = $("<img>").attr("src","<%= request.getContextPath() %>/photo/logoImages/" + value.saveName).css("height","100px").attr("class","card-img-top col-lg-12 col-sm-12 plapic"); // <img>
						
						$div.append($div1);
						$div1.append($a);
						$a.append($img);
						$div.append($div2);
						$div2.append($h5);
						$h5.append($a1);
						// <div> <div>  <a> <img> </a> </div> <div> <h5> <a> </a> </h5> </div> </div>
						 
						i++;
						$platinum.append($div)
					});
				},
				
				error:function(){
					console.log("이미지 불러오기 실패");
				}
			});
			
		});

</script>


<!-- 지역별 알바검색 및  업종별 알바 검색 -->
<div class="row" style="padding: 100px;">
	<div class="col-lg-6" id="district">
		<p style="font-size:25px"><strong>지역별 알바</strong></p>
		<br />
		<div class="col-lg-2 mainarea">종로구</div>
		<div class="col-lg-2 mainarea">중구</div>
		<div class="col-lg-2 mainarea">용산구</div>
		<div class="col-lg-2 mainarea">성동구</div>
		<div class="col-lg-2 mainarea">광진구</div>
		<div class="col-lg-2 mainarea">동대문구</div>
		<div class="col-lg-2 mainarea">중랑구</div>
		<div class="col-lg-2 mainarea">성북구</div>
		<div class="col-lg-2 mainarea">강북구</div>
		<div class="col-lg-2 mainarea">도봉구</div>
		<div class="col-lg-2 mainarea">노원구</div>
		<div class="col-lg-2 mainarea">은평구</div>
		<div class="col-lg-2 mainarea">서대문구</div>
		<div class="col-lg-2 mainarea">마포구</div>
		<div class="col-lg-2 mainarea">양천구</div>
		<div class="col-lg-2 mainarea">강서구</div>
		<div class="col-lg-2 mainarea">구로구</div>
		<div class="col-lg-2 mainarea">금천구</div>
		<div class="col-lg-2 mainarea">영등포구</div>
		<div class="col-lg-2 mainarea">동작구</div>
		<div class="col-lg-2 mainarea">관악구</div>
		<div class="col-lg-2 mainarea">서초구</div>
		<div class="col-lg-2 mainarea">강남구</div>
		<div class="col-lg-2 mainarea">송파구</div>
		<div class="col-lg-2 mainarea">강동구</div>
	</div>
	<div class="col-lg-6" id="category">
		<p style="padding-left: 10px; font-size:25px"><strong>업종별 알바</strong></p>
		<br />
		<div class="col-lg-4 maintype">외식·음료</div>
		<div class="col-lg-4 maintype">유통·판매</div>
		<div class="col-lg-4 maintype">문화·여가·생활</div>
		<div class="col-lg-4 maintype">서비스</div>
		<div class="col-lg-4 maintype">사무직</div>
		<div class="col-lg-4 maintype">고객상담·리서치·영업</div>
		<div class="col-lg-4 maintype">생산·건설·노무</div>
		<div class="col-lg-4 maintype">IT·컴퓨터</div>
		<div class="col-lg-4 maintype">교육·강사</div>
		<div class="col-lg-4 maintype">디자인</div>
		<div class="col-lg-4 maintype">미디어</div>
		<div class="col-lg-4 maintype">운전·배달</div>
		<div class="col-lg-4 maintype">병원·간호·연구</div>		
	</div>
</div>

<script>
		// 지역별로 이동
		$('.mainarea').click(function(){
			var dis=$(this).text();
			location.href="<%= request.getContextPath() %>/districtSub.se?dis="+dis;
		});
		
		// 업종별로 이동
		$('.maintype').click(function(){
			var cate=$(this).text();
			location.href="<%= request.getContextPath() %>/cateSub.se?cate="+cate;
		});
</script>

<!--상품적용알바 -->

<div class="row" >
<p style="padding-left: 100px; font-size:25px"><strong>플래티넘알바</strong></p>
<br />
<div class="row" id="choiceAlba2" align="left">
    
	</div>
</div>


<script>

	 $(function(){ 
		
		$.ajax({
				url:"test.sss",
				
				type:"get",
				success:function(data){  
					
					$.each(data, function(index, value){
						console.log(value.saveName);
					});					
				
					
					var $platinum = $("#choiceAlba2");
					
					$platinum.html("").css("padding-left","40px").css("padding-right","39px");
					var i =0;
					$.each(data, function(index, value){
						
						var $div = $("<div>").attr("class","col-sm-2 mb-4").css("padding-top","40px"); // <div> </div>
						var $hidden = $("<input>").attr("type","hidden").attr("class","wnum");
						var $div1 = $("<div>").attr("class","card h-10");
						var $div2 = $("<div>").attr("class","card-body");
						var $a = $("<a>") // <a> </a>
						var $a1 = $("<a>").text(value.wTitle).css("height","50px");
						var $h5 = $("<h5>").attr("class","card-title"); // <h5> </h5>
						var $img = $("<img>").attr("src","<%= request.getContextPath() %>/photo/logoImages/" + value.saveName).css("height","100px").attr("class","card-img-top col-lg-12 col-sm-12 plapic"); // <img>
						
						$div.append($div1);
						$div1.append($a);
						$a.append($img);
						$div.append($div2);
						$div2.append($h5);
						$h5.append($a1);
						// <div> <div>  <a> <img> </a> </div> <div> <h5> <a> </a> </h5> </div> </div>
						 
						i++;
						$platinum.append($div)
					});
				},
				
				error:function(){
					console.log("이미지 불러오기 실패");
				}
			});
			
		});

</script>




<%@ include file="views/common/footer.jsp" %>





</body>
</html>