package com.webank.databrain.consumer.api;

import com.webank.databrain.consumer.model.AuthRecordInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/26
 */
@RestController("api/consumer")
public class ConsumerController {

    /**
     * 授权回调
     */
    @PostMapping("/")
    public void callback(AuthRecordInfo authRecordInfo){

    }


}
