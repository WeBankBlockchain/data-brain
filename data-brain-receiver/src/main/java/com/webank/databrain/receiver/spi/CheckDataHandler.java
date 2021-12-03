package com.webank.databrain.receiver.spi;

import com.webank.databrain.receiver.model.HandleContext;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface CheckDataHandler {

    /**
     * 数据校验
     */
    void checkData(HandleContext context);

}
