package com.webank.databrain.common.enums.fetch;

import lombok.Getter;

/**
 * 数据处理类型
 * @author aaronchu
 * @Description
 * @date 2021/12/02
 */
@Getter
public enum ProcessTypeEnum {

    Encryption(1),

    Encoding(2),

    Compression(3);

    private int code;

    ProcessTypeEnum(int code) {
        this.code  = code;
    }

    public static ProcessTypeEnum getEnumByCode(int code){
        for(ProcessTypeEnum e: ProcessTypeEnum.values()){
            if(e.code == code){
                return e;
            }
        }
        return null;
    }
}
