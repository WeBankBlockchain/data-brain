package com.webank.databrain.provider.process;

import com.webank.databrain.common.enums.fetch.ProcessTypeEnum;
import com.webank.databrain.common.processor.DataProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * 数据处理器集合
 * @author aaronchu
 * @Description
 * @date 2021/12/02
 */
@Component
public class ProviderProcessors extends HashMap<ProcessTypeEnum, DataProcessor> {

    @Autowired
    public ProviderProcessors(List<DataProcessor> dataProcessors) {
        for(DataProcessor dataProcessor: dataProcessors){
            ProcessTypeEnum processHint = dataProcessor.processType();
            this.put(processHint, dataProcessor);
        }
    }
}
