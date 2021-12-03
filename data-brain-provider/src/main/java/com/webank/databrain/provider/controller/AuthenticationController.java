package com.webank.databrain.provider.controller;

import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.provider.model.AuthenticateRequestVO;
import com.webank.databrain.provider.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实现双层核验：身份核验 + 授权核验
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@RestController("api/provider/authenticate")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/")
    public CommonResponse authenticate(@RequestBody AuthenticateRequestVO authenticateRequestVO){
        authenticationService.authenticate(authenticateRequestVO);
        return CommonResponse.success();
    }
}
