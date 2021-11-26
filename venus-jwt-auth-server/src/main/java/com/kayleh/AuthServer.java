package com.kayleh;

import com.kayleh.config.RsaKeyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@MapperScan("com.kayleh.mapper")
@EnableConfigurationProperties(RsaKeyProperties.class)
@EnableDiscoveryClient
public class AuthServer {
    public static void main(String[] args) {
        SpringApplication.run(AuthServer.class, args);
    }
}
