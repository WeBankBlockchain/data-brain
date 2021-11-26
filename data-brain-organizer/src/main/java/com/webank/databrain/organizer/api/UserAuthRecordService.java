package com.webank.databrain.organizer.api;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface UserAuthRecordService extends AuthRecordService{

    void createAuthRecord();

    void revoke(long authRecordId);

}
