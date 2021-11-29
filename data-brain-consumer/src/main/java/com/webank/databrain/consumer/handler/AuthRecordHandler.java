package com.webank.databrain.consumer.handler;


import com.webank.databrain.common.model.AuthRecord;
import com.webank.databrain.common.model.MetaData;

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
    public void changeTransferState(long authRecordId, int transferState){}
    /**
     * 获取授权记录
     * @param authRecordID
     * @return
     */
    public AuthRecord getAuthRecordById(long authRecordID) {
        return null;
    }


    /**
     * 获取元数据
     * @param schemaId
     * @return
     */
    public MetaData getMetadataById(String schemaId) {
        return null;
    }
}
