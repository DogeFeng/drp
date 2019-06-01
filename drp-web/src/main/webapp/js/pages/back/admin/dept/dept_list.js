$(function(){
	$("button[id^=edit-]").each(function(){
		$(this).on("click",function(){
			did = this.id.split("-")[1] ;
			console.log("部门编号：" +  did) ;
			dname = $("#dname-" + did).val() ;
			if (dname == "") { 
				operateAlert(false,"","部门名称不允许为空，请确认后再提交更新！") ;
			} else {
				$.get("pages/back/admin/dept/dept_edit.action",{"did":did,"dname":dname},function(data){
					operateAlert(data.trim() == "true","部门名称修改成功！","部门名称修改失败！") ;
				},"text") ;
				//operateAlert(true,"部门名称更新成功！","") ;
			}
		}) ;
	}) ;
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			//mid = this.id.split("-",2)[1] ;
			mid = this.id.substring(4) ;
			console.log("雇员编号：" + mid) ;
			$("#memberInfo").modal("toggle") ;
			$.getJSON("/pages/back/admin/dept/dept_list_modal.action", {"mid": mid}, function (data) {
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
}) ;