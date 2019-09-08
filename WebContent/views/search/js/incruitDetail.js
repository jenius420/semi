$(function(){
	
	var oNum=$('#oNum').val();
	console.log(oNum);
	var check='check';
	$.ajax({
		url:"hopeEnt.se",
				data:{hopeBtn:check,oNum:oNum},
				type:"get",
				dataType:"json",
				success:function(obj){
					console.log("check"+obj.hopeBtn);
					$('#hopeEnt').html(obj.hopeBtn);
				},
				error:function(){
					console.log("ajax 실패");
				}
	})
	
	$(document).on('click','#hopeEnt', function(){
		var hopeBtn=$('#hopeEnt').text();
		console.log('hopeEnt : ' +hopeBtn);
		
		console.log(oNum);
			$.ajax({
				url:"hopeEnt.se",
				data:{hopeBtn:hopeBtn,oNum:oNum},
				type:"get",
				dataType:"json",
				success:function(obj){
					$('#hopeEnt').text(obj.hopeBtn);
				},
				error:function(){
					console.log("ajax 실패");
				}
			})
		
	});
	
})