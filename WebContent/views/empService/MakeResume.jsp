<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="emp.model.vo.Emp"%>

<%	
	Emp emp = (Emp)request.getSession().getAttribute("loginUser");
	String eName = emp.geteName();
	int phone = emp.getPhone();
	String address = emp.getAddress();
	String email = emp.getEmail();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/form/css/form.css" rel="stylesheet" media="all">
<title>이력서 등록</title>


</head>
<body>

<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
		
		<div class="outer">

			<form action="<%=request.getContextPath()%>/submitResume.es;" method='get' class='speaker-form'  enctype="multipart/form-data">
	
				<div class='form-row'>
				  <label class="lLabel">이름</label><p class="rLabel" style="width:180px;"><%=eName %></p>
				  <button type="button" class="gs-btn" style="padding: 2px; margin:0;" onclick="location.href='<%=request.getContextPath()%>';">개인정보 수정하기</button>
				</div>
				<div class='form-row'>	
				  <label class='lLabel'>전화번호</label><p class="rLabel"><%=phone %></p>
				</div>
				<div class='form-row'>
				  <label class='lLabel'>주소</label> <p class="rLabel"><%=address %></p>
				</div>
				<div class='form-row'>
				  <label class='lLabel'>이메일</label> <p class="rLabel"><%=email %></p>
				</div>
				<div style="height:30px;"></div>
				
	
				<div class='form-row'>
				  <label for='districtNum'>희망근무지(구)</label>
				  <select id='districtNum' name='districtNum'>
				    <option value='1'>강남구</option>
				    <option value='s'>Small</option>
				    <option value='m'>Medium</option>
				    <option value='l'>Large</option>
				  </select>
				</div>
				
				<div class='form-row'>
				  <label for='typeNum'>희망업종</label>
				  <select id='typeNum' name='typeNum' style="font-size:2em;">
				    <option value='1'>IT</option>
				    <option value='s'>Small</option>
				    <option value='m'>Medium</option>
				    <option value='l'>Large</option>
				  </select>
				</div>
				
				<div class='form-row'>
				  <label for='eduNum'>최종학력</label>
				  <select id='eduNum' name='eduNum'>
				    <option value='1'>대졸</option>
				    <option value='s'>Small</option>
				    <option value='m'>Medium</option>
				    <option value='l'>Large</option>
				  </select>
				</div>
				
				<div class='form-row'>
				  <label for='desireForm'>희망 급여</label>
				  <select id='desireForm' name='desireForm'>
				    <option value='1'>시급</option>
				    <option value='2'>일급</option>
				    <option value='3'>주급</option>
				    <option value='4'>월급</option>
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
		
		
		<div class="space"></div>
		<div class="space"></div>
		<div class="space"></div>
		<div class='form-row'>
		  <label for='full-name'>Name</label>
		  <input id='full-name' name='full-name' type='text'/>
		</div>
			

		<div class='form-row'>
		  <label for='full-name'>Name</label>
		  <input id='talk-type-1' name='talk-type' type='radio' value='main-stage' />
		  <label for='talk-type-1' class='radio-label'>Main Stage</label>
		  <input id='talk-type-2' name='talk-type' type='radio' value='workshop' checked />
		  <label for='talk-type-2' class='radio-label'>Workshop</label>
		</div>
		
		
		
			<form id="resumeForm" action="<%=request.getContextPath()%>/submitResume.es" method="POST" enctype="multipart/form-data">
				
				
				
				사진
				<div id="titleImgArea">
					<img id="titleImg" width="350" height="200">
				</div>
				
				<div id="fileArea">
					<input type="file" multiple name="thumbnailImg1" id="thumbnailImg1" onchange="loadImg(this);">
		
				</div>
				
				<script>
					
					// 파일 첨부했을 때 미리보기 공간에 미리보기 가능하게 하는 함수
					function loadImg(value){
						// value => input태그
						// num => 조건문으로 작업
						
						// file이 존재하는지 
						if(value.files && value.files[0]){
		
							var reader = new FileReader();
		
							reader.onload = function(e){	
								$("#titleImg").attr("src", e.target.result);
							}
		
							reader.readAsDataURL(value.files[0]);
							
						}
					}
				</script>
				
				
				<input type="hidden" value="보여주면 안 되는데 같이 넘겨야 하는 경우">
				
			</form>
			
			
			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
	

</body>
</html>