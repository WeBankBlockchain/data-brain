package com.webank.databrain.organizer.service;

import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.common.model.User;
import com.webank.databrain.organizer.api.UserAuthApi;
import com.webank.databrain.organizer.api.UserKeyApi;
import com.webank.databrain.common.model.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAccountService {
  @Autowired private UserAuthApi userAuthApi;
  @Autowired private UserKeyApi userKeyApi;

  public CommonResponse authentication(User user) {
    return userAuthApi.authentication(user);
  }

  public AccountResponse applyExternalAccount(User user) {
    return userKeyApi.createPrivateKey(user);
  }

  public AccountResponse getAccountInfo(User user) {
    return userKeyApi.getAccountInfo(user);
  }

  public String sign(String userId, String tx) {
      userKeyApi.sign(userId, tx);
      return null;
  }
}