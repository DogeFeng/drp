$(function(){
	$("button[id^=out-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[1] ;
			operateAlert(true,"待出库商品添加成功！","待出库商品添加失败！") ;
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
			/*$.get("###", {"mid": mid}, function (data) {
				var elem = $("#memberInfo table span") ;
				elem[0].innerText = ;
				elem[1].innerText = ;
				elem[2].innerText = ;
				elem[3].innerText = ;
				elem[4].innerText = ;
			}, "json");*/
			$("#memberInfo").modal("toggle") ;
		}) ;
	}) ;
})