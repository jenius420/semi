<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String contextPath = request.getContextPath();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8">
        <title>Flex - Responsive HTML Template</title>
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
    </head>
    
<body>
 <div class="content-section" id="contact">
            <div class="container">
                <div class="row">
                </div> <!-- /.row -->
                <div class="row">
                    <div class="col-md-12">
                       <div class="googlemap-wrapper">
                            <div id="map_canvas" class="map-canvas"></div>
                        </div> <!-- /.googlemap-wrapper -->
                    </div> <!-- /.col-md-12 -->
                </div> <!-- /.row -->
                <div class="row">
                    <div class="col-md-7 col-sm-6">
                        <p>
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
                            <li>Email: <a href="help@albamoon.co.kr">help@albamoon.co.kr</a></li>
                            <li>Address: 서울시 동작구 사당동 사당로</li>
                        </ul>
                        <!-- spacing for mobile viewing --><br><br>
                    </div> <!-- /.col-md-7 -->
                    <div class="col-md-5 col-sm-6">
                    </div> <!-- /.col-md-5 -->
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
        <script>window.jQuery || document.write('<script src="resources/js/vendor/jquery-1.11.0.min.js"><\/script>')</script>
        <script src="resources/js/bootstrap.js"></script>
        <script src="resources/js/plugins.js"></script>
        <script src="resources/js/main.js"></script>


                /* Simulate hover on iPad
                 * http://stackoverflow.com/questions/2851663/how-do-i-simulate-a-hover-with-a-touch-in-touch-enabled-browsers
                 --------------------------------------------------------------------------------------------------------------*/ 
                $('body').bind('touchstart', function() {});
            });
                  
        </script>
</body>
</html>