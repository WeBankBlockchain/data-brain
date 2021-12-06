package com.webank.databrain.provider.model.authentication.impl;

import com.webank.databrain.common.enums.auth.IdTypeEnum;
import com.webank.databrain.provider.model.authentication.ICredentialData;
import lombok.Data;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
@Data
public class UserIdPwd implements ICredentialData {

    private String userId;

    private String password;

    @Override
    public IdTypeEnum getIdType() {
        return IdTypeEnum.IdNo;
    }

    @Override
    public String getId() {
        return userId;
    }
}
