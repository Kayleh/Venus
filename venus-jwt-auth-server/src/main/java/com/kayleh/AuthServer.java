package com.kayleh;

import com.kayleh.config.RsaKeyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@MapperScan("com.kayleh.mapper")
@EnableConfigurationProperties(RsaKeyProperties.class)
public class AuthServer {

    public static void main(String[] args) {
        SpringApplication.run(AuthServer.class,args);
    }
}
