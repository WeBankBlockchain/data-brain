package com.webank.databrain.common.model;

import com.webank.databrain.common.model.CommonResponse;
import lombok.Data;

@Data
public class AccountResponse extends CommonResponse {
    private String externalAccount;
}
