package com.kayleh.service;

import com.kayleh.domain.UserPojo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    int addUser(UserPojo user);
}
