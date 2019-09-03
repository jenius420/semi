<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="empService.model.vo.Emp, java.util.ArrayList, common.model.vo.District, common.model.vo.JobType"%>
    
<%	
Emp emp = (Emp)request.getSession().getAttribute("emp");

ArrayList<District> dList = (ArrayList<District>)request.getAttribute("dList");
ArrayList<JobType> tList = (ArrayList<JobType>)request.getAttribute("tList");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>인재 검색</title>
<style>

.searchResume{
border: 1px solid black;	
height: 60px;
padding: 7px;
margin-top:20px;
margin-bottom:50px;
}

.filter{
display : inline-block;
margin-right:30px;

font-size:14px;
}

.filter select, .filter [type="text"]{
border-radius: 5px;
height: 40x;
}


.resume{
border: 1px solid black;
width:450px;
height:300px;
display : inline-block;
margin:10px;
}

.leftside{
display : inline-block;
border: 1px solid black;
width: 40%;
height: 95%;
padding:auto;
margin:auto;
}
.rightside{
display : inline-block;
border: 1px solid black;
width: 59%;
height: 95%;
padding:auto;
margin:auto;
}

.leftside{

}
</style>
</head>
<body>


	
	

<div id="div">

	<div id="header"><%@ include file="../common/header.jsp"%>
		<div class="jumbotron" id="jumbotron">
	      <div class="container">
	      	<br /><br /><br /><br /><br /><br /><br /><br />
	      </div>
	 	</div>
 	</div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../ownerService/OwnerServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			<div class="searchResume">
			
				<div class="filter">
					 <label for='districtNum'>희망근무지(구)</label>
					  <select id='districtNum' name='districtNum'>
					  	<%for(District d : dList) {%>
					  		<option value='<%=d.getDistrictNum()%>'><%=d.getDistrictName() %></option>
					  	<%}%>
					  </select>
				</div>
				
				<div class="filter">
					 <label for='typeNum'>희망업종</label>
					  <select id='typeNum' name='typeNum' style="width:300px;">
						<%for(JobType t : tList) {%>
					  		<option value='<%=t.getTypeNum()%>' ><%=t.getCategoryName()%> :: <%=t.getTypeName()%></option>
					  	<%}%>
					  </select>
				</div>
				
				<div class="filter">
					 <label for='edu'>최종학력</label>
					  <select id='edu' name='edu'>
					  	<option value='무관'>무관</option>
					    <option value='대졸'>대졸</option>
					    <option value='대학 재학생'>대학 재학생</option>
					    <option value='대학 휴학생'>대학 휴학생</option>
					    <option value='고졸'>고졸</option>
					  </select>
				</div>
				
				<div class="filter">
					 <label for='desireForm'>희망 급여</label> 
					  <select id='desireForm' name='desireForm'>
					  	<option value='무관'>무관</option>
					    <option value='시급'>시급</option>
					    <option value='일급'>일급</option>
					    <option value='월급'>월급</option>
					    <option value='연봉'>연봉</option>
					  </select>
					  <input id='desireIncome' name='desireIncome' type='text' style="width:120px;"/>
					  <label for='desireIncome' style="text-align:left;">원</label>
				</div>
				
				
				검색버튼 찾기
				검색버튼과 서블랫 연결
				출력div 꾸미기
				
				
				
				
				
			</div> <!-- 검색박스 끝 -->
			
			
			<div>
				<div class="resume">
					<div class="leftside">1</div>
					<div class="rightside">2</div>
				</div>
				<div class="resume">
					<div class="leftside">1</div>
					<div class="rightside">2</div>
				</div><div class="resume">
					<div class="leftside">1</div>
					<div class="rightside">2</div>
				</div><div class="resume">
					<div class="leftside">1</div>
					<div class="rightside">2</div>
				</div>
			
			</div>

		

	output 해당 조건에 맞는 이력서 리스트
	
	호출서블랫: searchResumeList.os input 필터(district,type,desireForm,desireIncome,finalEdu), keyword
	
	이력서 선택시 해당 이력서 보여주기 watchingResume.os input rNum (아님 이거 같은 화면에 비동기로 보여줄지?)

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->
	
</body>
</html>