package com.webank.databrain.receiver.api;

import com.webank.databrain.receiver.model.AuthRecordInfo;
import com.webank.databrain.receiver.model.RedirectRequestVO;
import com.webank.databrain.receiver.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
@RestController("api/consumer")
public class CallbackController {
    @Autowired
    private ReceiverService receiverService;


    /**
     * 授权回调
     */
    @PostMapping("organizer/callback")
    public void callbackByOrganizer(@RequestBody AuthRecordInfo authRecordInfo){

    }


    /**
     * 授权回调
     */
    @PostMapping("provider/callback")
    public void callbackByProvider(@RequestBody RedirectRequestVO redirectRequestVO){
        receiverService.onProviderCallback(redirectRequestVO);
    }

}
