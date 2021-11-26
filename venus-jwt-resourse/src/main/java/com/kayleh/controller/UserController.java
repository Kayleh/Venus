package com.kayleh.controller;

import com.kayleh.domain.UserPojo;
import com.kayleh.mapper.UserMapper;
import com.kayleh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;

    @GetMapping("/role")
    @PreAuthorize("hasRole('USER')")
    public String read() {
        return "have a USER role";
    }

    @RequestMapping("/query")
    public String query() {
        return "have a USER role";
    }

    @RequestMapping("/update")
    public String update() {
        return "update";
    }

    @PostMapping("/register")
    public UserPojo register(@RequestBody UserPojo user) {
        //对密码进行加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int i = userService.addUser(user);
        return user;
    }
}
