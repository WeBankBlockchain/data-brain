package com.webank.databrain.provider.config;

/**
 * 数据访问配置
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class DataFetchConfig {

    /**
     * 查询协议，数据库、URL、认证信息等
     */
    private String fetchType;

    private String fetchUrl;

    private Object fetchExt;

}
