<%@page import="member.model.vo.Member"%>
<%@page import="main.model.vo.Main"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@page import="member.model.vo.Member"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	/* String contextPath = request.getContextPath(); */
	
	
	Member loginUser = (Member)session.getAttribute("loginUser") ;

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 
Flex Template 
http://www.templatemo.com/tm-406-flex
-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        
        <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/animate.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/templatemo_misc.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/templatemo_style.css">

        <script src="<%=request.getContextPath() %>/resources/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
        
        
        <!-- Place somewhere in the <head> of your document -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/jquery.flexslider.js"></script>

<!-- Place in the <head>, after the three links -->
<script type="text/javascript" charset="utf-8">
$(window).load(function() {
    $('.flexslider').flexslider();
  });
  
  
  $(document).ready(function() {
/* 	    $("#test").on('click', function(){
	         $(this).css("border","1.5px solid #ff99ff");
	        $(this).css("background","#f2e6ff");
	        $(".search-icon button").css("background","#dfa0fa").css("cursor","pointer");
	    }); */
/* 	    
	    $("#test").mouseenter(function(){
	        $(this).css("background","#f2e6ff");
	        $(".search-icon button").css("background","#dfa0fa").css("cursor","pointer");
	    }).mouseout(function(){
	    	$(this).css("background","white");
	        $(".search-icon button").css("background","white").css("cursor","default");
	    }); */
	    
	    $("#test").focus(function(){
	        /* $(this).css("border","1.5px solid #ff99ff"); */
	        $(this).css("background","#f2e6ff");
	        $(".search-icon button").css("background","#dfa0fa").css("cursor","pointer");
	    }).blur(function(){
	    	$(this).css("background","white");
	        $(".search-icon button").css("background","white").css("cursor","default");
	    });
	    
	    
	   
	   /*  $("#test").off('click', function(){
	        $("#test").css("background","white");
	        $(".search-icon button").css("background","white").css("cursor","pointer")
	    }); */
	     
	});
</script>
<style>
	.menu-first>li>a:hover{
	color:rgb(176,18,241);
	cursor: pointer;
	}
	#jumbotron{
	background-image: url('resources/images/slide2.jpg');
	}
</style>
</head>
<body>
<!--[if lt IE 7]>
<p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
<![endif]-->



		<div class="site-main" id="sTop">
            <div class="site-header">
                <div class="main-header">
                    <div class="container">
                        <div id="menu-wrapper">
                            <div class="row">
                                <div class="logo-wrapper col-md-2 col-sm-2">
                                </div> <!-- /.logo-wrapper -->
                                <div class="search-wrapper"> <!-- 수정 -->
                                    <h1>
                                       <input type="text" id="test" class="search" placeholder="Search">
                                    </h1>
                                </div>
                               	<div class="search-icon">
                                       <button>검색</button>
                               	</div>   
                                <div class="col-md-10 col-sm-10 main-menu text-right toggle-wrapper">
                                    <div class="toggle-menu visible-sm visible-xs"><i class="fa fa-bars"></i></div>
                                    <ul class="menu-first">
                                        <% if(loginUser == null){ %>
 											<li class="active"><a href="#" onclick="window.open('views/member/login.jsp', '로그인', 'width=500, height=400 left=500 top=250 toolbar=no location=no status=no')">Login</a></li>
                                        
										<%}else{ %>
							               <li class="active"><a href="#" onclick="location.href='<%= request.getContextPath()%>/logout.me';">Logout</a></li>
										<%} %>
                                        <li><a href='<%=request.getContextPath()%>/district.se'">지역별</a></li>
                                        <li><a href="<%=request.getContextPath()%>/category.se">업종별</a></li>
                                        <li><a href='<%=request.getContextPath()%>/list.bo'>게시판</a></li>
                                        <li><a href='<%=request.getContextPath()%>/manageResume.es'>개인서비스</a></li> 
										<li><a href='<%=request.getContextPath()%>/incruitList.os'>기업서비스</a></li>                                   
                                    </ul>                                    
                                </div> <!-- /.main-menu -->
                            </div> <!-- /.row -->
                        </div> <!-- /#menu-wrapper -->                        
                    </div> <!-- /.container -->
                </div> <!-- /.main-header -->
            </div> <!-- /.site-header -->
        </div>
    
   



        <script src="<%=request.getContextPath() %>/resources/js/vendor/jquery-1.11.0.min.js"></script>
        <script>window.jQuery || document.write("<script src='<%=request.getContextPath() %>/resources/js/vendor/jquery-1.11.0.min.js'><\/script>")</script>
        <script src="<%=request.getContextPath() %>/resources/js/bootstrap.js"></script>
        <script src="<%=request.getContextPath() %>/resources/js/plugins.js"></script>
        <script src="<%=request.getContextPath() %>/resources/js/main.js"></script>

</body>
</html>