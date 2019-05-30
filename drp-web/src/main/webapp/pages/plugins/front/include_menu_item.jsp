<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
    public static final String GOODS_LIST_URL = "pages/front/goods/goods_list.jsp" ;
    private int foot = 1 ;
%>
<div class="panel-group" id="item">		<!-- 利用面板定义折叠组件 -->
    <c:forEach items="${allWitem}" var="witem" >
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#item" href="#content-<%=foot%>">
                        ${witem.title}
                    </a>
                </h4>
            </div>
            <div id="content-<%=foot++%>" class="panel-collapse collapse">		<!-- 面板默认隐藏 -->
                <div class="panel-body">
                    <div class="row">
                        <c:forEach items="${allSubtype}" var="subtype">
                            <c:if test="${subtype.wiid == witem.wiid}">
                                <div class="col-md-4"><a href="<%=GOODS_LIST_URL%>">${subtype.title}</a></div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
