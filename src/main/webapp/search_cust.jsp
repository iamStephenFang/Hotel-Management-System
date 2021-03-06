<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>后台管理系统—入住查询</title>
  <%@include file="head.jsp" %>
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
  <%--顶部导航栏--%>
  <%@include file="header.jsp" %>
  <s:if test="#session.choice == 1">
    <!-- waiter 侧边导航栏 -->
    <%@include file="waiter_sidebar.jsp" %>
  </s:if>
  <s:else>
    <!-- admin 侧边导航栏 -->
    <%@include file="admin_sidebar.jsp" %>
  </s:else>
  <div class="layui-body">
    <div class="layuimini-container">
      <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">
          <legend>搜索信息</legend>
          <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="findCustomers.action" method="post">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">顾客姓名</label>
                  <div class="layui-input-inline" style="width: 150px">
                    <input type="text" name="checkCustomer.name" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">顾客手机号</label>
                  <div class="layui-input-inline" style="width: 150px">
                    <input type="text" name="checkCustomer.phone" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">订单ID</label>
                  <div class="layui-input-inline" style="width: 150px">
                    <input type="number" name="orderId" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">房间号码</label>
                  <div class="layui-input-inline" style="width: 150px">
                    <input type="text" name="checkCustomer.roomId" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <input type="submit" class="layui-btn" value="搜索"/>
                </div>
              </div>
            </form>
          </div>
        </fieldset>
      </div>

      <div style="padding:10px">
        <table class="layui-table" lay-data="{page:true,limit:10}" lay-filter="currentTableFilter">
          <thead>
          <tr>
            <th lay-data="{field:'id', width:100, sort:true}">订单ID</th>
            <th lay-data="{field:'username', width:100}">住客姓名</th>
            <th lay-data="{field:'gender',width:80}">性别</th>
            <th lay-data="{field:'roomId',width:110,sort:true}">房间号码</th>
            <th lay-data="{field:'phone',width:130}">电话号码</th>
            <th lay-data="{field:'customerId',width:170}">身份证号</th>
            <th lay-data="{field:'orderStatus',width:110,sort:true}">订单状态</th>
            <th lay-data="{field:'checkInTime',width:120,sort:true}">入住时间</th>
            <th lay-data="{field:'leaveTime',width:120,sort:true}">离开时间</th>
            <th lay-data="{field:'orderDetail',width:160}">订单备注</th>
            <th lay-data="{field:'operate'}">操作</th>
          </tr>
          </thead>
          <tbody>
          <s:iterator value="#request.checkCustomers">
            <tr>
              <td><s:property value="orderId"/></td>
              <td><s:property value="name"/></td>
              <s:if test="%{gender==true}">
                <td>男</td>
              </s:if>
              <s:else>
                <td>女</td>
              </s:else>
              <td><s:property value="roomId"/></td>
              <td><s:property value="phone"/></td>
              <td><s:property value="customerId"/></td>
              <s:if test="%{orderStatus==true}">
                <td>
                  <span class="layui-badge layui-bg-blue" style="margin-top: 5px">已完成</span>
                </td>
              </s:if>
              <s:else>
                <td>
                  <span class="layui-badge layui-bg-orange" style="margin-top: 5px">未完成</span>
                </td>
              </s:else>
              <td><s:property value="checkInTime"/></td>
              <td><s:property value="leaveTime"/></td>
              <td><s:property value="orderDetail"/></td>
              <td>
                <a class="layui-btn layui-btn-xs data-count-edit" style="margin-top: 3px"
                   onclick="layuiLayer(<s:property value='orderId'/>,'<s:property value='customerId'/>');">编辑</a>
              </td>
            </tr>
          </s:iterator>
<%--          <a id="edit" class="layui-btn layui-btn-xs data-count-edit">编辑</a>--%>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<script src="lib/layui-v2.5.4/layui.js?v=1.0.4" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    document.getElementById("findCheckCustomer").className += "layui-this";

    function layuiLayer(orderId,customerId) {

      console.log(customerId);

      layui.use('layer',function () {
        var layer = layui.layer;
        // ,index = parent.layer.getFrameIndex(window.name);

        layer.open({
          type: 2,
          area: ['500px','640px'],
          fixed: false,
          maxmin: true,
          scrollbar: false,
          content: 'findCustomerByIds.action?orderId=' + orderId + "&customerId=" + customerId,
          cancel: function(index,layero) {
            if (confirm("是否刷新数据？")){
              window.location.href="http://localhost:8080/hotel_management_war_exploded/listAllCustomers.action";
            }
            return true;
          }
        });
      })
    }

    layui.use(['form', 'table', 'element', 'layer', 'layuimini','element'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table,
            element = layui.element;
            // layer = layui.layer;
            // index = parent.layer.getFrameIndex(window.name); //获取窗口索引

        // $('#edit').on('click', function () {
        //     layer.open({
        //         type: 2,
        //         area: ['700px', '600px'],
        //         fixed: false, //不固定
        //         maxmin: true,
        //         content: 'cust_edit.jsp'
        //     });
        //     parent.layer.iframeAuto(index);
        // });
        // //在父层弹出一个层
        // $('#new').on('click', function () {
        //     parent.layer.msg('该项目无法改变', {shade: 0.3})
        // });
        // //关闭iframe
        // $('#closeIframe').click(function () {
        //     var val = $('#name').val();
        //     if(val === ''){
        //         parent.layer.msg('请填写标记');
        //         return;
        //     }
        //     parent.layer.msg('信息成功修改');
        //     parent.layer.close(index);
        // });
        // // 监听搜索操作
        // form.on('submit(data-search-btn)', function (data) {
        //     var result = JSON.stringify(data.field);
        //     layer.alert(result, {
        //         title: '最终的搜索信息'
        //     });
        //
        //     //执行搜索重载
        //     table.reload('currentTableId', {
        //         page: {
        //             curr: 1
        //         }
        //         , where: {
        //             searchParams: result
        //         }
        //     }, 'data');
        //
        //     return false;
        // });
        //
        // // 监听添加操作
        // $(".data-add-btn").on("click", function () {
        //     layer.msg('添加数据');
        // });
        //
        // // 监听删除操作
        // $(".data-delete-btn").on("click", function () {
        //     var checkStatus = table.checkStatus('currentTableId')
        //         , data = checkStatus.data;
        //     layer.alert(JSON.stringify(data));
        // });
        //
        // //监听表格复选框选择
        // table.on('checkbox(currentTableFilter)', function (obj) {
        //     console.log(obj)
        // });
        //
        // table.on('tool(currentTableFilter)', function (obj) {
        //     var data = obj.data;
        //     if (obj.event === 'edit') {
        //         layer.alert('编辑行：<br>' + JSON.stringify(data))
        //     } else if (obj.event === 'delete') {
        //         layer.confirm('真的删除行么', function (index) {
        //             obj.del();
        //             layer.close(index);
        //         });
        //     }
        // });
    });
</script>

</body>
</html>
