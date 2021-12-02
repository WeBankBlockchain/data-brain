package com.webank.databrain.provider.handler.validate;

import com.webank.databrain.common.enums.auth.UserCredentialModeEnum;
import com.webank.databrain.common.model.authenticate.ICredentialData;
import com.webank.databrain.common.model.authenticate.CredentialInfo;
import com.webank.databrain.provider.error.ProviderErrorCode;
import com.webank.databrain.provider.error.ProviderException;
import com.webank.databrain.provider.authenticator.CredentialAuthenticator;
import com.webank.databrain.provider.model.CredentialValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 身份核验处理器
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
@Component
public class CredentialValidateHandler {

    private Map<UserCredentialModeEnum, CredentialAuthenticator> authenticators;

    @Autowired
    public CredentialValidateHandler(List<CredentialAuthenticator> authenticatorList) {
        this.authenticators = new HashMap<>();
        for(CredentialAuthenticator authenticator: authenticatorList){
            authenticators.put(authenticator.supportedMode(), authenticator);
        }
    }

    /**
     * 核验用户身份
     * @param credentials
     * @return
     */
    public CredentialValidationResult validateUserCredential(CredentialInfo credentials) {
        //1. Get authenticator by authenticate mode
        UserCredentialModeEnum credentialMode = UserCredentialModeEnum.getEnumByCode(credentials.getCredentialAuthMode());
        CredentialAuthenticator authenticator = this.authenticators.get(credentialMode);
        if(authenticator == null){
            throw new ProviderException(ProviderErrorCode.INVALID_CREDENTIAL_MODE, credentials.getCredentialAuthMode());
        }

        //2. Convert input model
        ICredentialData userInfo = authenticator.convert(credentials.getCredentialInfo());

        //3. Do authenticate
        return authenticator.validCredential(userInfo);
    }

}
