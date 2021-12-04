package com.webank.databrain.common.model;

import com.webank.databrain.common.model.CommonResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AccountResponse extends CommonResponse {
    private String externalAccount;
}
