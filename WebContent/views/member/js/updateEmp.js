$(function(){
	var rNum=$('#rNum').val();
	$.ajax({
		url:"address.me",
		data:{rNum:rNum},
		type:"get",
		dataType:"json",
		success:function(obj){
			console.log("체크" +obj.addr);
			$('#address').val(obj.addr);
			
		},
		error:function(){
			concole.log("paging 실패");
		}
		
	});
	
});


function checkPwd(){
	var pwd1 = $('#pwd').val();
	var pwd2 = $('#pwd2').val();
	if(pwd1==pwd2){
		$('#sameCheck').text("비밀번호 일치");
	}else{
		$('#sameCheck').text("비밀번호 불일치");
	}
	$('#pwd2').focus();
}
