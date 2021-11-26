package com.webank.databrain.provider.service;

import com.webank.databrain.provider.error.ProviderErrorCode;
import com.webank.databrain.provider.error.ProviderException;
import com.webank.databrain.provider.handler.AuthenticationHandler;
import com.webank.databrain.provider.model.AuthenticateInfoVO;
import com.webank.databrain.provider.spi.credential.UserCredentialAuthenticator;
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
        if(!this.userCredentialAuthenticator.isCredentialChecked(userInfo)){
            throw new ProviderException(ProviderErrorCode.ID_NOT_AUTHENTICATED, userInfo);
        }

        // 2. 检查用户是否进行过授权
        String authRecordID = authenticateInfoVO.getAuthRecordId();
      //  authHandler.getR
    }

}
