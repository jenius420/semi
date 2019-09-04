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

</style>
</head>
<body>
<%@ include file="views/common/header.jsp" %>
<button onclick="location.href='<%=request.getContextPath()%>/test111'">확인</button>

<div></div>
<div class="jumbotron" id="jumbotron">
      <div class="container">
      	<br /><br /><br /><br /><br /><br /><br /><br />
      </div>
 </div>
<br /><br />
<!-- 추천알바 -->
<div>
<p style="padding-left: 100px"><strong>추천알바</strong></p>
<br />
<div class="row" id="choiceAlba">
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

<script>
	$(function(){
		<% if(loginUser != null){ %> // 로그인한 회원만 이용가능하게
		location.href="<%= contextPath %>/RecomendList.main?=dongnum"+dongnum;
		<% } %>
	});
</script>

<!-- 지역별 알바검색 및  업종별 알바 검색 -->
<div class="row" style="padding: 100px;">
	<div class="col-lg-6" id="district">
		<p><strong>지역별 알바</strong></p>
		<br />
		<div class="col-lg-2">종로구</div>
		<div class="col-lg-2">중구</div>
		<div class="col-lg-2">용산구</div>
		<div class="col-lg-2">성동구</div>
		<div class="col-lg-2">광진구</div>
		<div class="col-lg-2">동대문구</div>
		<div class="col-lg-2">중랑구</div>
		<div class="col-lg-2">성북구</div>
		<div class="col-lg-2">강북구</div>
		<div class="col-lg-2">도봉구</div>
		<div class="col-lg-2">노원구</div>
		<div class="col-lg-2">은평구</div>
		<div class="col-lg-2">서대문구</div>
		<div class="col-lg-2">마포구</div>
		<div class="col-lg-2">양천구</div>
		<div class="col-lg-2">강서구</div>
		<div class="col-lg-2">구로구</div>
		<div class="col-lg-2">금천구</div>
		<div class="col-lg-2">영등포구</div>
		<div class="col-lg-2">동작구</div>
		<div class="col-lg-2">관악구</div>
		<div class="col-lg-2">서초구</div>
		<div class="col-lg-2">강남구</div>
		<div class="col-lg-2">송파구</div>
		<div class="col-lg-2">강동구</div>
	</div>
	<div class="col-lg-6" id="category">
		<p style="padding-left: 10px"><strong>업종별 알바</strong></p>
		<br />
		<div class="col-lg-4">외식·음료</div>
		<div class="col-lg-4">유통·판매</div>
		<div class="col-lg-4">문화·여가·생활</div>
		<div class="col-lg-4">서비스</div>
		<div class="col-lg-4">사무직</div>
		<div class="col-lg-4">고객상담·리서치·영업</div>
		<div class="col-lg-4">생산·건설·노무</div>
		<div class="col-lg-4">IT·컴퓨터</div>
		<div class="col-lg-4">교육·강사</div>
		<div class="col-lg-4">디자인</div>
		<div class="col-lg-4">미디어</div>
		<div class="col-lg-4">운전·배달</div>
		<div class="col-lg-4">병원·간호·연구</div>		
	</div>
</div>

<!--상품적용알바 -->
<div>
<p style="padding-left: 100px"><strong>플래티넘알바</strong></p>
<br />
<div class="row" id="choiceAlba" align="left">
    <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
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
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;" >
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
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
          </h5>
         </div>
      </div>
      <div class="col-lg-2 col-sm-6 mb-4" style="padding-left: 5px; padding-right: 5px;">
      <div class="card h-10">
        <a href="#"><img class="card-img-top col-lg-12 col-sm-12" src="photo/logoImages/noLogo.jpg" alt=""></a>
        </div>
        <div class="card-body">
          <h5 class="card-title">
            <a href="#">Project Oneaaaaaaaaaaaaaaaaaa</a>
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







<%@ include file="views/common/footer.jsp" %>





</body>
</html>