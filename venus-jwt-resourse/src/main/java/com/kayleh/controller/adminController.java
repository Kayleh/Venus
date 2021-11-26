package com.kayleh.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/11/25 15:03
 * @Since: 1.0.0
 */
@RestController
@RequestMapping("/admin")
public class adminController {
    //读写权限
    @GetMapping("/read-or-write")
    @PreAuthorize("hasAnyAuthority('read','write')")
    public String readWriteDate() {
        return "have a read or write authority";
    }

    //admin角色
    @GetMapping("/admin-role")
    @PreAuthorize("hasRole('ADMIN')")
    public String readAdmin() {
        return "have a admin role";
    }

    @RequestMapping("/query")
    public String query() {
        return "success";
    }
}
