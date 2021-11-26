package com.webank.databrain.provider.config;

import com.webank.databrain.provider.spi.credential.UserCredentialAuthenticator;
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

    /**
     * 通过类似SPI方式，让用户自己决定怎么检验身份
     * @return
     * @throws Exception
     */
    @Bean
    public UserCredentialAuthenticator loadUserCredentialHandler() throws Exception{
        Class clazz = Class.forName(this.providerConfig.getUserCredentialImplClass());
        Constructor constructor = clazz.getConstructor();
        return (UserCredentialAuthenticator) constructor.newInstance();
    }

}
