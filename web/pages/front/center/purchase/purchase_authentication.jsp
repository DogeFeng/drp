<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <jsp:include page="/pages/plugins/basepath.jsp"/>
    <script type="text/javascript" src="js/pages/front/center/purchase/purchase_authentication.js"></script>
</head>
<%!
    public static final String PURCHASE_AUTHENTICATION_URL = "" ;
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
            <jsp:include page="/pages/plugins/front/center/include_purchase_item.jsp">
                <jsp:param value="1" name="ch"/>
            </jsp:include>
        </div>
        <div class="col-md-10 col-xs-10">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <strong><span class="glyphicon glyphicon-edit"></span>&nbsp;客户认证</strong>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" action="<%=PURCHASE_AUTHENTICATION_URL%>" id="myform" method="post">
                        <fieldset>
                            <!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
                            <div class="form-group" id="nameDiv">
                                <!-- 定义表单提示文字 -->
                                <label class="col-md-3 control-label" for="name">客户姓名：</label>
                                <div class="col-md-5">
                                    <!-- 定义表单输入组件 -->
                                    <input type="text" id="name" name="name" class="form-control"
                                           placeholder="请输入您的认证姓名">
                                </div>
                                <!-- 定义表单错误提示显示元素 -->
                                <div class="col-md-4" id="nameMsg"></div>
                            </div>
                            <div class="form-group" id="typeDiv">
                                <!-- 定义表单提示文字 -->
                                <label class="col-md-3 control-label" for="type">认证类型：</label>
                                <div class="col-md-2">
                                    <!-- 定义表单输入组件 -->
                                    <div class="radio-inline"><input type="radio" name="type" id="type" value="1">企业</div>
                                </div>
                                <div class="col-md-3">
                                    <!-- 定义表单输入组件 -->
                                    <div class="radio-inline"><input type="radio" name="type" id="type" value="2" checked>个人</div>
                                </div>
                                <!-- 定义表单错误提示显示元素 -->
                                <div class="col-md-4" id="typeMsg"></div>
                            </div>
                            <div class="form-group" id="phoneDiv">
                                <!-- 定义表单提示文字 -->
                                <label class="col-md-3 control-label" for="phone">联系电话：</label>
                                <div class="col-md-5">
                                    <!-- 定义表单输入组件 -->
                                    <input type="text" id="phone" name="phone" class="form-control"
                                           placeholder="请输入您的联系电话">
                                </div>
                                <!-- 定义表单错误提示显示元素 -->
                                <div class="col-md-4" id="phoneMsg"></div>
                            </div>
                            <div class="form-group" id="pidDiv">
                                <!-- 定义表单提示文字 -->
                                <label class="col-md-3 control-label" for="pid">所在省份：</label>
                                <div class="col-md-5">
                                    <select id="pid" name="pid" class="form-control">
                                        <option value="">====== 请选择所在省份 ======</option>
                                        <option value="1">河北省</option>
                                        <option value="2">山西部</option>
                                        <option value="3">广东省</option>
                                    </select>
                                </div>
                                <!-- 定义表单错误提示显示元素 -->
                                <div class="col-md-4" id="pidMsg"></div>
                            </div>
                            <div class="form-group" id="cidDiv">
                                <!-- 定义表单提示文字 -->
                                <label class="col-md-3 control-label" for="cid">所在城市：</label>
                                <div class="col-md-5">
                                    <select id="cid" name="cid" class="form-control">
                                        <option value="">====== 请选择所在省份 ======</option>
                                        <option value="1">石家庄</option>
                                        <option value="2">沧州</option>
                                        <option value="3">邯郸</option>
                                    </select>
                                </div>
                                <!-- 定义表单错误提示显示元素 -->
                                <div class="col-md-4" id="cidMsg"></div>
                            </div>
                            <div class="form-group" id="addressDiv">
                                <!-- 定义表单提示文字 -->
                                <label class="col-md-3 control-label" for="address">通讯地址：</label>
                                <div class="col-md-5">
                                    <!-- 定义表单输入组件 -->
                                    <input type="text" id="address" name="address" class="form-control"
                                           placeholder="请输入客户通讯地址信息">
                                </div>
                                <!-- 定义表单错误提示显示元素 -->
                                <div class="col-md-4" id="addressMsg"></div>
                            </div>
                            <div class="form-group" id="noteDiv">
                                <!-- 定义表单提示文字 -->
                                <label class="col-md-3 control-label" for="note">备注信息：</label>
                                <div class="col-md-5">
                                    <!-- 定义表单输入组件 -->
                                    <textarea id="note" name="note" class="form-control"
                                              placeholder="请输入采购的内容项"></textarea>
                                </div>
                                <!-- 定义表单错误提示显示元素 -->
                                <div class="col-md-4" id="noteMsg"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-5 col-md-offset-3">
                                    <button type="submit" class="btn btn-primary">提交</button>
                                    <button type="reset" class="btn btn-warning">重置</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
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