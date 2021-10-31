package com.kayleh.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/10/31 20:09
 * @Since: 1.0.0
 */
@RestController
@RequestMapping("user")
public class AuthController {
    @GetMapping("login")
    public String login() {
        return "Hello SpringSecurity";
    }
}
