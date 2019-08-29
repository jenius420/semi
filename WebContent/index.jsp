<%@page import="main.model.vo.Main"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@page import="member.model.vo.Member"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String contextPath = request.getContextPath();
	
	// 로그인 세션
	/* Member loginUser = (Member)session.getAttribute("loginUser") ; */

%>


<%-- <%  /* 수진  */

	EmpMember em = (EmpMember)session.getAttribute("loginUser");

	ArrayList<Main> recomendList = (ArrayList<Main>)request.getAttribute("recomendList"); 
	ArrayList<Main> primiumList = (ArrayList<Main>)request.getAttribute("primiumList");


%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
 <head>
        <meta charset="utf-8">
        <title>Donjo - Albamoon site</title>
    	<meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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

        <script src="resources/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
        
        
        <!-- Place somewhere in the <head> of your document -->
<link rel="stylesheet" href="flexslider.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="resources/js/jquery.flexslider.js"></script>

<!-- Place in the <head>, after the three links -->
<script type="text/javascript" charset="utf-8">
  $(window).load(function() {
    $('.flexslider').flexslider();
  });
</script>
        
        
        
        
        
        
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
                                        <a href="#" class="search">Search</a>
                                    </h1>
                                </div>
                                <div class="col-md-10 col-sm-10 main-menu text-right toggle-wrapper">
                                    <div class="toggle-menu visible-sm visible-xs"><i class="fa fa-bars"></i></div>
                                    <ul class="menu-first">
                                        <li class="active"><a href="#">Login</a></li>
                                        <li><a href="#location">지역별</a></li>
                                        <li><a href="#date">기간별</a></li>
                                        <li><a href="#board">게시판</a></li>
                                        <li><a href="#personalService">개인서비스</a></li> 
                                        <li><a href="#businesService">기업서비스</a></li>                                 
                                    </ul>                                    
                                </div> <!-- /.main-menu -->
                            </div> <!-- /.row -->
                        </div> <!-- /#menu-wrapper -->                        
                    </div> <!-- /.container -->
                </div> <!-- /.main-header -->
            </div> <!-- /.site-header -->
            <div class="site-slider">
                <div class="slider">
                    <div class="flexslider">
                        <ul class="slides">
                            <li>
                                <div class="overlay"></div>
                                <img src="resources/images/slide1.jpg" alt="">
                                <div class="slider-caption visible-md visible-lg">
                                    <h2>여름 방학 알바도</h2>
                                    <p>summer period alba</p>
                                    <a href="#" class="slider-btn">Let join summer!</a>
                                </div>
                            </li>
                            <li>
                                <div class="overlay"></div>
                                <img src="resources/images/slide2.jpg" alt="">
                                <div class="slider-caption visible-md visible-lg">
                                    <h2>서울 특성화 알바 구인사이트</h2>
                                    <p>you can see only Seoul alba</p>
                                    <a href="#" class="slider-btn">Go to Seoul!</a>
                                </div>
                            </li>
                            <li>
                                <div class="overlay"></div>
                                <img src="resources/images/slide3.jpg" alt="">
                                <div class="slider-caption visible-md visible-lg">
                                    <h2>너의 가치를 뽐내봐</h2>
                                    <p>High standard work</p>
                                    <a href="#" class="slider-btn">create resume</a>
                                </div>
                            </li>
                        </ul>
                    </div> <!-- /.flexslider -->
                </div> <!-- /.slider -->
            </div> <!-- /.site-slider -->
        </div> <!-- /.site-main -->


        <div class="content-section" id="services">
            <div class="container">
                <div class="row">
                </div> <!-- /.row -->
                <div class="row">
                    
                            </div> <!-- /.service-content -->
                        </div> <!-- /#service-1 -->
                    </div> <!-- /.col-md-3 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /#services -->
        
        
        <div class="content-section" id="our-team">
            <div class="container">
                <div class="row">
                    <div class="heading-section col-md-12 text-center">
                        <h2>Recomend</h2>
                        <p>당신에게 추천하는 아르바이트</p>
                    </div> <!-- /.heading-section -->
                </div> <!-- /.row -->
                <div class="row">
                                	
                    <div class="team-member col-md-3 col-sm-6">
                        <div class="member-thumb">
                                   	<a href="resources/images/recomend1.png" data-rel="lightbox" class="expand">
                            <img src="resources/images/recomend1.png" alt="">
                            <div class="team-overlay">
                                <h3>BurgerKing</h3>
                                <span>제조업</span>
                                <ul class="social">
                                    	<i class="fa fa-search"></i>
                                </ul>
                            </div> <!-- /.team-overlay -->
                                 	</a>
                        </div> <!-- /.member-thumb -->
                    </div> <!-- /.team-member -->
                                 	
                    <div class="team-member col-md-3 col-sm-6">
                        <div class="member-thumb">
                                    <a href="resources/images/gallery/p2.jpg" data-rel="lightbox" class="expand">
                            <img src="resources/images/recomend2.png" alt="">
                            <div class="team-overlay">
                                <h3>Starbucks</h3>
                                <span>제조업</span>
                                <ul class="social">
                                    	<i class="fa fa-search"></i>
                                </ul>
                            </div> <!-- /.team-overlay -->
                                 	</a>
                        </div> <!-- /.member-thumb -->
                    </div> <!-- /.team-member -->
                                 	
                                 	
                    <div class="team-member col-md-3 col-sm-6">
                        <div class="member-thumb">
                                    <a href="resources/images/gallery/p2.jpg" data-rel="lightbox" class="expand">
                            <img src="resources/images/recomend3.png" alt="">
                            <div class="team-overlay">
                                <h3>McDonald's</h3>
                                <span>판매업</span>
                                    	<i class="fa fa-search"></i>
                            </div> <!-- /.team-overlay -->
                                 	</a>
                        </div> <!-- /.member-thumb -->
                    </div> <!-- /.team-member -->
                                 	
                                 	
                    <div class="team-member col-md-3 col-sm-6">
                        <div class="member-thumb">
                                    <a href="resources/images/gallery/p2.jpg" data-rel="lightbox" class="expand">
                            <img src="resources/images/recomend4.png" alt="">
                            <div class="team-overlay">
                                <h3>KFC</h3>
                                <span>사무직</span>
                                <ul class="social">
                                    	<i class="fa fa-search"></i>
                                </ul>
                            </div> <!-- /.team-overlay -->
                                 	</a>
                        </div> <!-- /.member-thumb -->
                    </div> <!-- /.team-member -->
                                 	
                </div> <!-- /.row -->
                <div class="row">
                    <div class="col-md-12 text-center">
                        <div class="skills-heading">
                            <h3 class="skills-title">추천하는 알바가 궁금해?</h3>
                            <p class="small-text">albamoon</p>
                        </div>
                    </div> <!-- /.col-md-12 -->
                </div> <!-- /.row -->
                
            </div> <!-- /.container -->
        </div> <!-- /#our-team -->
        


        <div class="content-section" id="portfolio">
            <div class="container">
                <div class="row">
                    <div class="heading-section col-md-12 text-center">
                        <h2>Primium</h2>
                        <p>최고의 아르바이트를 소개합니다.</p>
                    </div> <!-- /.heading-section -->
                </div> <!-- /.row -->
                <div class="row">
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="resources/images/gallery/p1.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>New Walk</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="resources/images/gallery/p1.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> <!-- /.portfolio-overlay -->
                        </div> <!-- /.portfolio-thumb -->
                    </div> <!-- /.portfolio-item -->
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="resources/images/gallery/p2.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Boat</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="resources/images/gallery/p2.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> <!-- /.portfolio-overlay -->
                        </div> <!-- /.portfolio-thumb -->
                    </div> <!-- /.portfolio-item -->
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="resources/images/gallery/p7.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Urban</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="resources/images/gallery/p7.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> <!-- /.portfolio-overlay -->
                        </div> <!-- /.portfolio-thumb -->
                    </div> <!-- /.portfolio-item -->
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="resources/images/gallery/p8.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Cycling</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="resources/images/gallery/p8.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> <!-- /.portfolio-overlay -->
                        </div> <!-- /.portfolio-thumb -->
                    </div> <!-- /.portfolio-item -->
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="resources/images/gallery/p3.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Digital Era</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="resources/images/gallery/p3.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> <!-- /.portfolio-overlay -->
                        </div> <!-- /.portfolio-thumb -->
                    </div> <!-- /.portfolio-item -->
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="resources/images/gallery/p4.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Horizon</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="resources/images/gallery/p4.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> <!-- /.portfolio-overlay -->
                        </div> <!-- /.portfolio-thumb -->
                    </div> <!-- /.portfolio-item -->
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="resources/images/gallery/p5.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Aquatic City</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="resources/images/gallery/p5.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> <!-- /.portfolio-overlay -->
                        </div> <!-- /.portfolio-thumb -->
                    </div> <!-- /.portfolio-item -->
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="resources/images/gallery/p6.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>New Path</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="resources/images/gallery/p6.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> <!-- /.portfolio-overlay -->
                        </div> <!-- /.portfolio-thumb -->
                    </div> <!-- /.portfolio-item -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /#portfolio -->





        <div class="content-section" id="contact">
            <div class="container">
                <div class="row">
                    <div class="heading-section col-md-12 text-center">
                        <h2>Connect US</h2>
                        <p>서울의 모든 알바, 알바문</p>
                    </div> <!-- /.heading-section -->
                </div> <!-- /.row -->
                <div class="row" >
                    <div class="col-md-7" style="text-align:center" >
                        <p >
                            (주) 돈조네트웍스 <br>                                         
                            사업자등록번호 : 123-12-123456 | 부가통신사업 : 제 021047호 <br>              
                            통신판매업신고 : 제2019-서울동작-07290호 <br>                                    
                            직업정보제공사업 신고번호 : 서울동 제 2019-07호 <br>
                            <br>
                            알바문 고객센터 <br>
                            평일    09:00 ~ 19:00 <br>
                            토요일  09:00 ~ 15:00 / (일요일,공휴일 휴무) <br>                             
                        </p>
                        <ul class="contact-info">
                            <li>Phone: 010-3514-1361</li>
                            <li>Email: <a href="help@alamoon.co.kr">help@alamoon.co.kr</a></li>
                            <li>Address: 서울시 동작구 사당동 사당로</li>
                        </ul>
                        <!-- spacing for mobile viewing --><br><br>
                    </div> <!-- /.col-md-7 -->
                   
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /#contact -->
            
        <div id="footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-xs-12 text-left">
                        <span>Copyright © ALBAMOON Crop. All Right Reserved</span>
                  </div> <!-- /.text-center -->
                    <div class="col-md-4 hidden-xs text-right">
                        <a href="#top" id="go-top">Back to top</a>
                    </div> <!-- /.text-center -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /#footer -->
        
        <script src="resources/js/vendor/jquery-1.11.0.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>')</script>
        <script src="resources/js/bootstrap.js"></script>
        <script src="resources/js/plugins.js"></script>
        <script src="resources/js/main.js"></script>

        

               
        
        <!-- templatemo 406 flex -->
    </body>
</html>