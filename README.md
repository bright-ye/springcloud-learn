# SpringCloud总结

# 1. 服务架构对比

## 1. 1 单体架构

**单体架构：**将所有功能都集中在一个项目中开发，打成一个包部署。

![image-20211208225018694](README.assets/image-20211208225018694.png)

优点：部署成本低，架构简单

缺点：耦合度高，维护、升级困难

## 1.2 分布式架构

**分布式架构：**根据业务功能对系统做拆分，每个业务功能模块作为一个独立项目开发，称为一个服务

![image-20211208225157954](README.assets/image-20211208225157954.png)

优点：降低服务耦合、有利于服务升级和拓展

缺点：服务调用关系错综复杂

## 1.3 微服务架构

![image-20211208225351800](README.assets/image-20211208225351800.png)

微服务实际是一种良好架构设计的**分布式架构方案**

微服务架构特征：

- 单一职责：微服务拆分粒度更小，每个微服务对应唯一的业务能力
- 自治: 团队独立、技术独立、数据独立，独立部署和交付
- 面向服务：服务统一标准的接口，与语言和技术无关
- 隔离性强：服务调用做好隔离、容错 、降级，避免出现级联关系

微服务在Java领域最引人注目的就是Spring Cloud提供的方案了。

## 1.4 SpringCloud

SpringCloud常见的组件包括：

![image-20211208225824202](README.assets/image-20211208225824202.png)

# 2. 服务拆分和远程调用

## 2.1 服务拆分

现模拟一个微服务demo，用户服务和订单服务

cloud-demo: 父工厂，管理依赖

- order-service：订单微服务，负责订单相关业务
- user-service: 用户微服务，负责用户相关业务

要求：

- 订单微服务和用户微服务都必须有自己的数据库（为了简化，模拟数据库），相互独立
- 订单服务和用户服务都对外暴露Restful接口

![image-20211209231301654](README.assets/image-20211209231301654-16390629811141.png)



