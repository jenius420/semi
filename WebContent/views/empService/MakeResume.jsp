<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	
	//String eName = emp.geteName();
	//int phone = emp.getPhone();
	//String address = emp.getAddress();
	//String email = emp.getEmail();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/includeForm.jsp"%>
<title>이력서 등록</title>
</head>
<body>

<div id="div">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../empService/EmpServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
		
		
		<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
        <div class="wrapper wrapper--w960">
            <div class="card card-2">
                <div class="card-heading"></div>
                <div class="card-body">
                    <h2 class="title">Registration Info</h2>
                    <form method="POST">
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Name" name="name">
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2 js-datepicker" type="text" placeholder="Birthdate" name="birthday">
                                    <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="gender">
                                            <option disabled="disabled" selected="selected">Gender</option>
                                            <option>Male</option>
                                            <option>Female</option>
                                            <option>Other</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="class">
                                    <option disabled="disabled" selected="selected">Class</option>
                                    <option>Class 1</option>
                                    <option>Class 2</option>
                                    <option>Class 3</option>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2" type="text" placeholder="Registration Code" name="res_code">
                                </div>
                            </div>
                        </div>
                        <div class="p-t-30">
                            <button class="btn btn--radius btn--green" type="submit">Search</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
		
		
		
		
		
		
		
		
		
		
		
			<form id="resumeForm" action="<%=request.getContextPath()%>/submitResume.es" method="POST" enctype="multipart/form-data">
				
				제목 <input type="text" name="resumeTitle" id="resumeTitle"
					placeholder="이력서 제목">
					
				이름
				전화번호
				이메일
				
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
				
				희망근무지(구) 
				<select name="district" id="district">
					<option value="강남구">강남구</option>
				</select> 
				
				희망업직종 
				<select name="type" id="type">
					<option value="IT">IT</option>
				</select> 
				
				최종학력 
				<select name="edu" id="edu">
					<option value="대학졸업">대학졸업</option>
				</select> 
				
				희망급여형태 
				<select name="desireForm" id="desireForm">
					<option value="시급">시급</option>
				</select> 
				
				희망급여 
				<input type="text" name="desireIncome" id="desireIncome">원
				
				
				
				하고싶은말
				<textarea name="comment" id="comment" cols="30" rows="10" style="resize:none;"></textarea>
				
				이력서공개설정 	
				<input type="checkbox" name="openSet" id="openSet"  value="Y" checked>
				
				<input type="hidden" value="보여주면 안 되는데 같이 넘겨야 하는 경우">
				
				<input type="submit" value="저장완료" validation 작성해야함>
				<input type="reset" value="초기화">
				<button type="button" onclick="javascript:history.back();">이전 화면으로</button>
		
			</form>
			
			
			
			
			
			
			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->
	

</body>
</html>