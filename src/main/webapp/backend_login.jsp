<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>后台管理-登录</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta http-equiv="Access-Control-Allow-Origin" content="*">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">
  <link rel="stylesheet" href="lib/layui-v2.5.4/css/layui.css" media="all">
  <style>
    body {
      background-image: url("images/bd.jpg");
      height: 100vh;
      width: 100%;
      background-size: cover;
      background-repeat: no-repeat;
    }

    #container {
      height: 100%;
      width: 100%;
    }

    input:-webkit-autofill {
      -webkit-box-shadow: inset 0 0 0 1000px #fff;
      background-color: transparent;
    }

    .admin-login-background {
      width: 300px;
      height: 300px;
      position: absolute;
      left: 50%;
      top: 40%;
      margin-left: -150px;
      margin-top: -100px;
    }

    .admin-header {
      text-align: center;
      margin-bottom: 20px;
      color: #ffffff;
      font-weight: bold;
      font-size: 40px
    }

    .admin-input {
      border-top-style: none;
      border-right-style: solid;
      border-bottom-style: solid;
      border-left-style: solid;
      height: 50px;
      width: 300px;
      padding-bottom: 0px;
    }

    .admin-input::-webkit-input-placeholder {
      color: #a78369
    }

    .layui-icon-username {
      color: #a78369 !important;
    }

    .layui-icon-username:hover {
      color: #9dadce !important;
    }

    .layui-icon-password {
      color: #a78369 !important;
    }

    .layui-icon-password:hover {
      color: #9dadce !important;
    }

    .admin-input-username {
      border-top-style: solid;
      border-radius: 10px 10px 0 0;
    }

    .admin-input-verify {
      border-radius: 0 0 10px 10px;
    }

    .admin-button {
      margin-top: 20px;
      font-weight: bold;
      font-size: 18px;
      width: 300px;
      height: 50px;
      border-radius: 5px;
      background-color: #a78369;
      border: 1px solid #d8b29f
    }

    .admin-icon {
      margin-left: 260px;
      margin-top: 10px;
      font-size: 30px;
    }

    i {
      position: absolute;
    }
    .captcha-img {position:absolute;margin-left:205px;margin-top:-36px;}
  </style>
</head>
<body>
<div id="container">
  <div class="admin-login-background">
    <div class="admin-header">
      <span>后台系统登录</span>
    </div>
    <form class="layui-form" action="login.action" method="post">
      <div>
        <i class="layui-icon layui-icon-username admin-icon"></i>
        <input id="username" name="id" type="text" placeholder="请输入工号" autocomplete="off"
               class="layui-input admin-input admin-input-username">
      </div>
      <div>
        <i class="layui-icon layui-icon-password admin-icon"></i>
        <input  id="password" type="password" name="password"  placeholder="请输入密码" autocomplete="off"
                class="layui-input admin-input">
      </div>
      <div>
        <select class="user-type" name="choice">
          <option value="1" selected>服务员登录</option>
          <option value="2">管理员登录</option>
        </select>
      </div>

      <div>
        <s:hidden name="realCode" value="%{#request.code}"/>
        <input id="code" type="text" name="inputCode" lay-verify="required|captcha" placeholder="验证码" autocomplete="off"
               class="layui-input verification captcha">
        <div class="captcha-img">
          <a href="authGenerate.action" title="重新生成验证码">
            <img id="captchaPic" src="<s:property value='#request.imageBits'/>" alt="验证码">
          </a>
        </div>
      </div>
      <button class="layui-btn admin-button" lay-submit="" lay-filter="login">登 录</button>
    </form>
  </div>
</div>
<script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer;

        // 登录过期的时候，跳出ifram框架
        if (top.location != self.location) top.location = self.location;

        // 进行登录操作
        form.on('submit(login)', function (data) {
            data = data.field;
            if (data.username == '') {
                layer.msg('用户名不能为空');
                return false;
            }
            if (data.password == '') {
                layer.msg('密码不能为空');
                return false;
            }
            if (data.code == '') {
              layer.msg('验证码不能为空');
              return false;
            }
            return true;
        });
    });
</script>
</body>
</html>
