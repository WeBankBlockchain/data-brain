package com.webank.databrain.common.enums.auth;

/**
 * 身份类型
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
public enum IdTypeEnum {

    IdNo(0),

    Phone(1);

    private int code;

    IdTypeEnum(int code) {
        this.code = code;
    }

}
