package com.webank.databrain.receiver.handler;


import com.webank.databrain.common.enums.auth.TransferStatusEnum;
import com.webank.databrain.common.model.AuthRecord;
import com.webank.databrain.receiver.model.AuthReceiveRequestVO;

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
    public void changeTransferState(String authRecordId, TransferStatusEnum transferState){}
    /**
     * 获取授权记录
     * @param authRecordId
     * @return
     */
    public AuthRecord getAuthRecordById(String authRecordId) {
        return null;
    }

    public void saveAuthRecord(AuthReceiveRequestVO request) {

    }
}
