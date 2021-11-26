package com.webank.databrain.provider.controller;

import com.webank.databrain.provider.model.AuthenticateInfoVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@RestController("api/provider/authenticate")
public class AuthenticationController {

    @PostMapping("/")
    public void authenticate(AuthenticateInfoVO authenticateInfoVO){

    }

    public void authenticate() {

    }

}
