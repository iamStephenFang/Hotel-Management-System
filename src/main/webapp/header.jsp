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
      <a href="javascript:;" style="margin-right: 20px">admin<span class="layui-nav-more"></span></a>
      <dl class="layui-nav-child">
        <dd>
          <a href="javascript:;" data-iframe-tab="page/user-setting.html" data-title="基本资料" data-icon="fa fa-gears">基本资料</a>
        </dd>
        <dd>
          <a href="javascript:;" data-iframe-tab="page/user-password.html" data-title="修改密码" data-icon="fa fa-gears">修改密码</a>
        </dd>
        <dd>
          <a href="javascript:;" class="login-out">退出登录</a>
        </dd>
      </dl>
    </li>
  </ul>
</div>
