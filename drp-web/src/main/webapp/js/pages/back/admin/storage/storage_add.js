$(function(){
	$(cid).on("change",function(){
		val = $(this).val() ;
		if (val != "") {
			setAddressValue() ;
		}
	}) ;
	$(pid).on("change",function(){
		val = $(this).val() ;
		if (val != "") {
			setAddressValue() ;
			$("#cid option:gt(0)").remove(); // 清除已有的内容
			$("#cid option:eq(0)").prop("selected") ;

			$.get("pages/back/admin/city/city_list.action", {"pid": val}, function (data) {
				for (x = 0; x < data.length; x++) {
					$(cid).append("<option value='" + data[x].cid + "'>" + data[x].title + "</option>");
				}
			}, "json");
		}
	}) ;
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			form.submit(); // 提交表单
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"title" : {
				required : true
			} ,
			"pid" : {
				required : true 
			},
			"cid" : {
				required : true 
			},
			"wid" : {
				required : true 
			},
			"iid" : {
				required : true 
			},
			"note" : {
				required : true
			}
		}
	});
})
function setAddressValue() {	// 设置省份和城市的内容
	province = "" ;
	city = "" ;
	if ($("#pid").val() != "") {
		province = $("#pid>option:selected").text(); // 获得选定元素的文本内容
	}
	if ($("#cid").val() != "") {
		city = $("#cid>option:selected").text(); // 获得选定元素的文本内容
	}
}