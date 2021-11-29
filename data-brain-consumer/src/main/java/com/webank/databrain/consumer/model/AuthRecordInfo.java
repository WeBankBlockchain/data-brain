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

    private boolean state;

    private long sequence;

}
