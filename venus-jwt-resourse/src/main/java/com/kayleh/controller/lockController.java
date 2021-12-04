package com.kayleh.controller;

import lombok.Cleanup;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/12/1 13:58
 * @Since: 1.0.0
 */
@RestController
@RequestMapping
public class lockController {
    @RequestMapping("/lock")
    public void lock() {
        //1、配置重试策略 5000：重试间隔 5：重试次数
        ExponentialBackoffRetry policy = new ExponentialBackoffRetry(1000, 5);
        //2、构造Curator客户端
        @Cleanup CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:3317")//localhost:
                .connectionTimeoutMs(60 * 1000)
                .sessionTimeoutMs(60 * 1000)
                .retryPolicy(policy).build();
        //3、启动客户端
        client.start();
        InterProcessMutex lock = new InterProcessMutex(client, "/zk_lock");
        try {
            if (lock.acquire(60, TimeUnit.SECONDS)) {
                Stat stat = client.checkExists().forPath("/zk_lock");
                if (null != stat) {
                    // Dot the transaction
                    try {
                        System.out.println("线程：" + Thread.currentThread() + "开始执行");
                        Thread.sleep(1000);
                        System.out.println("线程：" + Thread.currentThread() + "执行结束");
                        // do some work inside of the critical section here
                    } finally {
//                    lock.release();
                        if (lock.isAcquiredInThisProcess()) {
                            System.out.println("lock release...");
                            lock.release();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
