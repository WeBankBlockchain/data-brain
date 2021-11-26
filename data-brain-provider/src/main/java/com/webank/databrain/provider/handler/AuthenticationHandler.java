package com.webank.databrain.provider.handler;

import com.webank.databrain.common.enums.AuthStatusEnum;
import com.webank.databrain.provider.config.ProviderConfig;

import java.io.InputStream;

/**
 * 进行授权存证的状态更新
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class AuthenticationHandler {

    /**
     * 验证授权凭证是否已经用户授权
     * @param authRecordId
     * @throws Exception
     */
    void verifyAuthenticationStatus(String authRecordId) throws Exception{}

    /**
     * 更新认证状态
     * @param authRecordId
     */
    void updateAuthenticationStatus(String authRecordId, AuthStatusEnum a){}

    /**
     * 上传数据存证，更新存证状态
     * @param authRecordId
     * @param dataInputStream
     * @param providerConfig
     * @throws Exception
     */
    void recordData(String authRecordId, InputStream dataInputStream, ProviderConfig providerConfig) throws Exception{}

}
