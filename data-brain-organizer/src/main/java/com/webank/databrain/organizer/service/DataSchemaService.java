package com.webank.databrain.organizer.service;

import com.webank.databrain.common.model.AccountResponse;
import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.common.model.DataSchema;

public class DataSchemaService {

    public AccountResponse register(DataSchema dataSchema) {
        return  new AccountResponse();
    }

    public CommonResponse unregister(String schemaId) {
        return new CommonResponse();
    }

    public CommonResponse upgrade(DataSchema dataSchema) {
        return null;
    }

    public CommonResponse close(String schemaId) {
        return null;
    }

}
