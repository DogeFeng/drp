$(function(){
	$("button[id^=out-]").each(function(){
		var gid = $(this).attr("id").split("-")[1] ;
		$(this).on("click",function(){
			$.get("/pages/back/admin/distribution/distribution_goods_list.action",{"gid":gid},function(data){
				operateAlert(data.trim() == "true","待出库添加成功！","待出库添加失败！") ;
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
