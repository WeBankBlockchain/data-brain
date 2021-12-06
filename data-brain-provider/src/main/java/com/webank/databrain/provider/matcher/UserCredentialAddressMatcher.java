package com.webank.databrain.provider.matcher;

/**
 * 验证用户的地址和身份是否一致
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
public interface UserCredentialAddressMatcher {

    boolean isMatch(String userId, String address);

}
