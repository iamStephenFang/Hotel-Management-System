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
    <form class="layui-form layuimini-form" action="updateCustomer.action" method="post" style="margin-left:-30px;padding-right:50px">
      <s:hidden name="checkCustomer.orderId" value="%{#request.checkCustomer.orderId}"/>
      <div class="layui-form-item">
        <label class="layui-form-label">住客姓名:</label>
        <div class="layui-input-block">
          <input type="text" name="checkCustomer.name" value="<s:property value='#request.checkCustomer.name'/>"
                 lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">住客性别:</label>
        <div class="layui-input-block">
          <select name="checkCustomer.gender" lay-verify="required">
            <option value="1" selected>先生</option>
            <option value="0">女士</option>
          </select>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">身份证号:</label>
        <div class="layui-input-block">
          <input type="text" name="checkCustomer.customerId" value="<s:property value='#request.checkCustomer.customerId'/>"
                 lay-verify="required|identity" placeholder="请输入身份证号" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">手机号码:</label>
        <div class="layui-input-block">
          <input type="tel" name="checkCustomer.phone" value="<s:property value='#request.checkCustomer.phone'/>"
                 lay-verify="required|phone" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">入住日期:</label>
        <div class="layui-input-block">
          <input type="text" name="checkCustomer.checkInTime" value="<s:property value='#request.checkCustomer.checkInTime'/>" id="check_in_date"
                 lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input" lay-key="1">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">离店日期:</label>
        <div class="layui-input-block">
          <input type="text" name="checkCustomer.leaveTime" value="<s:property value='#request.checkCustomer.leaveTime'/>" id="check_out_date"
                 lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input" lay-key="2">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">入住房间:</label>
        <div class="layui-input-block">
          <input type="text" name="checkCustomer.roomId" value="<s:property value='#request.checkCustomer.roomId'/>"
                 lay-verify="required" placeholder="请输入房间号" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注信息:</label>
        <div class="layui-input-block">
          <s:textarea name="checkCustomer.orderDetail" value="%{#request.checkCustomer.orderDetail}" cssClass="layui-textarea"/>
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
    var choice = "<s:property value="#request.checkCustomer.gender"/>";
    var optionArray = document.getElementsByTagName("option");
    if (choice === true)
      optionArray[1].selected = true;
    else
      optionArray[0].selected = true;
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
