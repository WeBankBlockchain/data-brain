package com.webank.databrain.receiver.api;

import com.webank.databrain.receiver.model.AuthUserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/29
 */
@RestController("api/callback")
public class ConsumerController {

    /**
     * 前端传回授权请求信息
     */
    @PostMapping("userAuth")
    public void userAuth(@RequestBody AuthUserInfo authUserInfo){

    }


}
