<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/storageaudit/storageaudit_list_history.js"></script>
	<script type="text/javascript" src="js/split_page.js"></script>
</head>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="4"/>
			<jsp:param name="msi" value="42"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;审核历史记录</strong>
			</div>
			<div class="panel-body">
				<div>
					<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				</div>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center" style="width:10%;">入库单编号 </th> 
							<th class="text-left" style="width:20%;">申请标题</th>  
							<th class="text-left" style="width:20%;">入库仓库</th>
							<th class="text-center" style="width:10%;">审核日期</th>
							<th class="text-center" style="width:10%;">提交人</th>
							<th class="text-center" style="width:10%;">商品数量</th>
							<th class="text-center" style="width:10%;">总价（￥）</th>
							<th class="text-center" style="width:10%;">审核人员</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th class="text-center" style="width:10%;">20001010</th> 
							<td class="text-left"><span id="sid-1" style="cursor:pointer;">2017双十一衣帽入库</span></td>
							<td class="text-left"><span id="wid-1" style="cursor:pointer;">北京通州仓库一号库</span></td>
							<td class="text-center">2019-10-10</td>
							<td class="text-center"><span id="mid-admin" style="cursor:pointer;">老李</span></td>
							<td class="text-center">100</td>
							<td class="text-center">10000</td>
							<td class="text-center"><span id="mid-admin" style="cursor:pointer;">老张</span></td>
						</tr>
					</tbody>
				</table>
				<div id="splitBarDiv" style="float:right">
					<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
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
	<jsp:include page="/pages/plugins/back/modal/member_info_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/modal/storage_details_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/modal/warehouse_info_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/footer.jsp"/>
