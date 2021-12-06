package com.webank.databrain.witness.api;

/**
 * 用于验证用户的身份、地址是否匹配
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
public interface UserKeyMatchApi {

    boolean verifyUserMatch(String userId, String userAddress);

}
