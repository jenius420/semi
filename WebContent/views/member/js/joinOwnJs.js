
$(function(){
	
	
	
	$.ajax({
		url:"bigCategory.me",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
			type:"get",
			dataType:"json",
			success:function(list){
				var $searchResult= $('#bigCategory');
				$searchResult.html("");
				$.each(list, function(index, value){
					var $bigCategory= $("<option>").attr("value",value.bigCategory).text(value.bigCategory);
					$searchResult.append($bigCategory);
				});
				$('#bigCategory').children().attr("selected","selected");
			},error:function(){
				console.log("ajax통신 실패");
			}
		});
	
	
	$('#bigCategory').on('change',function(){
		var cate= $('option[selected=selected]').val();
		console.log(cate);
		$.ajax({
			url:"subCategory.me",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
				type:"get",
				data:{bigCategory:cate},
				dataType:"json",
				success:function(list){
					var $searchResult= $('#subCategory');
					$searchResult.html("");
					$.each(list, function(index, value){
						var $subCategory= $("<option>").attr("value",value.subCategory).text(value.subCategory);
						$searchResult.append($subCategory);
					});
					},error:function(){
					console.log("ajax통신 실패");
				}
			});
	})
	
	$('#mailAccept').change(function(){
		if($('#mailAccept').is(":checked")){
			$('#mailAccept').val('Y');
			console.log($('#mailAccept').val());
		}else{
			$('#mailAccept').val('N');
		}
	});
	$('#smsAccept').change(function(){
		if($('#smsAccept').is(":checked")){
			$('#smsAccept').val('Y');
			console.log($('#mailAccept').val());
		}else{
			$('#smsAccept').val('N');
		}
	});
	
});

