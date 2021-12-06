package com.webank.databrain.receiver.model;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
public interface BizDataContext {

    /**
     * 获取业务信息
     * @return
     */
    String getRequestId();

    /**
     * 序列化
     * @param outputStream
     */
    void serialize(OutputStream outputStream);

    /**
     * 反序列化
     * @param inputStream
     */
    void deserialize(InputStream inputStream);
}
