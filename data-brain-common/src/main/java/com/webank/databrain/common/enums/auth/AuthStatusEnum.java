package com.webank.databrain.common.enums;

/**
 * 认证状态
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public enum AuthStatusEnum {
    /**
     * 初始化
     */
    Init(0),

    /**
     * 组织方已认证
     */
    Authenticated_By_Organizer(1),

    /**
     * 提供方已认证
     */
    Authenticated_By_Provider(2),

    /**
     * 已撤销
     */
    Revoked(3);

    private int code;

    AuthStatusEnum(int code){
        this.code = code;
    }


    public static AuthStatusEnum getEnumByCode(int code){
        for(AuthStatusEnum e: AuthStatusEnum.values()){
            if(e.code == code){
                return e;
            }
        }
        throw new RuntimeException("Invalid AuthStatusEnum code:"+code);
    }
}
