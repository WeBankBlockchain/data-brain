package com.webank.databrain.receiver.service.impl;

import com.webank.databrain.common.model.AuthToken;
import com.webank.databrain.common.utils.JsonUtils;
import com.webank.databrain.receiver.handler.AuthRecordHandler;
import com.webank.databrain.receiver.handler.DataTransferHandler;
import com.webank.databrain.receiver.model.RedirectRequestVO;
import com.webank.databrain.receiver.service.ReceiverService;
import com.webank.databrain.receiver.spi.CheckDataHandler;
import com.webank.databrain.receiver.spi.InterceptorHandler;
import com.webank.databrain.receiver.spi.InterceptorHandlerRegistry;
import com.webank.databrain.receiver.spi.SignatureHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public class ReceiverServiceImpl implements ReceiverService {

    @Autowired
    private SignatureHandler signatureHandler;

    @Autowired
    private DataTransferHandler dataTransferHandler;

    @Autowired
    private CheckDataHandler checkDataHandler;

    @Autowired
    private AuthRecordHandler authRecordHandler;

    @Autowired
    private InterceptorHandlerRegistry registry;

    @Override
    public void onTokenReceived(RedirectRequestVO redirectRequest) {
        //1. 检查提供方签名
        AuthToken authToken = JsonUtils.fromJson(redirectRequest.getToken(), AuthToken.class);
        this.signatureHandler.checkSignature(redirectRequest.getToken(), authToken.getAddress(), redirectRequest.getProviderSignature());

        //2. 申请向提供方取数
        //this.dataTransferHandler.fetchData();

        //3. 取数后进行处理

    }

    @Override
    public byte[] obtainData(String consumerId, String authRecordId) {
        return new byte[0];
    }

    @Override
    public void interceptorHandle(byte[] data) {
        List<InterceptorHandler> interceptorHandlers = registry.getInterceptorHandler();
        interceptorHandlers.forEach(e -> {

        });
    }

    @Override
    public void checkData(CheckDataHandler handler) {

    }

    @Override
    public void confirmData(String authRecordId, int transferState) {

    }
}
