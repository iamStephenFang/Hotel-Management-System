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
    <form class="layui-form layuimini-form" action="" method="post" style="margin-left:-30px;padding-right:50px">
      <div class="layui-form-item">
        <label class="layui-form-label">房间类型:</label>
        <div class="layui-input-block">
          <input type="text" name="roomType.roomType" value="双床房"
                 lay-verify="required" placeholder="请输入房间类型" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">入住上限:</label>
        <div class="layui-input-block">
          <input type="text" name="roomType.checkInNum" value="4"
                 lay-verify="required|number" placeholder="请输入入住上限" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">房间价格:</label>
        <div class="layui-input-block">
          <input type="text" name="roomType.roomPrice" value="999"
                 lay-verify="required|number" placeholder="请输入房间价格" autocomplete="off" class="layui-input">
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
    layui.use(['form', 'laydate'], function () {
        var form = layui.form;

    });
</script>
</body>
</html>
