$(function(){
    $("#imageCode").on("click",function() {
        $("#imageCode").attr("src","ImageCode?p="+Math.random()) ;
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
        messages : {
            "mid" : {
                remote : "该用户名已存在，请更换新的用户名！"
            }
        } ,
        rules : {
            "mid" : {
                required : true
            },
            "password" : {
                required : true
            } ,
            "conf" : {
                required : true ,
                equalTo : "#password"
            } ,
            "code" : {
                required : true
            }
        }
    });
})