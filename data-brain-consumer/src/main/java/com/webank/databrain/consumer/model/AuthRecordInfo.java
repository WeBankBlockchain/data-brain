package com.webank.databrain.consumer.model;

import lombok.Data;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
@Data
public class AuthRecordInfo{

    private long authRecordId;
    /**
     * 请求来源
     */
    private int originType;

    private boolean state;

}
