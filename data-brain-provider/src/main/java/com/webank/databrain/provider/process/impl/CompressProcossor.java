package com.webank.databrain.provider.process.impl;

import com.webank.databrain.common.processor.DataProcessor;
import org.springframework.stereotype.Component;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Component
public class CompressProcossor implements DataProcessor<byte[], byte[]> {
    @Override
    public byte[] process(byte[] input) {
        return new byte[0];
    }
}
