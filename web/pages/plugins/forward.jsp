<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String msg = request.getParameter("msg") ;
    String path = request.getParameter("path") ;
%>
<div class="row">
    <div class="col-md-3"><img src="images/dandan.gif"></div>
    <div class="col-md-9">
        <p><span class="h3"><%=msg%></span></p>
        <p><span class="h3"><span id="time">4</span>秒后将进行页面的跳转，如果没有跳转，请按
							<a class="h3" href="<%=path%>">这里</a>！</span></p>
    </div>
</div>