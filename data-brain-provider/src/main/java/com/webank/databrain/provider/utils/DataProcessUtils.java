package com.webank.databrain.provider.utils;

import com.webank.databrain.common.enums.fetch.ProcessTypeEnum;
import com.webank.databrain.common.processor.DataProcessChain;
import com.webank.databrain.common.processor.DataProcessor;
import com.webank.databrain.provider.model.fetch.ProcessHint;
import com.webank.databrain.provider.process.ProviderProcessors;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/02
 */
@Slf4j
public class DataProcessUtils {

    public static DataProcessChain fromHints(ProviderProcessors providerProcessors, List<ProcessHint> hints) {
        DataProcessChain dataProcessChain = new DataProcessChain();
        for(int i=0;i<hints.size();i++) {
            int hintCode = hints.get(i).getTypeCode();
            ProcessTypeEnum processType = ProcessTypeEnum.getEnumByCode(hintCode);
            DataProcessor dataProcessor = providerProcessors.get(processType);
            dataProcessChain.registerProcessor(dataProcessor);
        }
        return dataProcessChain;
    }



}
