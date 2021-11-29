package com.webank.databrain.consumer.service;

import com.webank.databrain.consumer.model.HandleContext;
import com.webank.databrain.consumer.spi.CheckDataHandler;
import com.webank.databrain.consumer.spi.InterceptorHandlerRegistry;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface ConsumerService {

    /**
     * 数据请求
     */
    byte[] obtainData(String consumerId, String authRecordId);

    /**
     * 拦截器处理
     */
    void interceptorHandle(byte[] data, InterceptorHandlerRegistry registry);

    /**
     * 数据校验
     */
    void checkData(CheckDataHandler handler);

    /**
     * 数据确认上链
     */
    void confirmData(long authRecordId, int transferState);


}
