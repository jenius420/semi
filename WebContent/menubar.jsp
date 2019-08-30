<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member" %>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");

	// 세션에 담겨있는 메세지 받기 
	String msg = (String)session.getAttribute("msg");
	
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Albamoon</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	var msg = "<%= msg %>";
	
	$(function(){
		if(msg != "null"){
			alert(msg);
			
			// 세션에 담긴 메세지 한번만 출력하고 삭제하기
			<% session.removeAttribute("msg"); %>
		}
	})
	
</script>
<!-- 
Flex Template 
http://www.templatemo.com/tm-406-flex
-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/font-awesome.css">
        <link rel="stylesheet" href="resources/css/animate.css">
        <link rel="stylesheet" href="resources/css/templatemo_misc.css">
        <link rel="stylesheet" href="resources/css/templatemo_style.css">
        
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="resources/css/display.css">

        <script src="resources/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
        
        
        <!-- Place somewhere in the <head> of your document -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>


<!-- Place in the <head>, after the three links -->
	<script type="text/javascript" charset="utf-8">

	  
	  $(document).ready(function() {
		    $("#test").on('click', function(){
		        $(this).css("border","1.5px solid #ff99ff"); 
		    });
			  $('.main-menu ul li a ').on('click',function(){
				  $(this).css("text-transform", "uppercase;");
			  });
		});
	  
	  
	  
	  
	</script>
	
	<style>
	
		.menu-menu-wrapper{
		
	  width: 100%;
	  margin: 0 auto;
	  z-index: 1000;s
	  top: 50px;
	  -webkit-transition: all 150ms ease-in-out;
	  -moz-transition: all 150ms ease-in-out;
	  transition: all 150ms ease-in-out;
		}
		.temp{
		
		
		}
	
	
	</style>
       
    </head>
<body>



                <div class="menu-main-header">

                        <div id="menu-wrapper">
                            <div class="row">
                                <div class="logo-wrapper col-md-2 col-sm-2">
                                </div> <!-- /.logo-wrapper -->
                                <div class="search-wrapper"> <!-- 수정 -->
                                    <h1>
                                        <input type="text" id="test" class="search" placeholder="Search" >
                                    </h1>
                                </div>
                                <div class="col-md-10 col-sm-10 main-menu text-right toggle-wrapper temp">
                                    <div class="toggle-menu visible-sm visible-xs"><i class="fa fa-bars"></i></div>
                                    <ul class="menu-first">
                                        <% if(loginUser == null){ %>
 											<li class="active"><a href="#" onclick="window.open('views/member/login.jsp', '로그인', 'width=500, height=300 left=500 top=250 toolbar=no location=no status=no')">Login</a></li>
                                        
										<%}else{ %>
							               <li class="active"><a href="#" onclick="location.href='<%= contextPath%>/logout.me';">Logout</a></li>
										<%} %>
                                        <li><a href="#location">지역별</a></li>
                                        <li><a href="#date">기간별</a></li>
                                        <li><a href="#board">게시판</a></li>
                                        <li><a href="#personalService">개인서비스</a></li> 
                                        <li><a href="#businesService">기업서비스</a></li>                                 
                                    </ul>                                    
                                </div> <!-- /.main-menu -->
                            </div> <!-- /.row -->
                        </div> <!-- /#menu-wrapper -->                        
                </div> <!-- /.main-header -->






		<div class="asMenubar">
		
		    <div>
		        <div class="asm1">회원 관리</div>
		       	<div class="asLink" onclick="location.href='<%=request.getContextPath()%>/memList.as';">회원 관리</div>
		    </div>
		    <div class="space"></div>
		    
		    <div>
		        <div class="asm1">공고 관리</div>
		        <div class="asLink" onclick="location.href='<%=request.getContextPath()%>/ingIncruit.as';">진행중 공고</div>
		        <div class="asLink" onclick="location.href='<%=request.getContextPath()%>/doneIncruit.as';">지난 공고</div>
		        <div class="asLink" onclick="location.href='<%=request.getContextPath()%>/manageProduct.as';">공고 상품 관리</div>
		    </div>
		    <div class="space"></div>
		    
		    <div>
		        <div class="asm1">게시판 관리</div>
		      	<div class="asLink" onclick="location.href='<%=request.getContextPath()%>/boardReportList.as';">게시글 신고내역</div>
		      	<div class="asLink" onclick="location.href='<%=request.getContextPath()%>/commentReportList.as';">댓글 신고내역</div>
		    </div>
		    <div class="space"></div>
		
		
		</div>









        <div id="footer">
            <div class="container">
                    <div >
                        <pre>
      (주) 돈조네트웍스                                                                                    알바문 고객센터<br>                                         
 사업자등록번호 : 123-12-123456 | 부가통신사업 : 제 021047호                                              평일    09:00 ~ 19:00<br>              
 통신판매업신고 : 제2019-서울동작-07290호                                                               토요일  09:00 ~ 15:00 / (일요일,공휴일 휴무)<br>                                    
 직업정보제공사업 신고번호 : 서울동 제 2019-07호                                                         Phone: 010-3514-1361<br>
                                                                                                     Email: <a href="help@albamoon.co.kr">help@albamoon.co.kr</a>
                        </pre>
                  </div> <!-- /.text-center -->
             <span>Copyright © ALBAMOON Crop. All Right Reserved</span>
           	 		<div class="col-md-4 hidden-xs text-right">
                        <a href="#top" id="go-top">Back to top</a>
                    </div> <!-- /.text-center -->
            </div> <!-- /.container -->
        </div> <!-- /#footer -->
        
        <script src="resources/js/vendor/jquery-1.11.0.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>')</script>
        <script src="resources/js/bootstrap.js"></script>
        <script src="resources/js/plugins.js"></script>
        <script src="resources/js/main.js"></script>



	
	
	
</body>
</html>




