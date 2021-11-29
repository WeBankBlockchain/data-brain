package com.webank.databrain.provider.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Component
public class DataProcessRegistry
{
    private List<DataProcessor> dataProcessorList;

    @Autowired
    public DataProcessRegistry(List<DataProcessor> dataProcessorList) {
        this.dataProcessorList = dataProcessorList;
    }

    public synchronized void registerProcessor(DataProcessor dataProcessor) {
        this.dataProcessorList.add(dataProcessor);
    }

    public synchronized Object process(Object data){
        Object input = data;
        for(int i=0;i<dataProcessorList.size();i++){
            DataProcessor processor = dataProcessorList.get(i);
            input = processor.process(input);
        }
        return input;
    }
}
