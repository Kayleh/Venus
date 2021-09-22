package com.kayleh.utils;

import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 生成唯一id
 * @Author: Kayleh
 * @Date: 2021/9/22 13:25
 * @Since: 1.0.0
 */
public class IdUtil {
    /*
        UUID 32位的随机id
        缺点：无序，索引失效
     */
    public String uuid32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private static volatile SnowflakeIdWorker snowflakeIdWorker;
    private static final String PRIMARYKEY_WORKERID = "primarykey.workerid";
    private static final ReentrantLock LOCK = new ReentrantLock();

    /*
        雪花算法，获取分布式唯一id
     */
    private static SnowflakeIdWorker getSnowflakeIdWorker() {
        if (snowflakeIdWorker == null) {
            LOCK.lock();
            try {
                if (snowflakeIdWorker == null) {
                    // 此处是把机器ID存放到配置文件中进行读取
                    //数据中心ID则是通过Zookeeper去进行管理获取
                    // snowflakeIdWorker = new SnowflakeIdWorker(Long.valueOf(PropertiesUtil.getProperty(PRIMARYKEY_WORKERID)),DataCenterConfig.getDataCenterID());
                    snowflakeIdWorker = new SnowflakeIdWorker(1L, 2L);
                }
            } finally {
                LOCK.unlock();
            }
        }
        return snowflakeIdWorker;
    }
    public static long getPrimaryKey() {
        return getSnowflakeIdWorker().nextId();
    }


    public static void main(String[] args) {
        for (int i = 0; i < 99; i++) {
            long primaryKey = IdUtil.getPrimaryKey();
            System.out.println(primaryKey);
        }

    }
}
