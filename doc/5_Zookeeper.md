Zookeeper
> 面向分布式应用的分布式协调服务。

Zookeeper 节点分为永久节点、顺序节点、临时节点

绑定端口2181
```shell script
 docker run -itd --name zookeeper  -p 3317:2181  zookeeper
```

引入依赖 在Pom.xml文件中添加依赖

```xml
<!--zookeeper注册中心-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
</dependency>
 ```


服务配置文件
```yaml
spring:
  application:
    name: venus-jwt-auth-server
  cloud:
    zookeeper:
      connect-string: 127.0.0.1:3317
```

查看注册服务

在docker中进入zookeeper命令行;
docker exec -it zookeeper bash

进入zookeeper的bin目录:
cd bin

使用zookeeper client访问zookeeper服务:
./zkCli.sh

查看
ls /

查看所有services:
ls /services

查看waiter-service的信息:
ls /services/waiter-service

根据[id]查看相关服务的详细信息(id是动态的):
ls /services/waiter-service/[id]
示例:
ls /services/waiter-service/51c51677-488c-431f-9566-ccbeec5bef04

获取相关服务的详细信息(id是动态的):
get /services/waiter-service/[id]
示例:
get /services/waiter-service/51c51677-488c-431f-9566-ccbeec5bef04

获取相关服务的详细信息(id是动态的):
get /services/customer-service/[id]
示例:
get /services/customer-service/fd56228b-9b90-4052-99ce-307dd78fe05a



分布式锁
