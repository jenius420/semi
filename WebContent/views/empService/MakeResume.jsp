<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="empService.model.vo.Emp, java.util.ArrayList, common.model.vo.District, common.model.vo.JobType"%>

<%	
	Emp emp = (Emp)request.getSession().getAttribute("emp");
	String eName = emp.geteName();
	String phone = emp.getPhone();
	String address = emp.getAddress();
	String email = emp.getEmail();
	String gender = emp.getGender();
	int age = emp.getAge();
	
	ArrayList<District> dList = (ArrayList<District>)request.getAttribute("dList");
	ArrayList<JobType> tList = (ArrayList<JobType>)request.getAttribute("tList");
%>

<!DOCTYPE html>
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/form/css/form.css" rel="stylesheet" media="all">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/views/member/js/joinOwnJs.js"></script>


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
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
		
		<div class="outer">

			<form action="<%=request.getContextPath()%>/submitResume.es" method="post" class='speaker-form'  enctype="multipart/form-data">
		
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
				  <label class="lLabel">이름</label><p class="rLabel" style="width:180px;"><%=eName %></p>
				  <button type="button" class="gs-btn" style="padding: 2px; margin:0;" onclick="location.href='<%=request.getContextPath()%>';">개인정보 수정하기</button>
				</div>
				<div class='form-row'>
				  <label class="lLabel">나이/성별</label><p class="rLabel" style="width:180px;"><%=age %> <%=gender %></p>
				</div>
				<div class='form-row'>	
				  <label class='lLabel'>전화번호</label><p class="rLabel"><%=emp.getPhone() %></p>
				</div>
				<div class='form-row'>
				  <label class='lLabel'>주소</label> <p class="rLabel"> <%=emp.getDistrict() %> <%=emp.getRoadName() %> <%=emp.getRoadMain() %> <%=address %></p>
				</div>
				<div class='form-row'>
				  <label class='lLabel'>이메일</label> <p class="rLabel"><%=email %></p>
				</div>
				<div style="height:30px;"></div>
				
	
				<div class='form-row'>
				  <label for='districtNum'>희망근무지(구)</label>
				  <select id='districtNum' name='districtNum'>
				  	<%for(District d : dList) {%>
				  		<option value='<%=d.getDistrictNum()%>'><%=d.getDistrictName() %></option>
				  	<%}%>
				  </select>
				</div>
				
				<div class='form-row'>
				  <label for='bigCategory'>희망업종</label>
				  <select id='bigCategory'  style="width:auto;">
				  		<option></option>
				  </select>
				  &nbsp;&nbsp;&nbsp;
				  <select id='subCategory' name='subCategory' style="width:200px;">
				  		<option></option>
				  </select>
				</div>
				
				<div class='form-row'>
				  <label for='edu'>최종학력</label>
				  <select id='edu' name='edu' style="width:150px;" >
				    <option value='대졸 이상(4년제)'>대졸 이상(4년제)</option>
				    <option value='대졸 이상(2,3년제)'>대졸 이상(2,3년제)</option>
				    <option value='고졸 이상'>고졸 이상</option>
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
				  <textarea id='comment' name='comment' style="min-height: 200px;"></textarea>
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
		
	<div id="footer"><%@ include file="../common/footer.jsp" %></div>
	
</div> <!-- /화면 -->
	

</body>
</html>