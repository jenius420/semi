<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="empService.model.vo.Emp, 
    java.util.ArrayList, 
    common.model.vo.District, 
    ownerService.model.vo.Filter, 
    common.model.vo.JobType, 
    empService.model.vo.Resume,
    common.model.vo.Attachment"%>
    
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

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
width:95%;
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


.resume, .topside, .topside>div, .bottomside{

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
margin-top:20px;
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



.scrollbar
{
	margin-left: 30px;
	float: left;
	height: 150px;
	width: 85%;
	background: white;
	overflow-y: scroll;
	margin-bottom: 25px;
}
#style-1::-webkit-scrollbar-track
{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
	border-radius: 10px;
	background-color: white;
}
#style-1::-webkit-scrollbar
{
	width: 10px;
	background-color: purple;
}
#style-1::-webkit-scrollbar-thumb
{
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
					 <label for='districtNum' >희망근무지(구)</label>
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
					 <label for='typeNum'>희망업종</label>
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
					 <label for='desireForm'>희망 급여</label> 
					  <select id='desireForm' name='desireForm'>
					  	<option value='무관' <%if(filter != null && filter.getDesireForm() == null){%>selected<%}%>>무관</option>
					    <option value='시급' <%if(filter != null && filter.getDesireForm().equals("시급")){%>selected<%}%>>시급</option>
					    <option value='일급' <%if(filter != null && filter.getDesireForm().equals("일급")){%>selected<%}%>>일급</option>
					    <option value='월급' <%if(filter != null && filter.getDesireForm().equals("월급")){%>selected<%}%>>월급</option>
					    <option value='연봉' <%if(filter != null && filter.getDesireForm().equals("연봉")){%>selected<%}%>>연봉</option>
					  </select>
					  <input id='desireIncome' name='desireIncome' type='text' onkeypress="inNumber();" style="width:120px;"
					  <%if(filter != null && !filter.getDesireForm().equals("무관")){%>value="<%=filter.getDesireIncome()%>"<%}%>/>
					  <label for='desireIncome' style="text-align:left;" >원</label>
				</div>
				
				<div class="filter" style="margin-right: 0;">
					<div class="searchArea goInput">
						<input id="keyword" type="text" placeholder="자기소개 검색..." value="<%if(keyword != null){%><%=keyword%><%}%>" onkeyup="enterkey();">
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
						
						var desireFormNum = document.getElementById("desireForm");
						var desireForm = desireFormNum.options[desireFormNum.selectedIndex].value;
						
						var desireIncome = Number(document.getElementById("desireIncome").value);
						
						var keyword = document.getElementById("keyword").value;
						
						location.href="<%=request.getContextPath()%>/searchResumeList.os?districtNum=" + districtNum
								+ "&typeNum="+typeNum + "&edu="+edu + "&desireForm="+desireForm + "&desireIncome="+desireIncome + "&keyword="+keyword;	
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
							<label > 이름 : <%= a.geteName() %></label>
							<label > 전화번호 : <%= a.getPhone() %></label>
							<label > 이메일 : <%= a.getEmail() %></label>
							<label > 희망 급여 : <%= a.getDesireForm() %> <%= a.getDesireIncome() %>원</label>
						</div>
					</div>
					<div >
						<!--  class="scrollbar" id="style-1" class="bottomside"style="text-overflow: ellipsis;   overflow: hidden; width=200px;  " -->
						<div >
						<p style="height:auto; overflow:hidden;">"<%=a.getComment()%>"</p> 
					    </div>
					</div>
				</div>
				<%}} %>
			
			</div>

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->
	
</body>
</html>