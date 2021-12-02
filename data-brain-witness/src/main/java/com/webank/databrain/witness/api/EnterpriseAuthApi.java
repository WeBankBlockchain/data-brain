package com.webank.databrain.witness.api;

import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.common.model.Enterprise;
import com.webank.databrain.common.model.User;

public interface EnterpriseAuthApi {
    public <R extends CommonResponse> R authentication(Enterprise enterprise);

}
