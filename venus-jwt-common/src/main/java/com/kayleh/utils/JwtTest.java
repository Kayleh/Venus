package com.kayleh.utils;

import org.junit.jupiter.api.Test;

/**
 * @desp: 子模块 生成rsa公钥和私钥测试类
 * @author: power by Kayleh, 2021/11/12 15:08
 * @params:
 * @return:
 * @since: 1.0.0
 */
public class JwtTest {
    //生成秘钥存放的路径
    private String privateKey = "D:/project/Venus/venus-jwt-common/src/main/resources/id_key_rsa";
    private String publicKey = "D:/project/Venus/venus-jwt-common/src/main/resources/id_key_rsa.pub";

    @Test
    public void test1() throws Exception {
        RsaUtils.generateKey(publicKey, privateKey, "kayleh", 1024);
    }

}
