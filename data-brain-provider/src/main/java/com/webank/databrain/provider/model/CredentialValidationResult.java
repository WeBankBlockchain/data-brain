package com.webank.databrain.provider.model;

import lombok.Data;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
@Data
public class CredentialValidationResult {

    private boolean success;

    private String reason;

}
