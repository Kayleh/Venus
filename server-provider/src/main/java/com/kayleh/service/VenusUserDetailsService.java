package com.kayleh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @desp: 自定义权限认证逻辑
 * @author: power by Kayleh, 2021/10/31 21:33
 * @params: 
 * @return: 
 * @since: 1.0.0
 */
@Component
public class VenusUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("用户的用户名: {}", username);
        // 根据用户名，查找到对应的密码，与权限

        String password = passwordEncoder.encode("123456");
        logger.info("password: {}", password);

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        //这里User对象的第三个参数，它表示的是当前用户的权限，我们将它设置为”admin”。
        User user = new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}

