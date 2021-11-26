package com.webank.databrain.provider.model;

import lombok.Data;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Data
public class AuthenticateInfoVO {

    /**
     * 用户信息，可以是身份证号等
     */
    private Object userInfo;

    /**
     * 授权记录ID
     */
    private String authRecordId;

    /**
     * 重定向URL
     */
    private String redirectUrl;

    /**
     * 时间戳
     */
    private long ts;

}
