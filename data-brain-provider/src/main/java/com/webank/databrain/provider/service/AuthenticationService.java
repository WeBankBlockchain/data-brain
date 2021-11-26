package com.webank.databrain.provider.service;

import com.webank.databrain.common.enums.auth.AuthStatusEnum;
import com.webank.databrain.common.model.AuthRecord;
import com.webank.databrain.provider.error.ProviderErrorCode;
import com.webank.databrain.provider.error.ProviderException;
import com.webank.databrain.provider.handler.AuthenticationHandler;
import com.webank.databrain.provider.model.AuthenticateInfoVO;
import com.webank.databrain.provider.spi.UserCredentialAuthenticator;
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
    private AuthenticationHandler authHandler;

    @Autowired
    private UserCredentialAuthenticator userCredentialAuthenticator;

    public void authenticate(AuthenticateInfoVO authenticateInfoVO){
        // 1. 检查用户的身份是否已得到了核验
        Object userInfo = authenticateInfoVO.getUserInfo();
        if(!this.userCredentialAuthenticator.validCredential(userInfo)){
            throw new ProviderException(ProviderErrorCode.ID_NOT_AUTHENTICATED, userInfo);
        }

        // 2. 检查用户是否进行过授权
        long authRecordID = authenticateInfoVO.getAuthRecordId();
        AuthRecord authRecord = authHandler.getAuthRecordById(authRecordID);
        if(authRecord == null){
            throw new ProviderException(ProviderErrorCode.AUTH_RECORD_NOT_FOUND, authRecordID);
        }
        AuthStatusEnum authStatusEnum = AuthStatusEnum.getEnumByCode(authRecord.getAuthState());
        if(authStatusEnum != AuthStatusEnum.Authenticated_By_Organizer){
            throw new ProviderException(ProviderErrorCode.USER_NOT_AUTH, authRecordID);
        }
        //3. 更新认证授权状态
        authHandler.updateAuthenticationStatus(authRecordID, AuthStatusEnum.Authenticated_By_Provider);
    }

}
