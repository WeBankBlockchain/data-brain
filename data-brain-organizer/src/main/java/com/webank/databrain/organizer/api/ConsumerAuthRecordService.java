package com.webank.databrain.organizer.api;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface ConsumerAuthRecordService extends AuthRecordService{

    void changeTransferState(long authRecordId, int transferState);

}
