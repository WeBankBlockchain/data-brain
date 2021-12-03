package com.webank.databrain.provider.manager;

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
    public void updateAuthenticationStatus(String authRecordId, AuthStatusEnum authStatus){}

    /**
     * 存证信息上链
     * @param authRecordId
     * @param evidence
     */
    public void recordEvidence(String authRecordId, byte[] evidence){}

    /**
     * 获取授权凭证完整信息
     * @param authRecordID
     * @return
     */
    public AuthRecord getAuthRecordById(String authRecordID) {
        return null;
    }

}
