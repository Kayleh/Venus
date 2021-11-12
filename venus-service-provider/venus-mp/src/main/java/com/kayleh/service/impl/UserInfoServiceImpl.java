package com.kayleh.service.impl;

import com.kayleh.entity.UserInfo;
import com.kayleh.mapper.UserInfoMapper;
import com.kayleh.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author kayleh
 * @since 2021-11-03
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
