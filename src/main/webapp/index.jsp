<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>酒店管理系统-服务员登入</title>
  <%@include file="head.jsp" %>
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
  <%@include file="header.jsp" %>
  <%@include file="waiter_sidebar.jsp" %>
  <div class="layui-body">
  </div>

</div>
<script src="lib/layui-v2.5.4/layui.js?v=1.0.4" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['element', 'layer', 'layuimini'], function () {
        var $ = layui.jquery,
            element = layui.element,
            layer = layui.layer;

        layuimini.init('api/init.json');

        $('.login-out').on("click", function () {
            layer.msg('退出登录成功', function () {
                window.location = 'login-1.html';
            });
        });
    });
</script>
</body>
</html>
