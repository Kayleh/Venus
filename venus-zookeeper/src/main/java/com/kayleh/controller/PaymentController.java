package com.kayleh.controller;

import com.kayleh.util.ZookeeperClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Wizard
 * @Date: 2020/8/5 17:00
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/zk")
    public String zk() {
        return "Springcloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

    @RequestMapping("/lock")
    public void lock() {
        CuratorFramework client = ZookeeperClientUtil.getCuratorFramework();
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
