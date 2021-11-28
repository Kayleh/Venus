package com.kayleh.service.impl;

import com.kayleh.domain.UserVo;
import com.kayleh.mapper.BaseUserMapper;
import com.kayleh.service.BaseUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/11/28 13:23
 * @Since: 1.0.0
 */
@Service
@Transactional
public class BaseUserServiceImpl implements BaseUserService {
    @Resource
    BaseUserMapper baseUserMapper;
    @Override
    public UserVo selectOne(UserVo baseUser) {
        UserVo userVo = baseUserMapper.selectOne(baseUser);
        return userVo;
    }
}
