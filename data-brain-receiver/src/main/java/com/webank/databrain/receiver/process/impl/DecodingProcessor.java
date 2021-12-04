package com.webank.databrain.receiver.process.impl;

import com.webank.databrain.common.enums.fetch.ProcessTypeEnum;
import com.webank.databrain.common.processor.DataProcessor;

public class DecodingProcessor implements DataProcessor<byte[], byte[]> {
    @Override
    public byte[] process(byte[] bytes) {
        return new byte[0];
    }

    @Override
    public ProcessTypeEnum processType() {
        return ProcessTypeEnum.Encoding;
    }
}
