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
      <div class="layui-form-item">
        <label class="layui-form-label">住客性别</label>
        <div class="layui-input-block">
          <select lay-verify="required">
            <option value="1" selected>先生</option>
            <option value="2">女士</option>
          </select>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">身份证</label>
        <div class="layui-input-block">
          <input type="text" name="identity" lay-verify="identity" placeholder="" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">手机号码</label>
        <div class="layui-input-inline">
          <input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">入住房间</label>
        <div class="layui-input-inline">
          <select name="modules" lay-verify="required" lay-search="">
            <option value="">直接选择或搜索选择</option>
            <option value="1">layer</option>
            <option value="2">form</option>
            <option value="3">layim</option>
            <option value="4">element</option>
            <option value="5">laytpl</option>
            <option value="6">upload</option>
            <option value="7">laydate</option>
            <option value="8">laypage</option>
            <option value="9">flow</option>
            <option value="10">util</option>
            <option value="11">code</option>
            <option value="12">tree</option>
            <option value="13">layedit</option>
            <option value="14">nav</option>
            <option value="15">tab</option>
            <option value="16">table</option>
            <option value="17">select</option>
            <option value="18">checkbox</option>
            <option value="19">switch</option>
            <option value="20">radio</option>
          </select>
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
