package com.webank.databrain.receiver.config;

import com.webank.databrain.receiver.model.ProviderInfo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @author wesleywang
 * @Description
 * @date 2021/11/26
 */
@Configuration
@ConfigurationProperties("receiver")
@Data
public class ReceiverConfig {

    /**
     * 授权合约的地址
     */
    private String authRecordAddress;

    /**
     * 接收方私钥
     */
    private String hexPrivateKey;

    /**
     * 组织方URL
     */
    private String organizerUrl;

    /**
     * 提供方信息列表
     */
    private String providerConfigPath = "providers.json";

    /**
     * 数据处理顺序安排
     */
    private List<Integer> dataProcessHints;
}
