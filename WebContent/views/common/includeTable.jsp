<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="resources/table/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/table/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="resources/table/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="resources/table/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="resources/table/vendor/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" type="text/css" href="resources/table/css/gs-util.css">
<link rel="stylesheet" type="text/css" href="resources/table/css/gs-main.css">


<style>


.tab_container>label{
border:1px solid transparent;
display:inline-block;
padding:20px 30px;
margin:0 0 -1px;
font-weight: 600;
font-size:15px;
color: #bbb;

}

.tab_container>label:hover{
cursor:pointer;
color: purple;
}
</style>
</head>
<body>

<script src="resources/table/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="resources/table/vendor/bootstrap/js/popper.js"></script>
<script src="resources/table/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/table/vendor/select2/select2.min.js"></script>
<script src="resources/table/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script src="resources/table/js/gs-main.js"></script>
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