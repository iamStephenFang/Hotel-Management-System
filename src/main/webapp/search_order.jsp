<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>后台管理系统—订单查询</title>
  <%@include file="head.jsp" %>
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
  <%--顶部导航栏--%>
  <%@include file="header.jsp" %>
  <!-- 侧边导航栏 -->
  <%@include file="waiter_sidebar.jsp" %>
  <div class="layui-body">
    <div class="layuimini-container">
      <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">
          <legend>搜索信息</legend>
          <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">用户账户名</label>
                  <div class="layui-input-inline">
                    <input type="text" name="username" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">用户手机号</label>
                  <div class="layui-input-inline">
                    <input type="text" name="sex" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">订单ID</label>
                  <div class="layui-input-inline">
                    <input type="text" name="city" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <a class="layui-btn" lay-submit="" lay-filter="data-search-btn">搜索</a>
                </div>
              </div>
            </form>
          </div>
        </fieldset>
      </div>

      <table id="currentTableId" lay-filter="currentTableFilter">
        <thead>
          <tr>
            <th lay-data="{field:'orderId',width:100，sort:true}">订单ID</th>
            <th lay-data="{field:'account',width:100}">用户名</th>
            <th lay-data="{field:'gender',width:80}">性别</th>
            <th lay-data="{field:'roomType',width:100}">房间类型</th>
            <th lay-data="{field:'email',width:135}">邮箱地址</th>
            <th lay-data="{field:'phone',width:135}">电话号码</th>
            <th lay-data="{field:'orderStatus',width:100}">订单状态</th>
            <th lay-data="{field:'checkInTime',width:135}">到店时间</th>
            <th lay-data="{field:'leaveTime',width:135}">离开时间</th>
            <th lay-data="{field:'orderStatus',width:50}">订单备注</th>
            <th lay-data="{field:'operate',width:50}">操作</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator id="order" value="#request.orders">
            <tr>
              <td><s:property value="orderId"/></td>
              <td><s:property value="account"/> </td>
              <td><s:property value="gender"/> </td>
              <td><s:property value="roomType"/> </td>
              <td><s:property value="email"/> </td>
              <td><s:property value="phone"/> </td>
              <td><s:property value="orderStatus"/> </td>
              <td><s:property value="checkInTime"/> </td>
              <td><s:property value="leaveTime"/> </td>
              <td><s:property value="orderDetail"/> </td>
              <td>
                <form action="" method="post">
                  <button class="layui-btn data-add-btn">添加</button>
                  <button class="layui-btn layui-btn-danger data-delete-btn">删除</button>
                </form>
              </td>
            </tr>
          </s:iterator>
        </tbody>
      </table>
      <script type="text/html" id="currentTableBar">
        <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
      </script>
    </div>
  </div>
  <script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
  <script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
  <script>
      layui.use(['form', 'table', 'layer', 'layuimini'], function () {
          var $ = layui.jquery,
              form = layui.form,
              table = layui.table;

          table.init('currentTableFilter',{
              limit: 15,
              page: true
          });

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
