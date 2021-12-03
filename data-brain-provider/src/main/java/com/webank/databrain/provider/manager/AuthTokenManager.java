package com.webank.databrain.provider.manager;

import com.webank.databrain.common.model.AuthToken;
import org.springframework.stereotype.Component;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/03
 */
@Component
public class AuthTokenManager {

    /**
     * 生成Token
     * @return
     */
    public AuthToken generateToken() {
        return null;
    }

    /**
     * 保存Token
     * @param token
     */
    public void saveToken(AuthToken token) {

    }

    /**
     * 检查Token
     * @param authToken
     */
    public void verifyToken(AuthToken authToken) {

    }

    /**
     * 删除Token
     * @param authToken
     */
    public void deleteToken(AuthToken authToken) {

    }

}



