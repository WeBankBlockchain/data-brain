package com.webank.databrain.provider.model;

import com.webank.databrain.common.model.authenticate.AuthorizeInfo;
import com.webank.databrain.common.model.authenticate.CredentialInfo;
import lombok.Data;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Data
public class AuthenticateInfoVO {

    /**
     * 用户身份验证信息
     */
    private CredentialInfo credentialInfo;

    /**
     * 用户授权信息
     */
    private AuthorizeInfo authorizeInfo;

    /**
     * 重定向URL
     */
    private String redirectUrl;

    /**
     * 时间戳
     */
    private long ts;

}
