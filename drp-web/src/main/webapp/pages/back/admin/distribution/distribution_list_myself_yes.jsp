<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%!
	public static final String DISTRIBUTION_EDIT_URL = "pages/back/admin/distribution/distribution_edit_pre.action" ;
	public static final String DISTRIBUTION_LIST_DETAILS_URL = "pages/back/admin/distribution/distribution_list_details.action" ;
	public static final String DISTRIBUTION_DELETE_URL = "pages/back/admin/distribution/distribution_editStatus.action" ;
%>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/distribution/distribution_list_myself.js"></script>
	<script type="text/javascript" src="js/split_page.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="7"/>
			<jsp:param name="msi" value="72"/> 
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;我的出库单</strong>
			</div>
			<div class="panel-body">
				<div>
					<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				</div>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center" style="width:10%;">出库单编号 </th> 
							<th class="text-left" style="width:20%;">申请标题</th> 
							<th class="text-center" style="width:10%;">省份</th>
							<th class="text-center" style="width:10%;">城市</th>
							<th class="text-center" style="width:10%;">申请状态</th>
							<th class="text-center" style="width:10%;">商品数量</th>
							<th class="text-center" style="width:10%;">商品总价</th>
							<th class="text-left" style="width:20%;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allDistribution}" var="dist">
							<tr>
								<th class="text-center" style="width:10%;">${dist.dsid}</th>
								<td class="text-left">
									<a href="<%=DISTRIBUTION_EDIT_URL%>?dsid=${dist.dsid}">
											${dist.title}
									</a>
								</td>
								<td class="text-center">${allProvinces[dist.pid]}</td>
								<td class="text-center">${allCitys[dist.cid]}</td>
								<td class="text-center">${dist.status==1?"已提交":"未提交"}</td>
								<td class="text-center">${dist.gnum}</td>
								<td class="text-center">${dist.price}</td>
								<td class="text-left">
									<a href="<%=DISTRIBUTION_LIST_DETAILS_URL%>?dsid=${dist.dsid}" class="btn btn-warning btn-xs">
										<span class="glyphicon glyphicon-th-list"></span>&nbsp;出库清单</a>
									<a href="<%=DISTRIBUTION_DELETE_URL%>?dsid=${dist.dsid}&status=0" class="btn btn-danger btn-xs">
										<span class="glyphicon glyphicon-remove"></span>&nbsp;取消申请</a>
								</td>
							</tr>
						</c:forEach>

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
</body>
</html>
