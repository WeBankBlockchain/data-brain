package com.webank.databrain.common.model.authenticate;

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
     * 认证模式，具体和CredentialAuthMode保持一致
     */
    private int credentialAuthMode;

    /**
     * 认证数据。后续将会转换成ICredentialData
     */
    private Map<String, Object> credentialInfo;

}
