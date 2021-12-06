package com.webank.databrain.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public  class CommonDataResponse<T> extends CommonResponse{
    private T data;

    public static <TData> CommonDataResponse success(TData data){
        CommonDataResponse commonDataResponse = new CommonDataResponse();
        commonDataResponse.setCode(CommonResponse.OK);
        commonDataResponse.setData(data);
        return commonDataResponse;
    }
}
