package com.webank.databrain.provider.handler.validate;

import com.webank.databrain.common.enums.auth.UserCredentialModeEnum;
import com.webank.databrain.common.utils.JsonUtils;
import com.webank.databrain.provider.config.ProviderConfig;
import com.webank.databrain.provider.model.AuthenticateRequestVO;
import com.webank.databrain.provider.validator.SignatureValidator;
import com.webank.databrain.provider.validator.UserAddressValidator;
import com.webank.databrain.provider.model.authentication.ICredentialData;
import com.webank.databrain.provider.model.authentication.CredentialInfo;
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

    /**
     * 签名验证器
     */
    private SignatureValidator signatureValidator;

    /**
     * 地址验证器
     */
    private UserAddressValidator addressValidator;

    /**
     * 身份验证器
     */
    private Map<UserCredentialModeEnum, CredentialAuthenticator> authenticators;

    private ProviderConfig providerConfig;

    @Autowired
    public CredentialValidateHandler(List<CredentialAuthenticator> authenticatorList,
                                     SignatureValidator signatureValidator,
                                     UserAddressValidator addressValidator, ProviderConfig providerConfig) {
        this.signatureValidator = signatureValidator;
        this.addressValidator = addressValidator;
        this.authenticators = new HashMap<>();
        for(CredentialAuthenticator authenticator: authenticatorList){
            authenticators.put(authenticator.supportedMode(), authenticator);
        }
        this.providerConfig = providerConfig;
    }



    /**
     * 核验用户身份
     * @return
     */
    public CredentialValidationResult validateUserCredential(AuthenticateRequestVO request) {
        // 1. 验证签名
        String msg = this.toMsg(request);
        String address = request.getAuthorizeInfo().getUserAddress();
        String signature = request.getSignature();
        this.signatureValidator.validateSignature(msg, address, signature);
        // 2. 验证地址
        UserCredentialModeEnum credentialMode = UserCredentialModeEnum.getEnumByCode(providerConfig.getCredentialAuthMode());
        CredentialAuthenticator authenticator = this.authenticators.get(credentialMode);
        CredentialInfo credentialInfo = request.getCredentialInfo();
        ICredentialData typedCredentialInfo = authenticator.convert(credentialInfo.getCredentialInfo());
        this.addressValidator.validateAddress(typedCredentialInfo.getIdType(), typedCredentialInfo.getId(), address);
        // 3. 验证身份
        return authenticator.validCredential(typedCredentialInfo);
    }



    private String toMsg(AuthenticateRequestVO authenticateRequestVO) {
        StringBuilder sb = new StringBuilder();
        sb.append(JsonUtils.toJson(authenticateRequestVO.getCredentialInfo()));
        sb.append(JsonUtils.toJson(authenticateRequestVO.getAuthorizeInfo()));
        sb.append(authenticateRequestVO.getRedirectUrl());
        sb.append(authenticateRequestVO.getState());
        sb.append(authenticateRequestVO.getTs());
        return sb.toString();
    }
}
