<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public static final String CASE_LIST_URL = "#" ;
	public static final String MALL_INDEX_URL = "mall_index.jsp" ;
	public static final String NEWS_LIST_URL = "pages/front/news/news_list.jsp" ;
	public static final String LOGIN_URL = "login.jsp" ;
%>
<div class="col-md-12">
	<div class="row">
		<div class="col-md-6">
			<a href="<%=CASE_LIST_URL%>"><img id="but-case" src="images/but/but-case.jpg"></a>
		</div>
		<div class="col-md-6">
			<a href="<%=NEWS_LIST_URL%>"><img id="but-note" src="images/but/but-note.jpg"></a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<a href="<%=MALL_INDEX_URL%>"><img id="but-pre" src="images/but/but-mall.jpg"></a>
		</div>
		<div class="col-md-6">
			<a href="<%=LOGIN_URL%>"><img id="but-login" src="images/but/but-login.jpg"></a>
		</div>
	</div>
</div>