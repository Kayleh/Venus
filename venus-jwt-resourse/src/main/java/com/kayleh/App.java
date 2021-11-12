package com.kayleh;

import com.kayleh.config.RsaKeyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@MapperScan("com.dpb.mapper")
@EnableConfigurationProperties(RsaKeyProperties.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
