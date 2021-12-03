package com.webank.databrain.provider.controller;

import com.webank.databrain.common.model.CommonDataResponse;
import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.provider.model.FetchRequestVO;
import com.webank.databrain.provider.service.DataTransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public CommonResponse fetchData(FetchRequestVO fetchRequest) throws Exception{
        Object data = dataTransferService.fetchData(fetchRequest);
        return CommonDataResponse.success(data);
    }

}
