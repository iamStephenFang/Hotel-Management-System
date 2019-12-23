<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>服务员修改</title>
  <%@include file="head.jsp" %>
</head>
<body>
<div class="layuimini-container">
  <div class="layuimini-main">
    <form class="layui-form layuimini-form" action="" method="post" style="margin-left:-30px;padding-right:50px">
      <%--      <s:hidden name="waiter.phone" value="%{#request.waiter.phone}"/>--%>
      <div class="layui-form-item">
        <label class="layui-form-label">工号:</label>
        <div class="layui-input-block">
          <input type="text" name="waiter.waiterId" value="20180606"
                 lay-verify="required|number" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">账号名:</label>
        <div class="layui-input-block">
          <input type="text" name="waiter.account" value="老铁"
                 lay-verify="required" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">密码:</label>
        <div class="layui-input-block">
          <input type="text" name="waiter.password" value="123456"
                 lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-input-block">
          <button class="layui-btn" lay-submit>确认修改</button>
        </div>
      </div>
    </form>
  </div>
</div>
<script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form;

    });
</script>
</body>
</html>
