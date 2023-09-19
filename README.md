# 恒合仓库

#### 介绍
恒合仓库，经典的RBAC项目 

#### 项目描述
为满足日益扩大的仓库管理需求，对仓库中商品进销存进行统一管理，而开发了此系统。
系统主要包含：
- RBAC:用户角色权限控制

1. 用户管理(查询用户、添加用户、修改用户、删除用户、导出数据、批量删除、禁用/启用用户、重置密码、分配角色、更改权限)
2. 角色管理(查询角色、添加角色、修改角色、删除角色、导出数据、禁用/启用角色、更改权限)
3. 权限管理(查询权限、添加权限、修改权限、删除角色、禁用/启用权限)

4. 商品管理(查询商品、添加商品、修改商品、商品审核等)
5. 商品分类管理(商品分类的添加、商品分类的查询、商品分类的修改、商品分类的删除等)
6. 采购管理(我的采购单、添加采购单、采购单的审核等)
7. 入库管理(入库单、保存入库单、确认入库等)
8. 出库管理(出库单、保存出库单、审核出库单等)
9. 统计管理(各个仓库库存信息、仓库占有比、仓库存储走势、出入库信息统计、采购量占比、实时数据监测)
10. 调货管理(调货单查询、确认调货)
11. 仓库管理(查询仓库、添加仓库、修改仓库、删除仓库、导出数据)
12. 供货商管理(供货商添加、供货商修改、供货商的查询等)
13. 品牌管理(品牌添加、品牌修改、品牌的查询等)
14. 产地管理(产地添加、产地修改、产地的查询等)
15. 站内信管理(我的站内信、未读消息、站内信发送、站内信查询等)

#### 技术选型

1. SpringBoot + MyBatis + MySql + Redis + Vue3 + Axios + Element-Plus + Echarts


#### 安装教程

1.  执行db_warehouse.sql 文件
2.  配置maven
3.  jdk使用1.8
4.  项目采用前后端分离开发,前端需独立部署

#### 个人职责
- Ian 完成后端接口

#### 部署前端
1>安装node:
node的介绍:
node是一个基于Chrome V8引擎的JavaScript运行环境,让JavaScript运行在服务端的开发平台。

     npm包管理器的介绍:
     node安装之后一般都会默认安装npm包管理器;类似于linux的yum包管理器,可以给Vue项目下载相关插件、依赖;

     1)将安装压缩包解压就是安装

     2)配置path环境变量

     3)测试安装是否成功:
       node -v：查看node版本
       npm -v：查看npm包管理器的版本
       如果出现警告将node安装目录中的npm.cmd文件中的prefix -g改为prefix --location=global

2>给npm包管理器配置镜像加速器:
npm config set registry https://registry.npm.taobao.org
npm config get registry  -- 返回https://registry.npm.taobao.org，说明配置成功

3>使用npm包管理器下载安装yarn包管理器,同时配置镜像加速器:
yarn包管理器的介绍:
yarn包管理器跟npm包管理器的作用是一样的,区别就是npm包管理器是node自己的,而yarn包管理器属于第三方(facebook的);

     安装yarn包管理器:
     npm install -g yarn

     给yarn包管理器配置镜像加速器:
     yarn config set registry https://registry.npm.taobao.org 
     yarn config get registry  -- 返回https://registry.npm.taobao.org，说明配置成功

4>使用yarn包管理器为前端Vue项目下载安装所需插件:
在vue项目目录下执行命令：yarn

5>启动前端Vue项目:
在vue项目目录下执行命令：yarn dev

细节:
前端vue项目对后台项目的访问路径:
vue项目目录下的.env文件:
VITE_WAREHOUSE_CONTEXT_PATH=http://localhost:9999/warehouse
1)可以在.env文件中通过VITE_WAREHOUSE_CONTEXT_PATH变量修改设置前端Vue项目访问的后台项目的访问路径;
2)如果不做修改设置那么就要求我们的后台项目的项目路径必须是/warehouse,访问端口必须是9999;
