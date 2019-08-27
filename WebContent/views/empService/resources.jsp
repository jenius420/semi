<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="resources/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="resources/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="resources/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="resources/vendor/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" type="text/css" href="resources/css/gs-util.css">
<link rel="stylesheet" type="text/css" href="resources/css/gs-main.css">

<link rel="stylesheet" type="text/css" href="resources/css/displayStructure.css">
<style>
.gs-btn{
	background:transparent;
    border: 2px solid transparent;
    box-sizing: border-box;
    cursor: pointer;
    font-size: 14;
    font-weight: 700;
    line-height: 1;
    margin: 18px;
    padding: 15px 25px;
    text-align: center;
    text-decoration: none;
    display:inline-block;
    outline:none;
    position:relative;
    top:0;
    text-shadow:0 1px 1px rgba(0, 0, 0, 0.5);
    -webkit-transition: all 0.2s ease-in-out 0s;
    -moz-transition: all 0.2s ease-in-out 0s;
    -ms-transition: all 0.2s ease-in-out 0s;
     transition: all 0.2s ease-in-out 0s;
     background:#9a59b5;
	color:#fff;
	box-shadow: 0 3px 0 #7f4497;
	border-radius:5px;	
}

.gs-btn:hover{
	background:#c472e6;	
}
.gs-btn:active, .gs-btn:focus{
	background:#944fb0;	
}

.gs-btn-parent{
text-align: right;
}
</style>
</head>
<body>

<script src="resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="resources/vendor/bootstrap/js/popper.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/vendor/select2/select2.min.js"></script>
<script src="resources/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script src="resources/js/gs-main.js"></script>
<script>

$('.js-pscroll').each(function(){
	var ps = new PerfectScrollbar(this);

	$(window).on('resize', function(){
		ps.update();
	})
});
</script>

</body>
</html>