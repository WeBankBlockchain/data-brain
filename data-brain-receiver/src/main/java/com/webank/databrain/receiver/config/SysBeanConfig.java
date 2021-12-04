package com.webank.databrain.receiver.config;

import com.webank.databrain.common.processor.DataProcessPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SysBeanConfig {

    @Autowired
    private ReceiverConfig receiverConfig;

    @Bean
    public DataProcessPipeline pipeline() {
        return null;
    }


}
