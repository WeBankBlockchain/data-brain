package com.webank.databrain.common.enums.auth;

/**
 * 身份认证模式
 * @author aaronchu
 * @Description
 * @date 2021/12/01
 */
public enum UserCredentialModeEnum {

    UsernamePwd(0),

    PhoneValidationCode(1);

    private int code;

    UserCredentialModeEnum(int code){
        this.code = code;
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
