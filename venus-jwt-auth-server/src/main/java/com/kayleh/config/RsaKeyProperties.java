package com.kayleh.config;


import com.kayleh.utils.RsaUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;


/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/11/12 19:18
 * @Since: 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "rsa.key")
public class RsaKeyProperties {

    private String pubKeyFile;
    private String priKeyFile;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    /**
     * 系统启动的时候触发
     *
     * @throws Exception
     */
    @PostConstruct
    public void createRsaKey() throws Exception {
        publicKey = RsaUtils.getPublicKey(pubKeyFile);
        privateKey = RsaUtils.getPrivateKey(priKeyFile);
    }

}
