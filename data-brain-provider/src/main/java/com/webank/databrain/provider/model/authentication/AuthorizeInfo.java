package com.webank.databrain.provider.model.authentication;

import lombok.Data;

/**
 * 授权核验信息
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
@Data
public class AuthorizeInfo {

    /**
     * 授权记录ID
     */
    private String authRecordId;

    /**
     * 用户公钥地址
     */
    private String userAddress;

}
