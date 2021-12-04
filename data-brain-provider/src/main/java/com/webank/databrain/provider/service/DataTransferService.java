package com.webank.databrain.provider.service;

import com.webank.databrain.common.enums.auth.AuthStatusEnum;
import com.webank.databrain.common.enums.auth.TransferStatusEnum;
import com.webank.databrain.common.processor.DataProcessPipeline;
import com.webank.databrain.provider.handler.DataSchemaHandler;
import com.webank.databrain.provider.manager.AuthRecordManager;
import com.webank.databrain.common.model.AuthRecord;
import com.webank.databrain.common.model.AuthToken;
import com.webank.databrain.common.model.DataSchema;
import com.webank.databrain.common.utils.JsonUtils;
import com.webank.databrain.provider.error.ProviderErrorCode;
import com.webank.databrain.provider.error.ProviderException;
import com.webank.databrain.provider.handler.EvidenceHandler;
import com.webank.databrain.provider.handler.FetchHandler;
import com.webank.databrain.provider.model.FetchRequestVO;
import com.webank.databrain.provider.process.ProviderProcessors;
import com.webank.databrain.provider.utils.DataProcessUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class DataTransferService {

    @Autowired
    private AuthRecordManager authManager;

    @Autowired
    private DataSchemaHandler dataSchemaHandler;

    @Autowired
    private EvidenceHandler evidenceHandler;

    @Autowired
    private FetchHandler fetchHandler;

    @Autowired
    private ProviderProcessors processors;


    /**
     * 下载数据
     * @throws Exception
     */
    public Object fetchData(FetchRequestVO fetchRequest) throws Exception{
        String token = fetchRequest.getToken();
        AuthToken authToken = JsonUtils.fromJson(token, AuthToken.class);
        String authRecordId = authToken.getAuthRecordId();
        //1. 验证用户已经授权过
        AuthRecord authRecord = authManager.getAuthRecordById(authRecordId);
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
        DataSchema schema = this.dataSchemaHandler.getSchemaById(schemaId);
        if(schema == null){
            throw new ProviderException(ProviderErrorCode.SCHEMA_NOT_FOUND, authRecordId);
        }
        byte[] data = this.fetchHandler.fetch(schema);
        //3. Upload evidence
        byte[] evidence = this.evidenceHandler.generateEvidence(data);
        this.authManager.recordEvidence(authRecordId, evidence);
        //4. Data post process
        List<String> inBoundProcessors = fetchRequest.getInBoundProcessors();
        List<String> outBoundProcessors = DataProcessUtils.toOutBoundProcessors(inBoundProcessors);
        DataProcessPipeline dataProcessPipeline = DataProcessUtils.toPipeline(processors, outBoundProcessors);
        Object handledData = dataProcessPipeline.process(data);
        //5. Modify status
        this.authManager.changeTransferStatus(authRecordId, TransferStatusEnum.Sent);
        return handledData;
    }

}
