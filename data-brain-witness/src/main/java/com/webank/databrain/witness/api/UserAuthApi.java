package com.webank.databrain.witness.api;

import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.common.model.User;

public interface UserAuthApi {

    public <R extends CommonResponse> R authentication(User user);


}
