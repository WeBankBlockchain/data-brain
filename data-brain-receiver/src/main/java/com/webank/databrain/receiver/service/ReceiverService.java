package com.webank.databrain.receiver.service;

import com.webank.databrain.receiver.model.RedirectRequestVO;
import com.webank.databrain.receiver.spi.CheckDataHandler;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
public interface ReceiverService {

    /**
     * 接收到令牌
     * @param redirectRequestVO
     */
    void onTokenReceived(RedirectRequestVO redirectRequestVO);

    /**
     * 数据请求
     */
    byte[] obtainData(String consumerId, String authRecordId);

    /**
     * 拦截器处理
     */
    void interceptorHandle(byte[] data);

    /**
     * 数据校验
     */
    void checkData(CheckDataHandler handler);

    /**
     * 数据确认上链
     */
    void confirmData(String authRecordId, int transferState);



}
