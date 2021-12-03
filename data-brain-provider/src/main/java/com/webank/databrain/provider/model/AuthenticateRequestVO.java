package com.webank.databrain.provider.model;

import com.webank.databrain.provider.model.authentication.AuthorizeInfo;
import com.webank.databrain.provider.model.authentication.CredentialInfo;
import lombok.Data;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Data
public class AuthenticateRequestVO {

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
     * 用于防止CSRF攻击
     */
    private String state;

    /**
     * 时间戳
     */
    private long ts;

    /**
     * 用户对前述数据的签名
     */
    private String signature;

}
