<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#jumbotron{
	background-image: url('<%=request.getContextPath()%>/resources/images/slide2.jpg');
}
</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div></div>
<div class="jumbotron" id="jumbotron">
      <div class="container">
      	<br /><br /><br /><br /><br /><br /><br /><br />
      </div>
 </div>
<br /><br />
<div class="row" style="padding-top: 50px; padding-left: 150px; padding-right:150px;">
	<input type="hidden" value="글번호" />
	<p>등록일</p>
	<div class="col-sm-12" style="border: 1px solid lightgrey;">제목</div>
	<div class="col-sm-2"></div>
	<div class="col-sm-4" style=" height:250px; border: 1px solid lightgrey;"><img class="card-img-top col-lg-12 col-sm-12" src="<%=request.getContextPath() %>/photo/logoImages/noLogo.jpg" /></div>
	<div class="col-sm-4" style="height:250px; border: 1px solid lightgrey;">
		<p>회사명 :</p>
		<p>대표자명 : </p>
		<p>업종 : </p>
		<p>주소 : 서울특별시 </p>
		<p>마감일</p>
	</div>
	<div class="col-sm-6">
		<p><strong>월급</strong>xxxxx원</p>
		<p>근무기간</p>
		<p>근무요일</p>
		<p>근무시간</p>
	</div>
	<div class="col-sm-6">
		<p>인원</p>
		<p>성별</p>
		<p>연령</p>
		<p>학력</p>
	</div>
	<div class="col-sm-12">
		<div class="col-sm-12" id="photo">
			사진 넣을곳
		</div>
		<div class="col-sm-12">본문내용</div>
	</div>
</div>
</body>
</html>