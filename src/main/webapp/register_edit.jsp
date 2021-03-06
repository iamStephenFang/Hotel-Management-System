<%@ page import="cn.edu.zjut.po.Register" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>用户修改</title>
  <%@include file="head.jsp" %>
</head>
<body>
<div class="layuimini-container">
  <div class="layuimini-main">
    <form class="layui-form layuimini-form" action="updateRegister.action" method="post" style="margin-left:-30px;padding-right:50px">
<%--      <s:hidden name="register.phone" value="%{#request.register.phone}"/>--%>
      <div class="layui-form-item">
        <label class="layui-form-label">手机号:</label>
        <div class="layui-input-block">
          <input type="text" name="register.phone" value="<s:property value='#request.registers.phone'/>"
                 lay-verify="required|phone" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">账号名:</label>
        <div class="layui-input-block">
          <input type="text" name="register.account" value="<s:property value='#request.registers.account'/>"
                 lay-verify="required" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">密码:</label>
        <div class="layui-input-block">
          <input type="text" name="register.password" value="<s:property value='#request.registers.password'/>"
                 lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">性别:</label>
        <div class="layui-input-block">
          <select name="register.gender" lay-verify="required">
            <option value="true">先生</option>
            <option value="false">女士</option>
          </select>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">邮箱:</label>
        <div class="layui-input-block">
          <input type="tel" name="register.email" value="<s:property value='#request.registers.email'/>"
                 lay-verify="required|email" autocomplete="off" class="layui-input">
        </div>
      </div>
<%--      <div class="layui-form-item">--%>
<%--        <label class="layui-form-label">会员等级:</label>--%>
<%--        <div class="layui-input-block">--%>
<%--          <input type="tel" name="register.level" value="<s:property value='#request.registers.level'/>"--%>
<%--                 lay-verify="required" autocomplete="off" class="layui-input">--%>
<%--        </div>--%>
<%--      </div>--%>
      <div class="layui-form-item">
        <label class="layui-form-label">积分:</label>
        <div class="layui-input-block">
          <input type="tel" name="register.score" value="<s:property value='#request.registers.score'/>"
                 lay-verify="required|number" autocomplete="off" class="layui-input">
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
    window.onload=function() {
        var choice = <s:property value="#request.registers.gender"/>;
        var optionArray = document.getElementsByTagName("option");
        if (choice === true)
            optionArray[0].selected = true;
        else
            optionArray[1].selected = true;
    };

    layui.use(['form', 'laydate'], function () {
        var form = layui.form;

    });
</script>
</body>
</html>
