package com.kayleh.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/10/31 20:09
 * @Since: 1.0.0
 */
@RestController
@RequestMapping("user")
public class AuthController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("login")
    public String login() {
        return "springcloud with zookeeper：" + serverPort + "	" + UUID.randomUUID();
    }
}
