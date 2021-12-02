package com.webank.databrain.common.model;

import lombok.Data;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/02
 */
@Data
public class AuthToken {

    /**
     * 授权凭证Id
     */
    private String authRecordId;

    /**
     * 随机码
     */
    private String randomCode;


}
