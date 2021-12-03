package com.webank.databrain.provider.authenticator;

import com.webank.databrain.common.enums.auth.UserCredentialModeEnum;
import com.webank.databrain.provider.model.authentication.ICredentialData;
import com.webank.databrain.provider.model.CredentialValidationResult;

import java.util.Map;

/**
 * 用户身份认证器
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public interface CredentialAuthenticator<T extends ICredentialData> {

    T convert(Map<String, Object> userCredentialInfo);

    /**
     * 验证用户身份
     * @param userInfo
     * @return
     */
    CredentialValidationResult validCredential(T userInfo);

    UserCredentialModeEnum supportedMode();
}
