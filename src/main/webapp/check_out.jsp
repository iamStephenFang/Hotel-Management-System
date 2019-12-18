<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set var="step" value="3"/>
<html>
<head>
  <title>酒店管理系统-办理退房</title>
  <%@include file="head.jsp" %>
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
  <%@include file="header.jsp" %>
  <%@include file="waiter_sidebar.jsp" %>
  <div class="layui-body">
    <div class="layuimini-container">
      <div class="layui-fluid">
        <div class="layui-card">
          <div class="layui-card-body" style="padding-top: 40px;">
            <div carousel-item>
                <s:if test="#step==1">
                  <div>
                <div class="lay-step" style="width: 750px;">
                  <div class="step-item" style="width: 33.3333%;">
                    <div class="step-item-tail"><i class=""></i></div>
                    <div class="step-item-head step-item-head-active"><i class="layui-icon">1</i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">填写退房信息</div>
                    </div>
                  </div>
                  <div class="step-item" style="width: 33.3333%;">
                    <div class="step-item-tail"><i class=""></i></div>
                    <div class="step-item-head "><i class="layui-icon">2</i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">确认退房信息</div>
                    </div>
                  </div>
                  <div class="step-item" style="width: 33.3333%;">
                    <div class="step-item-head "><i class="layui-icon">3</i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">完成退房</div>
                    </div>
                  </div>
                </div>
                <form class="layui-form" style="margin: 0 auto;max-width: 460px;padding-top: 40px;">
                  <div class="layui-form-item">
                    <label class="layui-form-label">房间号:</label>
                    <div class="layui-input-block">
                      <input type="text" placeholder="请填写需退房的房间号" class="layui-input" lay-verify="number" required/>
                    </div>
                  </div>
                  <div class="layui-inline" style="margin-bottom: 15px">
                    <label class="layui-form-label">退房日期:</label>
                    <div class="layui-input-inline">
                      <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd"
                             autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <div class="layui-input-block">
                      <button class="layui-btn" lay-submit lay-filter="formStep">
                        &emsp;下一步&emsp;
                      </button>
                    </div>
                  </div>
                </form>
              </div>
              <div>
                </s:if>
                <s:if test="#step==2">
                <div class="lay-step" style="width: 750px;">
                  <div class="step-item" style="width: 33.3333%;">
                    <div class="step-item-tail"><i class="step-item-tail-done"></i></div>
                    <div class="step-item-head"><i class="layui-icon layui-icon-ok"></i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">填写退房信息</div>
                    </div>
                  </div>
                  <div class="step-item" style="width: 33.3333%;">
                    <div class="step-item-tail"><i class=""></i></div>
                    <div class="step-item-head step-item-head-active"><i class="layui-icon">2</i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">确认退房信息</div>
                    </div>
                  </div>
                  <div class="step-item" style="width: 33.3333%;">
                    <div class="step-item-head "><i class="layui-icon">3</i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">完成退房</div>
                    </div>
                  </div>
                </div>
                <form class="layui-form" style="margin: 0 auto;max-width: 460px;padding-top: 40px;">
                  <div class="layui-form-item">
                    <label class="layui-form-label">订单ID:</label>
                    <div class="layui-input-block">
                      <div class="layui-form-mid layui-word-aux">111</div>
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">房间类型:</label>
                    <div class="layui-input-block">
                      <div class="layui-form-mid layui-word-aux">双床房</div>
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">入住日期:</label>
                    <div class="layui-input-block">
                      <div class="layui-form-mid layui-word-aux">2019-12-25</div>
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">离店日期:</label>
                    <div class="layui-input-block">
                      <div class="layui-form-mid layui-word-aux">2019-12-27</div>
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <label class="layui-form-label">订单备注:</label>
                    <div class="layui-input-block">
                      <div class="layui-form-mid layui-word-aux">无</div>
                    </div>
                  </div>
                  <div class="layui-form-item">
                    <div class="layui-input-block">
                      <button type="button" class="layui-btn layui-btn-primary pre">上一步</button>
                      <button class="layui-btn" lay-submit lay-filter="formStep2">
                        &emsp;确认退房信息&emsp;
                      </button>
                    </div>
                  </div>
                </form>
              </div>
              <div>
                </s:if>
                <s:if test="#step==3">
                <div class="lay-step" style="width: 750px;">
                  <div class="step-item" style="width: 33.3333%;">
                    <div class="step-item-tail"><i class="step-item-tail-done"></i></div>
                    <div class="step-item-head"><i class="layui-icon layui-icon-ok"></i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">填写退房信息</div>
                    </div>
                  </div>
                  <div class="step-item" style="width: 33.3333%;">
                    <div class="step-item-tail"><i class="step-item-tail-done"></i></div>
                    <div class="step-item-head"><i class="layui-icon layui-icon-ok"></i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">确认退房信息</div>
                    </div>
                  </div>
                  <div class="step-item" style="width: 33.3333%;">
                    <div class="step-item-head step-item-head-active"><i class="layui-icon">3</i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">完成退房</div>
                    </div>
                  </div>
                </div>
                <div style="text-align: center;margin-top: 90px;">
                  <i class="layui-icon layui-circle"
                     style="color: white;font-size:30px;font-weight:bold;background: #52C41A;padding: 20px;line-height: 80px;">&#xe605;</i>
                  <div style="font-size: 24px;color: #333;font-weight: 500;margin-top: 30px;">
                    退房成功
                  </div>
                  <div style="font-size: 14px;color: #666;margin-top: 20px;">提醒顾客携带好个人证件离店</div>
                </div>
                <div style="text-align: center;margin-top: 50px;">
                  <button class="layui-btn next">再次办理</button>
                  <button class="layui-btn layui-btn-primary">查看信息</button>
                </div>
              </div>
            </div>
            </s:if>
          </div>
          <hr>
          <div style="color: #666;margin-top: 30px;margin-bottom: 40px;padding-left: 30px;">
            <h3>说明</h3><br>
            <h4>退房</h4>
            <p>请顾客确认入住期间是否存在消费行为，若存在需要在备注中注明。</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['form', 'laydate', 'step', 'layer', 'layuimini'], function () {
        var $ = layui.$,
            form = layui.form,
            step = layui.step,
            laydate = layui.laydate;

        step.render({
            elem: '#stepForm',
            filter: 'stepForm',
            width: '100%', //设置容器宽度
            stepWidth: '750px',
            height: '500px',
            stepItems: [{
                title: '填写退房信息'
            }, {
                title: '确认退房信息'
            }, {
                title: '完成退房'
            }]
        });
        //
        // laydate.render({
        //     elem: '#date'
        // });
        //
        // form.on('submit(formStep)', function (data) {
        //     step.next('#stepForm');
        //     return false;
        // });
        //
        // form.on('submit(formStep2)', function (data) {
        //     step.next('#stepForm');
        //     return false;
        // });
        //
        // $('.pre').click(function () {
        //     step.pre('#stepForm');
        // });
        //
        // $('.next').click(function () {
        //     step.next('#stepForm');
        // });
    })
</script>
</body>
</html>