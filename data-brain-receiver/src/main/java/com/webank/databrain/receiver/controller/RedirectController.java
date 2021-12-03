package com.webank.databrain.receiver.controller;

import com.webank.databrain.receiver.model.RedirectRequestVO;
import com.webank.databrain.receiver.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当用户在提供方完成认证后，提供方将会直接调用这个接口，完成令牌的传输
 * @author aaronchu
 * @Description
 * @date 2021/12/03
 */
@RestController("api/receiver/receiveToken")
public class RedirectController {

    @Autowired
    private ReceiverService receiverService;

    /**
     * 接收令牌
     */
    @PostMapping("/")
    public void receiveAuthToken(@RequestBody RedirectRequestVO redirectRequestVO) {
        receiverService.onTokenReceived(redirectRequestVO);
    }


}
