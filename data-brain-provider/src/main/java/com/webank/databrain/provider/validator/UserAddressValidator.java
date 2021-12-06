package com.webank.databrain.provider.validator;

import com.webank.databrain.common.enums.auth.IdTypeEnum;

/**
 * 验证用户的地址和身份是否一致
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
public interface UserAddressValidator {

    void validateAddress(IdTypeEnum idTypeEnum, String userId, String address);

}
