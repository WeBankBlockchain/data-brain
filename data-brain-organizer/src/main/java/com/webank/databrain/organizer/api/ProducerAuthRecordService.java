package com.webank.databrain.organizer.api;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface ProducerAuthRecordService extends AuthRecordService{

    void uploadEvidence();

    void changeTransferState();
}
