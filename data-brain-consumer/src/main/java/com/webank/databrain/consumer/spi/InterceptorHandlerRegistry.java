package com.webank.databrain.consumer.spi;

import java.util.List;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface InterceptorHandlerRegistry {

    /**
     * 获取服务实现的拦截器
     * @return set
     */
    List<InterceptorHandler> getInterceptorHandler();

    /**
     * 注册一个拦截器
     */
    void registerInterceptorHandler(InterceptorHandler handler);

}
