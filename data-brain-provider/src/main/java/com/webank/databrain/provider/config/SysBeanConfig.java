package com.webank.databrain.provider.config;

import com.webank.databrain.common.enums.crypto.CryptoAlgorithmEnum;
import com.webank.databrain.provider.authenticator.CredentialAuthenticator;
import com.webank.databrain.provider.validator.SignatureValidator;
import com.webank.databrain.provider.validator.impl.ECDSASignatureValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Constructor;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Configuration
public class SysBeanConfig {

    @Autowired
    private ProviderConfig providerConfig;

    @Bean
    public SignatureValidator signatureValidator() {
        if(providerConfig.getSignatureAlg() == CryptoAlgorithmEnum.ECDSA){
            return new ECDSASignatureValidator();
        }
        throw new RuntimeException("Unsupported signature algorithm "+providerConfig.getSignatureAlg());
    }
}
