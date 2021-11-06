package com.kayleh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: Wizard
 * @Date: 2020/8/4 15:57
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain8001.class, args);
    }
}
