package com.kayleh.utils.redis;

/**
 * @Author: Kayleh
 * @Date: 2020/12/11 19:12
 */
public class UserKey extends BasePrefix {
    public UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getUserByUserId = new UserKey("user");
}
