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
          <legend>添加房型</legend>
          <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="insertRoomType.action" method="post">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">房间类型</label>
                  <div class="layui-input-inline">
                    <input type="text" name="roomType.type" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">入住上限</label>
                  <div class="layui-input-inline">
                    <input type="number" name="roomType.checkInNum" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">房间价格</label>
                  <div class="layui-input-inline">
                    <input type="number" name="roomType.roomPrice" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <input type="submit" class="layui-btn" value="添加">
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
          <s:iterator value="#request.roomTypes" var="id">
            <tr>
              <td><s:property value="type"/></td>
              <td><s:property value="checkInNum"/></td>
              <td><s:property value="roomPrice"/></td>
              <td>
                <a class="layui-btn layui-btn-xs data-count-edit"
                   onclick="updateLayer('<s:property value='type'/>');">修改</a>
                <form id="<s:property value='type'/>" action="deleteRoomType.action" method="post" class="layui-inline">
                  <s:hidden name="roomType.type" value="%{#id.type}"/>
                  <a class="layui-btn layui-btn-danger layui-btn-xs data-count-edit"
                     onclick="deleteLayer('<s:property value='type'/>');">删除</a>
                </form>
              </td>
            </tr>
          </s:iterator>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
  <script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
  <script>
      document.getElementById("findRoomType").className += "layui-this";

      function updateLayer(type) {
          layui.use('layer', function () {
              var layer = layui.layer;

              layer.open({
                  type: 2,
                  area: ['500px', '300px'],
                  fixed: false,
                  maxmin: true,
                  scrollbar: false,
                  content: 'findByType.action?roomType.type='+ type.toString(),
                  cancel: function (index, layero) {
                      if (confirm("是否刷新数据？")) {
                          window.location.href = "http://localhost:8080/hotel_management_war_exploded/findAllRoomTypes.action";
                      }
                      return true;
                  }
              });
          })
      }

      function deleteLayer(type) {
          layui.use('layer', function () {
              var layer = layui.layer;

              layer.open({
                  type: 0,
                  fixed: false,
                  maxmin: true,
                  scrollbar: false,
                  content: '已存在记录的房型无法删除！确认删除该房型信息？',
                  btn: ['确认', '取消'],
                  yes: function (index, layero) {
                      var form = document.getElementById(type);
                      form.submit();
                  },
                  btn2: function (index, layero) {
                  }
              });
          })
      }

      layui.use(['form', 'table', 'element', 'layer', 'layuimini', 'element'], function () {
          var $ = layui.jquery,
              form = layui.form,
              table = layui.table,
              element = layui.element;
      });
  </script>
</body>
</html>
