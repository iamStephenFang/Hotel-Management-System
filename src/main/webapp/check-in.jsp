<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>酒店管理系统-办理入住</title>
  <%@include file="head.jsp" %>
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
    <%@include file="header.jsp" %>
    <%@include file="sidebar.jsp" %>
    <div class="layui-body">
    <div class="layuimini-container">
      <div class="layui-fluid">
        <div class="layui-card">
          <div class="layui-card-body" style="padding-top: 40px;">
            <div class="layui-carousel" id="stepForm" lay-filter="stepForm" style="margin: 0 auto;">
              <div carousel-item>
                <div>
                  <form class="layui-form" style="margin: 0 auto;max-width: 460px;padding-top: 40px;">
                    <div class="layui-form-item">
                      <label class="layui-form-label">订单ID:</label>
                      <div class="layui-input-block">
                        <input type="text" placeholder="请填写订单ID" class="layui-input" lay-verify="number" required/>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formStep">
                          &emsp;下一步&emsp;
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
                <div>
                  <form class="layui-form" style="margin: 0 auto;max-width: 460px;padding-top: 40px;">
                    <div class="layui-form-item">
                      <label class="layui-form-label">订单ID:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux">111</div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">房间数量:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux">2 间</div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">订单总额:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux">900 元</div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">房间类型:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux">双床房</div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">入住日期:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux">2019-12-25</div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">离店日期:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux">2019-12-27</div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">订单备注:</label>
                      <div class="layui-input-block">
                        <div class="layui-form-mid layui-word-aux"></div>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <div class="layui-input-block">
                        <button type="button" class="layui-btn layui-btn-primary pre">上一步</button>
                        <button class="layui-btn" lay-submit lay-filter="formStep2">
                          &emsp;填写入住信息&emsp;
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
                <div>
                  <form class="layui-form" style="margin: 0 auto;max-width: 460px;padding-top: 40px;">
                    <div class="layui-form-item">
                      <label class="layui-form-label">贵宾姓名:</label>
                      <div class="layui-input-block">
                        <input type="text" placeholder="请输入贵宾姓名" class="layui-input" required/>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">证件信息:</label>
                      <div class="layui-input-block">
                        <input type="number" placeholder="请填写贵宾身份证号" value="" class="layui-input" lay-verify="number"
                               required>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">贵宾性别:</label>
                      <div class="layui-input-block">
                        <select lay-verify="required">
                          <option value="1" selected>先生</option>
                          <option value="2">女士</option>
                        </select>
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <label class="layui-form-label">联系方式:</label>
                      <div class="layui-input-block">
                        <input type="number" placeholder="请填写贵宾电话号码" value="" class="layui-input" lay-verify="number"
                               required>
                      </div>
                    </div>

                    <div class="layui-form-item">
                      <label class="layui-form-label">分配房间:</label>
                      <div class="layui-input-inline">
                        <input type="text" name="" placeholder="请选择入住房间" autocomplete="off" class="layui-input"
                               id="demo">
                      </div>
                    </div>
                    <div class="layui-inline" style="margin-bottom: 15px">
                      <label class="layui-form-label">入住日期</label>
                      <div class="layui-input-inline">
                        <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd"
                               autocomplete="off" class="layui-input" lay-key="1">
                      </div>
                    </div>
                    <div class="layui-form-item">
                      <div class="layui-input-block">
                        <button type="button" class="layui-btn layui-btn-primary pre">上一步</button>
                        <button class="layui-btn" lay-submit lay-filter="formStep2">
                          &emsp;确认信息&emsp;
                        </button>
                      </div>
                    </div>
                  </form>
                  <!-- <pre class="layui-code">
                      //开始使用
                      var tableSelect = layui.tableSelect;
                      tableSelect.render({
                          elem: '#demo',	//定义输入框input对象 必填
                          checkedKey: 'id', //表格的唯一建值，非常重要，影响到选中状态 必填
                          searchKey: 'keyword',	//搜索输入框的name值 默认keyword
                          searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
                          table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                              url:'',
                              cols: [[]]
                          },
                          done: function (elem, data) {
                          //选择完后的回调，包含2个返回值 elem:返回之前input对象；data:表格返回的选中的数据 []
                          //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                          }
                      })
                      //默认值
                      只需要在触发input上添加 ts-selected="1,2,3" 属性即可 值需与checkedKey对应
                  </pre> -->
                </div>
                <div>
                  <div style="text-align: center;margin-top: 90px;">
                    <i class="layui-icon layui-circle"
                       style="color: white;font-size:30px;font-weight:bold;background: #52C41A;padding: 20px;line-height: 80px;">&#xe605;</i>
                    <div style="font-size: 24px;color: #333;font-weight: 500;margin-top: 30px;">
                      办理入住成功
                    </div>
                    <div style="font-size: 14px;color: #666;margin-top: 20px;">请提供给顾客相关信息</div>
                  </div>
                  <div style="text-align: center;margin-top: 50px;">
                    <button class="layui-btn next">再次办理</button>
                    <button class="layui-btn layui-btn-primary">查看信息</button>
                  </div>
                </div>
              </div>
            </div>
            <hr>
            <div style="color: #666;margin-top: 30px;margin-bottom: 40px;padding-left: 30px;">
              <h3>注意</h3><br>
              <h4>实际入住人数</h4>
              <p>请核对入住人数是否小于订单中规定的最大人数。</p>
              <br><h4>入住人员信息</h4>
              <p>请仔细核对住客信息确保和订单中一致</p>
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
    layui.use(['form', 'step', 'tableSelect', 'laydate'], function () {
        var $ = layui.$,
            form = layui.form,
            step = layui.step,
            tableSelect = layui.tableSelect,
            laydate = layui.laydate;

        laydate.render({
            elem: '#date'
        });

        step.render({
            elem: '#stepForm',
            filter: 'stepForm',
            width: '100%', //设置容器宽度
            stepWidth: '750px',
            height: '500px',
            stepItems: [{
                title: '检索订单信息'
            }, {
                title: '确认订单信息'
            }, {
                title: '添加住客信息'
            }, {
                title: '入住办理完成'
            }]
        });


        form.on('submit(formStep)', function (data) {
            step.next('#stepForm');
            return false;
        });

        form.on('submit(formStep2)', function (data) {
            step.next('#stepForm');
            return false;
        });

        form.on('submit(formStep3)', function (data) {
            step.next('#stepForm');
            return false;
        });

        $('.pre').click(function () {
            step.pre('#stepForm');
        });

        $('.next').click(function () {
            step.next('#stepForm');
        });

        tableSelect.render({
            elem: '#demo',
            checkedKey: 'id',
            table: {
                url: '../api/tableSelect.json',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: '房间号'},
                    {field: 'type', title: '类型'},
                ]]
            },
            done: function (elem, data) {
                var NEWJSON = []
                layui.each(data.data, function (index, item) {
                    NEWJSON.push(item.id)
                })
                elem.val(NEWJSON.join(","))
            }
        })
    })
</script>
</body>
</html>
