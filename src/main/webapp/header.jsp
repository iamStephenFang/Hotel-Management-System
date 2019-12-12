<div class="layui-header header">
  <div class="layui-logo"><a href="">
    <img src="images/logo.png" alt="logo">
    <h1>LayuiMini</h1>
  </a></div>
  <a>
    <div class="layuimini-tool"><i title="展开" class="fa fa-outdent" data-side-fold="1"></i></div>
  </a>

  <ul class="layui-nav layui-layout-left layui-header-menu layui-header-pc-menu mobile layui-hide-xs">
    <li class="layui-nav-item layui-this" id="currencyHeaderId" data-menu="currency"><a href="javascript:;"><i
        class="fa fa-address-book"></i> 常规管理</a></li>
    <li class="layui-nav-item " id="componentHeaderId" data-menu="component"><a href="javascript:;"><i
        class="fa fa-lemon-o"></i> 组件管理</a></li>
    <li class="layui-nav-item " id="otherHeaderId" data-menu="other"><a href="javascript:;"><i
        class="fa fa-slideshare"></i> 其它管理</a></li>
    <span class="layui-nav-bar"></span></ul>
  <ul class="layui-nav layui-layout-left layui-header-menu mobile layui-hide-sm">
    <li class="layui-nav-item">
      <a href="javascript:;"><i class="fa fa-list-ul"></i> 选择模块<span class="layui-nav-more"></span></a>
      <dl class="layui-nav-child layui-header-mini-menu">
        <dd><a href="javascript:;" id="currencyHeaderId" data-menu="currency"><i class="fa fa-address-book"></i>
          常规管理</a></dd>
        <dd><a href="javascript:;" id="componentHeaderId" data-menu="component"><i class="fa fa-lemon-o"></i> 组件管理</a>
        </dd>
        <dd><a href="javascript:;" id="otherHeaderId" data-menu="other"><i class="fa fa-slideshare"></i> 其它管理</a></dd>
      </dl>
    </li>
    <span class="layui-nav-bar"></span></ul>

  <ul class="layui-nav layui-layout-right">
    <li class="layui-nav-item">
      <a href="javascript:;" data-refresh="刷新"><i class="fa fa-refresh"></i></a>
    </li>
    <li class="layui-nav-item">
      <a href="javascript:;" data-clear="清理" class="layuimini-clear" data-href="api/clear.json"><i
          class="fa fa-trash-o"></i></a>
    </li>
    <li class="layui-nav-item layuimini-setting">
      <a href="javascript:;">admin<span class="layui-nav-more"></span></a>
      <dl class="layui-nav-child">
        <dd>
          <a href="javascript:;" data-iframe-tab="page/user-setting.html" data-title="基本资料"
             data-icon="fa fa-gears">基本资料</a>
        </dd>
        <dd>
          <a href="javascript:;" data-iframe-tab="page/user-password.html" data-title="修改密码" data-icon="fa fa-gears">修改密码</a>
        </dd>
        <dd>
          <a href="javascript:;" class="login-out">退出登录</a>
        </dd>
      </dl>
    </li>
    <li class="layui-nav-item layuimini-select-bgcolor mobile layui-hide-xs">
      <a href="javascript:;" data-bgcolor="配色方案"><i class="fa fa-ellipsis-v"></i></a>
    </li>
    <span class="layui-nav-bar"></span></ul>
</div>