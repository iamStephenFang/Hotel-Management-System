<%@ page import="cn.edu.zjut.po.RoomType" %>
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
    <form>
      <div class="layui-form-item">
        <label class="layui-form-label">消息标题:</label>
        <div class="layui-input-block">
          <input type="text" value="<s:property value='#request.message.title'/>" class="layui-input" readonly/>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">发布日期:</label>
        <div class="layui-input-block">
          <input type="text" value="<s:property value='#request.message.sendTime'/>" class="layui-input" readonly/>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">消息内容:</label>
        <div class="layui-input-block">
          <s:textarea value='%{#request.message.content}' cssClass="layui-textarea" readonly="true"/>
        </div>
      </div>
    </form>
  </div>
</div>
<script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['form', 'laydate'], function () {
        var form = layui.form;

    });
</script>
</body>
</html>
