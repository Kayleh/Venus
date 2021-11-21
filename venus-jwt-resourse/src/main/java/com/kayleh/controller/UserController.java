package com.kayleh.controller;

import com.kayleh.domain.UserPojo;
import com.kayleh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;


    @RequestMapping("/query")
    public String query() {
        return "success";
    }

    @RequestMapping("/update")
    public String update() {
        return "update";
    }

    @PostMapping("/register")
    public UserPojo register(@RequestBody(required = false) UserPojo user) {
        //对密码进行加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.addUser(user);
        return user;
    }
}
