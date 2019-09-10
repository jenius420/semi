<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="empService.model.vo.Emp, java.util.ArrayList, common.model.vo.District, ownerService.model.vo.Filter, common.model.vo.JobType, empService.model.vo.Resume,common.model.vo.Attachment"%>
<%	
Emp emp = (Emp)request.getSession().getAttribute("emp");

ArrayList<District> dList = (ArrayList<District>)request.getAttribute("dList");
ArrayList<JobType> tList = (ArrayList<JobType>)request.getAttribute("tList");
ArrayList<Resume> list = (ArrayList<Resume>)request.getAttribute("list");
ArrayList<Attachment> atList = (ArrayList<Attachment>)request.getAttribute("atList");
Filter filter = (Filter)request.getAttribute("filter");
String keyword = (String)request.getAttribute("keyword");

%>
<!DOCTYPE html >
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="<%=request.getContextPath()%>/views/member/js/joinOwnJs.js"></script>
    
<style>

input:focus, select:focus {
border:1px solid #df9dfb !important;

}

.searchResume{
height: 60px;
padding: 8px;
margin-top:20px;
margin-bottom:20px;
background-color: 	#DDA0DD;
width:100%;
color: #000080;
border-radius: 5px;
}

.filter{
display : inline-block;
margin-right:20px;
font-size:15px;
}

.filter select, .filter [type="text"]{
border-radius: 5px;
height: 35x;
border-
}

.searchArea{
display : inline-block;
margin-right: 0px;
}

.goInput{
margin-left:20px;
width:200px;
box-shadow: 3px 3px 4px rgba(0, 0, 0.15, 0.15);
margin-right: 0px;

}

.go{
height:40px;
width:40px;
background-image: url('resources/images/searchBtn.png');
background-size: 30px;
background-repeat: no-repeat;
vertical-align: middle;
margin-top: 5px;
margin-left: -40px;
border-radius: 200px;
}

.go:hover{
cursor:pointer;
}

#keyword::placeholder {
color:#6600cc;
font-size:13px;
font-style: italic;
opacity: 0.7;
font-weight: bold;
}

.resume{
width:370px;
height:200px;
display : inline-block;
margin:50px;
margin-bottom:100px;
vertical-align: top;
}

.topside{
width: 100%;
height: 70%;
padding:auto;
margin:auto;

}
.topside>div{
display:inline-block;
vertical-align: middle;

}
.topleftside{
width:30%;
height:80%;
margin: .5em;

}
.toprightside{
width:60%;
height:80%;
margin:.5em;
margin-top:10px;
}

.bottomside{
width: 95%;
height: 40%;
padding:auto;
margin-left: 0;
text-overflow: ellipsis;
}

img{
width:100%;
height:100%;
border-radius: 40px;
}

.scrollbar{
	margin-left: 30px;
	float: left;
	height: 150px;
	width: 85%;
	background: white;
	overflow-y: scroll;
	margin-bottom: 25px;
}

#style-1::-webkit-scrollbar-track{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	border-radius: 10px;
	background-color: white;
}

#style-1::-webkit-scrollbar{
	width: 10px;
	background-color: purple;
}

#style-1::-webkit-scrollbar-thumb{
	border-radius: 10px;
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
	background-color: purple;
}

</style>

</head>

<body>

