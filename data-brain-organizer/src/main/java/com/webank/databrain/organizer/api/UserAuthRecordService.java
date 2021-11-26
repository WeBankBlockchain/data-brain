package com.webank.databrain.organizer.api;

import com.webank.databrain.common.model.AuthRecord;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface UserAuthRecordService extends AuthRecordService{

    void createAuthRecord(AuthRecord authRecord);

    void revoke(long authRecordId);

}
