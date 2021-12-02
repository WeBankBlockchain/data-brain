package com.webank.databrain.common.processor;

import com.webank.databrain.common.enums.fetch.ProcessTypeEnum;

public interface DataProcessor<TIn, TOut> {

    TOut process(TIn in);

    ProcessTypeEnum processType();
}