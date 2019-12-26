<%@ page import="cn.edu.zjut.po.Room" %>
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
    <form class="layui-form layuimini-form" action="updateRoom.action" method="post" style="margin-left:-30px;padding-right:50px">
      <div class="layui-form-item">
        <label class="layui-form-label">房间号:</label>
        <div class="layui-input-block">
          <input type="text" name="room.roomId" value="<s:property value='#request.rooms.roomId'/>" class="layui-input" readonly>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">房间类型:</label>
        <div class="layui-input-block">
          <input type="text" name="room.roomType.type" value="<s:property value='#request.rooms.roomType.type'/>"
                 lay-verify="required" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">房间详情:</label>
        <div class="layui-input-block">
          <input type="text" name="room.roomDetail" value="<s:property value='#request.rooms.roomDetail'/>"
                 lay-verify="required" placeholder="请输入详情信息" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">房间状态:</label>
        <div class="layui-input-block">
          <select name="room.roomStatus" lay-verify="required">
            <option value="true">未入住</option>
            <option value="false">已入住</option>
          </select>
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
        var choice = <s:property value="#request.rooms.roomStatus"/>;
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
