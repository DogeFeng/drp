$(function(){
	$(selall).on("click",function(){
		checkboxSelectAll("nid",this.checked) ;
	}) ;
	$(removeBtn).on("click",function(){
		operateChecked("nid","/pages/back/emp") ;
	}) ;
	$("span[id^=pub-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			$("#memberInfo").modal("toggle") ;
		}) ;
	}) ;
	$("button[id^=news-]").each(function(){
		$(this).on("click",function(){
			operateAlert(true,"公告发布成功！","公告发布失败！") ;
		}) ;
	}) ;
})