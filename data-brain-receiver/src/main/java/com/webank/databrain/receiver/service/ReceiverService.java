package com.webank.databrain.receiver.service;

import com.webank.databrain.receiver.model.AuthReceiveRequestVO;
import com.webank.databrain.receiver.model.RedirectRequestVO;

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
    void onProviderCallback(RedirectRequestVO redirectRequestVO);

    void onAuthRecordReceived(AuthReceiveRequestVO request);
}
