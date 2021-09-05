package com.kayleh.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/8/19 15:10
 * @Version: 1.0
 */
public class JSONUtil {
    public String toJSONString(Object target) {
        return JSON.toJSONString(target);
    }

    public static Object JSON2Obj(String source) {
        return JSONObject.parse(source);
    }

    public static void main(String[] args) {
    }
}
