package com.kayleh.mapper;

import com.kayleh.domain.UserVo;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/11/28 13:13
 * @Since: 1.0.0
 */
public interface BaseUserMapper {
    UserVo selectOne(UserVo baseUser);
}
