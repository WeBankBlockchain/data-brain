package com.webank.databrain.consumer.service.impl;

import com.webank.databrain.consumer.handler.AuthRecordHandler;
import com.webank.databrain.consumer.service.ConsumerService;
import com.webank.databrain.consumer.spi.CheckDataHandler;
import com.webank.databrain.consumer.spi.InterceptorHandler;
import com.webank.databrain.consumer.spi.InterceptorHandlerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import sun.net.www.protocol.http.AuthCache;

import java.util.List;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public class ConsumerServiceImpl implements ConsumerService {


    @Autowired
    private CheckDataHandler checkDataHandler;

    @Autowired
    private AuthRecordHandler authRecordHandler;

    @Autowired
    private InterceptorHandlerRegistry registry;

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
    public void confirmData(long authRecordId, int transferState) {

    }
}
