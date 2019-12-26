<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>后台管理系统-用户查询</title>
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
          <legend>搜索信息</legend>
          <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="findRegisters.action" method="post">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">手机号</label>
                  <div class="layui-input-inline">
                    <input type="text" name="register.phone" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">账号名</label>
                  <div class="layui-input-inline">
                    <input type="text" name="register.account" autocomplete="off" class="layui-input">
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

      <div style="padding:10px 180px 10px 10px">
        <table class="layui-table" lay-data="{page:true,limit:10}" lay-filter="currentTableFilter">
          <thead>
          <tr>
            <th lay-data="{field:'phone',width:150,sort:true}">手机号</th>
            <th lay-data="{field:'account',width:150}">账号名</th>
            <th lay-data="{field:'password',width:150}">密码</th>
            <th lay-data="{field:'gender',width:100}">性别</th>
            <th lay-data="{field:'email',width:200}">邮箱</th>
            <th lay-data="{field:'level',width:150,sort:true}">会员等级</th>
            <th lay-data="{field:'score',width:100}">积分</th>
            <th lay-data="{field:'operate'}">操作</th>
          </tr>
          </thead>
          <tbody>
          <s:iterator value="#request.registers" var="rg">
          <tr>
            <td><s:property value="phone"/></td>
            <td><s:property value="account"/></td>
            <td><s:property value="password"/></td>
            <s:if test="%{gender==true}">
              <td>男</td>
            </s:if>
            <s:else>
              <td>女</td>
            </s:else>
            <td><s:property value="email"/></td>
            <s:if test="%{level==1}">
              <td>普通会员</td>
            </s:if>
            <s:elseif test="%{level==2}">
              <td>银卡会员</td>
            </s:elseif>
            <s:elseif test="%{level==3}">
              <td>金卡会员</td>
            </s:elseif>
            <s:elseif test="%{level==4}">
            <td>铂金会员</td>
          </s:elseif>
            <s:else>
              <td>未知会员</td>
            </s:else>
            <td><s:property value="score"/></td>
            <td>
              <a class="layui-btn layui-btn-xs data-count-edit"
                 onclick="updateLayer(<s:property value='phone'/>);">修改</a>
              <form id="<s:property value='phone'/>" action="deleteRegister.action" method="post" class="layui-inline">
                <s:hidden name="register.phone" value="%{#rg.phone}"/>
                <a class="layui-btn layui-btn-danger layui-btn-xs data-count-edit"
                   onclick="deleteLayer(<s:property value='phone'/>);">删除</a>
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
      document.getElementById("findRegister").className += "layui-this";

      function updateLayer(phone) {
          layui.use('layer', function () {
              var layer = layui.layer;

              layer.open({
                  type: 2,
                  area: ['500px', '520px'],
                  fixed: false,
                  maxmin: true,
                  scrollbar: false,
                  content: 'UpdateByPhone.action?register.phone=' + phone.toString(),
                  cancel: function (index, layero) {
                      if (confirm("是否刷新数据？")) {
                          window.location.href = "http://localhost:8080/hotel_management_war_exploded/findAllRegisters.action";
                      }
                      return true;
                  }
              });
          })
      }

      function deleteLayer(phone) {
          layui.use('layer', function () {
              var layer = layui.layer;

              layer.open({
                  type: 0,
                  fixed: false,
                  maxmin: true,
                  scrollbar: false,
                  content: '确认删除该用户信息？',
                  btn: ['确认', '取消'],
                  yes: function(index, layero){
                      var form = document.getElementById('deleteUser');
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
