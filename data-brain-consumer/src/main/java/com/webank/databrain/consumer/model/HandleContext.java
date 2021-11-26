package com.webank.databrain.consumer.model;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface HandleContext<T> {

    T getParseData();

    String getDataHash();

    String getAuthRecordId();

}
