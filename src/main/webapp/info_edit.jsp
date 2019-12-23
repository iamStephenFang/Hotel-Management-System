<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>酒店管理系统-修改信息</title>
  <%@include file="head.jsp" %>
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
  <%--顶部导航栏--%>
  <%@include file="header.jsp" %>
  <s:if test="#session.choice == 1">
    <!-- waiter 侧边导航栏 -->
    <%@include file="waiter_sidebar.jsp" %>
  </s:if>
  <div class="layui-body">
    <div class="layuimini-container">
      <div class="layui-main">
        <div style="width: 500px;margin: 20px 10px">
          <form class="layui-form layuimini-form" action="updateInfo.action" method="post">
            <div class="layui-form-item">
              <label class="layui-form-label required">工号:</label>
              <div class="layui-input-block">
                <s:if test="#session.choice == 1">
                  <input type="text" name="id" value="<s:property value='#session.user.waiterId'/>" class="layui-input" style="color: #9dadce" readonly>
                </s:if>
                <s:else>
                  <input type="text" name="id" value="<s:property value='#session.user.adminId'/>" class="layui-input" style="color: #9dadce" readonly>
                </s:else>
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label required">账号名:</label>
              <div class="layui-input-block">
                <input type="text" name="account" lay-verify="required" lay-reqtext="账号名不能为空"
                       placeholder="请输入管理账号" value="<s:property value='#session.user.account'/>" class="layui-input">
                <tip>填写自己账号的名称</tip>
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label required">旧密码:</label>
              <div class="layui-input-block">
                <input type="password" name="oldPassword" lay-verify="required" lay-reqtext="旧的密码不能为空"
                       placeholder="请输入旧的密码" class="layui-input">
                <tip>填写账号的旧密码</tip>
              </div>
            </div>

            <div class="layui-form-item">
              <label class="layui-form-label required">新密码:</label>
              <div class="layui-input-block">
                <input type="password" name="newPassword" lay-verify="required" lay-reqtext="新的密码不能为空"
                       placeholder="请输入新的密码" class="layui-input">
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label required">新密码:</label>
              <div class="layui-input-block">
                <input type="password" lay-verify="required" lay-reqtext="新的密码不能为空"
                       placeholder="请重复输入新的密码" class="layui-input">
              </div>
            </div>

            <div class="layui-form-item">
              <div class="layui-input-block">
                <button class="layui-btn" lay-submit>确认保存</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="lib/layui-v2.5.4/layui.js?v=1.0.4" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['element', 'layuimini'], function () {
        var $ = layui.jquery,
            element = layui.element;

        $('.login-out').on("click", function () {
            layer.msg('退出登录成功', function () {
                window.location = 'backend_login.html';
            });
        });
    });
</script>
</body>
</html>
