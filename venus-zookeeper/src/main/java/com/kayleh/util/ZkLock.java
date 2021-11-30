package com.kayleh.util;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class ZkLock {

    @SneakyThrows
    public static void main(String[] args) {
        test();

//        final String connectString = "localhost:3317,localhost:3317,localhost:3317";
//
//        // 重试策略，初始化每次重试之间需要等待的时间，基准等待时间为1秒。
//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//
//        // 使用默认的会话时间（60秒）和连接超时时间（15秒）来创建 Zookeeper 客户端
//        @Cleanup CuratorFramework client = CuratorFrameworkFactory.builder().
//                connectString(connectString).
//                connectionTimeoutMs(15 * 1000).
//                sessionTimeoutMs(60 * 100).
//                retryPolicy(retryPolicy).
//                build();
//
//        // 启动客户端
//        client.start();
//
//        final String lockNode = "/lock_node";
//        InterProcessMutex lock = new InterProcessMutex(client, lockNode);
//        try {
//            // 1. Acquire the mutex - blocking until it's available.
//            lock.acquire();
//
//            // OR
//
//            // 2. Acquire the mutex - blocks until it's available or the given time expires.
//            if (lock.acquire(60, TimeUnit.MINUTES)) {
//                Stat stat = client.checkExists().forPath(lockNode);
//                if (null != stat) {
//                    // Dot the transaction
//                }
//            }
//        } finally {
//            if (lock.isAcquiredInThisProcess()) {
//                System.out.println("lock release...");
//                lock.release();
//            }
//        }
    }

    public static void test() {
        CuratorFramework client = ZookeeperClientUtil.getCuratorFramework();

        InterProcessMutex lock = new InterProcessMutex(client, "/mylock");
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                if (lock.acquire(5, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " 获得了锁");
                    lock.release();
                } else
                    System.out.println(Thread.currentThread().getName() + " 没拿到锁");
            } catch (Exception e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }, "一号线程").start();

        new Thread(() -> {
            try {
                if (lock.acquire(5, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " 获得了锁");
                    lock.release();
                } else
                    System.out.println(Thread.currentThread().getName() + " 没拿到锁");
            } catch (Exception e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }, "二号线程").start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
