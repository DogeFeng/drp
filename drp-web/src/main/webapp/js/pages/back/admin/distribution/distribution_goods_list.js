$(function() {
	$("#allPrice").text(calSum()) ;
	$("#selectAll").on("click",function(){
		checkboxSelectAll('gid',this.checked) ;
	}) ;
	// 设置修改单独数量的操作
	$("button[id*=updateBtn-]").each(function(){
		// var gid = this.id.split("-")[1] ;
		$(this).on("click",function(){
			gid = $(this).attr("id").split("-")[1] ; // 获取id的属性内容
			amount = $("#amount-" + gid).val() ;
			if (parseInt(amount) == 0) {
				$("#goods-" + gid).remove() ;
			}
			data = gid + ":" + amount + ";";
			$.get("/pages/back/admin/distribution/distribution_details_edit.action",{"data":data},function(data){
				operateAlert(data.trim() == "true","购物车信息修改成功！","购物车信息修改失败！") ;
			},"text") ;
		}) ;
	}) ;
	// 实现整体修改操作的功能
	$(editBtn).on("click",function(){
		data = "" ; // 发送的修改数据
		$("input[id^='amount-']").each(function(){
			gid = $(this).attr("id").split("-")[1] ; // 获取id的属性内容
			amount = $(this).val() ; // 获取数量
			data += gid + ":" + amount + ";" ;
		}) ;
		$.get("/pages/back/admin/distribution/distribution_details_edit.action",{"data":data},function(data){
			operateAlert(data.trim() == "true","购物车信息修改成功！","购物车信息修改失败！") ;
		},"text") ;
	}) ;
	// $(editBtn).on("click",function(){
	// 	// 定义一个数组，保存所有需要被删除的gid数据
	// 	var delGid = new Array() ;
	// 	var foot = 0 ;
	// 	var data = "" ; // 实现最终数据拼凑的字符串
	// 	$("input[id*=amount-]").each(function(){
	// 		var gid = this.id.split("-")[1] ;
	// 		var amount = this.value ;
	// 		if (amount != "0") {
	// 			data += gid + ":" + amount + ";" ;
	// 		} else {
	// 			delGid[foot ++] = gid ;
	// 		}
	// 	}) ;
	// 	// 进行ajax异步数据处理操作
	// 	operateAlert(true,"商品数量修改成功！","商品数量修改失败！") ;
	// }) ;

	// $("#rmBtn").on("click",function(){	// 绑定用户锁定操作
	// 	var data = "" ;
	// 	$(":checked").each(function() {
	// 		if(this.id == "gid") {	// 要删除的内容
	// 			data += this.value + "," ;
	// 		}
	// 	}) ;
	// 	if (data != "") {
	// 		$(":checked").each(function() {
	// 			$("#goods-" + this.value).remove() ;
	// 		});
	// 		operateAlert(true,"商品信息移除成功！","商品信息移除失败！") ;
	// 	} else {
	// 		operateAlert(false,"","请先选择要移除的商品信息。") ;
	// 	}
	// }) ;
	$(rmBtn).on("click",function(){
		data = "" ; // 保存要删除的商品编号,用于传输数据
		gidArray = new Array() ; // 保存要删除 gid编号
		foot = 0 ;
		$(":checkbox[id='gid']").each(function(){
			if ($(this).prop("checked")) {
				data += $(this).val() + ";";
				gidArray[foot ++] = $(this).val() ;
			}
		}) ;
		console.log(data)
		if (data == "") {   // 此时没有选中任何的内容
			operateAlert(false,"","请先选择要删除的购物项！") ;
		} else {
			$.get("/pages/back/admin/distribution/distribution_details_delete.action",{"data":data},function(data){
				operateAlert(data.trim() == "true","购物车信息删除成功！","购物车信息删除失败！") ;
				if (data.trim() == "true") {    // 删除对应的表格行的信息
					for (x = 0 ; x < gidArray.length ; x ++) {
						$("#goods-" + gidArray[x]).remove() ;
					}
				}
			},"text") ;
		}
	}) ;
    // $(createBtn).on("click",function() {
    //     gidArray = new Array(); // 保存要传输的gid编号
    //     foot = 0;
    //     $(":checkbox[id='gid']").each(function () {
    //         if ($(this).prop("checked")) {
    //             gidArray[foot++] = parseInt($(this).val());
    //         }
    //     });
    //     $(this).attr("href",$(this).attr("href") + "?gids=" + gidArray);
    // });
	$("button[id*=add-]").each(function(){
		var gid = this.id.split("-")[1] ; // 取得商品ID数据
		$(this).on("click",function(){
			var amount = parseInt($("#amount-" + gid).val()) ;	// 直接取得value属性
			$("#amount-" + gid).val(amount+1) ;
			$("#allPrice").text(calSum()) ;
		})
	}) ;
	$("button[id*=sub-]").each(function(){
		var gid = this.id.split("-")[1] ; // 取得商品ID数据
		$(this).on("click",function(){
			var amount = parseInt($("#amount-" + gid).val()) ;	// 直接取得value属性
			if (amount > 0) {
				$("#amount-" + gid).val(amount - 1) ;
				$("#allPrice").text(calSum()) ;
			}
		})
	}) ; 
})
function calSum() {
	var sumPrice = 0.0 ;	// 保存总价
	// 计算购买的商品的总价数据
	$("span[id^='price-']").each(function(){
		var gid = this.id.split("-")[1] ; // 取得商品ID数据
		var price = parseFloat($(this).text()) ;	// 取得文本内容转变为小数
		var amount = parseInt($("#amount-" + gid).val()) ;	// 直接取得value属性变为整数
		sumPrice += price * amount;
	}) ;
	return round(sumPrice,2) ;
}