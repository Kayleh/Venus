package com.kayleh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/11/3 16:06
 * @Since: 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperApplication.class, args);
    }
}