<div id="div" style="height:2000px;">

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
			
				<div class="filter" style="margin-left:15px;">
					 <label for='districtNum' >근무지(구)</label>
					 <select id='districtNum' name='districtNum'>
					  	<%for(District d : dList) {%>
					  		<%if(filter != null && filter.getDistrictNum() == d.getDistrictNum()){ %>
					  			<option value='<%=d.getDistrictNum()%>' selected><%=d.getDistrictName() %></option>
					  		<%}else{ %>
					  			<option value='<%=d.getDistrictNum()%>'><%=d.getDistrictName() %></option>
					  		<%}}%>
					  </select>
				</div>

				<div class="filter">
					  <label for='typeNum'>업종</label>
					  <select id='typeNum' name='typeNum' style="width:300px;">
						<%for(JobType t : tList) {%>
							<%if(filter != null && filter.getTypeNum() == t.getTypeNum()){ %>
					  			<option value='<%=t.getTypeNum()%>' selected><%=t.getCategoryName()%> :: <%=t.getTypeName()%></option>
					  		<%}else{ %>
					  			<option value='<%=t.getTypeNum()%>' ><%=t.getCategoryName()%> :: <%=t.getTypeName()%></option>
					  		<%}}%>
					  </select>
				</div>
				
				<div class="filter">
					 <label for='edu'>학력</label>
					 <select id='edu' name='edu'>
					  	<option value='무관' <%if(filter != null && filter.getFinalEdu() == null){%>selected<%}%>>무관</option>
					    <option value='대졸 이상(4년제)' <%if(filter != null && filter.getFinalEdu().equals("대졸 이상(4년제)")){%>selected<%}%>>대졸 이상(4년제)</option>
					    <option value='대졸 이상(2,3년제)' <%if(filter != null && filter.getFinalEdu().equals("대졸 이상(2,3년제)")){%>selected<%}%>>대졸 이상(2,3년제)</option>
					    <option value='고졸 이상' <%if(filter != null && filter.getFinalEdu().equals("고졸 이상")){%>selected<%}%>>고졸 이상</option>
					  </select>
				</div>
				
				<div class="filter">
					 <label for='ageType'>연령대</label> 
					 <select id='ageType' name='ageType'>
					  	<option value='무관' <%if(filter != null && filter.getAgeType() == null){%>selected<%}%>>무관</option>
					    <option value='10대' <%if(filter != null && filter.getAgeType().equals("10대")){%>selected<%}%>>10대</option>
					    <option value='20대' <%if(filter != null && filter.getAgeType().equals("20대")){%>selected<%}%>>20대</option>
					    <option value='30대' <%if(filter != null && filter.getAgeType().equals("30대")){%>selected<%}%>>30대</option>
					    <option value='40대' <%if(filter != null && filter.getAgeType().equals("40대")){%>selected<%}%>>40대</option>
					    <option value='50대' <%if(filter != null && filter.getAgeType().equals("50대")){%>selected<%}%>>50대</option>
					    <option value='60대' <%if(filter != null && filter.getAgeType().equals("60대")){%>selected<%}%>>60대</option>
					  </select>
				</div>
				
				<div class="filter">
					 <label for='gender'>성별</label> 
					 <select id='gender' name='gender'>
					  	<option value='무관' <%if(filter != null && filter.getGender() == null){%>selected<%}%>>무관</option>
					    <option value='남' <%if(filter != null && filter.getGender().equals("남")){%>selected<%}%>>남자</option>
					    <option value='여' <%if(filter != null && filter.getGender().equals("여")){%>selected<%}%>>여자</option>
					  </select>
				</div>
			
				
				<div class="filter" style="margin-right: 0;">
					<div class="searchArea goInput">
						<input id="keyword" type="text" placeholder="자기소개 키워드 검색..." value="<%if(keyword != null){%><%=keyword%><%}%>" onkeyup="enterkey();">
					</div>
					<div class="searchArea go" onclick="searchResume();"></div>
				</div>
				
				<script type="text/javascript">
				
					function inNumber(){
					  if(event.keyCode<48 || event.keyCode>57){
					     event.returnValue=false;
					  }
					}
					
					function searchResume(){
						
						var district = document.getElementById("districtNum");
						var districtNum = district.options[district.selectedIndex].value;
						
						var type = document.getElementById("typeNum");
						var typeNum = type.options[type.selectedIndex].value;
						
						var eduNum = document.getElementById("edu");
						var edu = eduNum.options[eduNum.selectedIndex].value;
						
						var age = document.getElementById("ageType");
						var ageType = age.options[age.selectedIndex].value;
						
						var genderNum = document.getElementById("gender");
						var gender = genderNum.options[genderNum.selectedIndex].value;
						
						var keyword = document.getElementById("keyword").value;
						
						location.href="<%=request.getContextPath()%>/searchResumeList.os?districtNum=" + districtNum
								+ "&typeNum="+typeNum + "&edu="+edu + "&ageType=" + ageType + "&gender=" + gender + "&keyword="+keyword;	
					}
					
					function enterkey() {
				        if (window.event.keyCode == 13) {
				        	searchResume();
				        }
					}

				</script>
				
			</div> <!-- 검색박스 끝 -->
			
			<div>
				<%if(list== null || list.size() <1){%>
					<div  style="font-size: 20px; text-align: center; margin-top:150px; width:85%;">검색 결과가 없습니다</div>
				<% }else{%>
					<%for(Resume a : list) {%>
						<div class="resume">
							<div class="topside">
								<div class="topleftside">
									<img id="titleImg"  src="<%=request.getContextPath()%>/photo/resumeImage/<%= a.getSaveName() %>">
								</div>
								<div class="toprightside" >
									<label > 이름 : <%= a.geteName() %></label><br>
									<label > 나이/성별 : <%= a.getAge() %> <%= a.getGender() %></label>
									<label > 전화번호 : <%= a.getPhone() %></label>
									<label > 이메일 : <%= a.getEmail() %></label>
									<label > 희망 급여 : <%= a.getDesireForm() %> <%= a.getDesireIncome() %>원</label>
								</div>
							</div>
							<div >
								<div>
									<p style="height:auto; overflow:hidden;">"<%=a.getComment()%>"</p> 
							    </div>
							</div>
						</div>
				<%}}%>
			
			</div>

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->
	
</body>
</html>