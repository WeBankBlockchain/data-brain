package com.webank.databrain.provider.service;

import com.webank.databrain.common.model.DataDir;
import com.webank.databrain.provider.config.ProviderConfig;

import java.io.InputStream;

/**
 * 数据目录处理器
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class DataDirService {

    /**
     * 加载数据目录
     * @param inputStream
     * @return
     */
    DataDir loadDataDir(InputStream inputStream){return null;}

    /**
     * 部署数据目录合约
     * @param dataDir
     * @param config
     */
    void uploadDataDir(DataDir dataDir, ProviderConfig config){}

}
