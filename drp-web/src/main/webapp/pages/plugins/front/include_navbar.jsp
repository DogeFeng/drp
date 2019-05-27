<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public static final String LOGIN_URL = "login.jsp" ;
	public static final String MALL_INDEX_URL = "mall_index.jsp" ;

	public static final String PURCHASE_ADD_URL = "pages/front/center/purchase/purchase_add.jsp" ;

	public static final String MEMBER_EDIT_URL = "pages/front/center/member/member_edit.jsp" ;
	public static final String MEMBER_ADDRESS_LIST_URL = "pages/front/center/address/address_list.jsp" ;
	public static final String ORDERS_LIST_URL = "pages/front/center/orders/orders_list.jsp" ;
	public static final String SHOPCAR_LIST_URL = "pages/front/center/shopcar/shopcar_list.jsp" ;
%>
<div class="col-md-12">
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp"><strong>DRP</strong></a>
		</div>
		<ul class="nav navbar-nav">
				<li><a href="<%=LOGIN_URL%>"><span class="glyphicon glyphicon-certificate"></span>&nbsp;用户登录</a></li>
				<li><a href="<%=MALL_INDEX_URL%>"><span class="glyphicon glyphicon-certificate"></span>&nbsp;购物商城</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown"><span class="glyphicon glyphicon-globe"></span>&nbsp;个人中心<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="<%=MEMBER_EDIT_URL%>">
						<span class="glyphicon glyphicon-user"></span>&nbsp;个人资料</a></li>
					<li><a href="<%=MEMBER_ADDRESS_LIST_URL%>">
						<span class="glyphicon glyphicon-plane"></span>&nbsp;地址管理</a></li>
					<li class="divider">&nbsp;</li>
					<li><a href="<%=ORDERS_LIST_URL%>">
						<span class="glyphicon glyphicon-list-alt"></span>&nbsp;订单列表</a></li>
					<li><a href="<%=SHOPCAR_LIST_URL%>">
						<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;我的购物车</a></li>
					<li class="divider">&nbsp;</li>
					<li><a href="<%=PURCHASE_ADD_URL%>"><span class="glyphicon glyphicon-certificate"></span>&nbsp;大宗采购</a></li>
				</ul></li>
		</ul>
		<form class="navbar-form navbar-left" action="" method="post">
			<div class="form-group">
				<input type="text" class="form-control input-xs" placeholder="请输入商品关键字..." style="width:300px;background: #F5F5F5;height:30px;">
				<button class="btn btn-danger" style="height:30px;">搜索</button>
			</div>
		</form>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="javascript:;"
										class="dropdown-toggle" data-toggle="dropdown"> <i
						class="glyphicon glyphicon-user"></i>&nbsp;${name}&nbsp;<span
						class="glyphicon glyphicon-chevron-down"></span></a>
					<ul class="dropdown-menu main-list">
						<li><a href="pages/front/center/member/member_password_edit.jsp"><i class="glyphicon glyphicon-edit"></i>&nbsp;修改密码</a></li>
						<li><a href="pages/back/index.jsp"><i class="glyphicon glyphicon-home"></i>&nbsp;管理中心</a></li>
						<li class="divider"></li>
						<li><a href="MemberLoginActionFront!logout.action"><i class="glyphicon glyphicon-off"></i>&nbsp;登录注销</a></li>
					</ul></li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
			</ul>
	</nav>
</div>
