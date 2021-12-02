package com.webank.databrain.provider.model.authentication.impl;

import com.webank.databrain.provider.model.authentication.ICredentialData;
import lombok.Data;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
@Data
public class UsernamePwd implements ICredentialData {

    private String username;

    private String password;

}
