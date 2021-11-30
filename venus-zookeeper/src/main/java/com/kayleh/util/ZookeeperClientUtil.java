package com.kayleh.util;

import lombok.Cleanup;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Zookeeper客户端工具类
 *
 * @author kayleh
 * @date 2021/8/18
 */
public class ZookeeperClientUtil {

    /**
     * 获取Curator客户端
     */
    public static CuratorFramework getCuratorFramework() {

        //1、配置重试策略 5000：重试间隔 5：重试次数
        ExponentialBackoffRetry policy = new ExponentialBackoffRetry(5 * 1000, 5);
        //2、构造Curator客户端
        @Cleanup CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:3317")//localhost:
                .connectionTimeoutMs(60 * 1000)
                .sessionTimeoutMs(60 * 1000)
                .retryPolicy(policy).build();
        //3、启动客户端
        client.start();
        //4、输出信息
        System.out.println("zookeeper启动成功，获取到客户端链接");
        return client;
    }

    /**
     * @desp: 创建永久节点
     * @author: power by Kayleh, 2021/11/28 13:37
     * @params: []
     * @return: void
     * @since: 1.0.0
     */
    public static void create() {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper =
                    new ZooKeeper("127.0.0.1:3317", 4000, event -> {
                        if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
                            countDownLatch.countDown();
                        }
                    });
            zooKeeper.create("/kayleh", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @desp: 连接状态
     * @author: power by Kayleh, 2021/11/28 13:37
     * @params: [args]
     * @return: void
     * @since: 1.0.0
     */
    public static void main(String[] args) {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper =
                    new ZooKeeper(
//                            "192.168.3.33:2181,192.168.3.35:2181,192.168.3.37:2181",
                            "127.0.0.1:3317",
                            4000, new Watcher() {
                        @Override
                        public void process(WatchedEvent event) {
                            if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
                                //如果收到了服务端的响应事件，连接成功
                                countDownLatch.countDown();
                            }
                        }
                    });
            countDownLatch.await();
            //CONNECTED
            System.out.println("ZooKeeper state -> " + zooKeeper.getState());
            List<String> children = zooKeeper.getChildren("/services", false);
            System.out.println("-----node:-----");
            children.stream().parallel().forEachOrdered(System.out::println);
            System.out.println("---------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
