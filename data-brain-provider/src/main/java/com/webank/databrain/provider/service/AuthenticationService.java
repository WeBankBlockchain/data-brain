package com.webank.databrain.provider.service;

import com.webank.databrain.common.enums.auth.AuthStatusEnum;
import com.webank.databrain.common.manager.AuthRecordManager;
import com.webank.databrain.common.model.authenticate.AuthorizeInfo;
import com.webank.databrain.common.model.authenticate.CredentialInfo;
import com.webank.databrain.provider.error.ProviderErrorCode;
import com.webank.databrain.provider.error.ProviderException;
import com.webank.databrain.provider.handler.NotificationHandler;
import com.webank.databrain.provider.handler.validate.UserKeyValidationHandler;
import com.webank.databrain.provider.handler.validate.AuthorizeValidateHandler;
import com.webank.databrain.provider.handler.validate.CredentialValidateHandler;
import com.webank.databrain.provider.model.AuthenticateInfoVO;
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
    private UserKeyValidationHandler userKeyValidationHandler;

    @Autowired
    private AuthorizeValidateHandler authorizeValidateHandler;

    @Autowired
    private CredentialValidateHandler credentialValidateHandler;

    @Autowired
    private AuthRecordManager authRecordManager;

    @Autowired
    private NotificationHandler notificationHandler;

    public String authenticate(AuthenticateInfoVO authenticateInfoVO){
        CredentialInfo credentialInfo = authenticateInfoVO.getCredentialInfo();
        AuthorizeInfo authorizeInfo = authenticateInfoVO.getAuthorizeInfo();
        // 1. 用户地址认证
        this.userKeyValidationHandler.validateUserKeys(credentialInfo, authorizeInfo);
        // 2. 核验用户身份
        CredentialValidationResult credentialValidationResult = this.credentialValidateHandler.validateUserCredential(credentialInfo);
        if(!credentialValidationResult.isSuccess()){
            throw new ProviderException(ProviderErrorCode.ID_NOT_AUTHENTICATED, credentialValidationResult.getReason());
        }

        // 3. 检查用户是否进行过授权
        authorizeValidateHandler.validateAuthorizeInfo(authorizeInfo);

        //4. 更新认证授权状态
        authRecordManager.updateAuthenticationStatus(authorizeInfo.getAuthRecordId(), AuthStatusEnum.Authenticated_By_Provider);
        //5. 通知接收方取数
        //TODO: 需要一个随机码，具体参考OAUTH/JWT
     //   notificationHandler.notifyReceiver(authenticateInfoVO.getRedirectUrl(), authenticateInfoVO.getUserInfo(), authenticateInfoVO.getUserAddress());
        return "String";
    }


}
