package com.webank.databrain.provider.process;

import java.util.List;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class DataProcessRegistry
{
    private List<DataProcessor> dataProcessorList;

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
