package com.webank.databrain.witness.service;

import com.webank.databrain.common.model.AuthRecord;
import com.webank.databrain.common.model.CommonDataResponse;
import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.witness.blockchain.AuthRecordManager;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthRecordService {
    @Autowired
    private AuthRecordManager authRecordManager;

    public CommonDataResponse<AuthRecord> create(AuthRecord authRecord){
        authRecordManager.create(authRecord);
        return null;
    }

    public CommonResponse revoke(String authRecordId) {
        authRecordManager.revoke(authRecordId);
        return null;
    }

    public CommonDataResponse<AuthRecord> query(String authRecordId) {
        authRecordManager.query(authRecordId);
        return null;
    }

}
