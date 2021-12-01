package com.webank.databrain.provider.handler.validate;

import com.webank.databrain.common.enums.auth.AuthStatusEnum;
import com.webank.databrain.common.manager.AuthRecordManager;
import com.webank.databrain.common.model.AuthRecord;
import com.webank.databrain.common.model.authenticate.AuthorizeInfo;
import com.webank.databrain.provider.error.ProviderErrorCode;
import com.webank.databrain.provider.error.ProviderException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 授权核验处理器
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
public class AuthorizeValidateHandler {

    @Autowired
    private AuthRecordManager authRecordManager;

    /**
     * 核验用户授权
     */
    public void validateAuthorizeInfo(AuthorizeInfo authorizeInfo){
        long authRecordID = authorizeInfo.getAuthRecordId();
        AuthRecord authRecord = authRecordManager.getAuthRecordById(authRecordID);
        if(authRecord == null){
            throw new ProviderException(ProviderErrorCode.AUTH_RECORD_NOT_FOUND, authRecordID);
        }
        AuthStatusEnum authStatusEnum = AuthStatusEnum.getEnumByCode(authRecord.getAuthState());
        if(authStatusEnum != AuthStatusEnum.Authenticated_By_Witness){
            throw new ProviderException(ProviderErrorCode.USER_NOT_AUTH, authRecordID);
        }
    }
}
