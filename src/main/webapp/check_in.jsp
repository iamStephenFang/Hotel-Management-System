<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>酒店管理系统-办理入住</title>
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
              <s:if test="#request.step==null || #request.step==''">
                <div>
                  <div class="lay-step" style="width: 750px;">
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-tail"><i class=""></i></div>
                      <div class="step-item-head step-item-head-active"><i class="layui-icon">1</i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">检索订单信息</div>
                      </div>
                    </div>
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-tail"><i class=""></i></div>
                      <div class="step-item-head "><i class="layui-icon">2</i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">确认订单信息</div>
                      </div>
                    </div>
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-tail"><i class=""></i></div>
                      <div class="step-item-head "><i class="layui-icon">3</i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">添加住客信息</div>
                      </div>
                    </div>
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-head "><i class="layui-icon">4</i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">入住办理完成</div>
                      </div>
                    </div>
                  </div>
                  <form class="layui-form" action="searchOrder.action?step=2" method="post" style="margin: 0 auto;max-width: 460px;padding-top: 40px;">
                    <div class="layui-form-item">
                      <label class="layui-form-label">订单ID:</label>
                      <div class="layui-input-block">
                        <input type="text" name="orderId" placeholder="请填写订单ID" class="layui-input" lay-verify="number" required/>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <div class="layui-input-block">
                        <button class="layui-btn" lay-submit>
                          &emsp;下一步&emsp;
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
              </s:if>
              <s:if test="#request.step==2">
                <div>
                  <div class="lay-step" style="width: 750px;">
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-tail"><i class="step-item-tail-done"></i></div>
                      <div class="step-item-head"><i class="layui-icon layui-icon-ok"></i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">检索订单信息</div>
                      </div>
                    </div>
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-tail"><i class=""></i></div>
                      <div class="step-item-head step-item-head-active"><i class="layui-icon">2</i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">确认订单信息</div>
                      </div>
                    </div>
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-tail"><i class=""></i></div>
                      <div class="step-item-head "><i class="layui-icon">3</i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">添加住客信息</div>
                      </div>
                    </div>
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-head "><i class="layui-icon">4</i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">入住办理完成</div>
                      </div>
                    </div>
                  </div>
                  <form class="layui-form" action="findEmptyRoom.action?step=3" method="post" style="margin: 0 auto;max-width: 460px;padding-top: 40px;">
                    <div class="layui-form-item">
                      <label class="layui-form-label">订单ID:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux"><s:property value="#request.order.orderId"/></div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">房间数量:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux"><s:property value="#request.order.roomNum"/></div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">订单总额:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux"><s:property value="#request.order.payment"/></div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">房间类型:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux"><s:property value="#request.order.roomType"/></div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">入住日期:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux"><s:property value="#request.order.checkInTime"/></div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">离店日期:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux"><s:property value="#request.order.leaveTime"/></div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">订单备注:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux"><s:property value="#request.order.orderDetail"/></div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <div class="layui-input-block">
                        <a href="check_in.jsp" type="button" class="layui-btn layui-btn-primary pre">上一步</a>
                        <button class="layui-btn" lay-submit>
                          &emsp;填写入住信息&emsp;
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
              </s:if>
              <s:if test="#request.step==3">
                <div>
                  <div class="lay-step" style="width: 750px;">
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-tail"><i class="step-item-tail-done"></i></div>
                      <div class="step-item-head"><i class="layui-icon layui-icon-ok"></i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">检索订单信息</div>
                      </div>
                    </div>
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-tail"><i class="step-item-tail-done"></i></div>
                      <div class="step-item-head"><i class="layui-icon layui-icon-ok"></i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">确认订单信息</div>
                      </div>
                    </div>
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-tail"><i class=""></i></div>
                      <div class="step-item-head step-item-head-active"><i class="layui-icon">3</i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">添加住客信息</div>
                      </div>
                    </div>
                    <div class="step-item" style="width: 25%;">
                      <div class="step-item-head "><i class="layui-icon">4</i></div>
                      <div class="step-item-main">
                        <div class="step-item-main-title">入住办理完成</div>
                      </div>
                    </div>
                  </div>
                  <form id="diffActionForm" class="layui-form" method="post" style="margin: 0 auto;max-width: 400px;padding-top: 40px;">
                    <s:hidden name="checkCustomer.orderId" value="%{#session.orderId}"/>
                    <div class="layui-form-item">
                      <label class="layui-form-label">贵宾姓名:</label>
                      <div class="layui-input-block" style="width: 300px">
                        <input name="checkCustomer.name" type="text" placeholder="请输入贵宾姓名"
                               class="layui-input" lay-verify="required"/>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">证件信息:</label>
                      <div class="layui-input-block" style="width: 300px">
                        <input name="checkCustomer.customerId" placeholder="请填写贵宾身份证号" autocomplete="false"
                               class="layui-input" lay-verify="identity">
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">贵宾性别:</label>
                      <div class="layui-input-block" style="width: 300px">
                        <select name="checkCustomer.gender" lay-verify="required">
                          <option value="true" selected>先生</option>
                          <option value="false">女士</option>
                        </select>
                      </div>
                    </div>
                    <div class="layui-form-item" style="margin-bottom: 15px">
                      <label class="layui-form-label">入住日期:</label>
                      <div class="layui-input-block" style="width: 300px">
                        <input name="checkCustomer.checkInTime" type="text" id="date" lay-verify="date" placeholder="yyyy-MM-dd"
                               autocomplete="off" class="layui-input" lay-key="1">
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">分配房间:</label>
                      <div class="layui-input-block" style="width: 300px">
                        <select name="checkCustomer.roomId" lay-verify="required" lay-search>
                          <option value="" selected></option>
                          <s:iterator value="#request.rooms" var="roomId">
                            <option value="<s:property value='roomId'/>"><s:property value="roomId"/></option>
                          </s:iterator>
                        </select>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">联系方式:</label>
                      <div class="layui-input-block" style="width: 300px">
                        <input name="checkCustomer.phone" type="number" placeholder="请填写贵宾电话号码"
                               class="layui-input" lay-verify="number">
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <div class="layui-input-block" style="width:400px;margin-left:25px">
                        <a class="layui-btn layui-btn-primary pre" onclick="faceCheck();">
                          &emsp;人证核验&emsp;
                        </a>
                        <button class="layui-btn layui-btn-primary pre" onclick="continueAdd();">
                          &emsp;继续添加&emsp;
                        </button>
                        <button class="layui-btn" onclick="completeCheckIn();">
                          &emsp;完成入住&emsp;
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
              </s:if>
              <s:if test="#request.step==4">
                <div class="lay-step" style="width: 750px;">
                  <div class="step-item" style="width: 25%;">
                    <div class="step-item-tail"><i class="step-item-tail-done"></i></div>
                    <div class="step-item-head"><i class="layui-icon layui-icon-ok"></i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">检索订单信息</div>
                    </div>
                  </div>
                  <div class="step-item" style="width: 25%;">
                    <div class="step-item-tail"><i class="step-item-tail-done"></i></div>
                    <div class="step-item-head"><i class="layui-icon layui-icon-ok"></i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">确认订单信息</div>
                    </div>
                  </div>
                  <div class="step-item" style="width: 25%;">
                    <div class="step-item-tail"><i class="step-item-tail-done"></i></div>
                    <div class="step-item-head"><i class="layui-icon layui-icon-ok"></i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">添加住客信息</div>
                    </div>
                  </div>
                  <div class="step-item" style="width: 25%;">
                    <div class="step-item-head step-item-head-active"><i class="layui-icon">4</i></div>
                    <div class="step-item-main">
                      <div class="step-item-main-title">入住办理完成</div>
                    </div>
                  </div>
                </div>
                <div style="text-align: center;margin-top: 90px;">
                  <i class="layui-icon layui-circle"
                     style="color: white;font-size:30px;font-weight:bold;background: #52C41A;padding: 20px;line-height: 80px;">&#xe605;</i>
                  <div style="font-size: 24px;color: #333;font-weight: 500;margin-top: 30px;">
                    办理入住成功
                  </div>
                  <div style="font-size: 14px;color: #666;margin-top: 20px;">请提供给顾客相关信息</div>

                  <div style="text-align: center;margin-top: 50px;">
                    <a href="check_in.jsp" class="layui-btn next">再次办理</a>
                    <a href="listAllCustomers.action" class="layui-btn layui-btn-primary">查看信息</a>
                  </div>
                </div>
              </s:if>
            </div>
            <hr>
            <div style="color: #666;margin-top: 30px;margin-bottom: 40px;padding-left: 30px;">
              <h3>注意</h3><br>
              <h4>实际入住人数</h4>
              <p>请核对入住人数是否小于订单中规定的最大人数</p>
              <br><h4>入住人员信息</h4>
              <p>请仔细核对住客信息确保和订单中一致</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    document.getElementById("operateCheckIn").className += "layui-this";

    function faceCheck() {
        layui.use('layer', function () {
            var layer = layui.layer;

            layer.open({
                type: 2,
                area: ['500px', '300px'],
                fixed: false,
                maxmin: true,
                scrollbar: false,
                content: 'face_check.jsp'
            });
        })
    }

    function completeCheckIn() {
      var targetForm = document.getElementById("diffActionForm");
      targetForm.action = "insertCustomer.action?step=4";
      targetForm.submit();
    }

    function continueAdd() {
      var targetForm = document.getElementById("diffActionForm");
      targetForm.action = "insertCustomer.action?step=3";
      targetForm.submit();
    }

    layui.use(['form', 'step','tableSelect', 'laydate', 'layer', 'layuimini'], function () {
        var $ = layui.$,
            form = layui.form,
            laydate = layui.laydate;

        laydate.render({
            elem: '#date'
        });

    })
</script>
</body>
</html>
