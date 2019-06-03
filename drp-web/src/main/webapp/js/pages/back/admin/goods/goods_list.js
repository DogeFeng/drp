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
			$.getJSON("pages/back/admin/customer/customer_list_member_modal.action", {"mid": mid}, function (data) {
				url = "http://111.230.131.204/drp/upload/" + data.member.photo ;
				$("img").attr("src", url) ;
				$("#name").text(data.member.name) ;
				$("#level").text(data.level) ;
				$("#dept").text(data.dept) ;
				$("#phone").text(data.member.phone) ;
				$("#note").text(data.member.note) ;
			}).fail(function () {
				alert(2) ;
			});
		}) ;
	}) ;
})
