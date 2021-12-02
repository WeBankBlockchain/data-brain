package com.webank.databrain.witness.blockchain;

import com.webank.databrain.common.model.Enterprise;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseManager {

    public TransactionResponse register(Enterprise enterprise){
        return null;
    }

    public TransactionResponse authenticateEnterpriseCert(String id, String hash) {
        return null;
    }

    public TransactionResponse modify(Enterprise enterprise){
        return null;
    }

    public TransactionResponse remove(String enterpriseId){
        return null;
    }
}
