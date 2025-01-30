<style>       body {
           font-family: 'consolas', sans-serif; /* 你可以替换为任何你喜欢的字体 */
       }
   </style>
<div style="text-align: center;margin: 10px 0 0 0" >
       <img  align="center" alt="Venus.png" height="102.4px" src="Venus.png" width="102.4px"/>
</div>
<h1 align="center" style="margin: 0">Venus v0.1</h1>
<h4 align="center">基于SpringBoot+Vue前后端分离的Java快速开发框架</h4>
<p align="center">
	<a href="https://github.com/kayleh/venus"><img src="https://img.shields.io/github/license/mashape/apistatus.svg"></a>
</p> 

## 平台简介

Venus是一套开源的快速开发平台

* 权限认证使用Jwt，支持多终端认证系统。
* 支持加载动态权限菜单，多方式轻松权限控制。
* 高效率开发，使用代码生成器可以一键生成前后端代码。
* 多数据库支持：支持多数据库操作，可自由切换数据源。

### 平台技术框架

<table>
  <tr>
    <td colspan="2" style="text-align: center;" ><strong>开发环境</strong></td>
  </tr>
  <tr><td>编辑器</td><td>Vscode</td></tr>
  <tr> <td>后端</td><td>Java(jdk21.0.2) + Spring Boot(3.4.2)</td></tr>
  <tr><td>前端</td><td>Vue</td></tr>
  <tr><td>UI框架</td><td> Element UI</td></tr>
  <tr><td>数据库</td><td>MySQL8</td></tr>
  <tr><td>权限认证</td><td>Spring Security、Jwt</td></tr>
  <tr><td>三方鉴权</td><td>//TODO...</td></tr>
  <tr><td>日志管理</td><td>Logback</td></tr>
  <tr><td>缓存</td><td>Redis</td></tr>
  <tr><td>ORM</td><td>Mybatis</td></tr>
  <tr><td>数据分页</td><td>PageHelper</td></tr>
  <tr><td>接口传输加密</td><td>//TODO...</td></tr>
  <tr><td>雪花算法</td><td>//TODO...</td></tr>
  <tr><td>Excel框架</td><td>基于 POI </td></tr>
  <tr><td>连接池</td><td>Hikari</td></tr>
</table>

## 内置功能

1. 用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2. 部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3. 岗位管理：配置系统用户所属担任职务。
4. 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5. 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6. 字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7. 参数管理：对系统动态配置常用参数。
8. 通知公告：系统通知公告信息发布维护。
9. 操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 缓存监控：对系统的缓存信息查询，命令统计等。
17. 在线构建器：拖动表单元素生成相应的HTML代码。
18. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。
