package com.webank.databrain.receiver.handler;

import com.webank.databrain.common.model.AuthToken;
import com.webank.databrain.receiver.config.ReceiverConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用于向提供方取数
 * @author aaronchu
 * @Description
 * @date 2021/12/03
 */
@Component
public class DataTransferHandler {

    @Autowired
    private ReceiverConfig receiverConfig;

    /**
     * 向提供方申请取数
     * @param authToken 认证令牌。
     * @return
     */
    public byte[] fetchData(AuthToken authToken) {
        return null;
    }
}
