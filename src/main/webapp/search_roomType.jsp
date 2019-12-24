<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>后台管理系统-房间查询</title>
  <%@include file="head.jsp" %>
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
  <%--顶部导航栏--%>
  <%@include file="header.jsp" %>
  <%--侧边导航栏--%>
  <%@include file="admin_sidebar.jsp" %>
  <div class="layui-body">
    <div class="layuimini-container">
      <div class="layuimini-main">
        <fieldset class="layui-elem-field layuimini-search">
          <legend>添加信息</legend>
          <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="" method="post">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">房间类型</label>
                  <div class="layui-input-inline">
                    <input type="text" name="" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">入住上限</label>
                  <div class="layui-input-inline">
                    <input type="number" name="" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">房间价格</label>
                  <div class="layui-input-inline">
                    <input type="number" name="" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <input type="submit" class="layui-btn" value="添加">
                </div>
              </div>
            </form>
          </div>
        </fieldset>

        <fieldset class="layui-elem-field layuimini-search">
          <legend>搜索信息</legend>
          <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="" method="post">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">房间类型</label>
                  <div class="layui-input-inline">
                    <input type="text" name="" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <input type="submit" class="layui-btn" value="搜索">
                </div>
              </div>
            </form>
          </div>
        </fieldset>
      </div>

      <div style="padding:10px 800px 10px 10px">
        <table class="layui-table" lay-data="{page:true,limit:10}" lay-filter="currentTableFilter">
          <thead>
          <tr>
            <th lay-data="{field:'roomType',width:150,sort:true}">房间类型</th>
            <th lay-data="{field:'roomDetail',width:120,sort:true}">入住上限</th>
            <th lay-data="{field:'roomStatus',width:120,sort:true}">房间价格</th>
            <th lay-data="{field:'operate'}">操作</th>
          </tr>
          </thead>
          <tbody>
          <%--          <s:iterator value="#request.roomTypes">--%>
          <tr>
            <td><s:property value="'双床房'"/></td>
            <td><s:property value="'4'"/></td>
            <td><s:property value="'999'"/></td>
            <td>
              <a class="layui-btn layui-btn-xs data-count-edit"
                 onclick="updateLayer(<s:property value='201'/>);">修改</a>
              <form id="deleteRoomType" action="" method="post" class="layui-inline">
                <a class="layui-btn layui-btn-danger layui-btn-xs data-count-edit"
                   onclick="deleteLayer();">删除</a>
              </form>
            </td>
          </tr>
          <%--          </s:iterator>--%>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
  <script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
  <script>
      document.getElementById("findRoomType").className += "layui-this";

      function updateLayer(roomId) {
          layui.use('layer', function () {
              var layer = layui.layer;

              layer.open({
                  type: 2,
                  area: ['500px', '300px'],
                  fixed: false,
                  maxmin: true,
                  scrollbar: false,
                  content: 'roomType_edit.jsp',
                  cancel: function (index, layero) {
                      if (confirm("是否刷新数据？")) {
                          window.location.href = "";
                      }
                      return true;
                  }
              });
          })
      }

      function deleteLayer() {
          layui.use('layer', function () {
              var layer = layui.layer;

              layer.open({
                  type: 0,
                  fixed: false,
                  maxmin: true,
                  scrollbar: false,
                  content: '确认删除该房型信息？',
                  btn: ['确认', '取消'],
                  yes: function(index, layero){
                      var form = document.getElementById('deleteRoomType');
                      form.submit();
                  },
                  btn2: function(index, layero){
                  }
              });
          })
      }

      layui.use(['form', 'table', 'element', 'layer', 'layuimini','element'], function () {
          var $ = layui.jquery,
              form = layui.form,
              table = layui.table,
              element = layui.element;
      });
  </script>
</body>
</html>
