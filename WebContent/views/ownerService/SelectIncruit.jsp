<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ownerService.model.vo.Incruit, ownerService.model.vo.Owner"%>
<%
Owner owner= (Owner) session.getAttribute("owner");
Incruit i = (Incruit)request.getAttribute("incruit");
ArrayList<IncruitProduct> list = (ArrayList<IncruitProduct>)request.getAttribute("list");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/form/css/form.css" rel="stylesheet" media="all">
<link href="resources/form/css/checkbox.css" rel="stylesheet" media="all">

<title>공고 보기</title>
</head>
<body>

<div id="div" style="height: 1400px;">

	<div id="header"></div>
	
	<div id="content">
		
		<div id="content-left"><%@ include file="../ownerService/OwnerServiceMenubar.jsp"%></div>
		
		<div id="content-center">
		
			<div class="outer">
	
				<form action="<%=request.getContextPath()%>/updateIncruit.os" method="post" class='speaker-form'  style="height: 1050px;">
			
					<div class='form-row' style="border-bottom: 1px solid gray" >
					  <label for='full-name'>제목</label>
					  <input id='full-name' name='wTitle' type='text' style="width:600px; margin-bottom:15px;" value="<%=i.getwTitle() %>"/>
					</div>
					
					<br><br>
					
		
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
					  <label class='lLabel'>업종</label>
					  <p class="rLabel"><%=owner.getCategory() %> :: <%=owner.getType() %></p>
					</div>
		
					<br><br>
					
					<div class='form-row'>
						<label class='lLabel' style="padding-top:4px;">공고 마감일</label>
						<input type="date" name="endDate" value="<%=i.getDoneDate() %>">
					</div>
		
					<div class='form-row'>
					  <label class='lLabel' for='workDay'><span>근무요일</span></label>
						    <input id='workDay1' name='workDay' type='checkbox' value='월' <%if(i.getWorkDay().contains("월")){%>checked<%}%>/>
						    <label class='checkbox-label' for='workDay1'><span>월</span></label>
							<input id='workDay2' name='workDay' type='checkbox' value='화' <%if(i.getWorkDay().contains("화")){%>checked<%}%>/>
							<label class='checkbox-label' for='workDay2'><span>화</span></label>
							<input id='workDay3' name='workDay' type='checkbox' value='수' <%if(i.getWorkDay().contains("수")){%>checked<%}%>/>
							<label class='checkbox-label' for='workDay3'><span>수</span></label>
							<input id='workDay4' name='workDay' type='checkbox' value='목' <%if(i.getWorkDay().contains("목")){%>checked<%}%>/>
							<label class='checkbox-label' for='workDay4'><span>목</span></label>
							<input id='workDay5' name='workDay' type='checkbox' value='금' <%if(i.getWorkDay().contains("금")){%>checked<%}%>/>
							<label class='checkbox-label' for='workDay5'><span>금</span></label>
							<input id='workDay6' name='workDay' type='checkbox' value='토' <%if(i.getWorkDay().contains("토")){%>checked<%}%>/>
							<label class='checkbox-label' for='workDay6'><span>토</span></label>
							<input id='workDay7' name='workDay' type='checkbox' value='일' <%if(i.getWorkDay().contains("일")){%>checked<%}%>/>
							<label class='checkbox-label' for='workDay7'><span>일</span></label>
					</div>
					
					<div class='form-row'>
					  <label for='termNo'>근무 기간</label>
					  <select id='termNo' name='termNo' style='width:180px;'>
					    <option value='1' <%if(i.getTermNo() == 1){%>selected<%}%>>단기 :: 1주일 이하</option>
					    <option value='2' <%if(i.getTermNo() == 2){%>selected<%}%>>단기 :: 1주일 ~ 1개월</option>
					    <option value='3' <%if(i.getTermNo() == 3){%>selected<%}%>>장기 :: 3개월 ~ 6개월</option>
					    <option value='4' <%if(i.getTermNo() == 4){%>selected<%}%>>장기 :: 6개월 ~ 1년</option>
					    <option value='5' <%if(i.getTermNo() == 5){%>selected<%}%>>장기 :: 1년 이상</option>
					  </select>
					</div>
					
					<div class='form-row'>
					  <label for='workTime'>근무 시간</label>
						 <input id='workTime' name='workTime' type='text' style="width:120px; margin-bottom:10px;" value="<%i.getWorkTime() %>"/> <label style="font-size:14px; color: gray;">ex) 09:00 ~ 18:00 </label>
					</div>
					
					<div class='form-row'>
					  <label for='workAge'>희망 연령대</label>
					  <select id='workAge' name='workAge' style="width:70px;">
					    <option value='무관' <%if(i.getAge().equals("무관")){%>selected<%}%>>무관</option>
					    <option value='10대' <%if(i.getAge().equals("10대")){%>selected<%}%>>10대</option>
					    <option value='20대' <%if(i.getAge().equals("20대")){%>selected<%}%>>20대</option>
					    <option value='30대' <%if(i.getAge().equals("30대")){%>selected<%}%>>30대</option>
					    <option value='30대' <%if(i.getAge().equals("40대")){%>selected<%}%>>40대</option>
					    <option value='30대' <%if(i.getAge().equals("50대")){%>selected<%}%>>50대</option>
					    <option value='30대' <%if(i.getAge().equals("60대")){%>selected<%}%>>60대</option>
					  </select>
					</div>
					
					<div class='form-row'>
					  <label for='workGender'>희망 성별</label>
					  <select id='workGender' name='workGender' style="width:70px;">
					    <option value='무관' <%if(i.getGender().equals("무관")){%>selected<%}%>>무관</option>
					    <option value='남자' <%if(i.getGender().equals("남자")){%>selected<%}%>>남자</option>
					    <option value='여자' <%if(i.getGender().equals("여자")){%>selected<%}%>>여자</option>
					  </select>
					</div>
					
					<div class='form-row'>
					  <label for='workEdu'>희망 학력</label>
					  <select id='workEdu' name='workEdu' style="width:70px;">
					    <option value='대졸'  <%if(i.getEdu().equals("대졸")){%>selected<%}%>>대졸</option>
					    <option value='대학생' <%if(i.getEdu().equals("대학생")){%>selected<%}%>>대학생</option>
					    <option value='고졸' <%if(i.getEdu().equals("고졸")){%>selected<%}%>>고졸</option>
					    <option value='중졸' <%if(i.getEdu().equals("중졸")){%>selected<%}%>>중졸</option>
					  </select><label style="font-size:14px; color: gray; text-align:left; padding:2px 4px;"> 이상</label>
					</div>
					
					<div class='form-row'>
					  <label for='workForm'>희망 급여</label>
					  <select id='workForm' name='workForm'>
					  	<option value='협의 후 결정' <%if(i.getSalaryForm().equals("협의 후 결정")){%>selected<%}%>>협의 후 결정</option>
					    <option value='시급' <%if(i.getSalaryForm().equals("시급")){%>selected<%}%>>시급</option>
					    <option value='일급' <%if(i.getSalaryForm().equals("일급")){%>selected<%}%>>일급</option>
					    <option value='월급' <%if(i.getSalaryForm().equals("월급")){%>selected<%}%>>월급</option>
					    <option value='연봉' <%if(i.getSalaryForm().equals("연봉")){%>selected<%}%>>연봉</option>
					  </select>
					  <input id='salary' name='salary' type='text' style="margin-left:20px;" value="<%=i.getSalary() %>"/>
					  <label for='salary' style="text-align:left">원</label>
					</div>
					
					<div class='form-row'>
					  <label for='peopleCount'>모집 인원</label>
					  <select id='peopleCount' name='peopleCount' style="width:70px;">
					    <option value='1명' <%if(i.getPeopleCount().equals("1명")){%>selected<%}%>>1명</option>
					    <option value='2명' <%if(i.getPeopleCount().equals("2명")){%>selected<%}%>>2명</option>
					    <option value='3명' <%if(i.getPeopleCount().equals("3명")){%>selected<%}%>>3명</option>
					    <option value='4명' <%if(i.getPeopleCount().equals("4명")){%>selected<%}%>>4명</option>
					    <option value='5명' <%if(i.getPeopleCount().equals("5명")){%>selected<%}%>>5명</option>
					    <option value='6명' <%if(i.getPeopleCount().equals("6명")){%>selected<%}%>>6명</option>
					    <option value='7명' <%if(i.getPeopleCount().equals("7명")){%>selected<%}%>>7명</option>
					    <option value='8명' <%if(i.getPeopleCount().equals("8명")){%>selected<%}%>>8명</option>
					    <option value='9명' <%if(i.getPeopleCount().equals("9명")){%>selected<%}%>>9명</option>
					    <option value='10명' <%if(i.getPeopleCount().equals("10명")){%>selected<%}%>>10명</option>
					    <option value='10명 이상' <%if(i.getPeopleCount().equals("10명 이상")){%>selected<%}%>>10명 이상</option>
					  </select>
					</div>
					
					<div class='form-row'>
					  <label for='applyProduct'>적용 상품</label>
					  <select id='applyProduct' name='applyProduct' style="width:400px;">
					   	<%for(IncruitProduct a : list) {%>
				  			<option value='<%=a.getpCode()%>' ><%=a.getpTitle()%> :: <%=a.getpPay()%>원(일) :: <%=a.getpExplain()%></option>
				  		<%}%>
					  </select>
					</div>
	
					<div class='form-row'>
					  <label for='rExplain'>상세 내역</label>
					  <textarea id='rExplain' name='rExplain'></textarea>
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
		
		
		
		
		
		
		
		
		
		
수정 updateIncruit.os (등록날짜,마감날짜는 수정못함) 별의별데이터
마감 closeIncruit.os input wNum
목록으로

			</div> <!-- /메인콘텐트 -->
			
		<div id="content-right"></div>
		
		</div> <!-- /콘텐트 -->
		
	<div id="footer"></div>
	
</div> <!-- /화면 -->

</body>
</html>