package com.kayleh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: Wizard
 * @Date: 2020/8/5 17:00
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/zk")
    public String zk() {
        return "Springcloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
