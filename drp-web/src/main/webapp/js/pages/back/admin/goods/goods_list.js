$(function(){
	$("button[id^=out-]").each(function(){
		var gid = $(this).attr("id").split("-")[1] ;
		$(this).on("click",function(){
			console.log("*** gid = " + gid) ;
			$.get("/pages/back/admin/distribution/distribution_goods_list.action",{"gid":gid},function(data){
				console.log(data);
				operateAlert(data.trim() == "true","购物车添加成功！","购物车添加失败！") ;
			},"text") ;
		}) ;
	}) ;
	$("span[id^=storage-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			$("#goodsRecordInfo").modal("toggle") ; 
		}) ;
	}) ;
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			$("#memberInfo").modal("toggle") ;
		}) ;
	}) ;
})
