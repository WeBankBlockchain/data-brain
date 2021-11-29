package com.webank.databrain.provider.process;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public interface DataProcessor<TIn, TOut> {

    TOut process(TIn in);

}
