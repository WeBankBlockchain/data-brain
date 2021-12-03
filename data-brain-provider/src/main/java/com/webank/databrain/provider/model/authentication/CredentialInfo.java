package com.webank.databrain.provider.model.authentication;

import lombok.Data;

import java.util.Map;

/**
 * 身份核验信息
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
@Data
public class CredentialInfo {
    /**
     * 认证数据。后续将会转换成ICredentialData
     */
    private Map<String, Object> credentialInfo;

}
