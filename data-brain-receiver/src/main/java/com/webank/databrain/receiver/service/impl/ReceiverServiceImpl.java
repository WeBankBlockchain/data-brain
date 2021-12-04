package com.webank.databrain.receiver.service.impl;

import com.webank.databrain.common.enums.auth.TransferStatusEnum;
import com.webank.databrain.common.model.AuthToken;
import com.webank.databrain.common.processor.DataProcessPipeline;
import com.webank.databrain.common.utils.JsonUtils;
import com.webank.databrain.receiver.config.ReceiverConfig;
import com.webank.databrain.receiver.handler.AuthRecordHandler;
import com.webank.databrain.receiver.handler.DataTransferHandler;
import com.webank.databrain.receiver.handler.SignatureHandler;
import com.webank.databrain.receiver.model.RedirectRequestVO;
import com.webank.databrain.receiver.service.ReceiverService;
import com.webank.databrain.receiver.handler.CheckDataHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public class ReceiverServiceImpl implements ReceiverService {

    @Autowired
    private ReceiverConfig config;

    @Autowired
    private SignatureHandler signatureHandler;

    @Autowired
    private DataTransferHandler dataTransferHandler;

    @Autowired
    private CheckDataHandler checkDataHandler;

    @Autowired
    private AuthRecordHandler authRecordHandler;

    @Autowired
    private DataProcessPipeline dataProcessPipeline;

    @Override
    public void onProviderCallback(RedirectRequestVO redirectRequest) {
        //1. 检查提供方签名
        AuthToken authToken = JsonUtils.fromJson(redirectRequest.getToken(), AuthToken.class);
        this.signatureHandler.checkSignature(redirectRequest.getToken(), authToken.getAddress(), redirectRequest.getProviderSignature());

        //2. 申请向提供方取数
        byte[] data = this.dataTransferHandler.fetchData(authToken);

        //3. 取数后进行处理
        byte[] rawData = (byte[])this.dataProcessPipeline.process(data);

        //4. 数据检验
        this.checkDataHandler.checkData(rawData, authToken.getAuthRecordId());

        //5. 数据上链确认
        this.authRecordHandler.changeTransferState(authToken.getAuthRecordId(), TransferStatusEnum.Received);
        //6. 最终数据发送到业务
        this.handleFinalData(authToken.getAuthRecordId(), rawData);
    }

    protected void handleFinalData(String authRecord, byte[] data) {

    }



}
