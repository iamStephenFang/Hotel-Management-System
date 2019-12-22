<%@ page import="cn.edu.zjut.po.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>订单修改</title>
  <%@include file="head.jsp" %>
</head>
<body>
<div class="layuimini-container">
  <div class="layuimini-main">
    <form class="layui-form layuimini-form" action="updateOrder.action" method="post" style="margin-left:-30px;padding-right:50px">
      <s:hidden name="order.orderId" value="%{#request.order.orderId}"/>
      <br>
      <div class="layui-form-item">
        <label class="layui-form-label">修改房型</label>
        <div class="layui-input-block">
          <select name="order.roomType" lay-filter="room_type">
            <option value="双床房">双床房</option>
            <option value="大床房">大床房</option>
            <option value="家庭房">家庭房</option>
            <option value="总统套房">总统套房</option>
          </select>
          <tip>修改房间类型需要房客自行填补差价</tip>
        </div>
      </div>
      <br>
      <div class="layui-form-item">
        <label class="layui-form-label">入住日期:</label>
        <div class="layui-input-block">
          <input type="text" name="order.checkInTime" value="<s:property value='#request.order.checkInTime'/>" id="check_in_date" lay-verify="date"
                 placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" lay-key="1">
        </div>
      </div>
      <br>
      <div class="layui-form-item">
        <label class="layui-form-label">离店日期:</label>
        <div class="layui-input-block">
          <input type="text" name="order.leaveTime" value="<s:property value='#request.order.leaveTime'/>" id="check_out_date" lay-verify="date"
                 placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" lay-key="2">
        </div>
      </div>
      <br>
      <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注信息:</label>
        <div class="layui-input-block">
          <s:textarea value="%{#request.order.orderDetail}" name="order.orderDetail" cssClass="layui-textarea" />
        </div>
      </div>
      <br>
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
      var choice = "<s:property value="#request.order.roomType"/>";
      var optionArray = document.getElementsByTagName("option");
      if (choice === "双床房")
        optionArray[0].selected = true;
      else if (choice === "大床房")
        optionArray[1].selected = true;
      else if (choice === "家庭房")
        optionArray[2].selected = true;
      else
        optionArray[3].selected = true;
    };

    layui.use(['form', 'laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            laydate = layui.laydate;

        laydate.render({
            elem: '#check_in_date',
        });
        laydate.render({
            elem: '#check_out_date'
        });

    });
</script>
</body>
</html>
