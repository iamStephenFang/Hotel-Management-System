<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>人证核验</title>
  <%@include file="head.jsp" %>
</head>
<body>
<div class="layuimini-container">
  <div class="layuimini-main">
    <form class="layui-form layuimini-form" action="faceCheck.action" method="post" enctype="multipart/form-data" style="margin-left:-30px;padding-right:50px">
      <br>
      <div class="layui-form-item">
        <label class="layui-form-label">证件照:</label>
        <div class="layui-input-block">
          <input type="file" name="idFile" style="margin-top: 7px;">
        </div>
      </div>
      <br>
      <div class="layui-form-item">
        <label class="layui-form-label">正面照:</label>
        <div class="layui-input-block">
          <input type="file" name="faceFile" style="margin-top: 7px;">
        </div>
      </div>
      <br>
      <div class="layui-form-item">
        <div class="layui-input-block">
          <button class="layui-btn" lay-submit onclick="wait()">核验</button>
        </div>
      </div>
    </form>
  </div>
</div>
<script src="lib/layui-v2.5.4/layui.js" charset="utf-8"></script>
<script src="js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    function wait() {
        layui.use(['layer'], function () {
            var layer = layui.layer;
            layer.open({
                type: 3
            });
        });
    }

    layui.use(['form'], function () {
        var form = layui.form;
    });
</script>
</body>
</html>
