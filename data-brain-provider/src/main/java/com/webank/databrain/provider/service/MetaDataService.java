package com.webank.databrain.provider.service;

import com.webank.databrain.common.model.MetaData;
import com.webank.databrain.provider.config.ProviderConfig;

import java.io.InputStream;

/**
 * 数据目录处理器
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class MetaDataService {

    /**
     * 加载数据目录
     * @param inputStream
     * @return
     */
    MetaData loadMetaData(InputStream inputStream){return null;}

    /**
     * 部署数据目录合约
     * @param metaData
     * @param config
     */
    void uploadMetaData(MetaData metaData, ProviderConfig config){}

}
