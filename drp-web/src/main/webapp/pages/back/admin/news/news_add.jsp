<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/news/news_add.js"></script>
	<script type="text/javascript" src="bootstrap/tinymce/tinymce.min.js"></script>
</head>
<%!
	public static final String NEWS_ADD_URL = "" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="role" value="news"/>
			<jsp:param name="action" value="news:add"/>
		</jsp:include>
		<div class="content-wrapper">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><i class="fa fa-file-picture-o"></i>&nbsp;发布公告</strong>
				</div>
				<div class="panel-body">
					<form action="<%=NEWS_ADD_URL%>" id="myform" method="post" class="form-horizontal" enctype="multipart/form-data">
						<div class="form-group" id="titleDiv">
							<label class="col-md-2 control-label" for="title">公告标题：</label>
							<div class="col-md-5">
								<input type="text" name="title" id="title" class="form-control input-sm" placeholder="请输入公告标题">
							</div>
							<div class="col-md-4" id="titleMsg">*</div>
						</div>
						<div class="form-group" id="absDiv">
							<label class="col-md-2 control-label" for="abs">公告摘要：</label>
							<div class="col-md-5">
								<input type="text" name="abs" id="abs" class="form-control input-sm" placeholder="请输入公告摘要">
							</div>
							<div class="col-md-4" id="absMsg">*</div>
						</div>
						<div class="form-group" id="picDiv">
							<label class="col-md-2 control-label" for="pic">公告图片：</label>
							<div class="col-md-5">
								<input type="file" name="pic" id="pic" class="form-control input-sm" placeholder="请选择公告所需要的图片">
							</div>
							<div class="col-md-4" id="picMsg">*</div>
						</div>
						<div class="form-group" id="noteDiv">
							<label class="col-md-2 control-label" for="status">公告内容：</label>
							<div class="col-md-9">
								<textarea id="note" name="note" class="form-control" rows="10"></textarea>
							</div>
						</div>
						<div class="form-group" id="statusDiv">
							<label class="col-md-2 control-label" for="status">公告状态：</label>
							<div class="col-md-5">
								<div class="radio-inline">
									<input type="radio" id="status" name="status" checked value="1">直接发布
								</div>
								<div class="radio-inline">
									<input type="radio" id="status" name="status" value="0">暂存草稿
								</div>
							</div>
							<span class="col-md-4" id="statusSpan">*</span>
						</div>
						
						<div class="form-group"> 
							<div class="col-md-offset-2 col-md-5">
								<input type="submit" value="发布" class="btn btn btn-primary">
								<input type="reset" value="重置" class="btn btn btn-warning">
							</div>
						</div>
					</form>
				</div>
				<div class="panel-footer">
				</div>
			</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
</body>
</html>
