package com.webank.databrain.provider.service;

import org.springframework.stereotype.Service;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class AuthenticationService {

    /**
     * 身份核验
     * @param authRecordId 授权记录ID
     * @param redirectUrl 重定向URL
     */
    void authenticate(String authRecordId, String redirectUrl) throws Exception{}

    /**
     * 提供方人员可以做的事情：
     * 机构注册
     * 上传数据目录
     * 更新存证
     * 验证授权
     * 上传数据目录
     * 从用例角度考虑
     * 提供数据，常规操作
     * 为每个产品开发一个服务，这个服务包含数据上传、数据传输、数据校验等
     */

}
