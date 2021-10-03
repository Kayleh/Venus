package com.kayleh.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 生成唯一id
 * @Author: Kayleh
 * @Date: 2021/9/22 13:25
 * @Since: 1.0.0
 */
public class IdUtil {
    private static volatile SnowflakeIdWorker snowflakeIdWorker;
    private static final String PRIMARYKEY_WORKERID = "primarykey.workerid";
    private static final ReentrantLock LOCK = new ReentrantLock();


    /*
        雪花算法，获取分布式唯一id
     */
    public static long getPrimaryKey() {
        if (snowflakeIdWorker == null) {
            LOCK.lock();
            try {
                if (snowflakeIdWorker == null) {
                    // 此处是把机器ID存放到配置文件中进行读取
                    // 数据中心ID则是通过Zookeeper去进行管理获取
                    // snowflakeIdWorker = new SnowflakeIdWorker(Long.valueOf(PropertiesUtil.getProperty(PRIMARYKEY_WORKERID)),DataCenterConfig.getDataCenterID());
                    snowflakeIdWorker = new SnowflakeIdWorker(1L, 2L);
                }
            } finally {
                LOCK.unlock();
            }
        }
        return snowflakeIdWorker.nextId();
    }

    /*
        UUID 32位
     */
    public static String uuid32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        long temp;
        for (int i = 0; i < 99; i++) {
            System.out.println(uuid32());
        }

        Set<Long> set = new HashSet<>();

        for (int i = 0; i < 99; i++) {
            long l1 = System.currentTimeMillis();
            long primaryKey = IdUtil.getPrimaryKey();
            long l2 = System.currentTimeMillis();
            set.add(primaryKey);
            System.out.println(primaryKey);
            System.out.println("生成1个用时" + (l2 - l1) + "毫秒");
        }
        long r = System.currentTimeMillis();
        System.out.println(set.size());
        System.out.println("总" + (r - l) + "毫秒");
    }
}
