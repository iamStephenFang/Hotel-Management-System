<%@ page contentType="text/html;charset=UTF-8" %>
<div class="layui-header header">
  <div class="layui-logo">
    <a href="">
      <img src="images/backend_alt.png" alt="logo">
      <h1>酒店后台管理</h1>
    </a>
  </div>
  <a>
    <div class="layuimini-tool"><i title="展开" class="fa fa-outdent" data-side-fold="1"></i></div>
  </a>

  <ul class="layui-nav layui-layout-right">
    <li class="layui-nav-item layuimini-setting">
      <a href="javascript:;" style="margin-right: 20px">
        <s:property value="#session.user.account"/>
        <span class="layui-nav-more"></span></a>
      <dl class="layui-nav-child">
<%--        <dd>--%>
<%--          <a href="javascript:;" data-title="基本资料" data-icon="fa fa-gears">基本资料</a>--%>
<%--        </dd>--%>
        <dd>
          <a href="info_edit.jsp" data-title="修改密码" data-icon="fa fa-gears">账号设置</a>
        </dd>
        <dd>
          <a href="authGenerate.action" class="login-out">退出登录</a>
        </dd>
      </dl>
    </li>
  </ul>
</div>
