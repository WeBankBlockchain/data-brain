package com.webank.databrain.common.model;

import lombok.Data;

@Data
public class Product {
    //产品地址
    private String externalAddress;
    private String ownerId;
    //产品名称
    private String name;
    private String introduction;
    private String productId;
}
