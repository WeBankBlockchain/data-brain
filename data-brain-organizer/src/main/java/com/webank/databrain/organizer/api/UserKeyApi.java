package com.webank.databrain.organizer.api;

import com.webank.databrain.common.model.User;
import com.webank.databrain.common.model.AccountResponse;

public interface UserKeyApi {
    public <R extends AccountResponse> R createPrivateKey(User user);

    public  <R extends AccountResponse> R getAccountInfo(User user);
}
