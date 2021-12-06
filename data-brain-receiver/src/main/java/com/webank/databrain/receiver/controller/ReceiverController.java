package com.webank.databrain.receiver.controller;

import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.receiver.model.AuthReceiveRequestVO;
import com.webank.databrain.receiver.model.AuthRecordInfo;
import com.webank.databrain.receiver.model.RedirectRequestVO;
import com.webank.databrain.receiver.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 授权凭证ID
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
@RestController("api/receiver/auth")
public class ReceiverController {
    @Autowired
    private ReceiverService receiverService;

    /**
     * 从业务前端接收授权凭证
     * @return
     */
    @PostMapping()
    public CommonResponse receiveAuthRecord(@RequestBody AuthReceiveRequestVO request) {
        receiverService.onAuthRecordReceived(request);
        return CommonResponse.success();
    }

    /**
     * 授权回调
     */
    @PostMapping("provider/callback")
    public CommonResponse callbackByProvider(@RequestBody RedirectRequestVO redirectRequestVO){
        receiverService.onProviderCallback(redirectRequestVO);
        return CommonResponse.success();
    }

}
