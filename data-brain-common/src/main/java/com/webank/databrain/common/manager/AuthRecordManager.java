package com.webank.databrain.common.manager;

import com.webank.databrain.common.enums.auth.AuthStatusEnum;
import com.webank.databrain.common.model.AuthRecord;
import com.webank.databrain.common.model.DataSchema;

/**
 * 对AuthRecord进行增删改查
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
public class AuthRecordManager {

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
