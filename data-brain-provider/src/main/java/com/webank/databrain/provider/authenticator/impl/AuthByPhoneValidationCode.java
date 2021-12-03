package com.webank.databrain.provider.authenticator.impl;

import com.webank.databrain.common.enums.auth.UserCredentialModeEnum;
import com.webank.databrain.provider.model.authentication.impl.PhoneValidationCode;
import com.webank.databrain.provider.authenticator.CredentialAuthenticator;
import com.webank.databrain.provider.model.CredentialValidationResult;

import java.util.Map;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
public class AuthByPhoneValidationCode implements CredentialAuthenticator<PhoneValidationCode> {


    @Override
    public PhoneValidationCode convert(Map<String, Object> userCredentialInfo) {
        return null;
    }

    @Override
    public CredentialValidationResult validCredential(PhoneValidationCode userInfo) {
        return null;
    }

    @Override
    public UserCredentialModeEnum supportedMode() {
        return null;
    }
}
