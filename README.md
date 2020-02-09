# 独立酒店管理系统 ( JavaEE 课程设计项目 )
## 项目介绍
使用 JavaEE 编写的界面简洁、功能丰富的酒店管理系统。

该系统分为两部分：

- 面向酒店工作者的后台系统。酒店工作者分为两类，分别是服务员与管理员。服务员进入系统后可快速为顾客提供选定房间与退房业务，并可查询近期订单进行对照，管理员负责酒店的运营事务，对酒店配置进行管理，调整房间信息、会员等级信息，还可负责一部分服务员的事务，可以对一些信息进行修正。

- 面向用户的前台系统。用户进入系统后，可查看酒店信息，任意根据条件查询客房相关信息，快速便捷下达订单，节约了顾客查找客房信息的时间，优化顾客使用系统的体验。

本系统易维护、扩展性强、能兼容、界面美观且操作，通过使用本系统可以让繁琐的客房服务事务条理化,节约了顾客与工作人员的时间与精力,使酒店业务工作变得更加方便快捷。（同时超纲完成了课程设计的要求）

该项目会不定时进行更新修复bug，如果这个项目能够帮助到您，希望您star和watch，如果您在项目配置中遇到了bug请务必指正。

在开发之初由于小组作业的原因，后台系统与前台系统的项目分开撰写，两者共享一部分代码。您可以通过下面的链接查看面向用户的项目。

面向用户项目的地址（已开源）：[独立酒店预订系统](https://github.com/iamStephenFang/Hotel-Client)

## 技术栈

- [layuimini](https://github.com/zhongshaofa/layuimini) v2.5.4 
- [Spring Framework](https://mvnrepository.com/artifact/org.springframework) v4.3.25 
- [Struts 2](https://mvnrepository.com/artifact/org.apache.struts/struts2-core) v2.3.15.1
- [MyBatis](https://github.com/mybatis) v3.5.2
- [MySQL](https://dev.mysql.com/doc/relnotes/mysql/8.0/en/news-8-0-17.html) v8.0.17

## 项目特性
1. ~~满足课程设计要求~~
2. 满足小型独立酒店后台数据管理需求
3. 代码基本参照[阿里巴巴编码规范](https://edu.aliyun.com/certification/cldt02)进行编写，提供Spring IoC 全注解配置
4. 体现了 Spring IoC 与 Spring AOP 的设计思路
5. 实现了模态框和分布式表单的设计
6. 应用了MyBatis的动态SQL特性
7. 整合了人证核验功能
8. 整合了手机验证码核验功能（在[独立酒店预订系统](https://github.com/iamStephenFang/Hotel-Client)）
9. 整合了邮件注册功能（在[独立酒店预订系统](https://github.com/iamStephenFang/Hotel-Client)）
10. 提供了权限验证和登录验证功能

## 安装

该项目采用[Maven](https://github.com/apache/maven)进行配置，推荐使用[IntelliJ IDEA](https://www.jetbrains.com/idea/)编辑项目，在开始使用前请自行配置Java 8以上的Java环境。

```
git clone https://github.com/iamStephenFang/Hotel-Management-System.git
```

## 效果预览

![管理系统后台首页](https://s2.ax1x.com/2020/02/10/14itiV.png)

<center>管理系统后台首页</center>

![办理入住界面](https://s2.ax1x.com/2020/02/10/14FEy4.md.png)

<center>办理入住界面</center>

![管理房间界面](https://s2.ax1x.com/2020/02/10/14Fpoq.png)

<center>管理房间界面</center>

## 部署方法

使用该系统需要配置以下内容:

- SQL数据库
- Spring框架
- Struts框架
- Tomcat
- 扩充功能
    - 腾讯云身份证识别和人脸比对API
    - 网易云信验证码短信API
    - 网易163邮箱客户端授权码

请认真阅读以下文档中的配置指南完成此项目的完整配置，可以根据需求对相应的组件和功能进行部署。

> Maven项目配置文件中包含了[MySQL](https://dev.mysql.com/doc/relnotes/mysql/8.0/en/news-8-0-17.html)与[MariaDB](https://mariadb.org/download)的JDBC驱动，并且采用[c3p0](https://www.mchange.com/projects/c3p0/)作为连接池，可以通过修改`database.properties`文件修改连接数据库的参数。

> `hotel_management(仅结构).sql` 文件包含了所有构件系统数据库结构的sql语句，可以参照ER图与实际需要对数据库存储内容进行修改。

![数据库ER图](https://s2.ax1x.com/2020/02/10/14kPHA.png)

<center>数据库ER图</center>

![在IDEA中加载struts的配置文件](https://s2.ax1x.com/2020/02/09/1hlotg.jpg)

<center>在IDEA中加载Struts的配置文件</center>

![在IDEA中加载Spring的配置文件](https://s2.ax1x.com/2020/02/09/1hlHpj.jpg)

<center>在IDEA中加载Spring的配置文件</center>

![配置Tomcat服务器](https://s2.ax1x.com/2020/02/09/1hlv7T.jpg)

<center>配置Tomcat服务器</center>

### 人证核验功能

采用[腾讯云身份证识别和人脸比对API](https://cloud.tencent.com/document/product/1007/35921)，使用请注册并获取API密钥。

![](https://s2.ax1x.com/2020/02/09/1h8LjA.jpg)

<center>腾讯云相关后台页面</center>

获取密钥后向 `cn.edu.zjut.face` 包中的 `TencentCloudFaceCheck.java `文件内填入 **secretId** 和 **secretKey** 两个常量的值即可，更多配置信息详见代码和注释

身份证识别API文档：[https://cloud.tencent.com/document/product/866/33524](https://cloud.tencent.com/document/product/866/33524]

人脸比对API文档：[https://cloud.tencent.com/document/product/867/32802](https://cloud.tencent.com/document/product/867/32802)

### 手机验证码核验功能

采用[网易云信验证码短信API](https://dev.yunxin.163.com/docs/product/%E7%9F%AD%E4%BF%A1/%E7%9F%AD%E4%BF%A1%E6%8E%A5%E5%8F%A3%E6%8C%87%E5%8D%97)，使用请注册并获取API密钥。

![](https://s2.ax1x.com/2020/02/09/1hJLwt.jpg)

<center>网易云信后台页面</center>

获取密钥后在控制台新建验证码短信模板，并向 `cn.edu.zjut.authcode` 包中的 `AuthCodeService.java` 文件内填入 **APP_SECRET** , **APP_KEY** 和 **TEMPLATEID** 三个常量的值即可，更多配置信息详见代码和注释.


### 邮件注册功能

采用[网易163邮箱](https://mail.163.com/)，使用前请先设置客户端授权码。

![](https://s2.ax1x.com/2020/02/09/1hNkGT.png)

<center>网易163邮箱后台页面</center>

设置授权码后向 `cn.edu.zjut.email` 包中的 `EmailService.java` 文件内填入 **FROM** , **USER** 和 **PASSWORD** 三个常量的值即可，更多配置信息详见代码和注释

## 关于作者
- StephenFang - 管理员功能模块 - [iamStephenFang](https://github.com/iamStephenFang)
- 王小云 - 服务员功能模块 - [kuluoluohaoxiuyi](https://github.com/kuluoluohaoxiuyi)
- Bunny Wong - Fix bugs - [GetToSet](https://github.com/GetToSet)

## 授权协议
使用此项目需遵守MIT协议。
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
