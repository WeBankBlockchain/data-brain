package com.webank.databrain.receiver.process;

import com.webank.databrain.common.enums.fetch.ProcessTypeEnum;
import com.webank.databrain.common.processor.DataProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class ReceiverProcessors extends HashMap<ProcessTypeEnum, DataProcessor> {

    @Autowired
    public ReceiverProcessors(List<DataProcessor> dataProcessors) {
        for(DataProcessor dataProcessor: dataProcessors) {
            this.put(dataProcessor.processType(), dataProcessor);
        }
    }


}
