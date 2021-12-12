package com.kayleh.controller;

import com.kayleh.domain.UserPojo;
import com.kayleh.domain.UserVo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/11/25 15:03
 * @Since: 1.0.0
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {
    //读写权限
    @GetMapping("/read-or-write")
    @PreAuthorize("hasAnyAuthority('read','write')")
    @Cacheable
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
    @Secured("ROLE_ADMIN")
    public String query() {
        return "success";
    }

    @PreAuthorize("#age>98")//age参数必须大于98
    public String getAge(Integer age) {
        return String.valueOf(age);
    }

    @RequestMapping("/get")
    @Secured("ROLE_ADMIN")
    public String get(Principal principal) {
        UserVo currentUser = getCurrentUser();

        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        //details里面可能存放了当前登录用户的详细信息，也可以通过cast后拿到
        UserPojo userDetails = (UserPojo) authenticationToken.getDetails();
        String name = principal.getName();
        return "success";
    }

    @GetMapping("/currentusername")
    public String currentUserName(@CurrentSecurityContext(expression = "authentication")
                                          Authentication authentication) {
        Object details = authentication.getDetails();
        return authentication.getName();
    }

    @RequestMapping("/currentUser")
    public String currentUser() {
        UserVo currentUser = getCurrentUser();
        return currentUser.toString();
    }
}
