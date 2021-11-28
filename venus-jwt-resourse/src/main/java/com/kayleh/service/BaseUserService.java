package com.kayleh.service;

import com.kayleh.domain.UserVo;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/11/28 13:10
 * @Since: 1.0.0
 */
public interface BaseUserService {
    UserVo selectOne(UserVo baseUser);
}
