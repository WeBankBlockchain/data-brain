package com.webank.databrain.provider.controller;

import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.provider.model.AuthenticateInfoVO;
import com.webank.databrain.provider.service.DataTransferService;
import org.fisco.bcos.sdk.utils.Numeric;
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

    @PostMapping("/")
    public CommonResponse fetchData(@RequestBody AuthenticateInfoVO authenticateInfoVO) throws Exception{
        Object data = dataTransferService.fetchData(authenticateInfoVO.getAuthRecordId());
        return CommonResponse.success(data);
    }

}
