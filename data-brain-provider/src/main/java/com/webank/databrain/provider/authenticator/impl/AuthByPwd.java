package com.webank.databrain.provider.authenticator.impl;

import com.webank.databrain.common.constants.UserCredentialConstants;
import com.webank.databrain.common.enums.auth.UserCredentialModeEnum;
import com.webank.databrain.provider.model.authentication.impl.UserIdPwd;
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
public class AuthByPwd implements CredentialAuthenticator<UserIdPwd> {

    @Autowired
    private ProviderConfig providerConfig;

    @Override
    public UserIdPwd convert(Map<String, Object> userCredentialInfo) {
        UserIdPwd userIdPwd = new UserIdPwd();
        userIdPwd.setUserId(userCredentialInfo.get(UserCredentialConstants.USERNAME).toString());
        userIdPwd.setPassword(userCredentialInfo.get(UserCredentialConstants.PASSWORD).toString());
        return userIdPwd;
    }

    @Override
    public CredentialValidationResult validCredential(UserIdPwd userInfo) {
        return null;
    }

    @Override
    public UserCredentialModeEnum supportedMode() {
        return UserCredentialModeEnum.IdNoPwd;
    }
}










