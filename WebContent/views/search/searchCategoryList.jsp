<%@page import="search.model.vo.IncruitInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<% response.setContentType("text/html; charset=utf-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<!-- 부가적인 테마 -->

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->



<style>
	#bigCategory{
		border: 1px solid black;
	}
	table>tr>td{
		border: 1px solid black;
		
	}
	#jumbotron{
	background-image: url('<%=request.getContextPath()%>/resources/images/slide2.jpg');
}
#districtSub>div:hover, .category>td:hover{
	color:rgb(176,18,241);
	cursor: pointer;
}
</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div></div>
	<div class="jumbotron" id="jumbotron">
	<br /><br /><br />
	<br /><br /><br /><br /><br />
 	</div>
	
      <div class="row" style="padding-top: 50px; padding-left: 15px;">
      
       <div class="col-sm-2" id="districtSub" style="border-right: 1px solid black;">
       	<p><strong>지역별 알바</strong></p>
		<br />
		<div class="col-lg-6">종로구</div>
		<div class="col-lg-6">중구</div>
		<div class="col-lg-6">용산구</div>
		<div class="col-lg-6">성동구</div>
		<div class="col-lg-6">광진구</div>
		<div class="col-lg-6">동대문구</div>
		<div class="col-lg-6">중랑구</div>
		<div class="col-lg-6">성북구</div>
		<div class="col-lg-6">강북구</div>
		<div class="col-lg-6">도봉구</div>
		<div class="col-lg-6">노원구</div>
		<div class="col-lg-6">은평구</div>
		<div class="col-lg-6">서대문구</div>
		<div class="col-lg-6">마포구</div>
		<div class="col-lg-6">양천구</div>
		<div class="col-lg-6">강서구</div>
		<div class="col-lg-6">구로구</div>
		<div class="col-lg-6">금천구</div>
		<div class="col-lg-6">영등포구</div>
		<div class="col-lg-6">동작구</div>
		<div class="col-lg-6">관악구</div>
		<div class="col-lg-6">서초구</div>
		<div class="col-lg-6">강남구</div>
		<div class="col-lg-6">송파구</div>
		<div class="col-lg-6">강동구</div>
       <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
       <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />

       </div>
       
     
        
        <div class="col-sm-9" style="padding-top: 10px;"  align="center">
        	<label>업직종</label>
        	<table class="table table-bordered" id="bigCategory">
        		<tr class="category">
        			<td class="col-sm-3">외식·음료</td>
        			<td class="col-sm-3">유통·판매</td>
        			<td class="col-sm-3">문화·여가·생활</td>
        			<td class="col-sm-3">서비스</td>
        		</tr>
        		<tr class="category">
        			<td>사무직</td>
        			<td>IT·컴퓨터</td>
        			<td>고객상담·리서치·영업</td>
        			<td>생산·건설·노무</td>
        		</tr>
        		<tr class="category">
        			<td>교육·강사</td>
        			<td>디자인</td>
        			<td>미디어</td>
        			<td>운전·배달</td>
        		</tr>
        		<tr class="category">
        			<td>병원·간호·연구</td>
        		</tr>
        	</table>
        	
        	<button id="searchBtn">검색</button>
        <br /><br /><br />
          <h2 class="sub-header" style="float: left;">검색 결과</h2>
          <br />
          <div class="table-responsive" style="padding-left: 15px;">
            <table class="table table-striped row" id="incruitList">
              <thead style="border: 1px solid lightgray; ">
                <tr>
                  <th class="col-sm-1"></th>
                  <th class="col-sm-1">지역</th>
                  <th class="col-sm-5" >기업명/모집제목</th>
                  <th class="col-sm-2">급여</th>
                  <th class="col-sm-1">근무시간</th>
                  <th class="col-sm-1">등록일</th>
                </tr>
              </thead>
              <tbody id="searchResult">
                <tr>
                  <td style="padding-top: 18px;">글번호</td>
                  <td style="padding-top: 18px;">영등포구</td>
                  <td>
                  	<div >
                  	<a>기업명</a><br />
                  	<a>모집제목</a>
                  	</div>
                  </td>
                  <td style="padding-top: 18px;">
                  	<div class="payType" style="border: 1px solid lightgreen; display: inline;color: green; padding: 1px;">월</div>
                  	xxxxxxx원
                  </td>
                  <td style="padding-top: 18px;">xx시~xx시</td>
                  <td style="padding-top: 18px;">오늘/어제/</td>
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                  <td>adipiscing</td>
                  <td>elit</td>
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>Integer</td>
                  <td>nec</td>
                  <td>odio</td>
                  <td>Praesent</td>
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>libero</td>
                  <td>Sed</td>
                  <td>cursus</td>
                  <td>ante</td>
                </tr>
                <tr>
                  <td>1,004</td>
                  <td>dapibus</td>
                  <td>diam</td>
                  <td>Sed</td>
                  <td>nisi</td>
                </tr>
                <tr>
                  <td>1,005</td>
                  <td>Nulla</td>
                  <td>quis</td>
                  <td>sem</td>
                  <td>at</td>
                </tr>
                <tr>
                  <td>1,006</td>
                  <td>nibh</td>
                  <td>elementum</td>
                  <td>imperdiet</td>
                  <td>Duis</td>
                </tr>
                <tr>
                  <td>1,007</td>
                  <td>sagittis</td>
                  <td>ipsum</td>
                  <td>Praesent</td>
                  <td>mauris</td>
                </tr>
                <tr>
                  <td>1,008</td>
                  <td>Fusce</td>
                  <td>nec</td>
                  <td>tellus</td>
                  <td>sed</td>
                </tr>
                <tr>
                  <td>1,009</td>
                  <td>augue</td>
                  <td>semper</td>
                  <td>porta</td>
                  <td>Mauris</td>
                </tr>
                <tr>
                  <td>1,010</td>
                  <td>massa</td>
                  <td>Vestibulum</td>
                  <td>lacinia</td>
                  <td>arcu</td>
                </tr>
                <tr>
                  <td>1,011</td>
                  <td>eget</td>
                  <td>nulla</td>
                  <td>Class</td>
                  <td>aptent</td>
                </tr>
                <tr>
                  <td>1,012</td>
                  <td>taciti</td>
                  <td>sociosqu</td>
                  <td>ad</td>
                  <td>litora</td>
                </tr>
                <tr>
                  <td>1,013</td>
                  <td>torquent</td>
                  <td>per</td>
                  <td>conubia</td>
                  <td>nostra</td>
                </tr>
                <tr>
                  <td>1,014</td>
                  <td>per</td>
                  <td>inceptos</td>
                  <td>himenaeos</td>
                  <td>Curabitur</td>
                </tr>
                <tr>
                  <td>1,015</td>
                  <td>sodales</td>
                  <td>ligula</td>
                  <td>in</td>
                  <td>libero</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>

	
	
	<%@ include file="../common/footer.jsp" %>
	
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/views/search/js/searhCategoryList.js"></script>
</body>
</html>