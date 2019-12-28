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
          <span class="layui-left-nav"> 管理操作</span>
        </a>
        <dl class="layui-nav-child">
          <dd id="findWaiter">
            <a href="findAllWaiters.action" class="layui-menu-tips">
              <i class="fa fa-navicon"></i>
              <span class="layui-left-nav"> 管理服务员</span>
            </a>
          </dd>
          <dd id="findRegister">
            <a href="findAllRegisters.action" class="layui-menu-tips">
              <i class="fa fa-navicon"></i>
              <span class="layui-left-nav"> 管理用户</span>
            </a>
          </dd>
          <dd id="findCheckCustomer">
            <a href="listAllCustomers.action" class="layui-menu-tips">
              <i class="fa fa-navicon"></i>
              <span class="layui-left-nav"> 管理住客</span>
            </a>
          </dd>
        </dl>
      </li>

      <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;" class="layui-menu-tips">
          <i class="fa fa-search"></i>
          <span class="layui-left-nav"> 维护操作</span>
        </a>
        <dl class="layui-nav-child">
          <dd id="findRoom">
            <a href="findAllRooms.action" class="layui-menu-tips">
              <i class="fa fa-search-minus"></i>
              <span class="layui-left-nav"> 维护房间信息</span>
            </a>
          </dd>
          <dd id="findRoomType">
            <a href="findAllRoomTypes.action" class="layui-menu-tips">
              <i class="fa fa-search-minus"></i>
              <span class="layui-left-nav"> 维护房型信息</span>
            </a>
          </dd>
          <dd id="findOrder">
            <a href="listAllOrders.action" class="layui-menu-tips">
              <i class="fa fa-search-plus"></i>
              <span class="layui-left-nav"> 维护订单信息</span>
            </a>
          </dd>
          <dd id="findMember">
            <a href="findAllMembers.action" class="layui-menu-tips">
              <i class="fa fa-search-plus"></i>
              <span class="layui-left-nav"> 维护会员信息</span>
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

