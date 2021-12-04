package com.webank.databrain.common.enums.fetch;

import lombok.Getter;

import java.util.Objects;

/**
 * 数据处理类型
 * @author aaronchu
 * @Description
 * @date 2021/12/02
 */
@Getter
public enum ProcessTypeEnum {

    Encryption("encrypt"),

    Encoding("encode"),

    Compression("compress");

    private String id;

    ProcessTypeEnum(String id) {
        this.id = id;
    }

    public static ProcessTypeEnum getEnumById(String id){
        for(ProcessTypeEnum e: ProcessTypeEnum.values()){
            if(Objects.equals(e.id, id)){
                return e;
            }
        }
        return null;
    }
}
