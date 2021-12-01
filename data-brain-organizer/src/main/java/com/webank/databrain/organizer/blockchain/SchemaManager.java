package com.webank.databrain.organizer.blockchain;

import com.webank.databrain.common.model.DataSchema;
import org.fisco.bcos.sdk.transaction.model.dto.CallResponse;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.springframework.stereotype.Service;

@Service
public class SchemaManager {

    public TransactionResponse register(DataSchema dataSchema) {
        return null;
    }

    public TransactionResponse upgrade(DataSchema dataSchema) {
        return null;
    }

    public TransactionResponse close(String schemaId) {
        return null;
    }

    public CallResponse query(String schemaId) {
        return null;
    }

}
