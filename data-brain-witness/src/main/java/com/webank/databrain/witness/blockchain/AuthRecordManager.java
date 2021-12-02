package com.webank.databrain.witness.blockchain;

import com.webank.databrain.common.model.AuthRecord;
import org.fisco.bcos.sdk.transaction.model.dto.CallResponse;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;

public class AuthRecordManager {
    public TransactionResponse create(AuthRecord authRecord){
        return null;
    }

    public TransactionResponse revoke(String authRecordId) {
        return null;
    }

    public CallResponse query(String authRecordId) {
        return null;
    }
}
