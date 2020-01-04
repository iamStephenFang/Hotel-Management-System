<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
        <s:if test="#session.choice == 2">
          <fieldset class="layui-elem-field layuimini-search">
            <legend>添加信息</legend>
            <div style="margin: 10px 10px 10px 10px">
              <form class="layui-form layui-form-pane" action="addMessage.action" method="post">
                <div class="layui-form-item">
                  <div class="layui-inline">
                    <label class="layui-form-label">消息标题</label>
                    <div class="layui-input-inline">
                      <input type="text" name="message.title" lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  <div class="layui-inline">
                    <label class="layui-form-label">消息内容</label>
                    <div class="layui-input-inline">
                      <input type="text" name="message.content" lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  <div class="layui-inline">
                    <input type="submit" class="layui-btn" value="发布">
                  </div>
                </div>
              </form>
            </div>
          </fieldset>
        </s:if>

        <fieldset class="layui-elem-field layuimini-search">
          <legend>搜索信息</legend>
          <div style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="findMessages.action" method="post">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">起始时间</label>
                  <div class="layui-input-inline">
                    <input type="text" name="beginTime" id="beginTime" lay-verify="date|required" placeholder="yyyy-MM-dd"
                           autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">结束时间</label>
                  <div class="layui-input-inline">
                    <input type="text" name="endTime" id="endTime" lay-verify="date|required" placeholder="yyyy-MM-dd"
                           autocomplete="off" class="layui-input">
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

      <div style="padding:10px 200px 10px 10px">
        <table class="layui-table" lay-data="{page:true,limit:10}" lay-filter="currentTableFilter">
          <thead>
          <tr>
            <th lay-data="{field:'no',width:80,sort:true}">序号</th>
            <th lay-data="{field:'title',width:200}">消息标题</th>
            <th lay-data="{field:'content',width:500}">消息内容</th>
            <th lay-data="{field:'sendTime',width:120,sort: true}">发布日期</th>
            <th lay-data="{field:'operate'}">操作</th>
          </tr>
          </thead>
          <tbody>
          <s:iterator value="#request.messages" var="mes">
            <tr>
              <td><s:property value="no"/></td>
              <td><s:property value="title"/></td>
              <td><s:property value="content"/></td>
              <td><s:property value="sendTime"/></td>
              <td>
                <a class="layui-btn layui-btn-xs data-count-edit" style="margin-top: 3px"
                   onclick="messageDetail(<s:property value='no'/>);">查看详情</a>
                <s:if test="#session.choice == 2">
                  <form id="<s:property value='no'/>" action="deleteMessage.action" method="post" class="layui-inline">
                    <s:hidden name="message.no" value="%{#mes.no}"/>
                    <a class="layui-btn layui-btn-danger layui-btn-xs" style="margin-top: 3px"
                       onclick="messageDelete(<s:property value='no'/>);">删除</a>
                  </form>
                </s:if>
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
      document.getElementById("findMessage").className += "layui-this";

      function messageDetail(no) {
          layui.use('layer',function () {
              var layer = layui.layer;
              // ,index = parent.layer.getFrameIndex(window.name);

              layer.open({
                  type: 2,
                  area: ['500px','320px'],
                  fixed: false,
                  maxmin: true,
                  scrollbar: false,
                  content: 'findMessageById.action?message.no=' + no.toString()
              });
          })
      }

      function messageDelete(no) {
          layui.use('layer', function () {
              var layer = layui.layer;

              layer.open({
                  type: 0,
                  fixed: false,
                  maxmin: true,
                  scrollbar: false,
                  content: '确认删除该消息记录？',
                  btn: ['确认', '取消'],
                  yes: function(index, layero){
                      var form = document.getElementById(no);
                      form.submit();
                  },
                  btn2: function(index, layero){
                  }
              });
          })
      }

      layui.use(['form', 'table', 'layer', 'layuimini', 'element','laydate'], function () {
          var $ = layui.jquery,
              form = layui.form,
              table = layui.table,
              element = layui.element,
              beginDate = layui.laydate,
              endDate = layui.laydate;

              beginDate.render({
                  elem: '#beginTime'
              });

              endDate.render({
                  elem: '#endTime'
              });
      });
  </script>

</body>
</html>
