<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <%@include file="sidebar.jsp" %>
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
      <!--        <div class="layui-btn-group">-->
      <!--            <button class="layui-btn data-add-btn">添加</button>-->
      <!--            <button class="layui-btn layui-btn-danger data-delete-btn">删除</button>-->
      <!--        </div>-->
      <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
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

          table.render({
              elem: '#currentTableId',
              url: '../api/table.json',
              cols: [[
                  {type: "checkbox", width: 50, fixed: "left"},
                  {field: 'id', width: 100, title: '订单ID', sort: true},
                  {field: 'username', width: 100, title: '用户名'},
                  {field: 'sex', width: 80, title: '性别'},
                  {field: 'roomtype', width: 100, title: '房间类型'},
                  {field: 'email', width: 135, title: '邮箱地址'},
                  {field: 'phone', width: 135, title: '电话号码'},
                  {field: 'orderstatus', width: 100, title: '订单状态'},
                  {field: 'checkintime', width: 135, title: '到店时间'},
                  {field: 'leavetime', width: 135, title: '离店时间'},
                  {field: 'comment', title: '备注', minWidth: 150},
                  {title: '操作', minWidth: 50, templet: '#currentTableBar', fixed: "right", align: "center"}
              ]],
              limits: [10, 15, 20, 25, 50, 100],
              limit: 15,
              page: true
          });

          // 监听搜索操作
          form.on('submit(data-search-btn)', function (data) {
              var result = JSON.stringify(data.field);
              layer.alert(result, {
                  title: '最终的搜索信息'
              });

              //执行搜索重载
              table.reload('currentTableId', {
                  page: {
                      curr: 1
                  }
                  , where: {
                      searchParams: result
                  }
              }, 'data');

              return false;
          });

          // 监听添加操作
          $(".data-add-btn").on("click", function () {
              layer.msg('添加数据');
          });

          // 监听删除操作
          $(".data-delete-btn").on("click", function () {
              var checkStatus = table.checkStatus('currentTableId')
                  , data = checkStatus.data;
              layer.alert(JSON.stringify(data));
          });

          //监听表格复选框选择
          table.on('checkbox(currentTableFilter)', function (obj) {
              console.log(obj)
          });

          table.on('tool(currentTableFilter)', function (obj) {
              var data = obj.data;
              if (obj.event === 'edit') {
                  layer.alert('编辑行：<br>' + JSON.stringify(data))
              } else if (obj.event === 'delete') {
                  layer.confirm('真的删除行么', function (index) {
                      obj.del();
                      layer.close(index);
                  });
              }
          });

      });
  </script>

</body>
</html>
