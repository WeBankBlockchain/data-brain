package com.webank.databrain.provider.model.authentication;

import com.webank.databrain.common.enums.auth.UserCredentialModeEnum;
import lombok.Data;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/03
 */
@Data
public class AddressValidationData {

    /**
     * 认证模式
     */
    private UserCredentialModeEnum credentialMode;

    /**
     * 身份标识符
     */
    private String credentialIdentifier;

}
