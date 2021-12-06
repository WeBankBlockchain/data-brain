package com.webank.databrain.witness.controller;

import com.webank.databrain.common.model.AccountResponse;
import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.common.model.User;
import com.webank.databrain.witness.api.UserKeyApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
@RestController()
@RequestMapping("api/witness/user")
public class UserKeyController implements UserKeyApi {
    @Override
    public <R extends AccountResponse> R createPrivateKey(User user) {
        return null;
    }

    @Override
    public <R extends AccountResponse> R getAccountInfo(User user) {
        return null;
    }

    @Override
    public String sign(String userId, String tx) {
        return null;
    }

    @Override
    @GetMapping("match")
    public CommonResponse verifyUserMatch(@RequestParam("idType") int idType,
                                          @RequestParam ("userId")String userId,
                                          @RequestParam("userAddress") String userAddress) {
        return CommonResponse.success();
    }
}
