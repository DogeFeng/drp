<%@ page import="java.util.List" %>
<%@ page import="com.yootk.drp.vo.Goods" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/front/goods/goods_list.js"></script>
</head>
<%!
	public static final String GOODS_SHOW_URL = "pages/front/goods/goods_show.action" ;
	public static final String GOODS_PRICE_URL = "http://111.230.131.204/drp/upload/" ;
	private int foot = 1;
%>
<%
	request.setAttribute("lineSize",8) ;
	List<Goods> list = (List<Goods>)request.getAttribute("allGoods") ;
	if(!(list == null || list.size() ==0)){
		Long stid = list.get(0).getStid() ;
		session.setAttribute("stid" , stid) ;
	}else {
		session.setAttribute("stid" , 0) ;
	}
%>
<body>
	<div class="container contentback">
		<div id="headDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<jsp:include page="/pages/plugins/front/include_navbar.jsp" />
			</div>
		</div>
		<div style="height: 60px;"></div> 
		<div id="contentDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<strong><span class="glyphicon glyphicon-edit"></span>&nbsp;商品信息</strong>
					</div>
					<div class="panel-body">
						<div class="row">
							<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
						</div>
						<div class="row">
							<c:forEach items="${allGoods}" var="goods" >
								<div class="col-md-3 text-center">
									<p>
										<a href="<%=GOODS_SHOW_URL%>?gid=${goods.gid}">
											<img src="<%=GOODS_PRICE_URL%>${goods.photo}" style="width:100px;"></a></p>
									<span class="text-warning h4"><strong>￥${goods.price}</strong></span>
									<p><a href="<%=GOODS_SHOW_URL%>?gid=${goods.gid}">${goods.name}</a></p>
									<button id="addCar-<%=foot++%>" class="btn btn-primary btn-xs">
										<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;加入购物车</button>
								</div>
							</c:forEach>

						<div id="splitBarDiv" style="float:right">
							<jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
						</div>
					</div>
					<div class="panel-footer">
						<jsp:include page="/pages/plugins/alert.jsp"/>
					</div>
				</div>
			</div>
		</div>
		<div class="row" style="height:50px;">
			<jsp:include page="/pages/plugins/alert.jsp"/>
		</div>
		<div id="footDiv" class="row navbar-fixed-bottom">
			<jsp:include page="/pages/plugins/front/include_title_foot.jsp" />
		</div>
	</div>
	</div>
</body>
</html>