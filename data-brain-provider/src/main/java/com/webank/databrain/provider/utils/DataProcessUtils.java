package com.webank.databrain.provider.utils;

import com.webank.databrain.common.enums.fetch.ProcessTypeEnum;
import com.webank.databrain.common.processor.DataProcessPipeline;
import com.webank.databrain.common.processor.DataProcessor;
import com.webank.databrain.provider.process.ProviderProcessors;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/02
 */
@Slf4j
public class DataProcessUtils {

    public static List<String> toOutBoundProcessors(List<String> inBoundProcessors) {
        int size = inBoundProcessors.size();
        List<String> outBoundProcessors = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            outBoundProcessors.add(inBoundProcessors.get(size - i - 1));
        }
        return outBoundProcessors;
    }

    public static DataProcessPipeline toPipeline(ProviderProcessors providerProcessors, List<String> outBoundProcessors) {
        DataProcessPipeline dataProcessChain = new DataProcessPipeline();
        for(int i=0;i<outBoundProcessors.size();i++) {
            String id = outBoundProcessors.get(i);
            ProcessTypeEnum processType = ProcessTypeEnum.getEnumById(id);
            DataProcessor dataProcessor = providerProcessors.get(processType);
            dataProcessChain.registerProcessor(dataProcessor);
        }
        return dataProcessChain;
    }





}
