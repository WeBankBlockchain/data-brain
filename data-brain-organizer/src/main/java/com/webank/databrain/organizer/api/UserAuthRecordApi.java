package com.webank.databrain.organizer.api;

import com.webank.databrain.common.model.AuthRecord;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface UserAuthRecordApi {

    public void createAuthRecord(AuthRecord authRecord);

    public void revoke(String authRecordId);

}
