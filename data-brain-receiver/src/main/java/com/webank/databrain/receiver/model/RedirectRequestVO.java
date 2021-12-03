package com.webank.databrain.receiver.model;

import lombok.Data;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/03
 */
@Data
public class RedirectRequestVO {

    /**
     * 访问令牌
     */
    private String token;

    /**
     * 提供方签名
     */
    private String providerSignature;

}
