$(function(){
	//判断默认选择的二级菜单
	$(function(){
		var wiid = $("#wiid option:selected").val() ;
		var stid = $("#stidSelect").val() ;

		if(wiid != null) {
			$("#stid option:gt(0)").remove() ;		// 清除已有的内容
			$.get("pages/back/admin/goods/goods_add_pre_subtype.action", {"wiid": wiid}, function (data) {
				for (x = 0; x < data.length; x++) {
					if(stid == data[x].stid){
						$("#stid").append("<option value='" + data[x].stid + "' selected>" + data[x].title + "</option>") ;
					}else{
						$("#stid").append("<option value='" + data[x].stid + "'>" + data[x].title + "</option>") ;
					}
				}
			}, "json");
		}
	})

	//通过ajax获取二级菜单
	$("#wiid").on("change",function () {
		var wiid = $(this).val() ;
		if(wiid != null) {
			console.log($("#stidSelect").val()) ;
			$("#stid option:gt(0)").remove() ;		// 清除已有的内容
			$.get("pages/back/admin/goods/goods_add_pre_subtype.action", {"wiid": wiid}, function (data) {
				for (x = 0; x < data.length; x++) {
					$("#stid").append("<option value='" + data[x].stid + "'>" + data[x].title + "</option>") ;
				}
			}, "json");
		}

	}) ;

	tinymce.init({ selector:'#note' });
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
			"name" : {
				required : true
			} ,
			"tid" : {
				required : true 
			},
			"stid" : {
				required : true 
			},
			"price" : {
				required : true ,
				number : true 
			},
			"weight" : {
				required : true ,
				digits : true 
			},
			"pic" : {
				required : true ,
				accept : ["jpg","png","gif","bmp"]
			},
			"note" : {
				required : true
			}
		}
	});
})