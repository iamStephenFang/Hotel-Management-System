<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>酒店管理系统-登入</title>
  <style>
    .layui-card {
      border: 1px solid #f2f2f2;
      border-radius: 5px;
    }

    .icon {
      margin-right: 10px;
      color: #1aa094;
    }

    .icon-cray {
      color: #ffb800 !important;
    }

    .icon-blue {
      color: #1e9fff !important;
    }

    .icon-tip {
      color: #ff5722 !important;
    }

    .layuimini-qiuck-module {
      text-align: center;
      margin-top: 10px
    }

    .layuimini-qiuck-module a i {
      display: inline-block;
      width: 100%;
      height: 60px;
      line-height: 60px;
      text-align: center;
      border-radius: 2px;
      font-size: 30px;
      background-color: #F8F8F8;
      color: #333;
      transition: all .3s;
      -webkit-transition: all .3s;
    }

    .layuimini-qiuck-module a cite {
      position: relative;
      top: 2px;
      display: block;
      color: #666;
      text-overflow: ellipsis;
      overflow: hidden;
      white-space: nowrap;
      font-size: 14px;
    }

    .welcome-module {
      width: 100%;
      height: 210px;
    }

    .panel {
      background-color: #fff;
      border: 1px solid transparent;
      border-radius: 3px;
      -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
      box-shadow: 0 1px 1px rgba(0, 0, 0, .05)
    }

    .panel-body {
      padding: 10px
    }

    .panel-title {
      margin-top: 0;
      margin-bottom: 0;
      font-size: 12px;
      color: inherit
    }

    .label {
      display: inline;
      padding: .2em .6em .3em;
      font-size: 75%;
      font-weight: 700;
      line-height: 1;
      color: #fff;
      text-align: center;
      white-space: nowrap;
      vertical-align: baseline;
      border-radius: .25em;
      margin-top: .3em;
    }

    .layui-red {
      color: red
    }

    .main_btn>p {
      height: 40px;
    }

    .layui-bg-number {
      background-color: #F8F8F8;
    }

    .layuimini-notice:hover {
      background: #f6f6f6;
    }

    .layuimini-notice {
      padding: 7px 16px;
      clear: both;
      font-size: 12px !important;
      cursor: pointer;
      position: relative;
      transition: background 0.2s ease-in-out;
    }

    .layuimini-notice-title,
    .layuimini-notice-label {
      padding-right: 70px !important;
      text-overflow: ellipsis !important;
      overflow: hidden !important;
      white-space: nowrap !important;
    }

    .layuimini-notice-title {
      line-height: 28px;
      font-size: 14px;
    }

    .layuimini-notice-extra {
      position: absolute;
      top: 50%;
      margin-top: -8px;
      right: 16px;
      display: inline-block;
      height: 16px;
      color: #999;
    }
  </style>
  <%@include file="head.jsp" %>
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
  <%@include file="header.jsp" %>
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
        <div class="layui-row layui-col-space15">
          <div class="layui-col-md8">
            <div class="layui-row layui-col-space15">
              <div class="layui-col-md12">
                <div class="layui-card">
                  <div class="layui-card-header"><i class="fa fa-warning icon"></i>数据统计</div>
                  <div class="layui-card-body">
                    <div class="welcome-module">
                      <div class="layui-row layui-col-space10">
                        <div class="layui-col-xs6">
                          <div class="panel layui-bg-number">
                            <div class="panel-body">
                              <div class="panel-title">
                                <span class="label pull-right layui-bg-cyan">实时</span>
                                <h5>注册用户统计</h5>
                              </div>
                              <div class="panel-content">
                                <h1 class="no-margins"><s:property value='#request.home.registerNum'/></h1>
                                <small>当前分类总记录数</small>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="layui-col-xs6">
                          <div class="panel layui-bg-number">
                            <div class="panel-body">
                              <div class="panel-title">
                                <span class="label pull-right layui-bg-cyan">实时</span>
                                <h5>订单统计</h5>
                              </div>
                              <div class="panel-content">
                                <h1 class="no-margins"><s:property value='#request.home.orderNum'/></h1>
                                <small>当前分类总记录数</small>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="layui-col-xs6">
                          <div class="panel layui-bg-number">
                            <div class="panel-body">
                              <div class="panel-title">
                                <span class="label pull-right layui-bg-cyan">实时</span>
                                <h5>入住用户统计</h5>
                              </div>
                              <div class="panel-content">
                                <h1 class="no-margins"><s:property value='#request.home.checkCustomerNum'/></h1>
                                <small>当前分类总记录数</small>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="layui-col-xs6">
                          <div class="panel layui-bg-number">
                            <div class="panel-body">
                              <div class="panel-title">
                                <span class="label pull-right layui-bg-cyan">实时</span>
                                <h5>房间统计</h5>
                              </div>
                              <div class="panel-content">
                                <h1 class="no-margins"><s:property value='#request.home.roomNum'/></h1>
                                <small>当前分类总记录数</small>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="layui-col-md12">
                <div class="layui-card">
                  <div class="layui-card-header"><i class="fa fa-credit-card icon icon-blue"></i>快捷入口
                  </div>
                  <div class="layui-card-body">
                    <div class="welcome-module">
                      <div class="layui-row layui-col-space10 layuimini-qiuck">
                        <div class="layui-col-xs3 layuimini-qiuck-module">
                          <a href="findAllRooms.action" data-title="图标列表"
                             data-icon="fa fa-wrench">
                            <i class="fa fa-wrench"></i>
                            <cite>维护房间信息</cite>
                          </a>
                        </div>
                        <div class="layui-col-xs3 layuimini-qiuck-module">
                          <a href="findAllRoomTypes.action" data-title="图标列表"
                             data-icon="fa fa-wrench">
                            <i class="fa fa-wrench"></i>
                            <cite>维护房型信息</cite>
                          </a>
                        </div>
                        <div class="layui-col-xs3 layuimini-qiuck-module">
                          <a href="listAllOrders.action" data-title="图标列表"
                             data-icon="fa fa-wrench">
                            <i class="fa fa-wrench"></i>
                            <cite>维护订单信息</cite>
                          </a>
                        </div>
                        <div class="layui-col-xs3 layuimini-qiuck-module">
                          <a href="findAllMembers.action" data-title="图标列表"
                             data-icon="fa fa-wrench">
                            <i class="fa fa-wrench"></i>
                            <cite>维护会员信息</cite>
                          </a>
                        </div>
                        <div class="layui-col-xs3 layuimini-qiuck-module">
                          <a href="findAllWaiters.action" data-title="图标列表"
                             data-icon="fa fa-edit">
                            <i class="fa fa-edit"></i>
                            <cite>管理服务员信息</cite>
                          </a>
                        </div>
                        <div class="layui-col-xs3 layuimini-qiuck-module">
                          <a href="findAllRegisters.action" data-title="图标列表"
                             data-icon="fa fa-edit">
                            <i class="fa fa-edit"></i>
                            <cite>管理用户信息</cite>
                          </a>
                        </div>
                        <div class="layui-col-xs3 layuimini-qiuck-module">
                          <a href="listAllCustomers.action" data-title="图标列表"
                             data-icon="fa fa-edit">
                            <i class="fa fa-edit"></i>
                            <cite>管理住客信息</cite>
                          </a>
                        </div>
                        <div class="layui-col-xs3 layuimini-qiuck-module">
                          <a href="info_edit.jsp" data-title="图标列表"
                             data-icon="fa fa-edit">
                            <i class="fa fa-edit"></i>
                            <cite>管理账户信息</cite>
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="layui-col-md4">

            <div class="layui-card">
              <div class="layui-card-header"><i class="fa fa-bullhorn icon icon-tip"></i>系统公告</div>
              <div class="layui-card-body layui-text">
                <s:iterator value="#request.messages">
                  <div class="layuimini-notice">
                    <div class="layuimini-notice-title"><s:property value="title"/></div>
                    <div class="layuimini-notice-extra"><s:property value="sendTime"/></div>
                  </div>
                </s:iterator>
              </div>
            </div>

            <div class="layui-card">
              <div class="layui-card-header"><i class="fa fa-fire icon"></i>项目信息</div>
              <div class="layui-card-body layui-text">
                <table class="layui-table">
                  <colgroup>
                    <col width="100">
                    <col>
                  </colgroup>
                  <tbody>
                  <tr>
                    <td>项目名称</td>
                    <td>
                      酒店后台管理系统
                    </td>
                  </tr>
                  <tr>
                    <td>项目功能</td>
                    <td>
                      实现了酒店后台对于房间、房型、用户、住客、服务员信息的增删改查。
                    </td>
                  </tr>
                  <tr>
                    <td>项目简介</td>
                    <td>
                      项目前端基于lay UI，项目后端基于SSM框架。
                    </td>
                  </tr>
                  <tr>
                    <td>项目维护</td>
                    <td style="padding-bottom: 0;">
                      <div class="layui-btn-container">
                        <iframe src="https://ghbtns.com/github-btn.html?user=iamStephenFang&type=follow" frameborder="0"
                                scrolling="0" width="180px" height="20px"></iframe>
                        <iframe src="https://ghbtns.com/github-btn.html?user=kuluoluohaoxiuyi&type=follow"
                                frameborder="0" scrolling="0" width="180px" height="20px"></iframe>
                        <iframe src="https://ghbtns.com/github-btn.html?user=zxfXYZ&type=follow" frameborder="0"
                                scrolling="0" width="180px" height="20px"></iframe>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>项目地址</td>
                    <td style="padding-bottom: 0;">
                      <div class="layui-btn-container">
                        <iframe
                            src="https://ghbtns.com/github-btn.html?user=iamStephenFang&repo=Hotel-Management-System&type=star&count=true"
                            frameborder="0" scrolling="0" width="100px" height="20px"></iframe>
                      </div>
                    </td>
                  </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    window.onload=function() {
        var authCheck = ${param.authCheck};
        if (authCheck === false){
            layui.use('layer',function () {
                var layer = layui.layer;
                layer.open({
                    type: 0,
                    fixed: false,
                    maxmin: true,
                    scrollbar: false,
                    content: '权限不足！',
                    btn: '确认'
                });
            })
        }
    };

    layui.use(['layer', 'layuimini', 'element'], function () {
        var $ = layui.jquery,
            layer = layui.layer,
            layuimini = layui.layuimini;
        });



        // $('.login-out').on("click", function () {
        //     layer.msg('退出登录成功', function () {
        //         window.location = 'backend_login.jsp';
        //     });
        // });

</script>
</body>
</html>
