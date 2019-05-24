# SpringBootDemo
基于SpringBoot开发一个Restful服务，实现增删改查功能

SpringBoot介绍
Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。
简单的来说就是，只需几个jar和一些简单的配置，就可以快速开发项目。

用SpringBoot实战的话来说：
这里没有配置，没有web.xml，没有构建说明，甚至没有应用服务器，但这就是整个应用程序了。SpringBoot会搞定执行应用程序所需的各种后勤工作，你只要搞定应用程序的代码就好。

一、开发准备

1.1 数据库和表

首先，需要在MySql中创建一个数据库和一张表

数据库的名称为 springboot，表名称为 t_user

脚本如下:

CREATE DATABASE `springboot`;

USE `springboot`;

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `age` int(2) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

1.2 maven相关依赖

因为我们使用Maven创建的，所以需要添加SpringBoot的相关架包。

这里Maven的配置如下:

springBoot最核心的jar
spring-boot-starter ：核心模块，包括自动配置支持、日志和YAML；

二、工程说明

成功创建好数据库以及下载好相应架包之后。

我们来正式开发SpringBoot项目。

2.1工程结构图:

首先确定工程结构，这里我就简单的说明下了。

com.pancm.web - Controller 层
com.pancm.dao - 数据操作层 DAO
com.pancm.bean - 实体类
com.pancm.service - 业务逻辑层
Application - 应用启动类
application.properties - 应用配置文件，应用启动会自动读取配置

2.2 自定义配置文件

一般我们需要一些自定义的配置，例如配置jdbc的连接配置，在这里我们可以用 application.properties 进行配置。数据源实际的配置以各位的为准。

三、代码编写

在创建好相关工程目录之后，我们开始来编写相应的代码。

3.1 实体类编写(详情看User.java)

由于我们这里只是用于测试，只在数据库中创建了一张t_user表，所以这里我们就只创建一个User实体类，里面的字段对应t_user表的字段。

3.2 Dao层编写(详情看UserDao.java)

在以前的Dao层这块，hibernate和mybatis 都可以使用注解或者使用mapper配置文件。在这里我们使用spring的JPA来完成基本的增删改查。

说明:

一般有两种方式实现与数据库实现CRUD：

第一种是xml的mapper配置。
第二种是使用注解，@Insert、@Select、@Update、@Delete 这些来完成。本篇使用的是第二种。

3.3 Service 业务逻辑层(UserService,UserServiceImpl)

这块和hibernate、mybatis的基本一样。

3.4 Controller 控制层

控制层这块和springMVC很像，但是相比而言要简洁不少。

3.5 Application 主程序

SpringApplication 则是用于从main方法启动Spring应用的类。
默认，它会执行以下步骤：

创建一个合适的ApplicationContext实例 （取决于classpath）。
注册一个CommandLinePropertySource，以便将命令行参数作为Spring properties。
刷新application context，加载所有单例beans。
激活所有CommandLineRunner beans。
直接使用main启动该类，SpringBoot便自动化配置了。

四、代码测试

代码编写完之后，我们进行代码的测试。

启动Application 之后，使用postman工具进行接口的测试。

最后测试的时候遇到了问题：
1.用postman测试新增方法时，后台接收到的参数是null
这里需要注意的是用"method = RequestMethod.POST"这种Post方式请求时，参数要加上@RequestBody这个注解，否则就拿不到json的数据
用"method = RequestMethod.GET"这种GET方式请求时，参数要加上@RequestParam这个注解
