package com.webank.databrain.common.processor;

import java.util.ArrayList;
import java.util.List;

public class DataProcessPipeline
{
    private List<DataProcessor> dataProcessorList;

    public DataProcessPipeline() {
        this.dataProcessorList = new ArrayList<>();
    }

    public synchronized DataProcessPipeline registerProcessor(DataProcessor dataProcessor) {
        this.dataProcessorList.add(dataProcessor);
        return this;
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