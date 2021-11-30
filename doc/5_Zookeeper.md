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



##分布式锁
>客户端A要获取分布式锁的时候首先到locker下创建一个临时顺序节点（node_n），然后立即获取locker下的所有（一级）子节点。
此时因为会有多个客户端同一时间争取锁，因此locker下的子节点数量就会大于1。对于顺序节点，特点是节点名称后面自动有一个数字编号，
先创建的节点数字编号小于后创建的，因此可以将子节点按照节点名称后缀的数字顺序从小到大排序，这样排在第一位的就是最先创建的顺序节点，
此时它就代表了最先争取到锁的客户端！此时判断最小的这个节点是否为客户端A之前创建出来的node_n，如果是则表示客户端A获取到了锁，
如果不是则表示锁已经被其它客户端获取，因此客户端A要等待它释放锁，也就是等待获取到锁的那个客户端B把自己创建的那个节点删除。
此时就通过监听比node_n次小的那个顺序节点的删除事件来知道客户端B是否已经释放了锁，如果是，此时客户端A再次获取locker下的所有子节点，
再次与自己创建的node_n节点对比，直到自己创建的node_n是locker的所有子节点中顺序号最小的，此时表示客户端A获取到了锁！

![D:\project\Venus\doc\5_Zookeeper\img.png](img.png)
CuratorFramework 已经实现好的分布式锁
InterProcessLock (接口)
InterProcessMutex (可重入互斥锁)
InterProcessMultiLock (多个锁的管理容器)
InterProcessReadWriteLock (读写锁)
InterProcessSemaphoreMutex (不可重入的互斥锁)
