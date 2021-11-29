package com.webank.databrain.consumer.spi;

import com.webank.databrain.consumer.model.HandleContext;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface InterceptorHandler {

    /**
     * 服务实现
     * @param context
     */
    void interceptorHandle(HandleContext context);

}
