package com.kayleh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// 启用服务发现
@EnableDiscoveryClient
public class ServiceProvider8080 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider8080.class, args);
    }
}
