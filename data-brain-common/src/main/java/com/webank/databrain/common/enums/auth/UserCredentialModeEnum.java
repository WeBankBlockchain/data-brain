package com.webank.databrain.common.enums.auth;

import lombok.Getter;

/**
 * 身份认证模式
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
@Getter
public enum UserCredentialModeEnum {

    /**
     * 身份证号+密码
     */
    IdNoPwd(0, IdTypeEnum.IdNo),

    /**
     * 手机号+验证码
     */
    PhoneValidationCode(1, IdTypeEnum.Phone);

    private int code;
    private IdTypeEnum credentialType;

    UserCredentialModeEnum(int code, IdTypeEnum idTypeEnum){
        this.code = code;
        this.credentialType = idTypeEnum;
    }

    public static UserCredentialModeEnum getEnumByCode(int code){
        for(UserCredentialModeEnum e: UserCredentialModeEnum.values()){
            if(e.code == code){
                return e;
            }
        }
        throw new RuntimeException("Invalid credential mode :"+code);
    }
}
