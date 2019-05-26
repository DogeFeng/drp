<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <jsp:include page="/pages/plugins/basepath.jsp"/>
</head>
<body>
<div class="container contentback">
    <div id="headDiv" class="row">
        <div class="col-md-12 col-xs-12">
            <jsp:include page="/pages/plugins/front/include_navbar.jsp" />
        </div>
    </div>
    <div style="height: 60px;"></div>
    <div id="contentDiv" class="row">
        <script type="text/javascript">
            window.onload = function() {
                goForward() ;
            }
            function goForward() {
                spanObject = document.getElementById("countSpan") ;
                count = parseInt(spanObject.innerHTML) ;	// 取得当前计数的内容
                count -- ;
                if (count == 0) {	// 要进行跳转
                    window.location = "${basePath}/${path}" ;	// 跳转
                } else {
                    spanObject.innerHTML = count ;
                    setTimeout(goForward,1000) ;
                }
            }
        </script>
        <div>${msg}</div>
        <div><span id="countSpan">2</span>秒后跳转到其它页面！</div>
    </div>
    <div class="row" style="height:50px;">
        <jsp:include page="/pages/plugins/alert.jsp"/>
    </div>
    <div id="footDiv" class="row navbar-fixed-bottom">
        <jsp:include page="/pages/plugins/front/include_title_foot.jsp" />
    </div>
</div>
</body>
</html>
