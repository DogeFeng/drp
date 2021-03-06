<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/front/center/shopcar/shopcar_list.js"></script>
</head>
<%!
	public static final String GOODS_SHOW_URL = "pages/front/goods/goods_show.jsp" ;
%>
<body class="back">
	<div class="container contentback">
		<div id="headDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<jsp:include page="/pages/plugins/front/include_navbar.jsp" />
			</div>
		</div>
		<div style="height: 60px;"></div> 
		<div id="contentDiv" class="row">
			<div class="col-md-2 col-xs-2">
				<jsp:include page="/pages/plugins/front/center/include_center_item.jsp">
					<jsp:param value="4" name="ch"/>
				</jsp:include>
			</div>
			<div class="col-md-10 col-xs-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<strong><span class="glyphicon glyphicon-list"></span>&nbsp;我的购物车</strong>
					</div>
					<div class="panel-body">
						<table class="table table-condensed">
							<thead>
								<tr>
									<th class="text-center">
										<input type="checkbox" id="selectAll">
									</th>
									<th class="text-center"><strong>商品名称</strong></th>
									<th class="text-center"><strong>商品单价</strong></th>
									<th class="text-center"><strong>购买数量</strong></th>
									<th class="text-center"><strong>操作</strong></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="text-center">
										<input type="checkbox" id="gid" name="gid" value="1">
									</td>
									<td class="text-center">
										<a href="<%=GOODS_SHOW_URL%>" onmouseover="this.style.cursor='hand'">Java开发实战经典</a>
									</td>
									<td class="text-center"><span id="price-1">79.8</span></td>
									<td class="text-center">
										<button class="btn btn-primary" id="sub-1">-</button>
										<input type="text" id="amount-1" name="amount-1" class="shopcar-form-control" size="4" maxlength="4" value="20">
										<button class="btn btn-primary" id="add-1">+</button> 
									</td>
									<td class="text-center"><button class="btn btn-primary" id="updateBtn-1">修改</button></td>
								</tr>
								<tr> 
									<td class="text-center">
										<input type="checkbox" id="gid" name="gid" value="2">
									</td>
									<td class="text-center">
										<a href="<%=GOODS_SHOW_URL%>" onmouseover="this.style.cursor='hand'">Java开发实战经典</a>
									</td>
									<td class="text-center"><span id="price-2">79.8</span></td>
									<td class="text-center">
										<button class="btn btn-primary" id="sub-2">-</button>
										<input type="text" id="amount-2" name="amount-2" class="shopcar-form-control" size="4" maxlength="4" value="20">
										<button class="btn btn-primary" id="add-2">+</button> 
									</td>
									<td class="text-center"><button class="btn btn-primary" id="updateBtn-2">修改</button></td>
								</tr>
							</tbody>
						</table>
						<div class="text-right">
							总价￥<span id="allPrice" class="text-danger h2">78.9</span>
						</div>
						<div>
							<button class="btn btn-primary" id="editBtn"><span class="glyphicon glyphicon-pencil"></span>&nbsp;修改数量</button>
							<button class="btn btn-danger" id="rmBtn"><span class="glyphicon glyphicon-remove"></span>&nbsp;移出购物车</button>
							<a class="btn btn-success" href="pages/front/center/orders/orders_add.jsp" id="addBtn"><span class="glyphicon glyphicon-file"></span>&nbsp;下单</a>
						</div>
					</div>
					<div class="panel-footer">
						<jsp:include page="/pages/plugins/alert.jsp"/>
					</div>
				</div>
			</div>
		</div>
		<div id="footDiv" class="row navbar-fixed-bottom">
			<jsp:include page="/pages/plugins/front/include_title_foot.jsp" />
		</div>
	</div>
</body>
</html>