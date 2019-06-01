cid = 0 ;
$(function(){
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			//mid = this.id.split("-")[1] ;
			mid = this.id.substring(4) ;
			$("#memberInfo").modal("toggle") ;
			$.getJSON("/pages/back/admin/customer/customer_list_member_modal.action", {"mid": mid}, function (data) {
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
	$("span[id^=cuid-]").each(function(){
		$(this).on("click",function(){
			cuid = this.id.split("-")[1] ;
			loadData() ;
			$("#customerRecordInfo").modal("toggle") ;
			$("#table tr").remove();
			$.getJSON("/pages/back/admin/customer/customer_record_list.action",{"cuid":cuid},function (data) {
				for (x = 0; x < data.length; x++) {
					$(criid).append("<option value='" + data[x].criid + "'>" + data[x].title + "</option>");
					$("#table").append("<tr id='record-" + data[x].cuid + "'>" +
						"<td class='text-center'>" + data[x].cdate + "</td>" +
						"<td class='text-left'>" + "记录者" + "</td>" +
						"<td class='text-left'>" + "记录者电话" + "</td>" +
						"<td class='text-left'><pre class='pre-scrollable' style='width:700px;height: 60px'>" + data[x].note + "</pre></td>" +
						"</tr>")
				}
			})
		}) ;
	}) ;
	$("button[id^=out-]").each(function(){
		$(this).on("click",function(){
			cuid = this.id.split("-")[1] ;
			mid = "${mid}";
			console.log(mid);
			operateAlert(true,"出库客户追加成功！","出库客户追加失败！") ;
		}) ;
	}) ;
	$("button[id^=input-]").each(function(){
		$(this).on("click",function(){
			cuid = this.id.split("-")[1] ;
			$("#customerRecordInputInfo").modal("toggle") ;
			$.getJSON("/pages/back/admin/customer/customer_record_input_cuid.action",{"cuid":cuid},function (data) {
				$("#cuid").val(data) ;
			})
			$.getJSON("/pages/back/admin/customer/customer_record_input_pre.action",{},function (data) {
				for (x = 0; x < data.length; x++) {
					$(criid).append("<option value='" + data[x].criid + "'>" + data[x].title + "</option>");
				}
			});
		}) ;
	}) ;
	// $("#myform").validate({
	// 	debug : true, // 取消表单的提交操作
	// 	submitHandler : function(form) {
	// 		// 发送ajax请求进行异步数据处理操作
	// 		$("#customerRecordInputInfo").modal("toggle") ;
	// 		operateAlert(true,"客户联系记录追加成功！","客户联系记录追加失败！") ;
	// 	},
	// 	errorPlacement : function(error, element) {
	// 		$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
	// 	},
	// 	highlight : function(element, errorClass) {
	// 		$(element).fadeOut(1,function() {
	// 			$(element).fadeIn(1, function() {
	// 				$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
	// 			});
	//
	// 		})
	// 	},
	// 	unhighlight : function(element, errorClass) {
	// 		$(element).fadeOut(1,function() {
	// 			$(element).fadeIn(1,function() {
	// 					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
	// 			});
	// 		})
	// 	},
	// 	errorClass : "text-danger",
	// 	rules : {
	// 		"title" : {
	// 			required : true
	// 		} ,
	// 		"criid" : {
	// 			required : true
	// 		} ,
	// 		"note" : {
	// 			required : true
	// 		}
	// 	}
	// });
}) ;
function loadData() {	// 该函数名称一定要固定，不许修改
	// 如果要想进行分页的处理列表前首先查询出部门编号
	console.log("客户编号：" + cuid) ;
	// $("#memberBasicInfo tr:gt(0)").remove() ; // 加载之前要进行原有数据删除
	createSplitBar(10) ;	// 创建分页控制项
}