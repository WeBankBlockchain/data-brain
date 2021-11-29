package com.webank.databrain.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

    public static int OK = 200;

    private int code;

    private String message;

    private Object data;

    public static CommonResponse success(){
        return new CommonResponse(OK, null, null);
    }

    public static CommonResponse success(Object data){
        return new CommonResponse(OK, null, data);
    }
}
