package com.webank.databrain.receiver.model;

import lombok.Data;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
@Data
public class AuthReceiveRequestVO {

    /**
     * 授权凭证
     */
    private String authRecordId;

    /**
     * 通常表示当前用户办理业务的流水请求
     */
    private String requestContext;

}
