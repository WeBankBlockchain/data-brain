package com.webank.databrain.provider.handler;

import com.webank.databrain.common.enums.auth.AuthStatusEnum;
import com.webank.databrain.common.model.AuthRecord;
import com.webank.databrain.common.model.DataSchema;

/**
 * 进行授权存证的状态更新
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class AuthenticationHandler {

    /**
     * 更新认证状态
     * @param authRecordId
     */
    public void updateAuthenticationStatus(long authRecordId, AuthStatusEnum authStatus){}

    /**
     *
     * @param authRecordId
     * @param evidence
     */
    public void recordEvidence(long authRecordId, byte[] evidence){}

    /**
     *
     * @param authRecordID
     * @return
     */
    public AuthRecord getAuthRecordById(long authRecordID) {
        return null;
    }

    public DataSchema getMetadataById(String schemaId) {
        return null;
    }
}
