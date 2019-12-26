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
            <form class="layui-form layui-form-pane" action="insertRoom.action" method="post">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">房间号</label>
                  <div class="layui-input-inline" style="width: 150px">
                    <input type="number" name="room.roomId" autocomplete="off" class="layui-input" lay-verify="required">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">房间类型</label>
                  <div class="layui-input-inline" style="width: 150px">
                    <select name="room.roomType.type" lay-filter="room_type" lay-verify="required">
                      <option value="" selected></option>
                      <option value="双床房">双床房</option>
                      <option value="大床房">大床房</option>
                      <option value="家庭房">家庭房</option>
                      <option value="总统套房">总统套房</option>
                    </select>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">房间详情</label>
                  <div class="layui-input-inline" style="width: 150px">
                    <input type="text" name="room.roomDetail" autocomplete="off" class="layui-input" lay-verify="required">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">房间状态</label>
                  <div class="layui-input-inline" style="width: 150px">
                    <s:hidden name="room.roomStatus" value="0"/>
                    <input type="text" value="房间空余" class="layui-input" style="color: #9dadce" readonly>
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
            <form class="layui-form layui-form-pane" action="findRooms.action" method="post">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">房间号</label>
                  <div class="layui-input-inline">
                    <input type="text" name="room.roomId" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">房间类型</label>
                  <div class="layui-input-inline">
                    <input type="text" name="room.roomType.type" autocomplete="off" class="layui-input">
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

      <div style="padding:10px 600px 10px 10px">
        <table class="layui-table" lay-data="{page:true,limit:10}" lay-filter="currentTableFilter">
          <thead>
          <tr>
            <th lay-data="{field:'roomId',width:100,sort:true}">房间号</th>
            <th lay-data="{field:'roomType',width:150,sort:true}">房间类型</th>
            <th lay-data="{field:'roomDetail',width:200}">房间详情</th>
            <th lay-data="{field:'roomStatus',width:120,sort:true}">房间状态</th>
            <th lay-data="{field:'operate'}">操作</th>
          </tr>
          </thead>
          <tbody>
          <s:iterator value="#request.rooms" var="rm">
            <tr>
              <td><s:property value="roomId"/></td>
              <td><s:property value="roomType.type"/></td>
              <td><s:property value="roomDetail"/></td>
              <s:if test="%{roomStatus==false}">
                <td>
                  <span class="layui-badge layui-bg-blue" style="margin-top: 5px">已入住</span>
                </td>
              </s:if>
              <s:else>
                <td>
                  <span class="layui-badge layui-bg-orange" style="margin-top: 5px">未入住</span>
                </td>
              </s:else>
              <td>
                <a class="layui-btn layui-btn-xs data-count-edit"
                   onclick="updateLayer(<s:property value='roomId'/>);">修改</a>
                <form id="<s:property value='roomId'/>" action="deleteRoom.action" method="post" class="layui-inline">
                  <s:hidden name="room.roomId" value="%{#rm.roomId}"/>
                  <a class="layui-btn layui-btn-danger layui-btn-xs data-count-edit"
                     onclick="deleteLayer(<s:property value='roomId'/>);">删除</a>
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
      document.getElementById("findRoom").className += "layui-this";

      function updateLayer(roomId) {
          layui.use('layer', function () {
              var layer = layui.layer;

              layer.open({
                  type: 2,
                  area: ['500px', '350px'],
                  fixed: false,
                  maxmin: true,
                  scrollbar: false,
                  content: 'UpdateByRoomId.action?room.roomId=' + roomId.toString(),
                  cancel: function (index, layero) {
                      if (confirm("是否刷新数据？")) {
                          window.location.href = "http://localhost:8080/hotel_management_war_exploded/findAllRooms.action";
                      }
                      return true;
                  }
              });
          })
      }

      function deleteLayer(roomId) {
          layui.use('layer', function () {
              var layer = layui.layer;

              layer.open({
                  type: 0,
                  fixed: false,
                  maxmin: true,
                  scrollbar: false,
                  content: '确认删除该房间信息？',
                  btn: ['确认', '取消'],
                  yes: function (index, layero) {
                      var form = document.getElementById(roomId);
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
