package com.webank.databrain.receiver.handler;

import com.webank.databrain.receiver.model.BizDataContext;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
public interface CustomizeHandler<T extends BizDataContext> {

    void handleBusinessData(T bizData);

}
