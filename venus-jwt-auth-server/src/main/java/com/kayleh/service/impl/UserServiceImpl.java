package com.kayleh.service.impl;

import com.kayleh.domain.UserPojo;
import com.kayleh.mapper.UserMapper;
import com.kayleh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserPojo user = mapper.queryByUserName(s);
        return user;
    }
}
