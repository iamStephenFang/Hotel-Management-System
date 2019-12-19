<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>订单修改</title>
  <%@include file="head.jsp" %>
</head>
<body>
<div class="layuimini-container">
  <div class="layuimini-main">
    <div class="layui-form layuimini-form">
      <div class="layui-form-item">
        <label class="layui-form-label">修改房型</label>
        <div class="layui-input-block">
          <select name="room_type" lay-filter="room_type">
            <option value=""></option>
            <option value="0">双床房</option>
            <option value="1" selected="">大床房</option>
            <option value="2">家庭房</option>
            <option value="3">总统套房</option>
          </select>
          <tip>修改房间类型需要房客自行填补差价。</tip>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline" style="margin-left: 40px !important;">
          <label class="layui-form-label">入住日期</label>
          <div class="layui-input-inline">
            <input type="text" name="check_in_date" id="check_in_date" lay-verify="date" placeholder="yyyy-mm-dd"
                   autocomplete="off" class="layui-input" lay-key="1">
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline" style="margin-left: 40px !important;">
          <label class="layui-form-label">离店日期</label>
          <div class="layui-input-inline">
            <input type="text" name="check_out_date" id="check_out_date" lay-verify="date" placeholder="yyyy-mm-dd"
                   autocomplete="off" class="layui-input" lay-key="2">
          </div>
        </div>
      </div>
      <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注信息</label>
        <div class="layui-input-block">
          <textarea name="remark" class="layui-textarea" placeholder="请输入备注信息"></textarea>
        </div>
      </div>

      <div class="layui-form-item">
        <div class="layui-input-block">
          <button class="layui-btn" lay-submit lay-filter="saveBtn">确认修改</button>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
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
