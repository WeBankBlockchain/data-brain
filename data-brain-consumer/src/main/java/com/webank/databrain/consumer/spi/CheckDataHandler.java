package com.webank.databrain.consumer.spi;

import com.webank.databrain.consumer.model.HandleContext;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface CheckDataHandler<T> {

    /**
     * 数据校验
     */
    void checkData(HandleContext<T> context);

}
