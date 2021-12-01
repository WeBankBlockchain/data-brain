package com.webank.databrain.common.model;

import lombok.Data;

@Data
public class Enterprise {
    private String id;
    //企业名称
    private String name;
    //手机号
    private String contact;
    //联系地址
    private String location;
    //邮箱地址
    private String email;
    private int certType;
    private String certNo;
    //认证数据哈希
    private String certHash;
    private String representativeName;
    private int representativeCertType;
    private String representativeCertNo;
}
