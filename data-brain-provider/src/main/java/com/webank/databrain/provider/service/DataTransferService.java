package com.webank.databrain.provider.service;

import com.webank.databrain.common.enums.auth.AuthStatusEnum;
import com.webank.databrain.common.model.AuthRecord;
import com.webank.databrain.common.model.DataSchema;
import com.webank.databrain.provider.error.ProviderErrorCode;
import com.webank.databrain.provider.error.ProviderException;
import com.webank.databrain.provider.handler.AuthenticationHandler;
import com.webank.databrain.provider.handler.EvidenceHandler;
import com.webank.databrain.provider.handler.FetchHandler;
import com.webank.databrain.provider.process.DataProcessRegistry;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class DataTransferService {

    @Autowired
    private AuthenticationHandler authHandler;

    @Autowired
    private EvidenceHandler evidenceHandler;

    @Autowired
    private FetchHandler fetchHandler;

    @Autowired
    private DataProcessRegistry dataProcessRegistry;

    /**
     * 下载数据
     * @param authRecordId 授权记录ID
     * @throws Exception
     */
    public Object fetchData(long authRecordId) throws Exception{
        //1. 验证用户已经授权过
        AuthRecord authRecord = authHandler.getAuthRecordById(authRecordId);
        if(authRecord == null){
            throw new ProviderException(ProviderErrorCode.AUTH_RECORD_NOT_FOUND, authRecordId);
        }
        AuthStatusEnum authStatusEnum = AuthStatusEnum.getEnumByCode(authRecord.getAuthState());
        if(authStatusEnum != AuthStatusEnum.Authenticated_By_Provider) {
            throw new ProviderException(ProviderErrorCode.PROVIDER_NOT_AUTH, authRecordId);
        }
        //2. Extract Data
        String schemaId = authRecord.getSchemaId();
        if(schemaId == null){
            throw new ProviderException(ProviderErrorCode.SCHEMA_ID_NULL, authRecordId);
        }
        DataSchema schema = this.authHandler.getMetadataById(schemaId);
        if(schema == null){
            throw new ProviderException(ProviderErrorCode.SCHEMA_NOT_FOUND, authRecordId);
        }
        byte[] data = this.fetchHandler.fetch(schema);
        //3. Data post process
        Object handledData = (byte[])dataProcessRegistry.process(data);
        //4. Upload evidence
        byte[] evidence = this.evidenceHandler.generateEvidence(data);
        this.authHandler.recordEvidence(authRecordId, evidence);
        return handledData;
    }

}
