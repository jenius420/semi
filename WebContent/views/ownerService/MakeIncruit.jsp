<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="ownerService.model.vo.Owner, java.util.ArrayList, ownerService.model.vo.IncruitProduct"%>
<%	
	Owner owner= (Owner) session.getAttribute("owner");
	ArrayList<IncruitProduct> list = (ArrayList<IncruitProduct>)request.getAttribute("list");


%>
<!DOCTYPE html >
<html>
<head>
<title>Donjo - Albamoon site</title>
<link rel="shortcut icon" type="image⁄x-icon" href="<%= request.getContextPath()%>/resources/images/logo.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/form/css/form.css" rel="stylesheet" media="all">
<link href="resources/form/css/checkbox.css" rel="stylesheet" media="all">

<style>

.speaker-form{
margin-left:-200px;

}
</style>
</head>
<body>


<div id="div" style="height: 1700px;">

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
		
			<div class="outer">
	
				<form action="<%=request.getContextPath()%>/submitIncruit.os" method="post" class='speaker-form'  style="height: auto; margin-bottom:40px;">
			
					<div class='form-row' style="border-bottom: 1px solid gray" >
					  <label for='full-name'>제목</label>
					  <input id='full-name' name='wTitle' type='text' style="width:600px; margin-bottom:15px;"/>
					</div>
					
					<br><br>
					
					<div class='form-row'>
					  <label class="lLabel">업체명</label><p class="rLabel" style="width:180px;"><%=owner.getOpName() %></p>
					  <button type="button" class="gs-btn" style="padding: 2px; margin:0;" onclick="location.href='<%=request.getContextPath()%>';">개인정보 수정하기</button>
					</div>
					
					<div class='form-row'>	
					  <label class='lLabel'>전화번호</label><p class="rLabel">
					  	<%if(owner.getoTel() == null){%>
					  	 	없음
					  	 <%}else{ %>
					  	 	<%=owner.getoTel()%>
					  	 <%}%>
					  </p>
					</div>
					
					<div class='form-row'>
					  <label class='lLabel'>주소</label> <p class="rLabel">
						<%if(owner.getRoadName() != null){%>
					  	 	<%=owner.getDistrict()%> <%=owner.getRoadName()%> <%=owner.getRoadMain()%>
					  	 <%}else{ %>
					  	 	<%if(owner.getOpAddress() !=null){%>
					  	 		<%=owner.getOpAddress()%>
					  	 	<%}else{ %>
					  	 		미확인
					  	 	<%}%>
					  	 <%}%></p>
					</div>
					
					<div class='form-row'>
					  <label class='lLabel'>업종</label>
					  <p class="rLabel" style="width:auto;"><%=owner.getCategory() %> :: <%=owner.getType() %></p>
					</div>
		
					<br><br>
					
					<div class='form-row'>
						<label class='lLabel' style="padding-top:4px;">공고 마감일</label>
						<input type="date" name="endDate" >
					</div>
		
					<div class='form-row'>
						<label class='lLabel' for='workDay'><span>근무 요일</span></label>
						<input id='workDay1' name='workDay' type='checkbox' value='월'/><label class='checkbox-label' for='workDay1' style=""><span>월</span></label>
						<input id='workDay2' name='workDay' type='checkbox' value='화'/><label class='checkbox-label' for='workDay2'><span>화</span></label>
						<input id='workDay3' name='workDay' type='checkbox' value='수'/><label class='checkbox-label' for='workDay3'><span>수</span></label>
						<input id='workDay4' name='workDay' type='checkbox' value='목'/><label class='checkbox-label' for='workDay4'><span>목</span></label>
						<input id='workDay5' name='workDay' type='checkbox' value='금'/><label class='checkbox-label' for='workDay5'><span>금</span></label>
						<input id='workDay6' name='workDay' type='checkbox' value='토'/><label class='checkbox-label' for='workDay6'><span>토</span></label>
						<input id='workDay7' name='workDay' type='checkbox' value='일'/><label class='checkbox-label' for='workDay7'><span>일</span></label>
					</div>
					
					<div class='form-row'>
					  <label for='termNo'>근무 기간</label>
					  <select id='termNo' name='termNo' style='width:180px;'>
					    <option value='1'>단기 :: 1주일 이하</option>
					    <option value='2'>단기 :: 1주일 ~ 1개월</option>
					    <option value='3'>장기 :: 3개월 ~ 6개월</option>
					    <option value='4'>장기 :: 6개월 ~ 1년</option>
					    <option value='5'>장기 :: 1년 이상</option>
					  </select>
					</div>
					
					<div class='form-row'>
					  <label for='workTime'>근무 시간</label>
						 <input id='workTime' name='workTime' type='text' style="width:200px; margin-bottom:10px;"/> <!--  <label style="font-size:14px; color: gray;">ex) 09:00 ~ 18:00 </label>-->
					</div>
					
					<div class='form-row'>
					  <label for='workAge1'>희망 연령</label>
					  <input id='workAge' name='workAge' type='text' style="width:150px; margin-bottom:10px;"/>
					</div>
					
					<div class='form-row'>
					  <label for='workGender'>희망 성별</label>
					  <select id='workGender' name='workGender' style="width:70px;">
					    <option value='무관'>무관</option>
					    <option value='남자'>남자</option>
					    <option value='여자'>여자</option>
					  </select>
					</div>
					
					<div class='form-row'>
					  <label for='workEdu'>희망 학력</label>
					  <select id='workEdu' name='workEdu' style="width:150px;">
					 	<option value='무관'>무관</option>
					    <option value='대졸 이상(4년제)'>대졸 이상(4년제)</option>
					    <option value='대졸 이상(2,3년제)'>대졸 이상(2,3년제)</option>
					    <option value='고졸 이상'>고졸 이상</option>
					  </select>
					</div>
					
					<div class='form-row'>
					  <label for='workForm'>희망 급여</label>
					  <select id='workForm' name='workForm'>
					  	<option value='협의'>협의 후 결정</option>
					    <option value='시급'>시급</option>
					    <option value='일급'>일급</option>
					    <option value='월급'>월급</option>
					    <option value='연봉'>연봉</option>
					  </select>
					  <input id='salary' name='salary' type='text' style="margin-left:20px;"/>
					  <label for='salary' style="text-align:left">원</label>
					</div>
					
					<div class='form-row'>
					  <label for='peopleCount'>모집 인원</label>
					  <select id='peopleCount' name='peopleCount' style="width:70px;">
					    <option value='1명'>1명</option>
					    <option value='2명'>2명</option>
					    <option value='3명'>3명</option>
					    <option value='4명'>4명</option>
					    <option value='5명'>5명</option>
					    <option value='6명'>6명</option>
					    <option value='7명'>7명</option>
					    <option value='8명'>8명</option>
					    <option value='9명'>9명</option>
					    <option value='10명'>10명</option>
					    <option value='10명 이상'>10명 이상</option>
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
					  <textarea id='rExplain' name='rExplain' style="min-height: 200px;"></textarea>
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