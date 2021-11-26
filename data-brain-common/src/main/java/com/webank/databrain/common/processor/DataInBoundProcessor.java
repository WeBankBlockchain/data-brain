package com.webank.databrain.common.processor;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public interface DataInBoundProcessor {

    //TODO: 需要参考netty
    void processData(InputStream inputStream);
}
