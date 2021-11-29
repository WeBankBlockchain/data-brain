package com.webank.databrain.provider.spi;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public interface UserCredentialAuthenticator {

    boolean validCredential(Object userInfo);

}
