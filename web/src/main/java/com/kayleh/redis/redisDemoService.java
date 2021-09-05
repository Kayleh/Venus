package com.kayleh.redis;

import com.kayleh.domain.User;
import com.kayleh.utils.redis.RedisService;
import com.kayleh.utils.redis.UserKey;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/9/5 20:37
 * @Since: 1.0.0
 */
public class redisDemoService {


    @Autowired
    RedisService redisService;

    public void setCache(User user) {
        redisService.set(UserKey.getUserByUserId, user.getId(), user);
    }


}
