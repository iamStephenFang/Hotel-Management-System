<%@ page contentType="text/html;charset=UTF-8" %>
<!-- 侧边导航栏 -->
<div class="layui-side layui-bg-black">
  <div class="layui-side-scroll layui-left-menu">
    <ul class="layui-nav layui-nav-tree layui-left-nav-tree">

      <li class="layui-nav-item">
        <a href="enterIndex.action" class="layui-menu-tips">
          <i class="fa fa-home"></i>
          <span class="layui-left-nav"> 后台首页</span>
        </a>
      </li>

      <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;" class="layui-menu-tips">
          <i class="fa fa-file-text"></i>
          <span class="layui-left-nav"> 办理操作</span>
          <span class="layui-nav-more"></span>
        </a>
        <dl class="layui-nav-child">
          <dd id="operateCheckIn">
            <a href="check_in.jsp" class="layui-menu-tips">
              <i class="fa fa-navicon"></i>
              <span class="layui-left-nav"> 办理入住</span></a>
          </dd>
          <dd id="operateCheckOut">
            <a href="check_out.jsp" class="layui-menu-tips">
              <i class="fa fa-navicon"></i>
              <span class="layui-left-nav"> 办理退房</span>
            </a>
          </dd>
        </dl>
      </li>

      <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;" class="layui-menu-tips">
          <i class="fa fa-search"></i>
          <span class="layui-left-nav"> 查询操作</span>
          <span class="layui-nav-more"></span>
        </a>
        <dl class="layui-nav-child">
          <dd id="findOrder">
            <a href="listAllOrders.action" class="layui-menu-tips">
              <i class="fa fa-search-minus"></i>
              <span class="layui-left-nav"> 查询订单</span>
            </a>
          </dd>
          <dd id="findCheckCustomer">
            <a href="listAllCustomers.action" class="layui-menu-tips">
              <i class="fa fa-search-plus"></i>
              <span class="layui-left-nav"> 查询入住</span>
            </a>
          </dd>
        </dl>
      </li>

      <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;" class="layui-menu-tips">
          <i class="fa fa-gears"></i>
          <span class="layui-left-nav"> 公告操作</span>
        </a>
        <dl class="layui-nav-child">
          <dd id="findMessage">
            <a href="findAllMessage.action" class="layui-menu-tips">
              <i class="fa fa-search-minus"></i>
              <span class="layui-left-nav"> 查询公告</span>
            </a>
          </dd>
        </dl>
      </li>

      <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;" class="layui-menu-tips">
          <i class="fa fa-gears"></i>
          <span class="layui-left-nav"> 账户设置</span>
        </a>
        <dl class="layui-nav-child">
          <dd id="updatePassword">
            <a href="info_edit.jsp" class="layui-menu-tips">
              <i class="fa fa-search-minus"></i>
              <span class="layui-left-nav"> 修改密码</span>
            </a>
          </dd>
        </dl>
      </li>
    </ul>
  </div>
</div>

