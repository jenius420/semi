<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="ownerService.model.vo.Owner, java.util.ArrayList"%>
<%	
	Owner owner= (Owner) session.getAttribute("owner");



%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/form/css/form.css" rel="stylesheet" media="all">

<title>공고 작성</title>

<style>
input[type=checkbox]+label{
display:block;
margin:0.2em;
cursor:pointer;
padding:0.2em;
}
input[type=checkbox]{
display:none;
}
input[type=checkbox]+label:before{
content: "\2714";
border: 0.1em solid #000;
border-radius:0.2em;
display:inline-block;
width:1em;
height:1em;
padding-left:0.2em;
padding-bottom:0.3em;
padding-right:0.2em;
vertical-align:bottom;
color:transparent;
transition:.2s;
}

input[type=checkbox] + label:active:before{
transform:scale(0);
}

input[type=checkbox]:checked +label:before{
background-color: #fff;

color:purple;
}


</style>
</head>
<body>


<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../ownerService/OwnerServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			<div class="outer">
	
				<form action="<%=request.getContextPath()%>/submitResume.es" method="post" class='speaker-form'  enctype="multipart/form-data">
			
					<div class='form-row' style="border-bottom: 1px solid gray">
					  <label for='full-name'>제목</label>
					  <input id='full-name' name='wTitle' type='text'/>
					</div>
					
					
					<div class='form-row' id="fileArea" style="margin-bottom:20px;">
					  <label class="lLabel" for="photo" style="vertical-align: bottom;">사진</label>
					  <img id="titleImg" width="100" height="100">
					  <label for="photo" id="upload">업로드</label>
					  <input type="file" multiple name="photo" id="photo" onchange="loadImg(this);">
					  
					  </div>
	
					<script>	
						// 파일 첨부했을 때 미리보기 공간에 미리보기 가능하게 하는 함수
						function loadImg(value){
							if(value.files && value.files[0]){
			
								var reader = new FileReader();
								reader.onload = function(e){	
									$("#titleImg").attr("src", e.target.result);
								}
								reader.readAsDataURL(value.files[0]);
							}
						}
					</script>
		
					<div class='form-row'>
					  <label class="lLabel">업체명</label><p class="rLabel" style="width:180px;"><%=owner.getOpName() %></p>
					  <button type="button" class="gs-btn" style="padding: 2px; margin:0;" onclick="location.href='<%=request.getContextPath()%>';">개인정보 수정하기</button>
					</div>
					
					<div class='form-row'>	
					  <label class='lLabel'>전화번호</label><p class="rLabel"><%=owner.getoTel() %></p>
					</div>
					
					<div class='form-row'>
					  <label class='lLabel'>주소</label> <p class="rLabel"><%=owner.getDistrict()%> 
					  <%if (owner.getRoadName() == null){ %>
					 	 <%=owner.getDongName()%> <%=owner.getDongMain()%> <%=owner.getDongSub()%>
					  <%}else{ %>
					  	 <%=owner.getRoadName()%> <%=owner.getRoadMain()%> <%=owner.getRoadSub()%>
					   <%}%>
					  <%=owner.getOpAddress()%></p>
					</div>
					
					<div class='form-row'>
					  <label class='lLabel'>업종</label> <p class="rLabel"><%=owner.getCategory() %> :: <%=owner.getType() %></p>
					</div>
					
					<div style="height:30px;"></div>
					
		
					<div class='form-row'>
					  <label class='lLabel' for='workDay'><span>근무요일</span></label>
						  <input id='workDay' name='workDay' type='checkbox' value='월'/><label class='checkbox-label' for='workDay'><span>월</span></label>
					</div>
					
					<div class='form-row'>
					  <label for='typeNum'>희망업종</label>
					  <select id='typeNum' name='typeNum' style="width:300px;">
	
					  </select>
					</div>
					
					<div class='form-row'>
					  <label for='edu'>최종학력</label>
					  <select id='edu' name='edu'>
					    <option value='대졸'>대졸</option>
					    <option value='대학 재학생'>대학 재학생</option>
					    <option value='대학 휴학생'>대학 휴학생</option>
					    <option value='고졸'>고졸</option>
					  </select>
					</div>
					
					<div class='form-row'>
					  <label for='desireForm'>희망 급여</label>
					  <select id='desireForm' name='desireForm'>
					    <option value='시급'>시급</option>
					    <option value='일급'>일급</option>
					    <option value='월급'>월급</option>
					    <option value='연봉'>연봉</option>
					  </select>
					  <input id='desireIncome' name='desireIncome' type='text' style="margin-left:20px;"/>
					  <label for='desireIncome' style="text-align:left">원</label>
					  
					</div>
	
					<div class='form-row'>
					  <label for='comment'>하고싶은 말</label>
					  <textarea id='comment' name='comment'></textarea>
					</div>
		
					<div class='form-row'>
					  <label class='checkbox-label' for='openSet'>
					  <input id='openSet' name='openSet' type='checkbox' value='Y'/>
					  <span>이력서 공개 설정</span>
					  </label>
					</div>
					
					<div class='form-row'>
					  <button type="submit" class="btn" onclick="return submitCheck();">저장하기</button>
					</div>
					
					<script>
						function submitCheck(){
							var result = confirm("이대로 저장하시겠습니까");
							if(result){
								//$(".speaker-form").submit();
								return true;
							}else{	
								return false;
							}
						}
					</script>
	
				</form>
			</div>



		</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
	

</body>
</html>