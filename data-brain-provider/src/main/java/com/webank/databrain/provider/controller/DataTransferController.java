package com.webank.databrain.provider.controller;

import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.provider.model.AuthenticateInfoVO;
import com.webank.databrain.provider.service.DataTransferService;
import org.fisco.bcos.sdk.utils.Numeric;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@RestController("api/provider/data")
public class DataTransferController {

    private DataTransferService dataTransferService;


    @GetMapping("/")
    //TODO:token包含了authRecordID
    //TODO:增加数据后置处理模式
    public CommonResponse fetchData(long authRecordID, String token, String signature) throws Exception{
        Object data = dataTransferService.fetchData(authRecordID);
        return CommonResponse.success(data);
    }

}
