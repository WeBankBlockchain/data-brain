package com.webank.databrain.witness.service;

import com.webank.databrain.common.model.BlockchainTransaction;
import com.webank.databrain.common.model.CommonDataResponse;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;

public class ChainTransactionService {

    public long getBlockNumber() {
        return 0;
    }

    public CommonDataResponse<TransactionResponse> sendToBlockchain(BlockchainTransaction blockchainTransaction) {
        return null;
    }

    public CommonDataResponse<TransactionResponse> getTransactionResponse(String txHash) {
        return null;
    }
}
