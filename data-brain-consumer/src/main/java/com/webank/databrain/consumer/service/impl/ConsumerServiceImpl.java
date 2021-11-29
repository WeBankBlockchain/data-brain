package com.webank.databrain.consumer.service.impl;

import com.webank.databrain.consumer.service.ConsumerService;
import com.webank.databrain.consumer.spi.CheckDataHandler;
import com.webank.databrain.consumer.spi.InterceptorHandler;
import com.webank.databrain.consumer.spi.InterceptorHandlerRegistry;

import java.util.List;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public class ConsumerServiceImpl implements ConsumerService {


    @Override
    public byte[] obtainData(String consumerId, String authRecordId) {
        return new byte[0];
    }

    @Override
    public void interceptorHandle(byte[] data, InterceptorHandlerRegistry registry) {
        List<InterceptorHandler> interceptorHandlers = registry.getInterceptorHandler();
        interceptorHandlers.forEach(e -> {

        });
    }

    @Override
    public void checkData(CheckDataHandler handler) {

    }

    @Override
    public void confirmData(long authRecordId, int transferState) {

    }
}
