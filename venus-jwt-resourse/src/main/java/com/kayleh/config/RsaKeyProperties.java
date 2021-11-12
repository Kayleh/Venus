package com.kayleh.config;

import com.kayleh.utils.RsaUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

/**
 * @desp: 读取公钥的配置类
 * @author: power by Kayleh, 2021/11/12 19:49
 * @params:
 * @return:
 * @since: 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "rsa.key")
public class RsaKeyProperties {

    private String pubKeyFile;

    private PublicKey publicKey;

    /**
     * 系统启动的时候触发
     *
     * @throws Exception
     */
    @PostConstruct
    public void createRsaKey() throws Exception {
        publicKey = RsaUtils.getPublicKey(pubKeyFile);
    }

}
