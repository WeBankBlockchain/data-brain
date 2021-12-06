package com.webank.databrain.provider.model.authentication;

import com.webank.databrain.common.enums.auth.IdTypeEnum;

/**
 * Marker interface
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
public interface ICredentialData {

    /**
     * 身份认证类型
     * @return
     */
    IdTypeEnum getIdType();

    /**
     * 表示用户的核心ID信息
     * @return
     */
    String getId();



}
