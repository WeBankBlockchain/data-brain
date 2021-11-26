package com.webank.databrain.consumer.spi;

import com.webank.databrain.consumer.model.HandleContext;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface InterceptorHandler<T> {

    /**
     * 服务实现
     * @param data
     * @param context
     */
    void interceptorHandle(byte[] data, HandleContext<T> context);

}
