package com.kayleh.controller;

import com.kayleh.domain.UserVo;
import com.kayleh.service.BaseUserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/11/28 13:08
 * @Since: 1.0.0
 */
public class BaseController {

    @Resource
    private BaseUserService baseUserService;

    /**
     * 获取当前用户
     *
     * @return
     */
    protected UserVo getCurrentUser() {
        //获取当前用户
//        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        //details里面可能存放了当前登录用户的详细信息，也可以通过cast后拿到
//        UserPojo userDetails = (UserPojo) authenticationToken.getDetails();
        //查询当前用户
        UserVo baseUser = new UserVo();
        // baseUser.setName(userDetails.getUsername());
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String principal = authenticationToken.getPrincipal().toString();
        baseUser.setUsername(principal);
        baseUser = baseUserService.selectOne(baseUser);
        if (baseUser == null)
            throw new RuntimeException("用户不存在");
//            throw new RuntimeException("用户不存在: " + userDetails.getUsername());
        return baseUser;
    }
}
