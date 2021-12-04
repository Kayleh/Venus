package com.kayleh.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/12/4 20:10
 * @Since: 1.0.0
 */
public class loginController {
    @GetMapping("/toLogin")
    public String read() {
        return "login";
    }
}
