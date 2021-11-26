package com.webank.databrain.common.model;

import lombok.Data;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Data
public class CommonResponse {

    private int code;

    private String message;

    private Object data;

}
