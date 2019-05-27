<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%!
    public static final String CUSTOMER_AUTHENTICATION_URL = "pages/front/center/purchase/purchase_authentication.jsp" ;
    public static final String PURCHASE_ADD_URL = "pages/front/center/purchase/purchase_add.jsp" ;
    public static final String PURCHASE_LIST_URL = "pages/front/center/purchase/purchase_list.jsp" ;
%>
<ul class="nav nav-pills nav-stacked">									<!-- 定义导航 -->
    <li class="${param.ch == 1 ? "active" : ""}"><a href="<%=CUSTOMER_AUTHENTICATION_URL%>">客户认证</a></li>			<!-- 活跃导航项 -->
    <li class="${param.ch == 2 ? "active" : ""}"><a href="<%=PURCHASE_ADD_URL%>">采购申请单</a></li>
    <li class="${param.ch == 3 ? "active" : ""}"><a href="<%=PURCHASE_LIST_URL%>">采购订单</a></li>
</ul>
