package com.webank.databrain.witness.api;

import com.webank.databrain.common.model.User;
import com.webank.databrain.common.model.AccountResponse;

public interface UserKeyApi {
    public <R extends AccountResponse> R createPrivateKey(User user);

    public  <R extends AccountResponse> R getAccountInfo(User user);

    public String sign(String userId, String tx);
}
