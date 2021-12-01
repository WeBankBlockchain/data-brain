package com.webank.databrain.common.model;

import lombok.Data;

@Data
public  class CommonDataResponse<T> extends CommonResponse{
    private T data;
}
