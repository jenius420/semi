<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="search.model.vo.IncruitInfo"%>
	<% response.setContentType("text/html; charset=utf-8"); %>
<% ArrayList<IncruitInfo> incruitList = (ArrayList)request.getAttribute("incruitList");
 int maxPage = (Integer)request.getAttribute("maxPage");
 String detail =(String)request.getAttribute("detail");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<!-- 부가적인 테마 -->

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->

<script type="text/javascript"
	src="<%=request.getContextPath() %>/views/search/js/detailList.js"></script>

<style>
#searchResult>tr:hover{
	color:rgb(176,18,241);
	background: lightgrey;
	cursor: pointer;
}
	#bigCategory{
		border: 1px solid black;
	}
	table>tr>td{
		border: 1px solid black;
		
	}
	#jumbotron{
	background-image: url('<%=request.getContextPath()%>/resources/images/slide2.jpg');
}
#pageCheck{
	background:gray;
}
.districtSub>div:hover, .categorySub>div:hover, .district>td:hover{
	color:rgb(176,18,241);
	cursor: pointer;
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

	<div class="row" style="padding-top: 50px; padding-left: 15px;">

		<div class="col-sm-2" id="districtSub"
			style="border-right: 1px solid black;">
			<div class="categorySub">
				<p>
					<strong>업종별 알바</strong>
				</p>
				<br />
				<div class="col-lg-12">외식·음료</div>
				<div class="col-lg-12">유통·판매</div>
				<div class="col-lg-12">문화·여가·생활</div>
				<div class="col-lg-12">서비스</div>
				<div class="col-lg-12">사무직</div>
				<div class="col-lg-12">고객상담·리서치·영업</div>
				<div class="col-lg-12">생산·건설·노무</div>
				<div class="col-lg-12">IT·컴퓨터</div>
				<div class="col-lg-12">교육·강사</div>
				<div class="col-lg-12">디자인</div>
				<div class="col-lg-12">미디어</div>
				<div class="col-lg-12">운전·배달</div>
				<div class="col-lg-12">병원·간호·연구</div>

			</div>
			
			<div class="districtSub">
				<p>
				
					<strong>지역별 알바</strong>
				</p>
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
			<br />
			<br />
			<br />
			<br />
			<br /> <br />
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
</div>
		



		<div class="col-sm-9" style="padding-top: 10px;" align="center">
			<form class="form-inline" action="<%=request.getContextPath()%>/detailSearch.se" method="get">
				<input type="text" class="form-control" id="innerDetail" name="detail" value="<%=detail%>"/>
				<button type="submit" id="searchBtn" class="btn btn-default">검색</button>
			</form>
	<br /><br /><br />
			<h2 class="sub-header" style="float: left;">검색 결과</h2>
          <br />
          <div class="table-responsive" style="padding-left: 15px;">
            <table class="table row" id="incruitList">
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
              
              <%for(int i=0; i<incruitList.size(); i++){ %>
              		 <tr>
                  <td style="padding-top: 18px;"><%=incruitList.get(i).getNum() %></td>
                  
                  <td style="padding-top: 18px;"><%=incruitList.get(i).getDistrictName() %>
                  </td>
                  <td>
                  	
                  	<input type="hidden" value=<%=incruitList.get(i).getoNum() %> />
                  	<a><%=incruitList.get(i).getOpName() %></a><br />
                  	<a><%=incruitList.get(i).getTitle() %></a>
                  	
                  </td>
                  <td style="padding-top: 18px;">
                  	<%if(incruitList.get(i).getWorkForm().equals("시급")){ %>
                  	<div class="payType" style="border: 1px solid orange; display: inline;color: orange; padding: 1px;">시</div>
                  	<%}else if(incruitList.get(i).getWorkForm().equals("일급")){ %>
                  	<div class="payType" style="border: 1px solid blue; display: inline;color: blue; padding: 1px;">일</div>
                  	<%}else if(incruitList.get(i).getWorkForm().equals("주급")){ %>
                  	<div class="payType" style="border: 1px solid purple; display: inline;color: purple; padding: 1px;">주</div>
                  	<%}else if(incruitList.get(i).getWorkForm().equals("월급")){ %>
                  	<div class="payType" style="border: 1px solid green; display: inline;color: green; padding: 1px;">월</div>
                  	<%}else{ %>
                  	<div class="payType" style="border: 1px solid red; display: inline;color: red; padding: 1px;">연</div>
                  	<%} %>
                  	
                  	
                  	
                  	<%=incruitList.get(i).getSalary() %>원
                  </td>
                  <td style="padding-top: 18px;"><%=incruitList.get(i).getWorkDay() %></td>
                  <td style="padding-top: 18px;"><%=incruitList.get(i).getStartDate() %></td>
                </tr>
              <%} %>
               
                
              </tbody>
            </table>
				<div class="btn-group" role="group" aria-label="..." id="pageBtns">
					<button type="button" class="btn btn-default test">&lt&lt</button>
					<button type="button" class="btn btn-default test">&lt</button>
					<%
					 if(maxPage>10){
						maxPage=10;
					}
					for(int i=1;i<=maxPage;i++){  
					if(i==1){%>
					<button type="button"  id="pageCheck" class="btn btn-default test"><%=i %></button>
					<%}else{ %>
					<button type="button" class="btn btn-default test"><%=i %></button>
					<%} 
					}  %>
					<button type="button" class="btn btn-default test">&gt</button>
					<button type="button" class="btn btn-default test">&gt&gt</button>
				</div>
			</div>
        </div>
      </div>

		
		
	


	<%@ include file="../common/footer.jsp"%>
</body>
</html>