$(function(){
	$(selall).on("click",function(){
		$("input[id^=mid-]").each(function(){
			$(this).prop("checked",true) ;
		}) ;
	}) ;
})