package com.kayleh.utils;

import org.junit.jupiter.api.Test;

/**
 * @desp: 生成rsa公钥和私钥测试类
 * @author: power by Kayleh, 2021/11/12 15:08
 * @params:
 * @return:
 * @since: 1.0.0
 */
public class JwtTest {
    private String privateKey = "c:/tools/auth_key/id_key_rsa";

    private String publicKey = "c:/tools/auth_key/id_key_rsa.pub";

    @Test
    public void test1() throws Exception{
        RsaUtils.generateKey(publicKey,privateKey,"dpb",1024);
    }

}
