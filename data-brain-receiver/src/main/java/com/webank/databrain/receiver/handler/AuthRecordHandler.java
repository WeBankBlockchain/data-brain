package com.webank.databrain.receiver.handler;


import com.webank.databrain.common.model.AuthRecord;

/**
 * 进行授权存证的状态更新
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class AuthRecordHandler {

    /**
     * 更新传输状态
     * @param authRecordId
     */
    public void changeTransferState(String authRecordId, int transferState){}
    /**
     * 获取授权记录
     * @param authRecordID
     * @return
     */
    public AuthRecord getAuthRecordById(String authRecordId) {
        return null;
    }

}
