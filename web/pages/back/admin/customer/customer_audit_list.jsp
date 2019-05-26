<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%!
	public static final String CUSTOMER_ADD_URL = "" ;
%>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/customer/customer_audit_list.js"></script>
	<script type="text/javascript" src="js/split_page.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
	<!-- 导入头部标题栏内容 -->
	<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
	<!-- 导入左边菜单项 -->
	<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
		<jsp:param name="mi" value="2"/>
		<jsp:param name="msi" value="23"/>
	</jsp:include>
	<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;待审核客户信息列表</strong>
			</div>
			<div class="panel-body">
				<div>
					<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				</div>
				<table class="table table-condensed">
					<thead>
					<tr>
						<th class="text-center" style="width:10%;">客户姓名</th>
						<th class="text-left" style="width:10%;">重要性</th>
						<th class="text-left" style="width:10%;">联系电话</th>
						<th class="text-left" style="width:20%;">联系地址</th>
						<th class="text-left" style="width:10%;">提交日期</th>
						<th class="text-left" style="width:20%;">操作</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td class="text-center"><span id="mid-admin" style="cursor:pointer;">新博</span></td>
						<td class="text-left"><span class="text-danger">网站注册</span></td>
						<td class="text-left">1234456</td>
						<td class="text-left">天安门广场</td>
						<td class="text-left">2018-10-13</td>
						<td class="text-left">
							<button class="btn btn-primary btn-xs" id="audit-1">
								<span class="glyphicon glyphicon-floppy-save"></span>&nbsp;审核处理</button>
						</td>
					</tr>
					<tr>
						<td class="text-center"><span id="mid-hello" style="cursor:pointer;">旧博</span></td>
						<td class="text-left"><span class="text-danger">网站注册</span></td>
						<td class="text-left">1234456</td>
						<td class="text-left">天安门广场</td>
						<td class="text-left">2018-10-13</td>
						<td class="text-left">
							<button class="btn btn-primary btn-xs" id="audit-2">
								<span class="glyphicon glyphicon-floppy-save"></span>&nbsp;审核处理</button>
						</td>
					</tr>
					</tbody>
				</table>
				<div id="splitBarDiv" style="float:right">
					<jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
				</div>
			</div>
			<div class="panel-footer" style="height:100px;">
				<jsp:include page="/pages/plugins/alert.jsp"/>
			</div>
		</div>
	</div>
	<!-- 导入公司尾部认证信息 -->
	<jsp:include page="/pages/plugins/back/include_title_foot.jsp" />
	<!-- 导入右边工具设置栏 -->
	<jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp" />
	<div class="control-sidebar-bg"></div>
</div>
<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/modal/member_info_modal.jsp"/>
<jsp:include page="/pages/plugins/back/modal/customer_audit_modal.jsp"/>
<jsp:include page="/pages/plugins/back/modal/customer_record_list_modal.jsp"/>
<jsp:include page="/pages/plugins/back/modal/customer_record_input_modal.jsp"/>
</body>
</html>