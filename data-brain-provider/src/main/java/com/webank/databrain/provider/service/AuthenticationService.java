package com.webank.databrain.provider.service;

import org.springframework.stereotype.Service;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class AuthenticationService {

    /**
     * 身份验证
     * @param username
     * @param password
     */
    boolean authenticateCredential(String url, String userid){return false;}

    /**
     * 授权核验
     * @param authRecordId 授权记录ID
     * @param redirectUrl 重定向URL
     */
    void authenticate(String authRecordId, String redirectUrl) throws Exception{}



}
