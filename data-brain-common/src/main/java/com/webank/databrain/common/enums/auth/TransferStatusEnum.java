package com.webank.databrain.common.enums.auth;

import lombok.Getter;

/**
 * 传输状态
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Getter
public enum TransferStatusEnum {

    /**
     * 待发送
     */
    UnSent(0),

    /**
     * 已发送
     */
    Sent(1),

    /**
     * 已成功接收
     */
    Received(2),

    /**
     * 校验错误
     */
    DataError(3);

    private int code;

    TransferStatusEnum(int code){
        this.code = code;
    }


}
