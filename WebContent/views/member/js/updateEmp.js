$(function(){
	var rNum=$('#rNum').val();
	$.ajax({
		url:"address.me",
		data:{rNum:rNum},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
		type:"get",
		dataType:"json",
		success:function(list){
			$('#address').val(obj.address);
			
		},
		error:function(){
			concole.log("paging 실패");
		}
		
	})
});