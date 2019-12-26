<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>后台管理系统-维护会员</title>
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
          <legend>添加会员</legend>
          <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="insertMember.action" method="post">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">会员等级</label>
                  <div class="layui-input-inline">
                    <input type="number" name="member.level" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">会员折扣</label>
                  <div class="layui-input-inline">
                    <input type="text" name="member.discount" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">会员名称</label>
                  <div class="layui-input-inline">
                    <input type="text" name="member.memberDetail" autocomplete="off" class="layui-input">
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
            <th lay-data="{field:'roomType',width:150,sort:true}">会员等级</th>
            <th lay-data="{field:'roomDetail',width:120,sort:true}">会员折扣</th>
            <th lay-data="{field:'roomStatus',width:120,sort:true}">会员名称</th>
            <th lay-data="{field:'operate'}">操作</th>
          </tr>
          </thead>
          <tbody>
          <s:iterator value="#request.members" var="me">
            <tr>
              <td><s:property value="level"/></td>
              <td><s:property value="discount"/></td>
              <td><s:property value="memberDetail"/></td>
              <td>
                <a class="layui-btn layui-btn-xs data-count-edit"
                   onclick="updateLayer(<s:property value='level'/>);">修改</a>
<%--                <form id="<s:property value='level'/>" action="deleteMember.action" method="post" class="layui-inline">--%>
<%--                  <s:hidden name="member.level" value="%{#me.level}"/>--%>
<%--                  <a class="layui-btn layui-btn-danger layui-btn-xs data-count-edit"--%>
<%--                     onclick="deleteLayer();">删除</a>--%>
<%--                </form>--%>
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
      document.getElementById("findMember").className += "layui-this";

      function updateLayer(level) {
          layui.use('layer', function () {
              var layer = layui.layer;

              layer.open({
                  type: 2,
                  area: ['500px', '300px'],
                  fixed: false,
                  maxmin: true,
                  scrollbar: false,
                  content: 'UpdateByLevel.action?member.level=' +level.toString(),
                  cancel: function (index, layero) {
                      if (confirm("是否刷新数据？")) {
                          window.location.href = "http://localhost:8080/hotel_management_war_exploded/findAllMembers.action";
                      }
                      return true;
                  }
              });
          })
      }

      // function deleteLayer(level) {
      //     layui.use('layer', function () {
      //         var layer = layui.layer;
      //
      //         layer.open({
      //             type: 0,
      //             fixed: false,
      //             maxmin: true,
      //             scrollbar: false,
      //             content: '已存在记录的会员无法删除！确认删除该会员信息？',
      //             btn: ['确认', '取消'],
      //             yes: function (index, layero) {
      //                 var form = document.getElementById(level);
      //                 form.submit();
      //             },
      //             btn2: function (index, layero) {
      //             }
      //         });
      //     })
      // }

      layui.use(['form', 'table', 'element', 'layer', 'layuimini', 'element'], function () {
          var $ = layui.jquery,
              form = layui.form,
              table = layui.table,
              element = layui.element;
      });
  </script>
</body>
</html>
