package com.kayleh.controller;


import com.kayleh.entity.UserInfo;
import com.kayleh.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author kayleh
 * @since 2021-11-03
 */
@Controller
@RequestMapping("/api/user")
public class UserInfoController {
    @Autowired
    IUserInfoService userInfoService;

    @RequestMapping("get")
    public UserInfo get(){
        UserInfo byId = userInfoService.getById("1");
        System.out.println(byId.toString());
        return byId;
    }
}
