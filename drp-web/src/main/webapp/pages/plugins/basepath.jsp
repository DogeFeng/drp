<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() ;
    application.setAttribute("basePath", basePath) ; // 将BasePath的内容保存在application属性之中
%>
<title>DRP（Distribution Resource Plannin）分销管理系统</title>
<base href="<%=basePath%>/"/>
<link rel="icon" href="images/logo.ico" type="image/x-icon" />
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script type="text/javascript" src="js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery/additional-methods.min.js"></script>
<script type="text/javascript" src="js/jquery/Message_zh_CN.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/yootk.util.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="css/yootk.css">
<link type="text/css" rel="stylesheet" href="dist/plugins/ionicons/css/ionicons.min.css">
<link type="text/css" rel="stylesheet" href="dist/plugins/font-awesome/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet" href="dist/css/AdminLTE.min.css">
<link type="text/css" rel="stylesheet" href="dist/css/skins/_all-skins.min.css">