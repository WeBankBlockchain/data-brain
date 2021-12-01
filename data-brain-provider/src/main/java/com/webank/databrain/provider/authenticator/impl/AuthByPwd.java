package com.webank.databrain.provider.authenticator.impl;

import com.webank.databrain.common.enums.auth.UserCredentialModeEnum;
import com.webank.databrain.common.model.authenticate.impl.UsernamePwd;
import com.webank.databrain.provider.config.ProviderConfig;
import com.webank.databrain.provider.authenticator.CredentialAuthenticator;
import com.webank.databrain.provider.model.CredentialValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
@Component
public class AuthByPwd implements CredentialAuthenticator<UsernamePwd> {

    @Autowired
    private ProviderConfig providerConfig;

    @Override
    public UsernamePwd convert(Map<String, Object> userCredentialInfo) {
        UsernamePwd usernamePwd = new UsernamePwd();
        usernamePwd.setUsername(userCredentialInfo.get);
    }

    @Override
    public CredentialValidationResult validCredential(UsernamePwd userInfo) {
        return null;
    }

    @Override
    public UserCredentialModeEnum supportedMode() {
        return UserCredentialModeEnum.UsernamePwd;
    }
}










