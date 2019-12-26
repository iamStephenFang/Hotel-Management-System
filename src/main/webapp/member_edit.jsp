<%@ page import="cn.edu.zjut.po.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>会员信息修改</title>
  <%@include file="head.jsp" %>
</head>
<body>
<div class="layuimini-container">
  <div class="layuimini-main">
    <form class="layui-form layuimini-form" action="updateMember.action" method="post" style="margin-left:-30px;padding-right:50px" >
      <div class="layui-form-item">
        <label class="layui-form-label">会员等级:</label>
        <div class="layui-input-block">
          <input type="text" name="member.level" value="<s:property value='#request.members.level'/>"
                 lay-verify="required"  autocomplete="off" class="layui-input" readonly>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">会员折扣:</label>
        <div class="layui-input-block">
          <input type="text" name="member.discount" value="<s:property value='#request.members.discount'/>"
                 lay-verify="required" placeholder="请输入入住上限" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">会员名称:</label>
        <div class="layui-input-block">
          <input type="text" name="member.memberDetail" value="<s:property value='#request.members.memberDetail'/>"
                 lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-input-block">
          <button class="layui-btn" lay-submit>确认修改</button>
        </div>
      </div>
    </form>
  </div>
</div>
<script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['form', 'laydate'], function () {
        var form = layui.form;

    });
</script>
</body>
</html>
