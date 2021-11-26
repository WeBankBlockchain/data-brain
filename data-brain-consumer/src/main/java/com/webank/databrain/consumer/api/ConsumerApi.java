package com.webank.databrain.consumer.api;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface ConsumerApi {

    /**
     * 见证方授权回调
     */
    void callbackByOrganizer(String authRecordId);


    /**
     * 提供方授权回调
     */
    void callbackByProducer(boolean state);

}
