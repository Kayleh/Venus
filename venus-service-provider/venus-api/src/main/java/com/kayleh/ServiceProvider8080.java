package com.kayleh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 启用服务发现
public class ServiceProvider8080 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider8080.class, args);
    }
}
