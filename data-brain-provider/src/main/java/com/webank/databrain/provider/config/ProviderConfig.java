package com.webank.databrain.provider.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Configuration
@ConfigurationProperties("provider")
@Data
public class ProviderConfig {

    /**
     * 授权合约的地址
     */
    private String authRecordAddress;

    /**
     * 提供方私钥
     */
    private String hexPrivateKey;

    /**
     * 用户身份凭证检验实现接口
     */
    private String userCredentialImplClass;

    /**
     * 认证模式，具体和CredentialAuthMode保持一致
     */
    private int credentialAuthMode;

    /**
     * 组织方地址信息
     */
    private Witness witness;

    @ConfigurationProperties("witness")
    @Data
    public static class Witness {
        private String url;
    }
}
