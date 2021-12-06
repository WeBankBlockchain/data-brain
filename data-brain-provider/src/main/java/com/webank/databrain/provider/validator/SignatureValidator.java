package com.webank.databrain.provider.validator;

/**
 * 签名验证器
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
public interface SignatureValidator {

    void validateSignature(String msg, String address, String signature);

}
