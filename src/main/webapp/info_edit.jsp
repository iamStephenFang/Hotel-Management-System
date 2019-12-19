<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>酒店管理系统-修改信息</title>
  <%@include file="head.jsp" %>
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
  <%@include file="header.jsp" %>
  <%@include file="waiter_sidebar.jsp" %>
  <div class="layui-body">
    <div class="layuimini-container">
      <div class="layui-form layuimini-form">
        <div class="layui-form-item">
          <label class="layui-form-label required">账号名</label>
          <div class="layui-input-block">
            <input type="text" name="username" lay-verify="required" lay-reqtext="管理账号不能为空" placeholder="请输入管理账号"
                   value="admin" class="layui-input">
            <tip>填写自己账号的名称。</tip>
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label required">旧密码</label>
          <div class="layui-input-block">
            <input type="password" name="old_password" lay-verify="required" lay-reqtext="旧的密码不能为空"
                   placeholder="请输入旧的密码" value="" class="layui-input">
            <tip>填写账号的旧密码。</tip>
          </div>
        </div>

        <div class="layui-form-item">
          <label class="layui-form-label required">新密码</label>
          <div class="layui-input-block">
            <input type="password" name="new_password" lay-verify="required" lay-reqtext="新的密码不能为空"
                   placeholder="请输入新的密码" value="" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label required">新密码</label>
          <div class="layui-input-block">
            <input type="password" name="re_password" lay-verify="required" lay-reqtext="新的密码不能为空"
                   placeholder="请重复输入新的密码" value="" class="layui-input">
          </div>
        </div>

        <div class="layui-form-item">
          <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">确认保存</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="lib/layui-v2.5.4/layui.js?v=1.0.4" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['element', 'layer', 'layuimini'], function () {
        var $ = layui.jquery,
            element = layui.element,
            layer = layui.layer;

        $('.login-out').on("click", function () {
            layer.msg('退出登录成功', function () {
                window.location = 'backend_login.html';
            });
        });
    });
</script>
</body>
</html>
