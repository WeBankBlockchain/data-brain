package com.webank.databrain.provider.service;

import com.webank.databrain.common.enums.auth.AuthStatusEnum;
import com.webank.databrain.provider.manager.AuthRecordManager;
import com.webank.databrain.common.model.AuthToken;
import com.webank.databrain.provider.manager.AuthTokenManager;
import com.webank.databrain.provider.model.authentication.AuthorizeInfo;
import com.webank.databrain.provider.model.authentication.CredentialInfo;
import com.webank.databrain.provider.error.ProviderErrorCode;
import com.webank.databrain.provider.error.ProviderException;
import com.webank.databrain.provider.handler.NotificationHandler;
import com.webank.databrain.provider.handler.validate.AuthorizeValidateHandler;
import com.webank.databrain.provider.handler.validate.CredentialValidateHandler;
import com.webank.databrain.provider.model.AuthenticateRequestVO;
import com.webank.databrain.provider.model.CredentialValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Service
public class AuthenticationService {

    @Autowired
    private AuthorizeValidateHandler authorizeValidateHandler;

    @Autowired
    private CredentialValidateHandler credentialValidateHandler;

    @Autowired
    private AuthRecordManager authRecordManager;

    @Autowired
    private NotificationHandler notificationHandler;

    @Autowired
    private AuthTokenManager authTokenManager;

    public void authenticate(AuthenticateRequestVO authenticateRequestVO){
        CredentialInfo credentialInfo = authenticateRequestVO.getCredentialInfo();
        AuthorizeInfo authorizeInfo = authenticateRequestVO.getAuthorizeInfo();
        // 1. 核验用户身份
        CredentialValidationResult credentialValidationResult = this.credentialValidateHandler.validateUserCredential(authenticateRequestVO);
        if(!credentialValidationResult.isSuccess()){
            throw new ProviderException(ProviderErrorCode.ID_NOT_AUTHENTICATED, credentialValidationResult.getReason());
        }
        // 2. 检查用户是否进行过授权
        authorizeValidateHandler.validateAuthorizeInfo(authorizeInfo);
        // 3. 更新认证授权状态
        authRecordManager.updateAuthenticationStatus(authorizeInfo.getAuthRecordId(), AuthStatusEnum.Authenticated_By_Provider);
        // 4. 生成令牌，并通知接受方
        AuthToken authToken = authTokenManager.generateToken();
        notificationHandler.notifyReceiver(authenticateRequestVO.getRedirectUrl(), authToken);
        authTokenManager.saveToken(authToken);
    }


}
