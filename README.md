# 若依管理系统

## 项目介绍

一直想做一款后台管理系统，看了很多优秀的开源项目但是发现没有合适的。于是利用空余时间开始自己写了一套管理系统。如此有了若依。她可以用于所有的Web应用程序，如网站管理后台，网站会员中心，CMS，CRM，OA。所有前端后台代码封装过后十分精简易上手，出错概率低。同时支持移动客户端访问。系统会陆续更新一些实用功能。

性别：男   坐标：魔都·浦东  

邮箱：`2493536068@qq.com`  QQ群：`138056621`  欢迎大家提交issue、pr、star、fork。

## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持单表和树表。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 缓存监控：对系统的缓存信息查询，命令统计等。
17. 在线构建器：拖动表单元素生成相应的HTML代码。
18. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

## 演示地址

- admin/admin123  
- ry/123456  

## 在线文档

[https://www.yuque.com/u291176/ghg29w](https://www.yuque.com/u291176/ghg29w)

## 项目结构

```
com.ruoyi     
├── ruoyi-admin     // web模块
├── ruoyi-common    // 通用模块
├── ruoyi-framework // 核心模块
├── ruoyi-generator // 代码生成模块
├── ruoyi-quartz    // 定时任务模块
├── ruoyi-system    // 业务模块
└── ruoyi-ui        // 前端模块
```

## 技术选型

1.  SpringBoot 2.5.15
2.  Spring Security
3.  MyBatis
4.  Druid
5.  Fastjson
6.  PageHelper
7.  Swagger3
8.  Vue2
9.  Element UI
10. Axios
11. Echarts

## 开发工具

-   IDEA 2022.1.2
-   VSCode 1.66.2
-   Navicat 15.0.12

## 环境要求

-   JDK 1.8
-   Maven 3.6+
-   MySQL 5.7+
-   Node.js 14+

## 部署教程

1. 执行数据库脚本
2. 启动后端服务
3. 启动前端服务（使用的是lanan-admin 前端，没有使用这里的ruoyi-ui）
4. 前端github地址：[https://github.com/2493536068/lanan-admin.git](https://github.com/2493536068/lanan-admin)
5. 后端github地址：[https://github.com/2493536068/lanan-admin2.git](https://github.com/2493536068/ruoyi)
6. 后端在master分支，前端在dev分支

## 单元测试

- [登录接口Mock测试](doc/mock_test_example.md)
- [未读消息接口Mock测试](doc/unread_message_test.md)
- [未完工客户单接口Mock测试](doc/unfinished_customer_order_test.md)
- [未完工任务单接口Mock测试](doc/unfinished_task_order_test.md)

## 更新日志

- 2022.10.01 - 优化系统结构
- 2022.09.01 - 新增定时任务模块
- 2022.08.01 - 新增代码生成模块
- 2022.07.01 - 新增系统监控模块
- 2022.06.01 - 新增用户管理模块

## 联系方式

- 邮箱：2493536068@qq.com
- QQ群：138056621