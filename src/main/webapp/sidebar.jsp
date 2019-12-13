<%@ page contentType="text/html;charset=UTF-8" %>
<!-- 侧边导航栏 -->
<div class="layui-side layui-bg-black">
  <div class="layui-side-scroll layui-left-menu">
    <ul class="layui-nav layui-nav-tree layui-left-nav-tree layui-this" id="currency">

      <li class="layui-nav-item">
        <a href="/index.jsp" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-3" data-tab="/menu.html"
           target="_self"><i class="fa fa-home"></i><span class="layui-left-nav"> 后台首页</span></a>
      </li>
      <li class="layui-nav-item">
        <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-4"
           data-tab="/setting.html" target="_self"><i class="fa fa-gears"></i><span class="layui-left-nav"> 账户设置</span></a>
      </li>

      <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-file-text"></i><span
            class="layui-left-nav"> 办理操作</span> <span class="layui-nav-more"></span></a>
        <dl class="layui-nav-child">
          <dd>
            <a href="/check-in.jsp" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-6"
               data-tab="/form.html" target="_self"><i class="fa fa-navicon"></i><span
                class="layui-left-nav"> 办理入住</span></a>
          </dd>
          <dd>
            <a href="/check-out.jsp" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-7"
               data-tab="/form-step.html" target="_self"><i class="fa fa-navicon"></i><span
                class="layui-left-nav"> 办理退房</span></a>
          </dd>
        </dl>
      </li>
      <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-search"></i><span
            class="layui-left-nav"> 查询操作</span> <span class="layui-nav-more"></span></a>
        <dl class="layui-nav-child">
          <dd>
            <a href="/search_order.jsp" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-8"
               data-tab="/login-1.html" target="_blank"><i class="fa fa-search-minus"></i><span class="layui-left-nav"> 查询订单</span></a>
          </dd>
          <dd>
            <a href="/search_cust.jsp" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-9"
               data-tab="/login-2.html" target="_blank"><i class="fa fa-search-plus"></i><span class="layui-left-nav"> 查询入住</span></a>
          </dd>
        </dl>
      </li>
      <span class="layui-nav-bar" style="top: 0px; height: 0px; opacity: 0;"></span></ul>
  </div>
</div>

