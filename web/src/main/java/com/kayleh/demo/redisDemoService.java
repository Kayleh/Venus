package com.kayleh.demo;

import com.kayleh.domain.User;
import com.kayleh.result.CodeMsg;
import com.kayleh.result.Result;
import com.kayleh.utils.redis.RedisServiceUtil;
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
    RedisServiceUtil redisServiceUtil;

    public Result setCache(User user) {
        boolean set = redisServiceUtil.set(UserKey.getUserByUserId, user.getId(), user);
        CodeMsg codeMsg = new CodeMsg();
        codeMsg.setCode(200);
        codeMsg.setMsg("成功");
        return Result.success(codeMsg);
    }

    public void getCache(String userId) {
        redisServiceUtil.get(UserKey.getUserByUserId, userId, User.class);
    }


}
